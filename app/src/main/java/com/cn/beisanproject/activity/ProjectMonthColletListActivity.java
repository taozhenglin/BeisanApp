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
import com.cn.beisanproject.adapter.ProjectMonthColletAdapter;
import com.cn.beisanproject.modelbean.ProjectMonthCollectBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yinglan.keyboard.HideUtil;

import java.io.Serializable;
import java.util.HashMap;

import okhttp3.Call;

/**
 * created by tzl 2020 0716 项目月度计划汇总列表
 */
public class ProjectMonthColletListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private ProjectMonthColletAdapter projectMonthColletAdapter;
    private TextView tv_back;
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
        tv_common_title.setText("项目月度计划汇总");
        edt_search_contract = findViewById(R.id.edt_search_contract);
        edt_search_contract.setHint("汇总编号/描述");
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
         *   "objectname" : "PR",
         *   "condition" : {
         *     "A_PRSUMTYPE" : "PROJSUM",
         *     "A_PRTYPE" : "PROJ"
         *   },
         *   "appid" : "PR",
         *   "option" : "read",
         *   "curpage" : 1,
         *   "showcount" : 20
         * }
         */
        LogUtils.d("query==");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PR");
        object.put("objectname", "PR");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        JSONObject conditionObj=new JSONObject();
        conditionObj.put("A_PRSUMTYPE","PROJSUM");
        conditionObj.put("A_PRTYPE","PROJ");
        object.put("condition", conditionObj);
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("PRNUM", edt_search_contract.getText().toString());
        sinorsearchobject.put("DESCRIPTION",  edt_search_contract.getText().toString());
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
                ProjectMonthCollectBean projectMonthCollectBean;
                finishRefresh();
                ld.close();
                if (!response.isEmpty()) {
                    projectMonthCollectBean = JSONObject.parseObject(response, new TypeReference<ProjectMonthCollectBean>() {
                    });

                    if (projectMonthCollectBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (projectMonthCollectBean.getResult().getResultlist().size()>0){
                            totalpage=projectMonthCollectBean.getResult().getTotalpage();
                            if (currentPageNum == 1) {
                                if (projectMonthColletAdapter==null){
                                    projectMonthColletAdapter = new ProjectMonthColletAdapter(ProjectMonthColletListActivity.this, projectMonthCollectBean.getResult().getResultlist(), edt_search_contract.getText().toString(),"ProjectMonthColletListActivity");
                                    recyclerView.setAdapter(projectMonthColletAdapter);
                                }else {
                                    projectMonthColletAdapter.setData(projectMonthCollectBean.getResult().getResultlist(),edt_search_contract.getText().toString());
                                    projectMonthColletAdapter.notifyDataSetChanged();
                                }

                            } else {
                                //重复数据处理
                                if (currentPageNum<=totalpage){
                                    projectMonthColletAdapter.addAllList(projectMonthCollectBean.getResult().getResultlist());
                                    projectMonthColletAdapter.notifyDataSetChanged();
                                }else {
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
}
