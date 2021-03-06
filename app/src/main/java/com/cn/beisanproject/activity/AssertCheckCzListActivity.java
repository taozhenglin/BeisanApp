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
import com.cn.beisanproject.adapter.AsseertCheckCzAdapter;
import com.cn.beisanproject.modelbean.AssertCheckCzListBean;
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
public class AssertCheckCzListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private AsseertCheckCzAdapter asseertCheckCzAdapter;
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
        //隐藏标题栏
        setContentView(R.layout.asseert_activity);
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
        tv_common_title.setText("固定资产处置");
        edt_search_contract = findViewById(R.id.edt_search_contract);
        edt_search_contract.setHint("申请单号/描述");
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
//--固定资产处置列表查询
//    http://10.169.87.216:7001/mobile/common/api?data=
//    {"appid":"FIXEASSETRET","objectname":"FIXEASSETRET","curpage":1,"showcount":20,"option":"read","orderby":"FIXEASSETRETNUM DESC"}
    private void query() {
        ld.show();
        LogUtils.d("query");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "FIXEASSETRET");
        object.put("objectname", "FIXEASSETRET");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "FIXEASSETRETNUM DESC");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("FIXEASSETRETNUM", edt_search_contract.getText().toString());
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
                AssertCheckCzListBean assertCheckczListBean;
                finishRefresh();
                if (!response.isEmpty()) {
                    assertCheckczListBean = JSONObject.parseObject(response, new TypeReference<AssertCheckCzListBean>() {});

                    if (assertCheckczListBean.getErrcode().equals("GLOBAL-S-0")) {
                        int  totalPage= assertCheckczListBean.getResult().getTotalpage();
                        if (currentPageNum == 1) {
                            if (asseertCheckCzAdapter==null){
                                asseertCheckCzAdapter = new AsseertCheckCzAdapter(AssertCheckCzListActivity.this, assertCheckczListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                recyclerView.setAdapter(asseertCheckCzAdapter);
                            }else {
                                asseertCheckCzAdapter.setData(assertCheckczListBean.getResult().getResultlist(),edt_search_contract.getText().toString());
                                asseertCheckCzAdapter.notifyDataSetChanged();
                            }
                        } else {
                            if (currentPageNum<=totalPage){
                                asseertCheckCzAdapter.addAllList(assertCheckczListBean.getResult().getResultlist());
                                asseertCheckCzAdapter.notifyDataSetChanged();
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
