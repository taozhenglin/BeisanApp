package com.cn.beisanproject.activity;

import android.content.Intent;
import android.os.Bundle;
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
import com.cn.beisanproject.adapter.CommmonForMaterialDetaiAdapter;
import com.cn.beisanproject.adapter.PurchseContractAdapter;
import com.cn.beisanproject.adapter.YuSuanListAdapter;
import com.cn.beisanproject.modelbean.CommmonForMaterialDetailBean;
import com.cn.beisanproject.modelbean.PurchseContractListBean;
import com.cn.beisanproject.modelbean.YuSuanListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yinglan.keyboard.HideUtil;

import java.util.HashMap;

import okhttp3.Call;

public class YuSuanListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private YuSuanListAdapter yuSuanListAdapter;
    CommmonForMaterialDetaiAdapter commmonForMaterialDetaiAdapter;
    private TextView tv_back;
    private TextView tv_common_title;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
    private int totalpage;
    private String tag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purshase_contract_activity);
        tag=getIntent().getStringExtra("tag");
        //键盘自动隐藏
        HideUtil.init(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        initView();
        initEvent();


    }

    private void initEvent() {
        if (tag.equals("预算")){
            query1();
        }else {
            query2();
        }

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                if (tag.equals("预算")){
                    query1();
                }else {
                    query2();
                }


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                if (tag.equals("预算")){
                    query1();
                }else {
                    query2();
                }

            }
        });

    }
