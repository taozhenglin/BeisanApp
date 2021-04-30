package com.cn.beisanproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.adapter.PurchaseMonthPlanAdapter;
import com.cn.beisanproject.adapter.PurchaseOrderAdapter;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.PurchaseMonthPlanListBean;
import com.cn.beisanproject.modelbean.PurchaseOrderListBean;
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

import okhttp3.Call;

public class PurchaseOrderListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private PurchaseOrderAdapter purchaseOrderAdapter;
    private LinearLayout ll_back;
    private TextView tv_common_title;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
    int totalpage ;
    int totalresult;
    private LoadingDialog ld;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_month_list_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        initView();
        initEvent();
        initListener();
        EventBus.getDefault().register(this);
    }
    private void initListener() {
        ll_back.setOnClickListener(this);
        tv_search.setOnClickListener(this);
        edt_search_contract.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = findViewById(R.id.refreshLayout);
        ll_back = findViewById(R.id.ll_back);
        tv_search = findViewById(R.id.tv_search);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("采购订单");
        edt_search_contract = findViewById(R.id.edt_search_contract);
        edt_search_contract.setHint("订单编号/描述");
    }

    private void initEvent() {
        ld=new LoadingDialog(this);
        query();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                query();


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                query();

            }
        });

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_search:
                currentPageNum=1;
                query();
                break;
        }
    }
    private void query() {
        ld.show();
        /**
         * {"appid":"PURCHVIEW",
         * "objectname":"PURCHVIEW",
         * "curpage":1,"showcount":20,
         * "option":"read",
         * "orderby":"STARTDATE DESC",
         * "sqlSearch":" LB='采购合同' and UDCGHTLX = '采购订单'"}
         */
        LogUtils.d("query");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PURCHVIEW");
        object.put("objectname", "PURCHVIEW");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "STARTDATE DESC");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("CONTRACTNUM", edt_search_contract.getText().toString());
        sinorsearchobject.put("HTYF", edt_search_contract.getText().toString());
        sinorsearchobject.put("DESCRIPTION ",  edt_search_contract.getText().toString());
        object.put("sinorsearch", sinorsearchobject);
        object.put("sqlSearch", "LB='采购合同' and UDCGHTLX = '采购订单'");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                finishRefresh();
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                PurchaseMonthPlanListBean purchaseMonthPlanListBean;
                finishRefresh();
                if (!response.isEmpty()) {
                    //bean通用
                    PurchaseOrderListBean purchaseOrderListBean = JSONObject.parseObject(response, new TypeReference<PurchaseOrderListBean>() {});

                    if (purchaseOrderListBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (purchaseOrderListBean.getResult().getResultlist().size()>0){
                            if (currentPageNum == 1) {
                                totalpage = purchaseOrderListBean.getResult().getTotalpage();
                                totalresult = purchaseOrderListBean.getResult().getTotalresult();
                                if (purchaseOrderAdapter==null){
                                    purchaseOrderAdapter = new PurchaseOrderAdapter(PurchaseOrderListActivity.this, purchaseOrderListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    recyclerView.setAdapter(purchaseOrderAdapter);
                                }else {
                                    purchaseOrderAdapter.setData(purchaseOrderListBean.getResult().getResultlist(),edt_search_contract.getText().toString());
                                    purchaseOrderAdapter.notifyDataSetChanged();
                                }

                            } else {
                                if (currentPageNum<=totalpage){
                                    purchaseOrderAdapter.addAllList(purchaseOrderListBean.getResult().getResultlist());
                                    purchaseOrderAdapter.notifyDataSetChanged();
                                }else {
                                    ToastUtils.showShort("没有更多数据了");
                                }

                            }
                        }else {
                            ToastUtils.showShort("无数据");
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
    // 收到扫描盘点界面上传盘点ok后的通知 刷新列表
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNotify(PostData postData) {
        if (postData.getTag().equals("采购订单")) {
            query();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
