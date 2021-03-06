package com.cn.beisanproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
import com.cn.beisanproject.adapter.AssertDetailLineAdapter;
import com.cn.beisanproject.modelbean.AssertCheckListBean;
import com.cn.beisanproject.modelbean.AssertDetailLineBean;
import com.cn.beisanproject.modelbean.PostData;
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

public class AssertDetailAllFragment extends Fragment {
    private final Context mContext;
    private final AssertCheckListBean.ResultBean.ResultlistBean mResultlistBean;
    private TextView tv_check_no;
    private TextView tv_check_desc;
    private TextView tv_check_by;
    private TextView tv_check_starttime;
    private TextView tv_check_endtime;
    private TextView tv_created_by;
    private TextView tv_created_time;
    TextView tv_owner_companny;
    private LinearLayout ll_assert_container;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private boolean isRefresh=true;
    private AssertDetailLineAdapter assertDetailLineAdapter;
    List<AssertDetailLineBean.ResultBean.ResultlistBean> resultlist;
    private LoadingDialog ld;

    public AssertDetailAllFragment(Context context, AssertCheckListBean.ResultBean.ResultlistBean resultlistBean) {
        this.mContext=context;
        this.mResultlistBean=resultlistBean;
        LogUtils.d("mResultlistBean==" + mResultlistBean);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        ld = new LoadingDialog(mContext);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.assert_detail_fragment,container,false);
        tv_check_no = view.findViewById(R.id.tv_check_no);
        tv_check_desc = view.findViewById(R.id.tv_check_desc);
        tv_check_by = view.findViewById(R.id.tv_check_by);
        tv_check_starttime = view.findViewById(R.id.tv_check_starttime);
        tv_check_endtime = view.findViewById(R.id.tv_check_endtime);
        tv_created_by = view.findViewById(R.id.tv_created_by);
        tv_created_time = view.findViewById(R.id.tv_created_time);
        tv_owner_companny= view.findViewById(R.id.tv_owner_companny);
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = view.findViewById(R.id.refreshLayout);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_check_no.setText("盘点单编号：" + mResultlistBean.getFIXPDNUM());
        tv_check_desc.setText("盘点备注：" + mResultlistBean.getMEMO());
        tv_check_by.setText("盘点人: " + mResultlistBean.getPDUSERDESC());
        tv_check_starttime.setText("盘点开始时间: " + mResultlistBean.getSTARTDATE());
        tv_check_endtime.setText("盘点结束时间: " + mResultlistBean.getENDDATE());
        tv_created_by.setVisibility(View.GONE);
        tv_created_time.setVisibility(View.GONE);
        tv_owner_companny.setText("所属公司: " + mResultlistBean.getUDCOMPANY());
        getAssertLineDetail();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                getAssertLineDetail();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                getAssertLineDetail();
            }
        });

    }
    /**
     * -- 固定资产盘点明细行查询
     * http://192.168.1.180:7009/maximo/mobile/common/api?data=
     * {"appid":"FIXPDLINE","objectname":"FIXPDLINE","curpage":1,"showcount":20,"option":"read","orderby":"",
     * "sinorsearch":{"FIXASSETNUM":"","YPD":""},"sqlSearch":" FIXPDNUM=:FIXPDNUM "}
     */
    public void getAssertLineDetail() {
        ld.show();
        LogUtils.d("getAssertLineDetail");
//
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "FIXPDLINE");
        object.put("objectname", "FIXPDLINE");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        //模糊查询
        JSONObject sinorsearchobject = new JSONObject();
        sinorsearchobject.put("FIXASSETNUM", "");
        sinorsearchobject.put("YPD", "");
        object.put("sinorsearch", sinorsearchobject);
        LogUtils.d("FIXPDNUM==" + mResultlistBean.getFIXPDNUM());
        object.put("sqlSearch", "FIXPDNUM=" + mResultlistBean.getFIXPDNUM());
        //请求头
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure=" + e.toString());
                finishRefresh();
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse=" + response);
                finishRefresh();
                ld.close();
                if (!response.isEmpty()) {
                    AssertDetailLineBean assertDetailLineBean = JSONObject.parseObject(response, new TypeReference<AssertDetailLineBean>() {});
                    if (assertDetailLineBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (assertDetailLineBean.getResult().getResultlist().size()>0){
                            resultlist = assertDetailLineBean.getResult().getResultlist();
                            int  totalPage=assertDetailLineBean.getResult().getTotalpage();
                            if (currentPageNum == 1) {
                                if (assertDetailLineAdapter==null){
                                    assertDetailLineAdapter = new AssertDetailLineAdapter(mContext, resultlist,"",mResultlistBean);
                                    recyclerView.setAdapter(assertDetailLineAdapter);
                                }else {
                                    assertDetailLineAdapter.setData(resultlist);
                                    assertDetailLineAdapter.notifyDataSetChanged();
                                }

                            } else {
                                if (currentPageNum<=totalPage){
                                    assertDetailLineAdapter.addAllList(resultlist);
                                    assertDetailLineAdapter.notifyDataSetChanged();
                                }else {
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
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNotification(PostData data){
        LogUtils.d("222222 getNotification");
        if (data.getTag().equals("assert check scuess")){
            currentPageNum=1;
           getAssertLineDetail();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
