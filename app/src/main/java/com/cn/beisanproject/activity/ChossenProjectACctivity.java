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
import com.cn.beisanproject.modelbean.ChossenProjectListBean;
import com.cn.beisanproject.modelbean.DetailForProjectBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.HashMap;

import okhttp3.Call;

public class ChossenProjectACctivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private ChossenProjectAdapter chossenProjectAdapter;
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
        tv_common_title.setText("选择项目");
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


    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();

    }

    private void query() {
        /**
         * ---领料明细行-项目列表（sqlSearch 条件待定）
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"ITEM","objectname":"ITEM","curpage":1,"showcount":20,"option":"read","orderby":"",
         * "sinorsearch":{"ITEMNUM":"","DESCRIPTION":"","A_MODEL":""},"sqlSearch":" status='活动' "}
         */
        LogUtils.d("==query");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "ITEM");
        object.put("objectname", "ITEM");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("ITEMNUM", edt_search_contract.getText().toString());
        sinorsearchobject.put("DESCRIPTION ", edt_search_contract.getText().toString());
        sinorsearchobject.put("A_MODEL ", edt_search_contract.getText().toString());
        object.put("sinorsearch", sinorsearchobject);
        object.put("sqlSearch", " status='活动' ");
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
                ChossenProjectListBean chossenProjectListBean;
                finishRefresh();
                if (!response.isEmpty()) {
                    chossenProjectListBean = JSONObject.parseObject(response, new TypeReference<ChossenProjectListBean>() {
                    });

                    if (chossenProjectListBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (chossenProjectListBean.getResult().getResultlist().size() > 0) {
                            if (currentPageNum == 1) {
                                totalpage = chossenProjectListBean.getResult().getTotalpage();
                                totalresult = chossenProjectListBean.getResult().getTotalresult();
                                if (chossenProjectAdapter == null) {
                                    chossenProjectAdapter = new ChossenProjectAdapter(ChossenProjectACctivity.this, chossenProjectListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    recyclerView.setAdapter(chossenProjectAdapter);
                                } else {
                                    chossenProjectAdapter.setData(chossenProjectListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    chossenProjectAdapter.notifyDataSetChanged();
                                }

                            } else {
                                if (totalpage > 1 && totalresult > 20) {
                                    chossenProjectAdapter.addAllList(chossenProjectListBean.getResult().getResultlist());
                                    chossenProjectAdapter.notifyDataSetChanged();
                                }

                            }
                            chossenProjectAdapter.setOnclickListener(new ChossenProjectAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position, ChossenProjectListBean.ResultBean.ResultlistBean resultlistBean) {
                                    LogUtils.d("position==" + position);
                                    getDetail(resultlistBean.getITEMNUM());
                                }
                            });
                        }


                    }

                }

            }


        });
    }

    private void getDetail(String itemnum) {


        /**
         * ---物料明细行-根据明细行 【项目编号】从ITEM获取【领用单位、小类、规格型号、品牌】
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"ITEM","objectname":"ITEM","curpage":1,"showcount":20,"option":"read","orderby":"",
         * "sinorsearch":{"ITEMNUM":"","DESCRIPTION":"","A_MODEL":""},"sqlSearch":" status='活动' and ITEMNUM=:ITEMNUM"}
         */
        LogUtils.d("==query");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "ITEM");
        object.put("objectname", "ITEM");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("ITEMNUM", "");
        sinorsearchobject.put("DESCRIPTION ", "");
        sinorsearchobject.put("A_MODEL ", "");
        object.put("sinorsearch", sinorsearchobject);
        object.put("sqlSearch", " status='活动' and ITEMNUM= " + "'" + itemnum + "'");
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
                DetailForProjectBean detailForProjectBean;
                finishRefresh();
                if (!response.isEmpty()) {
                    detailForProjectBean = JSONObject.parseObject(response, new TypeReference<DetailForProjectBean>() {
                    });
                    if (detailForProjectBean.getErrcode().equals("GLOBAL-S-0")) {
                        Intent intent = new Intent();
                        intent.putExtra("data", detailForProjectBean.getResult().getResultlist().get(0));
                        setResult(RESULT_OK, intent);
                        finish();

                    }

                }

            }
        });

    }
}
