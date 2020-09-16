package com.cn.beisanproject.activity;

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
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.adapter.ProjectContractAdapter;
import com.cn.beisanproject.modelbean.ProjectContractListBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
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

public class ProjectContractListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private ProjectContractAdapter projectContractAdapter;
    private TextView tv_back;
    private TextView tv_common_title;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
    private int totalpage;
    private LinearLayout ll_back;
    private LoadingDialog ld;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_contract_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ld=new LoadingDialog(this);
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
        tv_common_title.setText("项目合同");
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
                //搜索
                currentPageNum=1;
                query();
                break;
        }
    }

    /**
     * 项目合同列表
     */
    private void query() {
        LogUtils.d("query");
        ld.show();
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PURCHVIEW");
        object.put("objectname", "PURCHVIEW");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "STARTDATE DESC");
        JSONObject searchobj = new JSONObject();//模糊查询
        searchobj.put("CONTRACTNUM", edt_search_contract.getText().toString());
        searchobj.put("DESCRIPTION", edt_search_contract.getText().toString());
        searchobj.put("HTYF", edt_search_contract.getText().toString());

//        searchobj.put("STATUS", edt_search_contract.getText().toString());
        object.put("sinorsearch", searchobj);
        object.put("sqlSearch", " LB='项目合同'");
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
                ld.close();
                ProjectContractListBean projectContractListBean;
                finishRefresh();
                if (!response.isEmpty()) {
                     projectContractListBean = JSONObject.parseObject(response, new TypeReference<ProjectContractListBean>() {
                    });
                    if (projectContractListBean.getErrcode().equals("GLOBAL-S-0")) {
                        totalpage=projectContractListBean.getResult().getTotalpage();
                        if (currentPageNum == 1) {
                            if (projectContractAdapter==null){
                                projectContractAdapter = new ProjectContractAdapter(ProjectContractListActivity.this, projectContractListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                recyclerView.setAdapter(projectContractAdapter);
                            }else{
                                projectContractAdapter.setData(projectContractListBean.getResult().getResultlist(),edt_search_contract.getText().toString());
                                projectContractAdapter.notifyDataSetChanged();

                            }

                        } else {

                            //重复数据处理
                            if (currentPageNum<=totalpage){
                                projectContractAdapter.addAllList(projectContractListBean.getResult().getResultlist());
                                projectContractAdapter.notifyDataSetChanged();
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
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent( StartWorkProcessBean startWorkProcessBean){
        LogUtils.d("onEvent==");
        if (startWorkProcessBean.getTag().equals("项目合同")){
            query();
        }
    }
}
