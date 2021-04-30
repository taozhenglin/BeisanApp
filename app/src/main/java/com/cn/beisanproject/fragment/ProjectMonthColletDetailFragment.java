package com.cn.beisanproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.activity.ProjectMonthColletDetailActivity;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.ProjectMonthCollectBean;
import com.cn.beisanproject.modelbean.ProjectMonthColletLineBean;
import com.cn.beisanproject.modelbean.ProjectMonthColletedBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

public class ProjectMonthColletDetailFragment extends Fragment {
    private final Context mContext;
    private final ProjectMonthCollectBean.ResultBean.ResultlistBean mResultlistBean;
    private final ProjectMonthCollectBean.ResultBean.ResultlistBean mProjectMonthCollectBean;
    private final boolean mNeedGet;
    private TextView tv_contract_no;
    private TextView tv_contract_statue;
    private TextView tv_contract_desc;
    private TextView tv_collet_date;
    private TextView tv_collet_time;
    private TextView tv_collet_type;
    private TextView tv_collet_by;
    private TextView tv_line1;
    private TextView tv_line2;
    private LinearLayout ll_top;
    private LinearLayout ll_button;
    private String PRNUM;
    private String A_PRKEY;

    public ProjectMonthColletDetailFragment(Context context, ProjectMonthCollectBean.ResultBean.ResultlistBean resultlistBean, ProjectMonthCollectBean.ResultBean.ResultlistBean projectMonthCollectBean, boolean needGet) {
        mContext = context;
        mResultlistBean = resultlistBean;
        mProjectMonthCollectBean = projectMonthCollectBean;
        mNeedGet = needGet;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.project_month_detail_fragment, container, false);
        tv_contract_no = view.findViewById(R.id.tv_contract_no);
        tv_contract_statue = view.findViewById(R.id.tv_contract_statue);
        tv_contract_desc = view.findViewById(R.id.tv_contract_desc);
        tv_collet_date = view.findViewById(R.id.tv_collet_date);
        tv_collet_time = view.findViewById(R.id.tv_collet_time);
        tv_collet_type = view.findViewById(R.id.tv_collet_type);
        tv_collet_by = view.findViewById(R.id.tv_collet_by);
        tv_line1 = view.findViewById(R.id.tv_line1);
        tv_line2 = view.findViewById(R.id.tv_line2);
        ll_top = view.findViewById(R.id.ll_top);
        ll_button = view.findViewById(R.id.ll_button);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mNeedGet) {
            PRNUM = mProjectMonthCollectBean.getPRNUM();
            A_PRKEY= mProjectMonthCollectBean.getA_PRKEY();
            tv_contract_no.setText("汇总编号：" + mProjectMonthCollectBean.getPRNUM());
            tv_contract_statue.setText(mProjectMonthCollectBean.getSTATUS());
            tv_contract_desc.setText("描述：" + mProjectMonthCollectBean.getDESCRIPTION());
            tv_collet_date.setText("汇总年月：" + mProjectMonthCollectBean.getA_PRKEY());
            tv_collet_time.setText("汇总时间：" + mProjectMonthCollectBean.getISSUEDATE());
            tv_collet_type.setText("汇总类型：" + mProjectMonthCollectBean.getA_PRSUMTYPE());
            tv_collet_by.setText("汇总人：" + mProjectMonthCollectBean.getR_DEPTDESC());
        } else {
            PRNUM = mResultlistBean.getPRNUM();
            A_PRKEY= mResultlistBean.getA_PRKEY();
            tv_contract_no.setText("汇总编号：" + mResultlistBean.getPRNUM());
            tv_contract_statue.setText(mResultlistBean.getSTATUS());
            tv_contract_desc.setText("描述：" + mResultlistBean.getDESCRIPTION());
            tv_collet_date.setText("汇总年月：" + mResultlistBean.getA_PRKEY());
            tv_collet_time.setText("汇总时间：" + mResultlistBean.getISSUEDATE());
            tv_collet_type.setText("汇总类型：" + mResultlistBean.getA_PRSUMTYPE());
            tv_collet_by.setText("汇总人：" + mResultlistBean.getR_DEPTDESC());
        }
        getCollectedList();
        getNeedCollectList();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    private void getNeedCollectList() {

        /**
         * {
         *   "objectname" ： "PR",
         *   "option" ： "read",
         *   "orderby" ： "",
         *   "curpage" ： 1,
         *   "showcount" ： 20,
         *   "sqlSearch" ： "A_PRKEY='201905' and a_prtype = 'PROJ'  and a_prsumtype is null and status='已批准' and a_tosum=0",
         *   "appid" ： "PR"
         * }
         */
        LogUtils.d("getNeedCollectList");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PR");
        object.put("objectname", "PR");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        String sqlSearch = "A_PRKEY=%s and a_prtype = 'PROJ'  and a_prsumtype is null and status=%s and a_tosum=%s";
        sqlSearch = String.format(sqlSearch, "'" + A_PRKEY + "'", "'" + "已批准" + "'", "'" + 0 + "'");
        object.put("sqlSearch", sqlSearch);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                if (!response.isEmpty()) {
                    ProjectMonthColletedBean projectMonthColletedBean = JSONObject.parseObject(response, new TypeReference<ProjectMonthColletedBean>() {
                    });
                    if (projectMonthColletedBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<ProjectMonthColletedBean.ResultBean.ResultlistBean> resultlist = projectMonthColletedBean.getResult().getResultlist();
                        ll_button.removeAllViews();
                        if (resultlist.size() > 0) {
                            for (int i = 0; i < resultlist.size(); i++) {
                                View inflate = LayoutInflater.from(mContext).inflate(R.layout.project_month_collected_item, ll_top, false);
                                TextView tv_request_no = inflate.findViewById(R.id.tv_request_no);
                                TextView tv_desc = inflate.findViewById(R.id.tv_desc);
                                TextView tv_statues = inflate.findViewById(R.id.tv_statues);
                                TextView tv_total_cost = inflate.findViewById(R.id.tv_total_cost);
                                TextView tv_request_by = inflate.findViewById(R.id.tv_request_by);
                                TextView tv_request_dep = inflate.findViewById(R.id.tv_request_dep);
                                TextView tv_request_team = inflate.findViewById(R.id.tv_request_team);
                                TextView tv_request_type = inflate.findViewById(R.id.tv_request_type);
                                TextView tv_is_collected = inflate.findViewById(R.id.tv_is_collected);


                                tv_request_no.setText("申请号：" + resultlist.get(i).getPRNUM());
                                tv_desc.setText("计划描述：" + resultlist.get(i).getDESCRIPTION());
                                tv_statues.setText("状态：" + resultlist.get(i).getSTATUS());
                                tv_total_cost.setText("总成本：" + resultlist.get(i).getTOTALCOST());
                                tv_request_by.setText("申请人：" + resultlist.get(i).getREQUESTEDBY());
                                tv_request_dep.setText("申请部门：" + resultlist.get(i).getA_PURCATALOG());
                                tv_request_team.setText("申请班组：" + resultlist.get(i).getA_CREWID());
                                tv_request_type.setText("申请类型：" + resultlist.get(i).getA_PURTYPE());
                                tv_is_collected.setText("汇总否：" + resultlist.get(i).getA_TOSUM());
                                ll_button.addView(inflate);
                            }
                        }


                    }

                }

            }


        });

    }

    private void getCollectedList() {
        /**
         * {"appid"："PR",
         * "objectname"："PR",
         * "curpage"：1,
         * "showcount"：20,"
         * option"："read",
         * "orderby"："",
         * "sqlSearch"：" a_sumnum=：prnum "}
         *
         */
        LogUtils.d("getContractDetail");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PR");
        object.put("objectname", "PR");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        object.put("sqlSearch", " a_sumnum=" + "'" + PRNUM + "'");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                if (!response.isEmpty()) {
                    ProjectMonthColletedBean projectMonthColletedBean = JSONObject.parseObject(response, new TypeReference<ProjectMonthColletedBean>() {
                    });
                    if (projectMonthColletedBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<ProjectMonthColletedBean.ResultBean.ResultlistBean> resultlist = projectMonthColletedBean.getResult().getResultlist();
                        ll_top.removeAllViews();
                        if (resultlist.size() > 0) {
                            for (int i = 0; i < resultlist.size(); i++) {
                                View inflate = LayoutInflater.from(mContext).inflate(R.layout.project_month_collected_item, ll_top, false);
                                TextView tv_request_no = inflate.findViewById(R.id.tv_request_no);
                                TextView tv_desc = inflate.findViewById(R.id.tv_desc);
                                TextView tv_statues = inflate.findViewById(R.id.tv_statues);
                                TextView tv_total_cost = inflate.findViewById(R.id.tv_total_cost);
                                TextView tv_request_by = inflate.findViewById(R.id.tv_request_by);
                                TextView tv_request_dep = inflate.findViewById(R.id.tv_request_dep);
                                TextView tv_request_team = inflate.findViewById(R.id.tv_request_team);
                                TextView tv_is_collected = inflate.findViewById(R.id.tv_is_collected);


                                tv_request_no.setText("申请号：" + resultlist.get(i).getPRNUM());
                                tv_desc.setText("计划描述：" + resultlist.get(i).getDESCRIPTION());
                                tv_statues.setText("状态：" + resultlist.get(i).getSTATUS());
                                tv_total_cost.setText("总成本：" + resultlist.get(i).getTOTALCOST());
                                tv_request_by.setText("申请人：" + resultlist.get(i).getREQUESTEDBY());
                                tv_request_dep.setText("申请部门：" + resultlist.get(i).getA_PURCATALOG());
                                tv_request_team.setText("申请班组：" + resultlist.get(i).getA_CREWID());
                                tv_is_collected.setText("汇总否：" + resultlist.get(i).getA_TOSUM());
                                ll_top.addView(inflate);
                            }
                        }


                    }

                }

            }


        });
    }
    @Subscribe (threadMode = ThreadMode.MAIN)
    public void getNotification(StartWorkProcessBean processBean){
        LogUtils.d("222222 getNotification");
        if (processBean.getTag().equals("项目月度计划汇总")){
          tv_contract_statue.setText(processBean.getNextStatus());

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
