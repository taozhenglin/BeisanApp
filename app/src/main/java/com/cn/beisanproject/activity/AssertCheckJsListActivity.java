package com.cn.beisanproject.activity;

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
import com.cn.beisanproject.adapter.AsseertCheckJsAdapter;
import com.cn.beisanproject.modelbean.AssertCheckJsListBean;
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

import okhttp3.Call;

/**
 * Created by tzl
 * on 2020/11/2
 */
public class AssertCheckJsListActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private AsseertCheckJsAdapter asseertCheckJsAdapter;
    private LinearLayout ll_back;
    private TextView tv_common_title;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
    private LoadingDialog ld;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asseert_activity);
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
        tv_common_title.setText("固定资产接收");
        edt_search_contract = findViewById(R.id.edt_search_contract);
        edt_search_contract.setHint("接收单号/接收描述");
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
    /**
     *
     * @param
     */
    private void query() {
        ld.show();
        LogUtils.d("query");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "FIXEDASSETJS");
        object.put("objectname", "FIXEDASSETJS");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "FIXEDASSETJSNUM DESC");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("FIXEDASSETJSNUM", edt_search_contract.getText().toString());
        sinorsearchobject.put("DESCRIPTION",  edt_search_contract.getText().toString());
//        sinorsearchobject.put("PDZT", edt_search_contract.getText().toString());
        object.put("sinorsearch", sinorsearchobject);
        object.put("sqlSearch", "1=1");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure=" + e.toString());
                ld.close();
                finishRefresh();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse=" + response);
                ld.close();
                AssertCheckJsListBean assertCheckJsListBean;
                finishRefresh();
                if (!response.isEmpty()) {
                    assertCheckJsListBean = JSONObject.parseObject(response, new TypeReference<AssertCheckJsListBean>() {});

                    if (assertCheckJsListBean.getErrcode().equals("GLOBAL-S-0")) {
                        int  totalPage= assertCheckJsListBean.getResult().getTotalpage();
                        if (currentPageNum == 1) {
                            if (asseertCheckJsAdapter==null){
                                asseertCheckJsAdapter = new AsseertCheckJsAdapter(AssertCheckJsListActivity.this, assertCheckJsListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                recyclerView.setAdapter(asseertCheckJsAdapter);
                            }else {
                                asseertCheckJsAdapter.setData(assertCheckJsListBean.getResult().getResultlist(),edt_search_contract.getText().toString());
                                asseertCheckJsAdapter.notifyDataSetChanged();
                            }

                        } else {
                            if (currentPageNum<=totalPage){
                                asseertCheckJsAdapter.addAllList(assertCheckJsListBean.getResult().getResultlist());
                                asseertCheckJsAdapter.notifyDataSetChanged();
                            }else {
                                ToastUtils.showShort("没有更多数据了");
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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    // 刷新列表
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNotify(PostData postData) {
        if (postData.getTag().equals("固定资产接收"))
            query();
    }
}
