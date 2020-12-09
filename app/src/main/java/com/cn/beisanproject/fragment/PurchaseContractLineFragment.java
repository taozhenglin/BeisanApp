package com.cn.beisanproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import com.cn.beisanproject.activity.PurchaseContractDetailActivity;
import com.cn.beisanproject.modelbean.AssertDetailBean;
import com.cn.beisanproject.modelbean.ContractLIneDetailBean;
import com.cn.beisanproject.modelbean.PurchseContractDetailBean;
import com.cn.beisanproject.modelbean.PurchseContractListBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.WaitDoListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

public class PurchaseContractLineFragment extends Fragment {
    private final Context mContext;
    private final PurchseContractListBean.ResultBean.ResultlistBean mResultlistBean;
    TextView tv_contract_no;
    TextView tv_contract_statue;
    TextView tv_contract_desc;
    TextView tv_xunjia_no;
    TextView tv_xunjia_desc;
    TextView tv_isyear_contract;
    TextView tv_department;
    TextView tv_contract_jia;
    TextView tv_contract_yi;
    TextView tv_company;
    TextView tv_request_department;
    TextView tv_contract_created;
    TextView tv_contract_signtime;
    TextView tv_contract_starttime;
    TextView tv_contract_endtime;
    private TextView tv_contract_cost;
    private TextView tv_total_cost;
    private TextView tv_price;
    private TextView tv_count;
    private TextView tv_danwei;
    private TextView tv_xinghao;
    private TextView tv_brand;
    private TextView tv_wuzi_desc;
    private TextView tv_wuzi_no;
    private TextView tv_line_no;
    private LinearLayout ll_line_container;
    PurchseContractDetailBean mPurchseContractDetailBean;
    boolean mNeedGet;
    String ownerid;
    String contractnum;
    String orgid;

    public PurchaseContractLineFragment(Context context, PurchseContractListBean.ResultBean.ResultlistBean resultlistBean, boolean needGet,  PurchseContractDetailBean purchseContractDetailBean) {
        this.mContext = context;
        this.mResultlistBean = resultlistBean;
        mNeedGet = needGet;
        mPurchseContractDetailBean = purchseContractDetailBean;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contract_detail_line_fragment, container, false);
        tv_contract_no = view.findViewById(R.id.tv_contract_no);
        tv_contract_statue = view.findViewById(R.id.tv_contract_statue);
        tv_contract_desc = view.findViewById(R.id.tv_contract_desc);
        tv_request_department = view.findViewById(R.id.tv_request_department);
        tv_contract_created = view.findViewById(R.id.tv_contract_created);
        tv_contract_signtime = view.findViewById(R.id.tv_contract_signtime);
        tv_contract_cost = view.findViewById(R.id.tv_contract_cost);
        tv_contract_starttime = view.findViewById(R.id.tv_contract_starttime);
        tv_contract_endtime = view.findViewById(R.id.tv_contract_endtime);
        //下面明细行

