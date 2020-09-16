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
import com.cn.beisanproject.adapter.EqumentRequestAdapter;
import com.cn.beisanproject.adapter.ProjectContractChangeAdapter;
import com.cn.beisanproject.modelbean.EqumentRequestListBean;
import com.cn.beisanproject.modelbean.ProjectContractChangeBean;
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

public class EqumentRequestListkActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private EqumentRequestAdapter equmentRequestAdapter;
    private TextView tv_back;
    private TextView tv_common_title;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
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
        tv_common_title.setText("设备台账增减申请");
        edt_search_contract = findViewById(R.id.edt_search_contract);
        edt_search_contract.setHint("申请单号/设备编号");
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
         *   "objectname" : "JD_SBTZ",
         *   "curpage" : 1,
         *   "appid" : "JD_SBTZ",
         *   "option" : "read",
         *   "showcount" : 20,
         *   "orderby":"",
         *   "sinorsearch":{"JD_SBTZID":"","ASSETNUM":"","NAME":""}
         * }
         */

        LogUtils.d("query==");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "JD_SBTZ");
        object.put("objectname", "JD_SBTZ");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("ASSETNUM", edt_search_contract.getText().toString());
        sinorsearchobject.put("JD_SBTZID",  edt_search_contract.getText().toString());
        sinorsearchobject.put("NAME",  edt_search_contract.getText().toString());
        object.put("sinorsearch", sinorsearchobject);
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
                EqumentRequestListBean equmentRequestListBean;
                finishRefresh();
                ld.close();
                if (!response.isEmpty()) {
                    equmentRequestListBean = JSONObject.parseObject(response, new TypeReference<EqumentRequestListBean>() {
                    });

                    if (equmentRequestListBean.getErrcode().equals("GLOBAL-S-0")) {
                      int  totalPage=equmentRequestListBean.getResult().getTotalpage();
                        if (currentPageNum == 1) {
                            if (equmentRequestAdapter==null){
                                equmentRequestAdapter = new EqumentRequestAdapter(EqumentRequestListkActivity.this, equmentRequestListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                recyclerView.setAdapter(equmentRequestAdapter);
                            }else {
                                equmentRequestAdapter.setData(equmentRequestListBean.getResult().getResultlist(),edt_search_contract.getText().toString());
                                equmentRequestAdapter.notifyDataSetChanged();
                            }

                        } else {
                            if (currentPageNum<=totalPage){
                                equmentRequestAdapter.addAllList(equmentRequestListBean.getResult().getResultlist());
                                equmentRequestAdapter.notifyDataSetChanged();
                            }

                        }


                    }

                }

            }


        });

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
    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();

    }
}
