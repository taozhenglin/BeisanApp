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
import com.cn.beisanproject.Utils.HighLightUtils;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.ProjectContractListBean;
import com.cn.beisanproject.modelbean.ProjectContractDetailBean;
import com.cn.beisanproject.modelbean.ProjectInvoiceAttachBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

public class ProjectInvoiceFragment extends Fragment {
    private final Context mContext;
    private final ProjectContractListBean.ResultBean.ResultlistBean mResultlistBean;
    private final boolean mNeedGet;
    private final ProjectContractDetailBean mProjectContractDetailBean;
    TextView tv_contract_no;
    TextView tv_contract_statue;
    TextView tv_contract_desc;
    TextView tv_xunjia_no;
    TextView tv_xunjia_desc;
    TextView tv_department;
    TextView tv_contract_jia;
    TextView tv_contract_yi;
    TextView tv_company;
    TextView tv_request_department;
    TextView tv_contract_created;
    TextView tv_contract_signtime;
    TextView tv_contract_starttime;
    TextView tv_contract_endtime;
    TextView tv_contract_cost;
    private LinearLayout ll_contract_attachment;
    private TextView tv_yusuan_no;
    private TextView tv_yusuan_desc;
    private TextView tv_contract_catogry;
    private TextView tv_contract_type;
    private TextView tv_contract_tax;
    private TextView tv_total_cost;
    private TextView tv_dead_line;
    String CONTNUM;
    String ownerid;
    String contractnum;
    String orgid;
    String company;
    private LoadingDialog ld;

