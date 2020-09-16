package com.cn.beisanproject.activity;

import android.content.Intent;
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
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.adapter.ChossenProjectAdapter;
import com.cn.beisanproject.adapter.ChossenStoreAdapter;
import com.cn.beisanproject.modelbean.ChossenProjectListBean;
import com.cn.beisanproject.modelbean.ChossenStoreListBean;
import com.cn.beisanproject.modelbean.DetailForProjectBean;
import com.cn.beisanproject.modelbean.DetailForStoreBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.HashMap;

import okhttp3.Call;

public class ChossenStoreACctivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private ChossenStoreAdapter chossenStoreAdapter;
    private LinearLayout ll_back;
    private TextView tv_common_title;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
    int totalpage;
    int totalresult;

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
        tv_common_title.setText("选择库房");
        edt_search_contract = findViewById(R.id.edt_search_contract);
        edt_search_contract.setHint("项目编号/描述");
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

    private void query() {
        /**
         * ---物料明细行-库房（sqlSearch 条件待定）
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"LOCATIONS","objectname":"LOCATIONS","curpage":1,"showcount":20,"option":"read","orderby":"",
         * "sinorsearch":{"LOCATION":"","DESCRIPTION":"","TYPE":"","SITEID":""},"sqlSearch":" 1=1 "}
         */
        LogUtils.d("==query");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "LOCATIONS");
        object.put("objectname", "LOCATIONS");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("LOCATION", edt_search_contract.getText().toString());
        sinorsearchobject.put("DESCRIPTION ", edt_search_contract.getText().toString());
        sinorsearchobject.put("TYPE ", edt_search_contract.getText().toString());
        sinorsearchobject.put("SITEID ", edt_search_contract.getText().toString());

        object.put("sinorsearch", sinorsearchobject);
        object.put("sqlSearch", "  SITEID='1000'  ");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                finishRefresh();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ChossenStoreListBean chossenStoreListBean;
                finishRefresh();
                if (!response.isEmpty()) {
                    chossenStoreListBean = JSONObject.parseObject(response, new TypeReference<ChossenStoreListBean>() {
                    });

                    if (chossenStoreListBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (chossenStoreListBean.getResult().getResultlist().size() > 0) {
                            if (currentPageNum == 1) {
                                totalpage = chossenStoreListBean.getResult().getTotalpage();
                                totalresult = chossenStoreListBean.getResult().getTotalresult();
                                if (chossenStoreAdapter == null) {
                                    chossenStoreAdapter = new ChossenStoreAdapter(ChossenStoreACctivity.this, chossenStoreListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    recyclerView.setAdapter(chossenStoreAdapter);
                                } else {
                                    chossenStoreAdapter.setData(chossenStoreListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    chossenStoreAdapter.notifyDataSetChanged();
                                }

                            } else {
                                if (currentPageNum <= totalpage) {
                                    chossenStoreAdapter.addAllList(chossenStoreListBean.getResult().getResultlist());
                                    chossenStoreAdapter.notifyDataSetChanged();
                                }

                            }
                            chossenStoreAdapter.setOnclickListener(new ChossenStoreAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position, ChossenStoreListBean.ResultBean.ResultlistBean resultlistBean) {
                                    LogUtils.d("position==" + position);
                                    Intent intent = new Intent();
                                    intent.putExtra("data", resultlistBean);
                                    setResult(RESULT_OK, intent);
                                    finish();
//                                    getDetail(resultlistBean.getLOCATION());
                                }
                            });
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
}
