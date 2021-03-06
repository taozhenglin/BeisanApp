package com.cn.beisanproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.activity.MainActivity;
import com.cn.beisanproject.adapter.WaitDoAdapter;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.WaitDoListBean;
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

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import me.leolin.shortcutbadger.ShortcutBadger;
import okhttp3.Call;

public class WaitDoFragment extends Fragment implements View.OnClickListener {
    private final Context mContext;
    private LoadingDialog ld;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    int currentPageNum = 1;
    private boolean isRefresh;
    private WaitDoAdapter mWaitDoAdapter;
    private int totalepage;
    private LinearLayout ll_top;
    private TextView tv_select_all;
    private TextView tv_unselect_all;
    private TextView tv_commit_all;
    List<WaitDoListBean.ResultBean.ResultlistBean> resultlist;
    private TextView tv_select_menu;

    public WaitDoFragment(Context context) {
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.waitdo_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        refreshLayout = view.findViewById(R.id.refreshLayout);
//        mainListAdapter.setShowLine(false);
        layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ll_top = view.findViewById(R.id.ll_top);
        tv_select_menu = view.findViewById(R.id.tv_select_menu);
        tv_select_all = view.findViewById(R.id.tv_select_all);
        tv_unselect_all = view.findViewById(R.id.tv_unselect_all);
        tv_commit_all = view.findViewById(R.id.tv_commit_all);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEvent();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    void initEvent() {
        tv_select_menu.setOnClickListener(this);
        tv_select_all.setOnClickListener(this);
        tv_unselect_all.setOnClickListener(this);
        tv_commit_all.setOnClickListener(this);
        queryData();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                if (mWaitDoAdapter != null) {
                    mWaitDoAdapter.mFlag = false;
                    tv_select_menu.setText("编辑");
                }
                queryData();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                queryData();
            }
        });
    }

    private void queryData() {
        ld = new LoadingDialog(mContext);
        ld.show();
        /**
         * ---代办任务记录
         * {"appid":"WFASSIGNMENT","objectname":"WFASSIGNMENT","curpage":1,"showcount":20,"option":"read","orderby":"startdate desc",
         * "sqlSearch":"  exists (select personid from maxuser where loginid='HUYUE'
         * and wfassignment.assigncode=maxuser.personid)
         * and assignstatus='活动' and processname in('PO','RFQ','CONTPURCH','PRSUM','PR','GPDTZ','VENAPPLY','JLTZ','MATREQ','SBTZ','SSTZ','XMHT','UDXMHTBG','PRPROJ','XBJ','PROJSUM','XXHTZ','CONTRACTPO','INVUSEZY','FIXEDASSETJS','FIXEASSETRET')"}
         */
        LogUtils.d("query");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "WFASSIGNMENT");
        object.put("objectname", "WFASSIGNMENT");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "startdate desc");
        String sqlSearch = " exists (select personid from maxuser where loginid=%s " +
                "and wfassignment.assigncode=maxuser.personid)  " +
                "and assignstatus='活动' and processname in('PO','RFQ','CONTPURCH','PRSUM','PR','GPDTZ','VENAPPLY','JLTZ','MATREQ','SBTZ','SSTZ','XMHT','UDXMHTBG','PRPROJ','XBJ','PROJSUM','XXHTZ','CONTRACTPO','INVUSEZY','UDFIXYSRG','UDFIXBF','UDFIXZZ','UDPRYS')";
        sqlSearch = String.format(sqlSearch, "'" + SharedPreferencesUtil.getString(mContext, "personId") + "'");
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
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                WaitDoListBean waitDoListBean = null;
                finishRefresh();
                ld.close();
                if (!response.isEmpty()) {
                    if (response.startsWith("Error")) {
                        ToastUtils.showShort(R.string.GETDATAFAILED);
                    } else {
                        waitDoListBean = JSONObject.parseObject(response, new TypeReference<WaitDoListBean>() {});
                        if (waitDoListBean.getErrcode().equals("GLOBAL-S-0")) {
                            totalepage = waitDoListBean.getResult().getTotalpage();
                            int totalresult = waitDoListBean.getResult().getTotalresult();
                            resultlist = waitDoListBean.getResult().getResultlist();
                            PostData postData = new PostData();
                            postData.setCount(totalresult);
                            postData.setTag("waitdocount");
                            EventBus.getDefault().post(postData);
                            SharedPreferencesUtil.setInt(mContext, "waitdototalresult", totalresult);
                            if (resultlist.size() > 0) {
                                for (int i = 0; i < resultlist.size(); i++) {
                                    resultlist.get(i).setChecked(false);
                                }

//                            if (totalresult > 0) {
//                                ShortcutBadger.applyCount(mContext, totalresult); //for 1.1.4+
//                            }else{
//                                ShortcutBadger.removeCount(mContext);
//                            }
                                if (currentPageNum == 1) {
                                    if (mWaitDoAdapter == null) {
                                        mWaitDoAdapter = new WaitDoAdapter(mContext, resultlist);
                                        recyclerView.setAdapter(mWaitDoAdapter);
                                    } else {
                                        mWaitDoAdapter.setData(resultlist);
                                        mWaitDoAdapter.notifyDataSetChanged();
                                    }

                                } else {
                                    if (currentPageNum <= totalepage) {
                                        mWaitDoAdapter.addAllList(resultlist);
                                        mWaitDoAdapter.notifyDataSetChanged();
                                    } else {
                                        ToastUtils.showShort("没有更多数据了");
                                    }

                                }
                            } else {
                                ll_top.setVisibility(View.GONE);
                                refreshLayout.setVisibility(View.GONE);
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

    // 收到扫描盘点界面上传盘点ok后的通知 刷新列表
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNotify(PostData postData) {
        if (postData.getTag().equals("采购合同") || postData.getTag().equals("项目合同") ||
                postData.getTag().equals("领料单") || postData.getTag().equals("库存转移") ||
                postData.getTag().equals("计量设备台账增减申请") || postData.getTag().equals("设备台账增减申请") ||
                postData.getTag().equals("信息化台账增减申请") || postData.getTag().equals("设施台账增减申请") ||
                postData.getTag().equals("供配电设备台账增减申请") || postData.getTag().equals("供应商申请") ||
                postData.getTag().equals("采购月度计划汇总") || postData.getTag().equals("采购月度计划") ||
                postData.getTag().equals("采购询价单") || postData.getTag().equals("采购订单") ||
                postData.getTag().equals("入库单") || postData.getTag().equals("项目合同变更") ||
                postData.getTag().equals("项目月度计划汇总") || postData.getTag().equals("项目询价单") ||
                postData.getTag().equals("项目立项/项目月度计划") || postData.getTag().equals("固定资产接收") ||
                postData.getTag().equals("固定资产处置") || postData.getTag().equals("项目验收")
        ) {
            queryData();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_select_menu:
                mWaitDoAdapter.mFlag = !mWaitDoAdapter.mFlag;

                if (mWaitDoAdapter.mFlag) {
                    tv_select_menu.setText("取消");
                } else {
                    tv_select_menu.setText("编辑");
                }
                mWaitDoAdapter.notifyDataSetChanged();
                break;
            case R.id.tv_select_all:
                if (mWaitDoAdapter.mFlag) {
                    for (int i = 0; i < mWaitDoAdapter.getData().size(); i++) {
                        mWaitDoAdapter.getData().get(i).setChecked(true);
                    }
                }
                mWaitDoAdapter.notifyDataSetChanged();
                break;
            case R.id.tv_unselect_all:
                if (mWaitDoAdapter.mFlag) {
                    for (int i = 0; i < mWaitDoAdapter.getData().size(); i++) {
                        mWaitDoAdapter.getData().get(i).setChecked(false);
                    }
                }
                mWaitDoAdapter.notifyDataSetChanged();
                break;
            case R.id.tv_commit_all:
                List<String> ids = new ArrayList<>();
                if (mWaitDoAdapter.mFlag) {
                    for (int i = 0; i < mWaitDoAdapter.getData().size(); i++) {
                        if (mWaitDoAdapter.getData().get(i).getChecked()) {
                            ids.add(mWaitDoAdapter.getData().get(i).getOWNERID() + "");
                        }
                    }
                    LogUtils.d("222222    "+ids.size());

                }
                break;
        }
    }
}
