package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.SupplierListBean;
import com.cn.beisanproject.modelbean.WaitDoListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class SupplierDetailActivity extends AppCompatActivity {
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.tv_common_title)
    TextView tvCommonTitle;
    @BindView(R.id.iv_fun)
    ImageView ivFun;
    @BindView(R.id.tv_request_no)
    TextView tvRequestNo;
    @BindView(R.id.tv_request_statue)
    TextView tvRequestStatue;
    @BindView(R.id.tv_supporter_no)
    TextView tvSupporterNo;
    @BindView(R.id.tv_supporter_name)
    TextView tvSupporterName;
    @BindView(R.id.tv_zhuce_no)
    TextView tvZhuceNo;
    @BindView(R.id.tv_request_by)
    TextView tvRequestBy;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_request_time)
    TextView tvRequestTime;
    @BindView(R.id.tv_start_statue)
    TextView tvStartStatue;
    @BindView(R.id.tv_line)
    TextView tvLine;
    @BindView(R.id.tv_contact)
    TextView tvContact;
    @BindView(R.id.tv_phone_no)
    TextView tvPhoneNo;
    @BindView(R.id.tv_fax)
    TextView tvFax;
    @BindView(R.id.tv_postal_code)
    TextView tvPostalCode;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_currency)
    TextView tvCurrency;
    @BindView(R.id.tv_daibiao)
    TextView tvDaibiao;
    @BindView(R.id.tv_bank)
    TextView tvBank;
    @BindView(R.id.tv_bank_no)
    TextView tvBankNo;
    @BindView(R.id.tv_line1)
    TextView tvLine1;
    @BindView(R.id.tv_conunt)
    TextView tvConunt;
    @BindView(R.id.tv_tax_no)
    TextView tvTaxNo;
    @BindView(R.id.tv_licence)
    TextView tvLicence;
    @BindView(R.id.tv_rigester_count)
    TextView tvRigesterCount;
    @BindView(R.id.tv_fanwei)
    TextView tvFanwei;
    @BindView(R.id.tv_fixed_assets)
    TextView tvFixedAssets;
    @BindView(R.id.tv_guanlian)
    TextView tvGuanlian;
    @BindView(R.id.sc)
    ScrollView sc;
    @BindView(R.id.tv_approval)
    TextView tvApproval;
    private boolean needGet;
    private WaitDoListBean.ResultBean.ResultlistBean waitdolistbean;
    private SupplierListBean.ResultBean.ResultlistBean mResultlistBean;
    private String statues;
    private LoadingDialog ld;
    private String[] stringItems1 = new String[]{"启动工作流"};
    private String[] stringItems2 = new String[]{"工作流审批"};
    private PopupWindow pop;
    private int isAgree =1;
    private String VENDORSAPPLYID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supplier_detail_activity);
        ButterKnife.bind(this);

        initView();
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            waitdolistbean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            VENDORSAPPLYID = waitdolistbean.getOWNERID() + "";
            LogUtils.d("VENDORSAPPLYID==" + VENDORSAPPLYID);
        } else {
            mResultlistBean = (SupplierListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页列表
            statues = mResultlistBean.getSTATUS();
            VENDORSAPPLYID = mResultlistBean.getVENDORSAPPLYID() + "";
            if (statues.equals("已审批") || statues.equals("关闭") || statues.equals("已取消")) {
                tvApproval.setVisibility(View.GONE);
            } else {
                if (statues.equals("新增")) {
                    tvApproval.setText("启动工作流");
                } else {
                    tvApproval.setText("工作流审批");
                }
            }
        }
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ld = new LoadingDialog(this);
        initEvent();
    }

    private void initEvent() {
        if (needGet) {
            getDetail();
        } else {
            tvRequestNo.setText("申请编号:" + mResultlistBean.getVENDORSAPPLYID());
            tvRequestStatue.setText(mResultlistBean.getSTATUS());
            tvSupporterNo.setText("供应商编码:" + mResultlistBean.getVENDORSCODE());
            tvSupporterName.setText("供应商名称:" + mResultlistBean.getNAME());
            tvZhuceNo.setText("工商注册号:" + mResultlistBean.getREGISTRATION());
            tvRequestBy.setText("申请人员:" + mResultlistBean.getAPPLICANT());
            tvPhone.setText("手机卡号:" + mResultlistBean.getCONTRACTPHONE());
            tvRequestTime.setText("申请时间:" + mResultlistBean.getAPPLYDATE());
            tvStartStatue.setText("启用状态:" + mResultlistBean.getUSEFLAG());
            tvContact.setText("联系人:" + mResultlistBean.getCONTACT());
            tvPhoneNo.setText("电话:" + mResultlistBean.getPHONE());
            tvFax.setText("传真:" + mResultlistBean.getFAX());
            tvPostalCode.setText("邮政编码:" + mResultlistBean.getADDRESS4());
            tvAddress.setText("地址:" + mResultlistBean.getADDRESS1());
            tvCurrency.setText("货币:" + mResultlistBean.getCURRENCYCODE());
            tvDaibiao.setText("法人代表:" + mResultlistBean.getBANKNAME());
            tvBank.setText("开户银行:" + mResultlistBean.getBANKACCOUNT());
            tvBankNo.setText("银行账号:" + mResultlistBean.getBANKNUM());
            tvConunt.setText("公司人数:" + mResultlistBean.getPERCOUNT());
            tvTaxNo.setText("税号:" + mResultlistBean.getTAX1CODE());
            tvLicence.setText("许可证:" + mResultlistBean.getLICENCE());
            tvRigesterCount.setText("注册资金:" + mResultlistBean.getCAPITAL());
            tvFanwei.setText("经营范围:" + mResultlistBean.getSCOPE());
            tvFixedAssets.setText("固定资产:" + mResultlistBean.getFIXEDASSETS());
            tvGuanlian.setText("关联业务:" + mResultlistBean.getOPERATION());

        }

    }

    private void getDetail() {
        /**
         * {
         *   "objectname" : "VENDORSAPPLY",
         *   "option" : "read",
         *   "condition" : {
         *     "VENDORSAPPLYID" : 975
         *   },
         *   "orderby" : "VENDORS desc",
         *   "curpage" : 0,
         *   "showcount" : 1,
         *   "appid" : "VENDORSAPPLY"
         * }
         */
        ld.show();
        LogUtils.d("getDetail==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "VENDORSAPPLY");
        object.put("objectname", "VENDORSAPPLY");
        object.put("curpage", 0);
        object.put("showcount", 1);
        object.put("option", "read");
        object.put("orderby", "VENDORS DESC");
        JSONObject condition = new JSONObject();
        condition.put("VENDORSAPPLYID", VENDORSAPPLYID);
        object.put("condition", condition);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure=" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse=" + response);
                ld.close();
                SupplierListBean supplierListBean;
                if (!response.isEmpty()) {
                    supplierListBean = JSONObject.parseObject(response, new TypeReference<SupplierListBean>() {
                    });
                    if (supplierListBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (supplierListBean.getResult().getResultlist().size() > 0) {
                            SupplierListBean.ResultBean.ResultlistBean resultlist = supplierListBean.getResult().getResultlist().get(0);
                            statues = resultlist.getSTATUS();
                            if (statues.equals("已审批") || statues.equals("关闭") || statues.equals("已取消")) {
                                tvApproval.setVisibility(View.GONE);
                            } else {
                                if (statues.equals("新增")) {
                                    tvApproval.setText("启动工作流");
                                } else {
                                    tvApproval.setText("工作流审批");
                                }
                            }
                            VENDORSAPPLYID = resultlist.getVENDORSAPPLYID() + "";
                            tvRequestNo.setText("申请编号:" + resultlist.getVENDORSAPPLYID());
                            tvRequestStatue.setText(resultlist.getSTATUS());
                            tvSupporterNo.setText("供应商编码:" + resultlist.getVENDORSCODE());
                            tvSupporterName.setText("供应商名称:" + resultlist.getNAME());
                            tvZhuceNo.setText("工商注册号:" + resultlist.getREGISTRATION());
                            tvRequestBy.setText("申请人员:" + resultlist.getAPPLICANT());
                            tvPhone.setText("手机卡号:" + resultlist.getCONTRACTPHONE());
                            tvRequestTime.setText("申请时间:" + resultlist.getAPPLYDATE());
                            tvStartStatue.setText("启用状态:" + resultlist.getUSEFLAG());
                            tvContact.setText("联系人:" + resultlist.getCONTACT());
                            tvPhoneNo.setText("电话:" + resultlist.getPHONE());
                            tvFax.setText("传真:" + resultlist.getFAX());
                            tvPostalCode.setText("邮政编码" + resultlist.getADDRESS4());
                            tvAddress.setText("地址:" + resultlist.getADDRESS1());
                            tvCurrency.setText("货币:" + resultlist.getCURRENCYCODE());
                            tvDaibiao.setText("法人代表:" + resultlist.getBANKNAME());
                            tvBank.setText("开户银行:" + resultlist.getBANKACCOUNT());
                            tvBankNo.setText("银行账号:" + resultlist.getBANKNUM());
                            tvConunt.setText("公司人数:" + resultlist.getPERCOUNT());
                            tvTaxNo.setText("税号:" + resultlist.getTAX1CODE());
                            tvLicence.setText("许可证:" + resultlist.getLICENCE());
                            tvRigesterCount.setText("注册资金:" + resultlist.getCAPITAL());
                            tvFanwei.setText("经营范围:" + resultlist.getSCOPE());
                            tvFixedAssets.setText("固定资产:" + resultlist.getFIXEDASSETS());
                            tvGuanlian.setText("关联业务:" + resultlist.getOPERATION());
                        }

                    }

                }
            }
        });
    }

    private void initView() {
        tvCommonTitle.setText("供应商申请");
    }

    @OnClick({R.id.tv_back, R.id.tv_approval})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_approval:

                if (statues.equals("新增")) {
                    ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems1, tvApproval);
                    dialog.isTitleShow(false)
                            .titleTextSize_SP(12)
                            .titleTextColor(Color.parseColor("#33000000"))
                            .cancelText("取消")
                            .cancelText(getResources().getColor(R.color.guide_blue))
                            .itemTextColor(getResources().getColor(R.color.guide_blue))
                            .layoutAnimation(null)
                            .show();
                    dialog.setOnOperItemClickL(new OnOperItemClickL() {
                        @Override
                        public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                            switch (position) {
                                case 0://
                                    start();
                                    dialog.dismiss();
                                    break;
                                case 1:
                                    break;
                            }
                        }
                    });

                } else {
                    ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems2, tvApproval);
                    dialog.isTitleShow(false)
                            .titleTextSize_SP(12)
                            .titleTextColor(Color.parseColor("#33000000"))
                            .cancelText("取消")
                            .cancelText(getResources().getColor(R.color.guide_blue))
                            .itemTextColor(getResources().getColor(R.color.guide_blue))
                            .layoutAnimation(null)
                            .show();
                    dialog.setOnOperItemClickL(new OnOperItemClickL() {
                        @Override
                        public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                            switch (position) {
                                case 0://
                                    showRemarkPopupwindow();
                                    dialog.dismiss();
                                    break;
                                case 1:
                                    break;
                            }
                        }
                    });
                }
                break;
        }
    }

    private void start() {
        /**
         *<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfservicestartWF creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:processname>VENAPPLY</max:processname>
         *          <max:mbo>VENDORSAPPLY</max:mbo>
         *          <max:keyValue>861</max:keyValue>
         *          <max:key>VENDORSAPPLYid</max:key>
         *          <max:loginid>maxadmin</max:loginid>
         *       </max:wfservicestartWF>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>VENAPPLY</max:processname>\n" +
                "         <max:mbo>VENDORSAPPLY</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>VENDORSAPPLYid</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, VENDORSAPPLYID, SharedPreferencesUtil.getString(this, "personId"));
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");
        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();

            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (!response.isEmpty()) {
                    if (response.contains("<return>")&&response.contains("</return>")){
                        int start = response.indexOf("<return>");
                        int end = response.indexOf("</return>");
                        String substring = response.substring(start + 8, end);
                        LogUtils.d("substring==" + substring);
                        StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                        });
                        if (startWorkProcessBean.getMsg().equals("流程启动成功！")){
                            statues=startWorkProcessBean.getNextStatus();
                            tvApproval.setText("工作流审批");
                            tvRequestStatue.setText(startWorkProcessBean.getNextStatus());
                            startWorkProcessBean.setTag("供应商申请");
                            EventBus.getDefault().post(startWorkProcessBean);
                        }else {

                        }
                        ToastUtils.showShort(startWorkProcessBean.getMsg());
                    }else {
                        ToastUtils.showShort(R.string.UNKNOW_ERROR);
                    }

                }


            }
        });

    }

    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow() {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.commondialog, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(true);// 点击空白处时，隐藏掉pop窗口
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
        final EditText input_et = (EditText) remarkView.findViewById(R.id.input_et);
        TextView finish_tv = (TextView) remarkView.findViewById(R.id.finish_tv);
        TextView cancel_tv = (TextView) remarkView.findViewById(R.id.cancel_tv);
        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
        ImageView iv_agree = (ImageView) remarkView.findViewById(R.id.iv_agree);
        iv_agree.setBackgroundResource(R.drawable.selected);
        ImageView iv_disagree = (ImageView) remarkView.findViewById(R.id.iv_disagree);
        iv_disagree.setBackgroundResource(R.drawable.unselected);
        iv_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_agree.setBackgroundResource(R.drawable.selected);
                iv_disagree.setBackgroundResource(R.drawable.unselected);
                isAgree = 1;
                input_et.setHint("同意");
                LogUtils.d("同意==");
            }
        });
        iv_disagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_disagree.setBackgroundResource(R.drawable.selected);
                iv_agree.setBackgroundResource(R.drawable.unselected);
                isAgree = 0;
                input_et.setHint("驳回");
                LogUtils.d("不同意==");
            }
        });
//        final TextView number_tv = (TextView) remarkView.findViewById(R.id.number_tv);
//        title_tv.setText("给TA贴标签");
//        input_et.setHint("请填写10个字以内的标签名称");
//        finish_tv.setText("确定");
//        number_tv.setText("0/10");

        //用于检测输入的字数
        input_et.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;
            private int selectionStart;
            private int selectionEnd;
            private int num = 10;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp = s;
            }

            @Override
            public void afterTextChanged(Editable s) {
                int number = s.length();

            }
        });

        //确定后，添加标签页

        finish_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = input_et.getText().toString().trim();
                goApproval(isAgree, txt);
                pop.dismiss(); //不管有否字符串都应该去dismiss
            }
        });

        cancel_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
    }

    private void goApproval(int ifAgree, String opinion) {
        if (StringUtils.isEmpty(opinion)){
            if (ifAgree==1){
                opinion="同意";
            }else {
                opinion="驳回";
            }
        }
        /**
         * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:max="http://www.ibm.com/maximo">
         * 	<soapenv:Header />
         * 	<soapenv:Body>
         * 		<max:wfservicewfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         * 			<max:processname>VENAPPLY</max:processname>
         * 			<max:mboName>VENDORSAPPLY</max:mboName>
         * 			<max:keyValue>986</max:keyValue>
         * 			<max:key>VENDORSAPPLYID</max:key>
         * 			<max:ifAgree>1</max:ifAgree>
         * 			<max:opinion>Ghhhh</max:opinion>
         * 			<max:loginid>SHENKK</max:loginid>
         * 		</max:wfservicewfGoOn>
         * 	</soapenv:Body>
         * </soapenv:Envelope>
         */
        String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\" >" +
                "<max:processname>VENAPPLY</max:processname>" +
                "<max:mboName>VENAPPLY</max:mboName>" +
                "<max:keyValue>%s</max:keyValue>" +
                "<max:key>VENDORSAPPLYID</max:key>" +
                "<max:ifAgree>%s</max:ifAgree>" +
                "<max:opinion>%s</max:opinion>" +
                "<max:loginid>%s</max:loginid>" +
                "</max:wfservicewfGoOn>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
        // ifAgree ：1 同意  2 不同意   opinion：输入内容
        request = String.format(request, VENDORSAPPLYID, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");
        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                ld.close();
                LogUtils.d("onResponse==" + response);
                if (response.contains("<return>")&&response.contains("</return>")){
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                    });
                    if (startWorkProcessBean.getMsg().equals("审批成功")) {
                        statues = startWorkProcessBean.getNextStatus();
                        tvRequestStatue.setText(startWorkProcessBean.getNextStatus());
                        PostData postData=new PostData();
                        postData.setTag("供应商申请");
                        EventBus.getDefault().post(postData);
                    } else {

                    }
                    ToastUtils.showShort(startWorkProcessBean.getMsg());
                }else
                    ToastUtils.showShort(R.string.UNKNOW_ERROR);


            }
        });
    }


    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) this).getWindow().setAttributes(lp);
    }
}
