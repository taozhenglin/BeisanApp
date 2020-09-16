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
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.adapter.AsseertCheckAdapter;
import com.cn.beisanproject.modelbean.AssertCheckListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yinglan.keyboard.HideUtil;

import java.util.HashMap;

import okhttp3.Call;

public class AssertCheckListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private AsseertCheckAdapter mPurchaseAdapter;
    private TextView tv_back;
    private TextView tv_common_title;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
    private boolean click;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asseert_activity);
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
        tv_back = findViewById(R.id.tv_back);
        tv_search = findViewById(R.id.tv_search);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("固定资产盘点");
        edt_search_contract = findViewById(R.id.edt_search_contract);
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
     *
     * @param
     */
    private void query() {
        LogUtils.d("query");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "FIXPD");
        object.put("objectname", "FIXPD");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "FIXPDNUM DESC");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("FIXPDNUM", edt_search_contract.getText().toString());
        sinorsearchobject.put("MEMO",  edt_search_contract.getText().toString());
        sinorsearchobject.put("PDZT", edt_search_contract.getText().toString());
        object.put("sinorsearch", sinorsearchobject);
        object.put("sqlSearch", "1=1");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure=" + e.toString());
                finishRefresh();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse=" + response);
                AssertCheckListBean assertCheckListBean;
                finishRefresh();
                if (!response.isEmpty()) {
                     assertCheckListBean = JSONObject.parseObject(response, new TypeReference<AssertCheckListBean>() {
                    });

                    if (assertCheckListBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (currentPageNum == 1) {
                            if (mPurchaseAdapter==null){
                                mPurchaseAdapter = new AsseertCheckAdapter(AssertCheckListActivity.this, assertCheckListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                recyclerView.setAdapter(mPurchaseAdapter);
                            }else {
                                mPurchaseAdapter.setData(assertCheckListBean.getResult().getResultlist(),edt_search_contract.getText().toString());
                                mPurchaseAdapter.notifyDataSetChanged();
                            }

                        } else {
//                            if (mPurchaseAdapter.getListSize()<20){
                            mPurchaseAdapter.addAllList(assertCheckListBean.getResult().getResultlist());
//                            }
                            mPurchaseAdapter.notifyDataSetChanged();
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_search:
                query();

                break;
        }
    }
}