    public ProjectInvoiceFragment(Context context, ProjectContractListBean.ResultBean.ResultlistBean resultlistBean, boolean needGet, ProjectContractDetailBean projectContractDetailBean) {
        this.mContext = context;
        this.mResultlistBean = resultlistBean;
        mNeedGet=needGet;
        mProjectContractDetailBean=projectContractDetailBean;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ld=new LoadingDialog(mContext);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mNeedGet){
            CONTNUM=mProjectContractDetailBean.getResult().getResultlist().get(0).getCONTNUM();
            tv_contract_no.setText("合同编号：" + mProjectContractDetailBean.getResult().getResultlist().get(0).getCONTRACTNUM());
            tv_contract_statue.setText(mProjectContractDetailBean.getResult().getResultlist().get(0).getSTATUS());
            tv_contract_desc.setText("合同描述：" + mProjectContractDetailBean.getResult().getResultlist().get(0).getDESCRIPTION());
            tv_request_department.setText("申请部门: " + mProjectContractDetailBean.getResult().getResultlist().get(0).getA_DEPT());
            tv_department.setText("主管部门: " + mProjectContractDetailBean.getResult().getResultlist().get(0).getJFQZDB());
            tv_contract_jia.setText("甲方：" + mProjectContractDetailBean.getResult().getResultlist().get(0).getHTJF());
            tv_contract_yi.setText("乙方：" + mProjectContractDetailBean.getResult().getResultlist().get(0).getVENDORDESC());
            tv_contract_catogry.setText("合同分类：" + mProjectContractDetailBean.getResult().getResultlist().get(0).getUDHTFL());
            tv_contract_type.setText("合同类型：" + mProjectContractDetailBean.getResult().getResultlist().get(0).getUDHTLX());
            tv_company.setText("公司：" + mProjectContractDetailBean.getResult().getResultlist().get(0).getA_COMP());
            tv_contract_cost.setText("合同金额：" + mProjectContractDetailBean.getResult().getResultlist().get(0).getTOTALBASECOST());
            tv_total_cost.setText("合同总金额：" + mProjectContractDetailBean.getResult().getResultlist().get(0).getTOTALCOST());
        }else {
            CONTNUM=mResultlistBean.getCONTNUM();
            tv_contract_no.setText("合同编号：" + mResultlistBean.getCONTRACTNUM());
            tv_contract_statue.setText(mResultlistBean.getSTATUS());
            tv_contract_desc.setText("合同描述：" + mResultlistBean.getDESCRIPTION());
            tv_request_department.setText("申请部门: " + mResultlistBean.getA_DEPT());

            tv_department.setText("主管部门: " + mResultlistBean.getJFQZDB());
            tv_contract_jia.setText("甲方：" + mResultlistBean.getHTJF());
            tv_contract_yi.setText("乙方：" + mResultlistBean.getVENDORDESC());
            tv_contract_catogry.setText("合同分类：" + mResultlistBean.getUDHTFL());
            tv_contract_type.setText("合同类型：" + mResultlistBean.getUDHTLX());
            tv_company.setText("公司：" + mResultlistBean.getA_COMP());
            tv_contract_cost.setText("合同金额：" + mResultlistBean.getTOTALBASECOST());
            tv_total_cost.setText("合同总金额：" + mResultlistBean.getTOTALCOST());
        }
        getInvoiceDetail();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.project_contract_invoice, container, false);

        tv_contract_no = view.findViewById(R.id.tv_contract_no);
        tv_contract_statue = view.findViewById(R.id.tv_contract_statue);
        tv_contract_desc = view.findViewById(R.id.tv_contract_desc);
        tv_request_department = view.findViewById(R.id.tv_request_department);//申请部门
        tv_department = view.findViewById(R.id.tv_department);//主管部门
        tv_contract_jia = view.findViewById(R.id.tv_contract_jia);
        tv_contract_yi = view.findViewById(R.id.tv_contract_yi);
        tv_company = view.findViewById(R.id.tv_company);
        tv_contract_catogry = view.findViewById(R.id.tv_contract_catogry);//合同分类
        tv_contract_type = view.findViewById(R.id.tv_contract_type);//合同类型
        tv_contract_cost = view.findViewById(R.id.tv_contract_cost);
        tv_total_cost = view.findViewById(R.id.tv_total_cost);
        //合同附件
        ll_contract_attachment = view.findViewById(R.id.ll_contract_attachment);
        EventBus.getDefault().register(this);
        return view;
    }
    private void getInvoiceDetail() {
        ld.show();
        /**
         * --合同相关发票明细行查询
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"INVOICE","objectname":"INVOICE","curpage":1,"showcount":20,"option":"read","orderby":"UDHTBH DESC"",
         * "sqlSearch":" UDHTBH=:CONTNUM "}
         */
        LogUtils.d("getInvoiceDetail");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "INVOICE");
        object.put("objectname", "INVOICE");
        object.put("curpage", 1);
        object.put("showcount", 999);
        object.put("option", "read");
        object.put("orderby", "UDHTBH DESC");
        String sqlSearch = "UDHTBH=" + "'" + CONTNUM + "'";
        object.put("sqlSearch", sqlSearch);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (!response.isEmpty()){
                    ProjectInvoiceAttachBean projectInvoiceAttachBean = JSONObject.parseObject(response, new TypeReference<ProjectInvoiceAttachBean>() {});
                    if (projectInvoiceAttachBean.getErrcode().equals("GLOBAL-S-0")){
                        ll_contract_attachment.removeAllViews();
                        if (projectInvoiceAttachBean.getResult().getResultlist().size()>0){
                            List<ProjectInvoiceAttachBean.ResultBean.ResultlistBean> resultlist = projectInvoiceAttachBean.getResult().getResultlist();
                            for (int i = 0; i < resultlist.size(); i++) {
                                View inflate = LayoutInflater.from(mContext).inflate(R.layout.contract_detail_attach, ll_contract_attachment, false);
                                TextView tv_attach_no = inflate.findViewById(R.id.tv_attach_no);
                                TextView tv_attach_desc = inflate.findViewById(R.id.tv_attach_desc);
                                TextView tv_upload_time = inflate.findViewById(R.id.tv_upload_time);
                                TextView tv_more1 = inflate.findViewById(R.id.tv_more1);
                                tv_more1.setVisibility(View.VISIBLE);
                                TextView tv_more2 = inflate.findViewById(R.id.tv_more2);
                                tv_more2.setVisibility(View.VISIBLE);
                                tv_attach_no.setText(HighLightUtils.highlight(mContext, "发票号：" + resultlist.get(i).getINVOICENUM(), resultlist.get(i).getINVOICENUM(), "#1B88EE", 0, 0));
                                tv_attach_desc.setText("发票描述：" + resultlist.get(i).getDESCRIPTION());
                                tv_upload_time.setText("税前总计：" + resultlist.get(i).getPRETAXTOTAL());
                                tv_more1.setText("税款总计：" + resultlist.get(i).getTOTALTAX1());
                                tv_more2.setText("发票金额总计：" + resultlist.get(i).getTOTALCOST());


                                ll_contract_attachment.addView(inflate);
                            }

                        }
                    }
                }
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent( PostData postData){
        LogUtils.d("onEvent==");
        if (postData.getTag().equals("项目合同")){
            tv_contract_statue.setText(postData.getNextStatus());
            getInvoiceDetail();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
