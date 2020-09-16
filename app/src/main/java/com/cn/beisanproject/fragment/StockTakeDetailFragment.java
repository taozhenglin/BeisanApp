package com.cn.beisanproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.activity.StockTakeDetailActivity;
import com.cn.beisanproject.activity.SupplierListActivity;
import com.cn.beisanproject.adapter.StockTakeDetailAdapter;
import com.cn.beisanproject.adapter.SupplierAdapter;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

public class StockTakeDetailFragment extends Fragment {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private Context mContext;
    private TextView tv_pandian_no;
    private TextView tv_pandian_desc;
    private TextView tv_pandian_date;
    private TextView tv_location;
    private TextView tv_created_by;
    private TextView tv_created_time;
    private TextView tv_big_type;
    private TextView tv_middle_type;
    private TextView tv_small_type;
    private boolean isRefresh = true;
    StockingTakeListBean.ResultBean.ResultlistBean mResultlistBean;
    private List<StockingLineListBean.ResultBean.ResultlistBean> resultlist;
    private int totalpage;
    private StockTakeDetailAdapter stockTakeDetailAdapter;
    List<JSONObject> jsonlist = new ArrayList<>();
    private LoadingDialog ld;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d("222222", "onCreate");
        EventBus.getDefault().register(this);
        ld = new LoadingDialog(mContext);
    }

    public StockTakeDetailFragment(Context context, StockingTakeListBean.ResultBean.ResultlistBean resultlistBean) {
        this.mContext = context;
        this.mResultlistBean = resultlistBean;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stock_detail_fragment, container, false);
        tv_pandian_no = view.findViewById(R.id.tv_pandian_no);
        tv_pandian_desc = view.findViewById(R.id.tv_pandian_desc);
        tv_pandian_date = view.findViewById(R.id.tv_pandian_date);
        tv_location = view.findViewById(R.id.tv_location);
        tv_created_by = view.findViewById(R.id.tv_created_by);
        tv_created_time = view.findViewById(R.id.tv_created_time);
        tv_big_type = view.findViewById(R.id.tv_big_type);
        tv_middle_type = view.findViewById(R.id.tv_middle_type);
        tv_small_type = view.findViewById(R.id.tv_small_type);


        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = view.findViewById(R.id.refreshLayout);
        initEvent();
        LogUtils.d("222222", "onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtils.d("222222", "onViewCreated");
        tv_pandian_no.setText("盘点单编号：" + mResultlistBean.getSTOCKNUM());
        tv_pandian_desc.setText("盘点描述：" + mResultlistBean.getDESCRIPTION());
        tv_pandian_date.setText("盘点日期：" + mResultlistBean.getPDDATE());
        tv_location.setText("仓库：" + mResultlistBean.getLOCATION());
        tv_created_by.setText("创建人：" + mResultlistBean.getCREATENAME());
        tv_created_time.setText("创建时间：" + mResultlistBean.getCREATEDATE());
        tv_big_type.setText("大类：" + mResultlistBean.getA_1CLASSDESC());
        tv_middle_type.setText("中类：" + mResultlistBean.getA_2CLASSDESC());
        tv_small_type.setText("小类：" + mResultlistBean.getA_3CLASSDESC());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.d("222222", "onActivityCreated");
    }

    private void initEvent() {
        getStockLine();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                getStockLine();


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                getStockLine();

            }
        });

    }

    /**
     * --库存盘点明细查询
     * http://192.168.1.180:7009/maximo/mobile/common/api?data=
     * {"appid":"UDSTOCKLINE","objectname":"UDSTOCKLINE","curpage":1,"showcount":20,"option":"read","orderby":"LINENUM asc","sqlSearch":" stocknum=:stocknum "}
     */
    private void getStockLine() {
        ld.show();
        LogUtils.d("getStockLine");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "UDSTOCKLINE");
        object.put("objectname", "UDSTOCKLINE");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "LINENUM asc");
        String sqlSearch = "stocknum=" + mResultlistBean.getSTOCKNUM();
        object.put("sqlSearch", sqlSearch);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure=" + e.toString());
                finishRefresh();
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse=" + response);
                finishRefresh();
                ld.close();
                StockingLineListBean stockingLineListBean;
                if (!response.isEmpty()) {
                    stockingLineListBean = JSONObject.parseObject(response, new TypeReference<StockingLineListBean>() {
                    });

                    if (stockingLineListBean.getErrcode().equals("GLOBAL-S-0")) {
                        resultlist = stockingLineListBean.getResult().getResultlist();
                        totalpage = stockingLineListBean.getResult().getTotalpage();
                        if (resultlist.size() > 0) {
                            if (currentPageNum == 1) {
                                if (stockTakeDetailAdapter == null) {
                                    stockTakeDetailAdapter = new StockTakeDetailAdapter(mContext, mResultlistBean,resultlist,"");
                                    recyclerView.setAdapter(stockTakeDetailAdapter);
                                } else {
                                    stockTakeDetailAdapter.setData(StockTakeDetailFragment.this.resultlist);
                                    stockTakeDetailAdapter.notifyDataSetChanged();
                                }


                            } else {
                                //重复数据处理
                                if (currentPageNum <= totalpage) {
                                    stockTakeDetailAdapter.addAllList(StockTakeDetailFragment.this.resultlist);
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

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        LogUtils.d("222222StockTakeDetailFragment", "onAttach");
    }

    // 收到扫描盘点界面上传盘点ok后的通知 刷新列表
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNotify(PostData postData) {
        if (postData.getTag().equals("stock check scuess")) {
            getStockLine();
        }
    }


    public void getData() {
        getStockLine();
    }
}
