package com.cn.beisanproject.activity;

import android.os.Bundle;
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
import com.cn.beisanproject.adapter.PurchseContractAdapter;
import com.cn.beisanproject.adapter.SupplierAdapter;
import com.cn.beisanproject.modelbean.PurchseContractListBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.SupplierListBean;
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

public class SupplierListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private SupplierAdapter supplierAdapter;
    private LinearLayout ll_back;
    private TextView tv_common_title;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
    private int totalpage;
    private LoadingDialog ld;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.purshase_contract_activity);

        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ld=new LoadingDialog(this);
        initView();
        initEvent();
        initListener();
        EventBus.getDefault().register(this);


    }

    private void initListener() {
        ll_back.setOnClickListener(this);
        tv_search.setOnClickListener(this);
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
        tv_common_title.setText("供应商申请");
        edt_search_contract = findViewById(R.id.edt_search_contract);
        edt_search_contract.setHint("申请编号/供应商编码/供应商名称");
    }

    private void initEvent() {
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

    /**
     * 采购合同列表
     */
    private void query() {
        /**
         * {
         *   "objectname" : "VENDORSAPPLY",
         *   "option" : "read",
         *   "orderby" : "APPLYDATE DESC",
         *   "curpage" : 1,
         *   "sinorsearch" : {
         *     "VENDORS" : "",
         *     "VENDORSCODE" : "",
         *     "NAME" : ""
         *   },
         *   "showcount" : 20,
         *   "appid" : "VENDORSAPPLY"
         * }
         */
        LogUtils.d("query");
        ld.show();
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "VENDORSAPPLY");
        object.put("objectname", "VENDORSAPPLY");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "APPLYDATE DESC");
        JSONObject searchobj = new JSONObject();//模糊查询
        searchobj.put("VENDORS", edt_search_contract.getText().toString());
        searchobj.put("VENDORSCODE", edt_search_contract.getText().toString());
        searchobj.put("NAME", edt_search_contract.getText().toString());
        object.put("sinorsearch", searchobj);
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
                LogUtils.d("onResponse==" + response);
                finishRefresh();
                ld.close();
                SupplierListBean supplierListBean;
                if (!response.isEmpty()) {
                    supplierListBean = JSONObject.parseObject(response, new TypeReference<SupplierListBean>() {});
                    if (supplierListBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (supplierListBean.getResult().getResultlist().size()>0) {
                            totalpage = supplierListBean.getResult().getTotalpage();
                            if (currentPageNum == 1) {
                                if (supplierAdapter == null) {
                                    supplierAdapter = new SupplierAdapter(SupplierListActivity.this, supplierListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    recyclerView.setAdapter(supplierAdapter);
                                } else {
                                    supplierAdapter.setData(supplierListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    supplierAdapter.notifyDataSetChanged();
                                }

                            } else {
                                //重复数据处理
                                if (currentPageNum <= totalpage) {
                                    supplierAdapter.addAllList(supplierListBean.getResult().getResultlist());
                                    supplierAdapter.notifyDataSetChanged();
                                } else {
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_search:
                //搜索
                currentPageNum=1;
                query();
                break;
        }

    }

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe (threadMode = ThreadMode.MAIN)
    public void onEvent( StartWorkProcessBean startWorkProcessBean){
        LogUtils.d("onEvent==");
        if (startWorkProcessBean.getTag().equals("供应商申请")){
            query();
        }
    }
}
