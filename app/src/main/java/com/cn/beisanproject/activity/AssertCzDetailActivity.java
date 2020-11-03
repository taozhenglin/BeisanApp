package com.cn.beisanproject.activity;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.adapter.AssertJsDetailLineAdapter;
import com.cn.beisanproject.modelbean.AssertCheckCzListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2020/11/3
 */
public class AssertCzDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private AssertCheckCzListBean.ResultBean.ResultlistBean resultlistBean;
    private TextView tv_check_no;
    private TextView tv_check_desc;
    TextView tv_statues;
    private TextView tv_check_by;
    private TextView tv_check_starttime;
    private TextView tv_check_endtime;
    private TextView tv_created_by;
    private TextView tv_created_time;
    private LinearLayout ll_assert_container;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private boolean isRefresh=true;
    private AssertJsDetailLineAdapter assertDetailLineAdapter;
    TextView tv_title;
    private TextView tv_approval;
    private LoadingDialog ld;
    private View top_bar;
    private LinearLayout ll_back;
    TextView tv_common_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assert_detail_fragment);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        resultlistBean = (AssertCheckCzListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
        initView();
    }

    private void initView() {
        top_bar = findViewById(R.id.top_bar);
        top_bar.setVisibility(View.VISIBLE);
        ll_back = findViewById(R.id.ll_back);
        ll_back.setOnClickListener(this);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("处置详情");
        tv_check_no = findViewById(R.id.tv_check_no);
        tv_check_desc = findViewById(R.id.tv_check_desc);
        tv_check_by = findViewById(R.id.tv_check_by);
        tv_check_starttime = findViewById(R.id.tv_check_starttime);
        tv_check_endtime = findViewById(R.id.tv_check_endtime);
        tv_created_by = findViewById(R.id.tv_created_by);
        tv_created_time = findViewById(R.id.tv_created_time);

        tv_check_no.setText("申请单号: " +resultlistBean.getFIXEASSETRETNUM());
        tv_statues= findViewById(R.id.tv_statues);
        tv_statues.setVisibility(View.VISIBLE);
        tv_statues.setText(resultlistBean.getSTATUS());
        tv_check_desc.setText("描述: " +resultlistBean.getDESCRIPTION());
        tv_check_by.setText("创建人: " +resultlistBean.getENTERBY());
        tv_check_starttime.setText("申请日期: " +resultlistBean.getENTERDATE());
        tv_check_endtime.setText("申请事由: " +resultlistBean.getREASON());
        tv_created_by.setText("管理部门: " +resultlistBean.getMANAGEMENT());
        tv_created_time.setVisibility(View.GONE);

        tv_title = findViewById(R.id.tv_title);
        tv_title.setText("处置明细行");
        tv_approval = findViewById(R.id.tv_approval);
        tv_approval.setVisibility(View.VISIBLE);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = findViewById(R.id.refreshLayout);

        ld = new LoadingDialog(this);
        getAssertLineDetail();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                getAssertLineDetail();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                getAssertLineDetail();
            }
        });
    }

    /**
     * -- 固定资产处置明细行查询
     * http://192.168.1.180:7009/maximo/mobile/common/api?data=
     * {"appid":"FIXEASSETRETLINE","objectname":"FIXEASSETRETLINE","curpage":1,"showcount":20,"option":"read","orderby":"",
     * "sinorsearch":{"FIXASSETNUM":"","YPD":""},"sqlSearch":" FIXPDNUM=:FIXPDNUM "}
     */
    public void getAssertLineDetail() {
        ld.show();
        LogUtils.d("getAssertLineDetail");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "FIXEASSETRETLINE");
        object.put("objectname", "FIXEASSETRETLINE");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        //模糊查询
//        JSONObject sinorsearchobject = new JSONObject();
//        sinorsearchobject.put("FIXASSETNUM", "");
//        sinorsearchobject.put("YPD", "");
//        object.put("sinorsearch", sinorsearchobject);
        LogUtils.d("222222"+resultlistBean.getFIXEASSETRETNUM());
        object.put("sqlSearch", "FIXEASSETRETNUM=" + resultlistBean.getFIXEASSETRETNUM());
        //请求头
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure=" + e.toString());
                finishRefresh();
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse=" + response);
                finishRefresh();
                ld.close();
//                if (!response.isEmpty()) {
//                    AssertJsDetailLineBean assertJsDetailLineBean = JSONObject.parseObject(response, new TypeReference<AssertJsDetailLineBean>() {});
//                    if (assertJsDetailLineBean.getErrcode().equals("GLOBAL-S-0")) {
//                        if (assertJsDetailLineBean.getResult().getResultlist().size()>0){
//                            List<AssertJsDetailLineBean.ResultBean.ResultlistBean> resultlist = assertJsDetailLineBean.getResult().getResultlist();
//                            int  totalPage=assertJsDetailLineBean.getResult().getTotalpage();
//                            if (currentPageNum == 1) {
//                                if (assertDetailLineAdapter==null){
//                                    assertDetailLineAdapter = new AssertJsDetailLineAdapter(AssertJsDetailActivity.this, resultlist);
//                                    recyclerView.setAdapter(assertDetailLineAdapter);
//                                }else {
//                                    assertDetailLineAdapter.setData(resultlist);
//                                    assertDetailLineAdapter.notifyDataSetChanged();
//                                }
//
//                            } else {
//                                if (currentPageNum<=totalPage){
//                                    assertDetailLineAdapter.addAllList(resultlist);
//                                    assertDetailLineAdapter.notifyDataSetChanged();
//                                }else {
//                                    ToastUtils.showShort("没有更多数据了");
//                                }
//
//                            }
//                        }
//
//                    }
//
//                }

            }


        });

    }
    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_approval:
                finish();
                break;
        }
    }
}
