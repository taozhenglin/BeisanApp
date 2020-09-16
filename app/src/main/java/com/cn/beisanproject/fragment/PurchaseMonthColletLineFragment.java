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
import com.cn.beisanproject.activity.PurchaseMonthColletDetailActivity;
import com.cn.beisanproject.modelbean.ProjectMonthCollectBean;
import com.cn.beisanproject.modelbean.ProjectMonthColletLineBean;
import com.cn.beisanproject.modelbean.PurchaseMonthColletLineBean;
import com.cn.beisanproject.modelbean.PurchaseMonthColletedDeatailBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

public class PurchaseMonthColletLineFragment extends Fragment {
    private final Context mContext;
    private final ProjectMonthCollectBean.ResultBean.ResultlistBean mResultlistBean;
    private final boolean mNeedGet;
    private final PurchaseMonthColletedDeatailBean.ResultBean.ResultlistBean mData;
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
    private String prnum;


    public PurchaseMonthColletLineFragment(Context context, ProjectMonthCollectBean.ResultBean.ResultlistBean resultlistBean, boolean needGet, PurchaseMonthColletedDeatailBean.ResultBean.ResultlistBean data) {
        mContext = context;
        mResultlistBean = resultlistBean;
        mNeedGet = needGet;
        mData = data;
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
        tv_line1.setText("已汇总计划明细行");
        tv_line2 = view.findViewById(R.id.tv_line2);
        tv_line2.setVisibility(View.GONE);
        ll_top = view.findViewById(R.id.ll_top);
        ll_button = view.findViewById(R.id.ll_button);
        ll_button.setVisibility(View.GONE);
        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mNeedGet) {
            prnum = mData.getPRNUM();
            tv_contract_no.setText("项目汇总:" + mData.getPRNUM());
            tv_contract_statue.setText(mData.getSTATUS());
            tv_contract_desc.setText("描述:" + mData.getDESCRIPTION());
            tv_collet_date.setText("汇总年月:" + mData.getA_PRKEY());
            tv_collet_time.setText("汇总时间:" + mData.getISSUEDATE());
            tv_collet_type.setText("汇总类型:" + mData.getA_PRSUMTYPE());
            tv_collet_by.setText("汇总人:" + mData.getR_DEPTDESC());
        } else {
            prnum = mResultlistBean.getPRNUM();
            tv_contract_no.setText("项目汇总:" + mResultlistBean.getPRNUM());
            tv_contract_statue.setText(mResultlistBean.getSTATUS());
            tv_contract_desc.setText("描述:" + mResultlistBean.getDESCRIPTION());
            tv_collet_date.setText("汇总年月:" + mResultlistBean.getA_PRKEY());
            tv_collet_time.setText("汇总时间:" + mResultlistBean.getISSUEDATE());
            tv_collet_type.setText("汇总类型:" + mResultlistBean.getA_PRSUMTYPE());
            tv_collet_by.setText("汇总人:" + mResultlistBean.getR_DEPTDESC());
        }

        getLine();
    }

    private void getLine() {
        /**
         * {
         *   "objectname" : "PRLINE",
         *   "option" : "read",
         *   "orderby" : "prnum ASC",
         *   "curpage" : 1,
         *   "showcount" : 20,
         *   "sqlSearch" : "prnum in (select prnum from pr where a_sumnum='1389')",
         *   "appid" : "PRLINE"
         * }
         */
        LogUtils.d("getContractDetail");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PRLINE");
        object.put("objectname", "PRLINE");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "prnum ASC");
        String sqlSearch = "prnum in (select prnum from pr where a_sumnum=%s)";
        sqlSearch = String.format(sqlSearch, "'" + prnum + "'");
        object.put("sqlSearch", sqlSearch);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ToastUtils.showShort(R.string.getDatafailed);
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                if (!response.isEmpty()) {
                    PurchaseMonthColletLineBean projectMonthColletLineBean = JSONObject.parseObject(response, new TypeReference<PurchaseMonthColletLineBean>() {
                    });
                    if (projectMonthColletLineBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<PurchaseMonthColletLineBean.ResultBean.ResultlistBean> resultlist = projectMonthColletLineBean.getResult().getResultlist();
                        ll_top.removeAllViews();
                        if (resultlist.size() > 0) {
                            for (int i = 0; i < resultlist.size(); i++) {
                                View inflate = LayoutInflater.from(mContext).inflate(R.layout.prurchse_month_collect_lineitem, ll_top, false);
                                TextView tv_plan_no = inflate.findViewById(R.id.tv_plan_no);
                                TextView tv_line_no = inflate.findViewById(R.id.tv_line_no);

                                TextView tv_assert_no = inflate.findViewById(R.id.tv_assert_no);
                                TextView tv_desc = inflate.findViewById(R.id.tv_desc);
                                TextView tv_brand = inflate.findViewById(R.id.tv_brand);
                                TextView tv_model = inflate.findViewById(R.id.tv_model);
                                TextView tv_unit_cost = inflate.findViewById(R.id.tv_unit_cost);
                                TextView tv_count = inflate.findViewById(R.id.tv_count);
                                TextView tv_total_cost = inflate.findViewById(R.id.tv_total_cost);
                                TextView tv_categroy = inflate.findViewById(R.id.tv_categroy);
                                TextView tv_request_type = inflate.findViewById(R.id.tv_request_type);
                                TextView tv_request_by = inflate.findViewById(R.id.tv_request_by);
                                TextView tv_request_dep = inflate.findViewById(R.id.tv_request_dep);
                                TextView tv_request_team = inflate.findViewById(R.id.tv_request_team);
                                TextView tv_note = inflate.findViewById(R.id.tv_note);


                                tv_plan_no.setText("计划号：" + resultlist.get(i).getPRNUM());
                                tv_line_no.setText("计划行号：" + resultlist.get(i).getPRLINENUM());
                                tv_assert_no.setText("物资编码：" + resultlist.get(i).getITEMNUM());
                                tv_desc.setText("物资描述：" + resultlist.get(i).getDESCRIPTION());
                                tv_model.setText("规格型号：" + resultlist.get(i).getA_MODEL());
                                tv_brand.setText("品牌：" + resultlist.get(i).getA_BRAND());
                                tv_unit_cost.setText("单价：" + resultlist.get(i).getUNITCOST());
                                tv_count.setText("数量：" + resultlist.get(i).getORDERQTY());
                                tv_total_cost.setText("小计成本：" + resultlist.get(i).getLOADEDCOST());
                                tv_categroy.setText("物资类别：" + resultlist.get(i).getLINETYPE());
                                tv_request_type.setText("申请类型：" + resultlist.get(i).getA_PURTYPE());
                                tv_request_by.setText("申请人：" + resultlist.get(i).getREQUESTEDBYDESC());
                                tv_request_dep.setText("申请部门：" + resultlist.get(i).getA_DEPTDESC());
                                tv_request_team.setText("申请班组：" + resultlist.get(i).getA_CREWIDDESC());
                                tv_note.setText("备注：" + resultlist.get(i).getREMARK());

                                ll_top.addView(inflate);
                            }
                        }


                    }

                }

            }


        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(StartWorkProcessBean startWorkProcessBean) {
        LogUtils.d("onEvent==");
        if (startWorkProcessBean.getTag().equals("采购月度计划汇总")) {
            tv_contract_statue.setText(startWorkProcessBean.getNextStatus());
            getLine();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
