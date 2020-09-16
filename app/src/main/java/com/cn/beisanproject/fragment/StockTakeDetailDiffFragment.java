package com.cn.beisanproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.activity.StockTakeDetailActivity;
import com.cn.beisanproject.adapter.StockTakeDetailAdapter;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StockingLineListBean;
import com.cn.beisanproject.modelbean.StockingTakeListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

public class StockTakeDetailDiffFragment extends Fragment {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private Context mContext;
    private boolean isRefresh=true;
    StockingTakeListBean.ResultBean.ResultlistBean mResultlistBean;
    private LoadingDialog ld;
    private StockTakeDetailAdapter stockTakeDetailAdapter;
    private List<StockingLineListBean.ResultBean.ResultlistBean> resultlist;
    private int totalpage;


    public StockTakeDetailDiffFragment(Context context, StockingTakeListBean.ResultBean.ResultlistBean resultlistBean) {
        mContext=context;
        mResultlistBean=resultlistBean;
        ld=new LoadingDialog(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.stock_diff_fragment,container,false);
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = view.findViewById(R.id.refreshLayout);
        initEvent();
        LogUtils.d("222222","onCreateView");
        return view;
    }

    private void initEvent() {
        getDiffList();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                getDiffList();


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                getDiffList();

            }
        });
    }

    private void getDiffList() {
        /**
         * --库存盘点差异盘点明细查询
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"UDSTOCKLINE","objectname":"UDSTOCKLINE","curpage":1,"showcount":20,"option":"read","orderby":"LINENUM asc",
         * "sqlSearch":" stocknum=:stocknum and CYQUANTITY<>0"}
         */

//        ld.show();
        LogUtils.d("222222getDiffList");
//
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "UDSTOCKLINE");
        object.put("objectname", "UDSTOCKLINE");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "LINENUM asc");
        object.put("sqlSearch", "stocknum=" + mResultlistBean.getSTOCKNUM()+" and CYQUANTITY<>0");
        //请求头
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure"+e.toString());

            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse"+response.toString());
                finishRefresh();
                ld.close();
                StockingLineListBean stockingLineListBean;
                if (!response.isEmpty()) {
                    stockingLineListBean = JSONObject.parseObject(response, new TypeReference<StockingLineListBean>() {});

                    if (stockingLineListBean.getErrcode().equals("GLOBAL-S-0")) {
                        resultlist = stockingLineListBean.getResult().getResultlist();
                        totalpage = stockingLineListBean.getResult().getTotalpage();
                        if (resultlist.size() > 0) {
                            SharedPreferencesUtil.setString(mContext, "resultlist", response);

                            if (currentPageNum == 1) {
                                if (stockTakeDetailAdapter == null) {
                                    stockTakeDetailAdapter = new StockTakeDetailAdapter(mContext,mResultlistBean,resultlist,"diff");
                                    recyclerView.setAdapter(stockTakeDetailAdapter);
                                } else {
                                    stockTakeDetailAdapter.setData(resultlist);
                                    stockTakeDetailAdapter.notifyDataSetChanged();
                                }


                            } else {
                                //重复数据处理
                                if (currentPageNum <= totalpage) {
                                    stockTakeDetailAdapter.addAllList(resultlist);
                                    stockTakeDetailAdapter.notifyDataSetChanged();
                                } else {
                                    ToastUtils.showShort("没有更多数据了");
                                }
                            }

                        }


                    }

                }
            }
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtils.d("222222","onViewCreated");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d("222222","onCreate");
        EventBus.getDefault().register(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();

    }

    public void getData() {
        LogUtils.d("222222StockTakeDetailDiffFragment","getData");
        getDiffList();
    }
    // 收到扫描盘点界面上传盘点ok后的通知 刷新列表
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNotify(PostData postData) {
        if (postData.getTag().equals("stock check scuess")) {
            getDiffList();
        }
    }

}