        ll_line_container = view.findViewById(R.id.ll_line_container);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mNeedGet) {
            ownerid = mPurchseContractDetailBean.getResult().getResultlist().get(0).getCONTRACTID() + "";
            contractnum = mPurchseContractDetailBean.getResult().getResultlist().get(0).getCONTRACTNUM();
            orgid = mPurchseContractDetailBean.getResult().getResultlist().get(0).getORGID();
            tv_contract_no.setText("合同编号：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getCONTRACTNUM());
            tv_contract_statue.setText(mPurchseContractDetailBean.getResult().getResultlist().get(0).getSTATUS());
            tv_contract_desc.setText("合同描述：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getDESCRIPTION());
            tv_request_department.setText("申请部门："+mPurchseContractDetailBean.getResult().getResultlist().get(0).getA_DEPT());
            tv_contract_created.setText("合同编制人：");
            tv_contract_signtime.setText("合同签订日期：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getJ_CONTRACTDATE());
            tv_contract_cost.setText("合同金额：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getTOTALCOST());
            tv_contract_starttime.setText("合同开始日期：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getSTARTDATE());
            tv_contract_endtime.setText("合同结束日期：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getENDDATE());
            getContractLine();
        } else {
            ownerid = mResultlistBean.getCONTRACTID() + "";
            contractnum = mResultlistBean.getCONTRACTNUM();
            orgid = mResultlistBean.getORGID();
            tv_contract_no.setText("合同编号：" + mResultlistBean.getCONTRACTNUM());
            tv_contract_statue.setText(mResultlistBean.getSTATUS());
            tv_contract_desc.setText("合同描述：" + mResultlistBean.getDESCRIPTION());
            tv_request_department.setText("申请部门：");
            tv_contract_created.setText("合同编制人：");
            tv_contract_signtime.setText("合同签订日期：" + mResultlistBean.getJ_CONTRACTDATE());
            tv_contract_cost.setText("合同金额：" + mResultlistBean.getTOTALCOST());
            tv_contract_starttime.setText("合同开始日期：" + mResultlistBean.getSTARTDATE());
            tv_contract_endtime.setText("合同结束日期：" + mResultlistBean.getENDDATE());
            getContractLine();
        }

    }



    /**
     * -- 采购合同明细行查询
     * http://192.168.1.180:7009/maximo/mobile/common/api?data=
     * {"appid":"CONTRACTLINE","objectname":"CONTRACTLINE","curpage":1,"showcount":20,"option":"read","orderby":"contractlinenum asc",
     * "sqlSearch":" contractnum='3016' and revisionnum ='0' and orgid='10' "}
     */
    void getContractLine() {
        LogUtils.d("getContractLine");
//
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "CONTRACTLINE");
        object.put("objectname", "CONTRACTLINE");
        object.put("curpage", 1);
        object.put("showcount", 999);
        object.put("option", "read");
        object.put("orderby", "contractlinenum asc");
        object.put("sqlSearch", "contractnum = " + "'"+contractnum+"'" + "and revisionnum =" + "'"+0+"'" + " and orgid = " + "'"+orgid+"'");
        //请求头
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure=" + e.toString());
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse=" + response);
//                finishRefresh();
                if (!response.isEmpty()) {
                    ContractLIneDetailBean contractLIneDetailBean = JSONObject.parseObject(response, new TypeReference<ContractLIneDetailBean>() {});

                    if (contractLIneDetailBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (contractLIneDetailBean.getResult().getResultlist().size() > 0) {
                            ll_line_container.removeAllViews();
                            for (int i = 0; i < contractLIneDetailBean.getResult().getResultlist().size(); i++) {
                                View inflate = LayoutInflater.from(mContext).inflate(R.layout.contract_line_item, ll_line_container, false);
                                tv_line_no = inflate.findViewById(R.id.tv_line_no);
                                tv_wuzi_no = inflate.findViewById(R.id.tv_wuzi_no);
                                tv_wuzi_desc = inflate.findViewById(R.id.tv_wuzi_desc);
                                tv_xinghao = inflate.findViewById(R.id.tv_xinghao);
                                tv_brand = inflate.findViewById(R.id.tv_brand);
                                tv_danwei = inflate.findViewById(R.id.tv_danwei);
                                tv_count = inflate.findViewById(R.id.tv_count);
                                tv_price = inflate.findViewById(R.id.tv_price);
                                tv_total_cost = inflate.findViewById(R.id.tv_total_cost);
                                tv_total_cost.setText("总价" + contractLIneDetailBean.getResult().getResultlist().get(i).getLINECOST());
                                tv_price.setText("单价：" + contractLIneDetailBean.getResult().getResultlist().get(i).getUNITCOST());
                                tv_count.setText("数量：" + contractLIneDetailBean.getResult().getResultlist().get(i).getORDERQTY());
                                tv_danwei.setText("单位：" + contractLIneDetailBean.getResult().getResultlist().get(i).getORDERUNIT());
                                tv_xinghao.setText("型号:");
                                tv_brand.setText("品牌:" + contractLIneDetailBean.getResult().getResultlist().get(i).getITEMNUM());
                                tv_wuzi_desc.setText("物资描述：" + contractLIneDetailBean.getResult().getResultlist().get(i).getITEMDESC());
                                tv_wuzi_no.setText("物资编码：" + contractLIneDetailBean.getResult().getResultlist().get(i).getITEMNUM());
                                tv_line_no.setText("明细行序号：" + contractLIneDetailBean.getResult().getResultlist().get(i).getCONTRACTLINENUM());
                                ll_line_container.addView(inflate);
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
        if (startWorkProcessBean.getTag().equals("采购合同")) {
            tv_contract_statue.setText(startWorkProcessBean.getNextStatus());
            getContractLine();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }
}
