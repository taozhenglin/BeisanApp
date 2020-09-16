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
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.adapter.ProjectContractChangeAdapter;
import com.cn.beisanproject.adapter.ProjectMothAdapter;
import com.cn.beisanproject.modelbean.ProjectContractChangeBean;
import com.cn.beisanproject.modelbean.ProjectMonthListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yinglan.keyboard.HideUtil;

import java.util.HashMap;

import okhttp3.Call;

/**
 * 项目合同变更列表
 */
public class ProjectContractChangeListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private ProjectContractChangeAdapter projectContractChangeAdapter;
    private TextView tv_back;
    private TextView tv_common_title;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
    private LinearLayout ll_back;

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
        tv_common_title.setText("项目合同变更");
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

    private void query() {
        /**
         * {
         *   "objectname" : "UDPURCHBG",
         *   "orderby" : "UDBGNUM DESC",
         *   "appid" : "UDPURCHBG",
         *   "option" : "read",
         *   "curpage" : 1,
         *   "showcount" : 20
         * }
         */

        LogUtils.d("query==");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "UDPURCHBG");
        object.put("objectname", "UDPURCHBG");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "UDBGNUM DESC");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("UDBGNUM", edt_search_contract.getText().toString());
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
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse=" + response);
                ProjectContractChangeBean projectContractChangeBean;
                finishRefresh();
                if (!response.isEmpty()) {
                    projectContractChangeBean = JSONObject.parseObject(response, new TypeReference<ProjectContractChangeBean>() {
                    });

                    if (projectContractChangeBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (currentPageNum == 1) {
                            if (projectContractChangeAdapter==null){
                                projectContractChangeAdapter = new ProjectContractChangeAdapter(ProjectContractChangeListActivity.this, projectContractChangeBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                recyclerView.setAdapter(projectContractChangeAdapter);
                            }else {
                                projectContractChangeAdapter.setData(projectContractChangeBean.getResult().getResultlist(),edt_search_contract.getText().toString());
                                projectContractChangeAdapter.notifyDataSetChanged();
                            }

                        } else {
                            projectContractChangeAdapter.addAllList(projectContractChangeBean.getResult().getResultlist());
                            projectContractChangeAdapter.notifyDataSetChanged();
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
