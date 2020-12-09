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
import com.cn.beisanproject.adapter.CountEqmentRequestAdapter;
import com.cn.beisanproject.adapter.InformationRequestAdapter;
import com.cn.beisanproject.modelbean.CountEqmentRequestListBean;
import com.cn.beisanproject.modelbean.InformationRequestListBean;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yinglan.keyboard.HideUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import okhttp3.Call;

public class CountEqmentRequestListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private CountEqmentRequestAdapter countEqmentRequestAdapter;
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
        tv_common_title.setText("计量设备台账增减申请");
        edt_search_contract = findViewById(R.id.edt_search_contract);
        edt_search_contract.setHint("申请单号/系统编号");
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
        /**
         * {
         *   "objectname" : "JD_MEASUREMENT",
         *   "curpage" : 1,
         *   "appid" : "JD_MEASUREMENT",
         *   "option" : "read",
         *   "showcount" : 20
         * }
         */
        ld.show();

        LogUtils.d("query==");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "JD_MEASUREMENT");
        object.put("objectname", "JD_MEASUREMENT");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        JSONObject sinorsearch = new JSONObject();
        sinorsearch.put("ASSETNUM",edt_search_contract.getText().toString());
        sinorsearch.put("JD_MEASUREMENTID",edt_search_contract.getText().toString());
        object.put("sinorsearch", sinorsearch);
        String sqlSearch=" status !='已确认'";
        object.put("sqlSearch", sqlSearch);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure=" + e.toString());
                ToastUtils.showShort("获取数据失败");
                finishRefresh();
                ld.close();
            }
            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse=" + response);
                CountEqmentRequestListBean countEqmentRequestListBean;
                finishRefresh();
                ld.close();
                if (!response.isEmpty()) {
                    countEqmentRequestListBean = JSONObject.parseObject(response, new TypeReference<CountEqmentRequestListBean>() {
                    });

                    if (countEqmentRequestListBean.getErrcode().equals("GLOBAL-S-0")) {
                        int  totalPage=countEqmentRequestListBean.getResult().getTotalpage();
                        if (currentPageNum == 1) {
                            if (countEqmentRequestAdapter==null){
                                countEqmentRequestAdapter = new CountEqmentRequestAdapter(CountEqmentRequestListActivity.this, countEqmentRequestListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                recyclerView.setAdapter(countEqmentRequestAdapter);
                            }else {
                                countEqmentRequestAdapter.setData(countEqmentRequestListBean.getResult().getResultlist(),edt_search_contract.getText().toString());
                                countEqmentRequestAdapter.notifyDataSetChanged();
                            }
                        } else {
                            if (currentPageNum<=totalPage){
                                countEqmentRequestAdapter.addAllList(countEqmentRequestListBean.getResult().getResultlist());
                                countEqmentRequestAdapter.notifyDataSetChanged();
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
                currentPageNum=1;
                query();
                break;
        }
    }
    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();

    }
    // 刷新列表
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNotify(PostData postData) {
        if (postData.getTag().equals("计量设备台账增减申请"))
            query();
    }
}
