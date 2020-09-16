package com.cn.beisanproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.cn.beisanproject.adapter.MaterialRequestionAdapter;
import com.cn.beisanproject.modelbean.MaterialRequestListBean;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yinglan.keyboard.HideUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import okhttp3.Call;

/**
 * 领料单列表
 */
public class MaterialRequestListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private MaterialRequestionAdapter materialRequestionAdapter;
    private TextView tv_back;
    private TextView tv_common_title;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
    LoadingDialog ld;
    private ImageView iv_fun;
    int totalpage;
    int totalresult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_request_activity);
        //键盘自动隐藏
        HideUtil.init(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ld = new LoadingDialog(this);
        initView();
        initEvent();
        initListener();
    }

    private void initListener() {
        tv_back.setOnClickListener(this);
        tv_search.setOnClickListener(this);
//        iv_fun.setOnClickListener(this);
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
//        iv_fun = findViewById(R.id.iv_fun);
//        iv_fun.setBackgroundResource(R.drawable.add);
        tv_common_title.setText("领料单");
        edt_search_contract = findViewById(R.id.edt_search_contract);
    }

    private void initEvent() {
        getMaterialRequestList();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                getMaterialRequestList();


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                getMaterialRequestList();

            }
        });

    }

    /**
     * -- 领料单查询
     * http://192.168.1.180:7009/maximo/mobile/common/api?data=
     * {"appid":"WORKORDER","objectname":"WORKORDER","curpage":1,"showcount":20,"option":"read",
     * "orderby":"WORKORDERID  DESC","sinorsearch":{"WONUM":"","DESCRIPTION":""},"sqlSearch":" A_WOTYPE='MR' "}
     */
    private void getMaterialRequestList() {
        ld.show();
        LogUtils.d("getMaterialRequestList");
//
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "WORKORDER");
        object.put("objectname", "WORKORDER");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "WORKORDERID  DESC");
        JSONObject searchobj = new JSONObject();//模糊查询
        searchobj.put("WONUM", edt_search_contract.getText().toString());
        searchobj.put("DESCRIPTION", edt_search_contract.getText().toString());
//        searchobj.put("STATUS", edt_search_contract.getText().toString());
        object.put("sinorsearch", searchobj);
        object.put("sqlSearch", " A_WOTYPE='MR' ");
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
                MaterialRequestListBean materialRequestListBean;
                finishRefresh();
                ld.close();
                if (!response.isEmpty()) {
                    materialRequestListBean = JSONObject.parseObject(response, new TypeReference<MaterialRequestListBean>() {
                    });
                    if (materialRequestListBean.getErrcode().equals("GLOBAL-S-0")) {
                        totalpage = materialRequestListBean.getResult().getTotalpage();
                        totalresult = materialRequestListBean.getResult().getTotalresult();
                        if (currentPageNum == 1) {
                            if (materialRequestionAdapter == null) {
                                materialRequestionAdapter = new MaterialRequestionAdapter(MaterialRequestListActivity.this, materialRequestListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                recyclerView.setAdapter(materialRequestionAdapter);
                            } else {
                                materialRequestionAdapter.setData(materialRequestListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                materialRequestionAdapter.notifyDataSetChanged();
                            }

                        } else {
                            //重复数据处理
                            if (currentPageNum <= totalpage) {
                                materialRequestionAdapter.addAllList(materialRequestListBean.getResult().getResultlist());
                                materialRequestionAdapter.notifyDataSetChanged();
                            } else {
                                ToastUtils.showShort("没有更多数据了");
                            }

                        }


                    }
                }

            }

//            @Override
//            public void onResponse(String response) {
//            }
        });

    }

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe (threadMode = ThreadMode.MAIN)
    public void getNotiFication(PostData postData){
        LogUtils.d("222222 getNotiFication");
        if (postData!=null&&postData.getTag().equals("领料单")){
            getMaterialRequestList();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
//            case R.id.iv_fun://新增
////                startActivity(new Intent(this,AddMaterialListItemActivity.class));
//                break;
            case R.id.tv_search:  //搜索
                getMaterialRequestList();
                break;

        }
    }
}