// 职能部门  使用方向 工单类型
    private void query2() {
        /**
         * {
         *   "objectname" : "ALNDOMAIN",
         *   "option" : "read",
         *   "curpage" : 1,
         *   "sinorsearch" : {
         *     "VALUE" : "",
         *     "DESCRIPTION" : ""
         *   },
         *   "showcount" : 20,
         *   "sqlSearch" : "DOMAINID = 'PRPOSTYPE'",
         *   "appid" : "ALNDOMAIN"
         * }
         */

        /**
         * {
         *   "objectname" : "ALNDOMAIN",
         *   "option" : "read",
         *   "curpage" : 1,
         *   "sinorsearch" : {
         *     "VALUE" : "",
         *     "DESCRIPTION" : ""
         *   },
         *   "showcount" : 20,
         *   "sqlSearch" : "DOMAINID = 'D_USEFOR'",
         *   "appid" : "ALNDOMAIN"
         * }
         */

        /**
         * {
         *   "objectname" : "ALNDOMAIN",
         *   "option" : "read",
         *   "orderby" : "",
         *   "curpage" : 1,
         *   "sinorsearch" : {
         *     "VALUE" : "",
         *     "DESCRIPTION" : ""
         *   },
         *   "showcount" : 20,
         *   "sqlSearch" : "DOMAINID = 'D_WOTYPE'  AND VALUE= 'MR'",
         *   "appid" : "ALNDOMAIN"
         * }
         */
        LogUtils.d("query2");
//
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "ALNDOMAIN");
        object.put("objectname", "ALNDOMAIN");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        JSONObject searchobj = new JSONObject();//模糊查询
        searchobj.put("VALUE", edt_search_contract.getText().toString());
        searchobj.put("DESCRIPTION", edt_search_contract.getText().toString());
        object.put("sinorsearch", searchobj);
        String sqlSearch;
        if (tag.equals("职能部门")){
            sqlSearch="DOMAINID = 'PRPOSTYPE'";
        }else if (tag.equals("使用方向")){
            sqlSearch="DOMAINID = 'D_USEFOR'";
        }else {//工单类型
            sqlSearch="DOMAINID = 'D_WOTYPE'  AND VALUE= 'MR'";
        }
        object.put("sqlSearch", sqlSearch);
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
                finishRefresh();
                CommmonForMaterialDetailBean commmonForMaterialDetailBean;
                if (!response.isEmpty()) {
                    commmonForMaterialDetailBean = JSONObject.parseObject(response, new TypeReference<CommmonForMaterialDetailBean>() {
                    });
                    if (commmonForMaterialDetailBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (commmonForMaterialDetailBean.getResult().getResultlist().size() > 0) {
                            totalpage = commmonForMaterialDetailBean.getResult().getTotalpage();
                            if (currentPageNum == 1) {
                                if (commmonForMaterialDetaiAdapter == null) {
                                    commmonForMaterialDetaiAdapter = new CommmonForMaterialDetaiAdapter(YuSuanListActivity.this, commmonForMaterialDetailBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    recyclerView.setAdapter(commmonForMaterialDetaiAdapter);
                                } else {
                                    commmonForMaterialDetaiAdapter.setData(commmonForMaterialDetailBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    commmonForMaterialDetaiAdapter.notifyDataSetChanged();
                                }

                            } else {
                                //重复数据处理
                                if (currentPageNum <= totalpage) {
                                    commmonForMaterialDetaiAdapter.addAllList(commmonForMaterialDetailBean.getResult().getResultlist());
                                    commmonForMaterialDetaiAdapter.notifyDataSetChanged();
                                } else {
                                    ToastUtils.showShort("没有更多数据了");
                                }
                            }
                            commmonForMaterialDetaiAdapter.setOnclickListener(new CommmonForMaterialDetaiAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position, CommmonForMaterialDetailBean.ResultBean.ResultlistBean resultlistBean) {
                                    LogUtils.d("position==" + position);
                                    Intent intent = new Intent();
                                    intent.putExtra("data", resultlistBean);
                                    setResult(RESULT_OK, intent);
                                    finish();
                                }
                            });
                        }


                    }

                }
            }
        });


    }

    // 仅预算
    private void query1() {
        /**
         * {
         *   "objectname" : "FINCNTRL",
         *   "option" : "read",
         *   "curpage" : 1,
         *   "sinorsearch" : {
         *     "UDSSND" : "",
         *     "UDYSLX" : "",
         *     "DESCRIPTION" : "",
         *     "PROJECTID" : ""
         *   },
         *   "showcount" : 20,
         *   "sqlSearch" : "FCSTATUS='已批准'",
         *   "appid" : "FINCNTRL"
         * }
         */
        LogUtils.d("query1");
//
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "FINCNTRL");
        object.put("objectname", "FINCNTRL");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "STARTDATE DESC");
        JSONObject searchobj = new JSONObject();//模糊查询
        searchobj.put("UDSSND", edt_search_contract.getText().toString());
        searchobj.put("UDYSLX", edt_search_contract.getText().toString());
        searchobj.put("DESCRIPTION", edt_search_contract.getText().toString());
        searchobj.put("PROJECTID", edt_search_contract.getText().toString());
        object.put("sinorsearch", searchobj);
        object.put("sqlSearch", "FCSTATUS='已批准'");
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
                finishRefresh();
                YuSuanListBean yuSuanListBean;
                if (!response.isEmpty()) {
                    yuSuanListBean = JSONObject.parseObject(response, new TypeReference<YuSuanListBean>() {
                    });
                    if (yuSuanListBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (yuSuanListBean.getResult().getResultlist().size() > 0) {
                            totalpage = yuSuanListBean.getResult().getTotalpage();
                            if (currentPageNum == 1) {
                                if (yuSuanListAdapter == null) {
                                    yuSuanListAdapter = new YuSuanListAdapter(YuSuanListActivity.this, yuSuanListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    recyclerView.setAdapter(yuSuanListAdapter);
                                } else {
                                    yuSuanListAdapter.setData(yuSuanListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    yuSuanListAdapter.notifyDataSetChanged();
                                }

                            } else {
                                //重复数据处理
                                if (currentPageNum <= totalpage) {
                                    yuSuanListAdapter.addAllList(yuSuanListBean.getResult().getResultlist());
                                    yuSuanListAdapter.notifyDataSetChanged();
                                } else {
                                    ToastUtils.showShort("没有更多数据了");
                                }
                            }
                            yuSuanListAdapter.setOnclickListener(new YuSuanListAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position, YuSuanListBean.ResultBean.ResultlistBean resultlistBean) {
                                    LogUtils.d("position==" + position);
                                    Intent intent = new Intent();
                                    intent.putExtra("data", resultlistBean);
                                    setResult(RESULT_OK, intent);
                                    finish();


                                }
                            });
                        }


                    }

                }
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
        tv_back.setOnClickListener(this);
        tv_search = findViewById(R.id.tv_search);
        tv_search.setOnClickListener(this::onClick);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText(tag);
        edt_search_contract = findViewById(R.id.edt_search_contract);
        edt_search_contract.setHint("");

    }

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_search:
                if (tag.equals("预算")){
                    query1();
                }else {
                    query2();
                }
                break;

        }
    }
}
