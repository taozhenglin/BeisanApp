package com.cn.beisanproject.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import com.cn.beisanproject.adapter.StockingTakeAdapter;
import com.cn.beisanproject.handler.RFIDHandler;
import com.cn.beisanproject.modelbean.StockingTakeListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yinglan.keyboard.HideUtil;
import com.zebra.rfid.api3.Readers;
import com.zebra.rfid.api3.TagData;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;


public class StockTakeListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private StockingTakeAdapter stockingTakeAdapter;
    private LinearLayout ll_back;
    private TextView tv_common_title;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private EditText edt_search_contract;
    private TextView tv_search;
    private int totalpage;

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
        // RFID Handler
//        rfidHandler = new RFIDHandler();
//        rfidHandler.onCreate(this);
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
        tv_common_title.setText("库存盘点");
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

    /**
     * --库存盘点列表查询
     * http://192.168.1.180:7009/maximo/mobile/common/api?data=
     * {"appid":"UDSTOCK","objectname":"UDSTOCK","curpage":1,"showcount":20,"option":"read","orderby":"STOCKNUM desc"}
     */
    private void query() {

        LogUtils.d("query");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "UDSTOCK");
        object.put("objectname", "UDSTOCK");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "STOCKNUM desc");
        JSONObject sinorsearchobject = new JSONObject();//模糊查询要用到  均传用户输入内容
        sinorsearchobject.put("STOCKNUM", edt_search_contract.getText().toString());
        sinorsearchobject.put("DESCRIPTION", edt_search_contract.getText().toString());
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
                StockingTakeListBean stockingTakeListBean;
                finishRefresh();
                if (!response.isEmpty()) {
                    stockingTakeListBean = JSONObject.parseObject(response, new TypeReference<StockingTakeListBean>() {
                    });

                    if (stockingTakeListBean.getErrcode().equals("GLOBAL-S-0")) {
                        totalpage = stockingTakeListBean.getResult().getTotalpage();
                        if (stockingTakeListBean.getResult().getResultlist().size()>0){
//                            for (int i = 0; i <stockingTakeListBean.getResult().getResultlist().size() ; i++) {
//                                stockingTakeListBean.getResult().getResultlist().get(i).setHaschecked("no");
//                            }
                            if (currentPageNum == 1) {
                                if (stockingTakeAdapter == null) {
                                    stockingTakeAdapter = new StockingTakeAdapter(StockTakeListActivity.this, stockingTakeListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    recyclerView.setAdapter(stockingTakeAdapter);
                                } else {
                                    stockingTakeAdapter.setData(stockingTakeListBean.getResult().getResultlist(), edt_search_contract.getText().toString());
                                    stockingTakeAdapter.notifyDataSetChanged();
                                }

                            } else {

                                //重复数据处理
                                if (currentPageNum <= totalpage) {
                                    stockingTakeAdapter.addAllList(stockingTakeListBean.getResult().getResultlist());
                                    stockingTakeAdapter.notifyDataSetChanged();
                                } else {
                                    ToastUtils.showShort("没有更多数据了");
                                }
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
                currentPageNum=1;
                query();

                break;
        }
    }

//    @Override
//    public void handleTagdata(TagData[] tagData) {
//        Log.d("222222", "handleTagdata");
//        ToastUtils.showShort("handleTagdata");
//        final StringBuilder sb = new StringBuilder();
//        for (int index = 0; index < tagData.length; index++) {
//            sb.append(tagData[index].getTagID() + "\n");
//        }
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
////                textrfid.append(sb.toString());
//                Log.d("222222","sb.toString()="+sb.toString());
//                ToastUtils.showShort(sb.toString());
////                List<StockingTakeListBean.ResultBean.ResultlistBean> data = stockingTakeAdapter.getData();
////                for (int i = 0; i <data.size() ; i++) {
////                    for (int j = 0; j < tagData.length; j++) {
////                       if (data.get(i).getSTOCKNUM().equals(tagData[j].getTagID())){
////                           data.get(i).setHaschecked("yes");
////                       }
////                    }
////
////                }
////                stockingTakeAdapter.notifyDataSetChanged();
//            }
//        });
//    }

//    @Override
//    public void handleTriggerPress(boolean pressed) {
//        if (pressed) {
//            Log.d("222222", "handleTriggerPress pressed=true");
//
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
////                    textrfid.setText("");
//                }
//            });
//            rfidHandler.performInventory();
//        } else {
//            Log.d("222222", "handleTriggerPress pressed=false");
//            rfidHandler.stopInventory();
//        }
//
//    }


}
