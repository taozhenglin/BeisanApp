package com.cn.beisanproject.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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
import com.cn.beisanproject.adapter.ProjectMothAdapter;
import com.cn.beisanproject.adapter.PurchaseEnquiryAdapter;
import com.cn.beisanproject.modelbean.ProjectMonthListBean;
import com.cn.beisanproject.modelbean.PurchaseEnquiryListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yinglan.keyboard.HideUtil;

import java.util.HashMap;

import okhttp3.Call;

/**
 * 采购询价单
 */
public class PurchaseEnquiryListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private PurchaseEnquiryAdapter purchaseEnquiryAdapter;
    private TextView tv_back;
    private TextView tv_common_title;

    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
    int totalpage;
    int totalresult;
    private LoadingDialog ld;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_month_list_activity);
        //键盘自动隐藏
        HideUtil.init(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        initView();
        initEvent();
        initListener();
    }

    private void initListener() {
        tv_back.setOnClickListener(this);
        tv_search.setOnClickListener(this);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = findViewById(R.id.refreshLayout);
        tv_back = findViewById(R.id.tv_back);
        tv_search = findViewById(R.id.tv_search);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("采购询价单");
        edt_search_contract = findViewById(R.id.edt_search_contract);
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

    private void query() {
        ld.show();
        /**
         * {
         *   "objectname" : "RFQ",
         *   "option" : "read",
         *   "orderby" : "ENTERDATE DESC",
         *   "curpage" : 1,
         *   "showcount" : 20,
         *   "sqlSearch" : "APP='RFQ'",
         *   "appid" : "RFQ"
         * }
         */
        LogUtils.d("query==");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "RFQ");
        object.put("objectname", "RFQ");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "ENTERDATE DESC");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("RFQNUM", edt_search_contract.getText().toString());
        sinorsearchobject.put("DESCRIPTION", edt_search_contract.getText().toString());
        object.put("sinorsearch", sinorsearchobject);
        object.put("sqlSearch", "APP='RFQ'");
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
                PurchaseEnquiryListBean purchaseEnquiryListBean;
                finishRefresh();
                ld.close();
                if (!response.isEmpty()) {
                    purchaseEnquiryListBean = JSONObject.parseObject(response, new TypeReference<PurchaseEnquiryListBean>() {
                    });

                    if (purchaseEnquiryListBean.getErrcode().equals("GLOBAL-S-0")) {
                        totalpage = purchaseEnquiryListBean.getResult().getTotalpage();
                        totalresult = purchaseEnquiryListBean.getResult().getTotalresult();
                        if (currentPageNum == 1) {
                            if (purchaseEnquiryAdapter == null) {
                                purchaseEnquiryAdapter = new PurchaseEnquiryAdapter(PurchaseEnquiryListActivity.this, purchaseEnquiryListBean.getResult().getResultlist(), edt_search_contract.getText().toString(),"PurchaseEnquiryListActivity");
                                recyclerView.setAdapter(purchaseEnquiryAdapter);
                            } else {
                                purchaseEnquiryAdapter.setData(purchaseEnquiryListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                purchaseEnquiryAdapter.notifyDataSetChanged();
                            }

                        } else {
                            if (currentPageNum<=totalpage){
                                purchaseEnquiryAdapter.addAllList(purchaseEnquiryListBean.getResult().getResultlist());
                                purchaseEnquiryAdapter.notifyDataSetChanged();
                            }else {
                                ToastUtils.showShort("没有更多数据了");
                            }
                        }
//
//
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_search:
                //搜索
                currentPageNum=1;
                query();
                break;
        }
    }
}
