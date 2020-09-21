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
import com.cn.beisanproject.adapter.StockingMoveAdapter;
import com.cn.beisanproject.adapter.StockingTakeAdapter;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StockMoveListBean;
import com.cn.beisanproject.modelbean.StockingTakeListBean;
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
 * 库存转移 列表
 */
public class StockMoveListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private StockingMoveAdapter stockingMoveAdapter;
    private LinearLayout ll_back;
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
        setContentView(R.layout.stock_take_activity);
        //隐藏标题栏
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
        tv_common_title.setText("库存转移");
        edt_search_contract = findViewById(R.id.edt_search_contract);
        edt_search_contract.setHint("编号/描述/状态");
    }

    private void initEvent() {
        ld = new LoadingDialog(this);
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

    /**
     * http://10.169.87.216:7001/mobile/common/api?data=
     * {"appid":"INVUSE",
     * "objectname":"INVUSE",
     * "curpage":1,"showcount":20,
     * "option":"read",
     * "orderby":"INVUSENUM DESC"}
     */
    private void query() {

        ld.show();
        LogUtils.d("query");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "INVUSE");
        object.put("objectname", "INVUSE");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "INVUSENUM desc");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("INVUSENUM", edt_search_contract.getText().toString());
        sinorsearchobject.put("STATUS", edt_search_contract.getText().toString());
        sinorsearchobject.put("DESCRIPTION", edt_search_contract.getText().toString());
        object.put("sinorsearch", sinorsearchobject);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                finishRefresh();
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                StockMoveListBean stockMoveListBean;
                finishRefresh();
                if (!response.isEmpty()) {
                    stockMoveListBean = JSONObject.parseObject(response, new TypeReference<StockMoveListBean>() {});
//
                    if (stockMoveListBean.getErrcode().equals("GLOBAL-S-0")) {
                        totalpage = stockMoveListBean.getResult().getTotalpage();

                        if (currentPageNum == 1) {
                            if (stockingMoveAdapter == null) {
                                stockingMoveAdapter = new StockingMoveAdapter(StockMoveListActivity.this, stockMoveListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                recyclerView.setAdapter(stockingMoveAdapter);
                            } else {
                                stockingMoveAdapter.setData(stockMoveListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                stockingMoveAdapter.notifyDataSetChanged();
                            }

                        } else {

                            //重复数据处理
                            if (currentPageNum <= totalpage) {
                                stockingMoveAdapter.addAllList(stockMoveListBean.getResult().getResultlist());
                                stockingMoveAdapter.notifyDataSetChanged();
                            } else {
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
                currentPageNum = 1;
                query();
                break;
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNotify(PostData postData) {
        if (postData.getTag().equals("库存转移")) {
            query();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
