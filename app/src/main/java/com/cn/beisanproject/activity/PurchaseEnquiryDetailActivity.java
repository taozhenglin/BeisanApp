package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
import com.cn.beisanproject.modelbean.PuarchaseEnquiryBean;
import com.cn.beisanproject.modelbean.PuarchaseEnquirySupportBean;
import com.cn.beisanproject.modelbean.PuarchaseSupportQuoteBean;
import com.cn.beisanproject.modelbean.PurchaseEnquiryListBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.WaitDoListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.yinglan.keyboard.HideUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * 采购询价单详情
 */
public class PurchaseEnquiryDetailActivity extends AppCompatActivity implements View.OnClickListener {
       String OWNERID ;
    TextView tv_project_collect;
    TextView tv_statues;
    TextView tv_desc;
    TextView tv_enquiry_type;
    TextView tv_duty_dep;
    TextView tv_enquiry_by;
    TextView tv_request_dep;
    TextView tv_request_team;
    TextView tv_contract;
    TextView tv_baojia_amount;
    TextView tv_auth_amount1;
    TextView tv_auth_amount2;
    TextView tv_note;

    LinearLayout ll_top;
    LinearLayout ll_button;
    private LinearLayout ll_back;
    private TextView tv_common_title;
    private TextView tv_title;
    private ImageView iv_fun;

    WaitDoListBean.ResultBean.ResultlistBean waitdolistbean;
    PurchaseEnquiryListBean.ResultBean.ResultlistBean mResultlistBean;
    private LoadingDialog ld;
    private boolean needGet;
     String rfqnum;
    String siteid;
    String vendor;
    private TextView tv_start;
    private int isAgree=1;
    private PopupWindow pop;
    String statues;
    private String RFQID;
    private String[] stringItems1 = new String[]{"启动工作流"};
    private String[] stringItems2 = new String[]{"工作流审批"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purshase_enquiry_activity);
        initView();
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            waitdolistbean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            OWNERID=waitdolistbean.getOWNERID()+"";
            LogUtils.d("OWNERID=" + OWNERID);
        }else{
            mResultlistBean= (PurchaseEnquiryListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页列表
            rfqnum=mResultlistBean.getRFQNUM();
            siteid=mResultlistBean.getSITEID();
            statues=mResultlistBean.getSTATUS();
            if (statues.equals("已关闭")||statues.equals("取消")||statues.equals("关闭")||statues.equals("已取消")){
                tv_start.setVisibility(View.GONE);
            }else {
                if (statues.equals("等待批准")){//可启动
                    tv_start.setText("启动工作流");
                }else {
                    tv_start.setText("工作流审批");
                }
            }
            RFQID=mResultlistBean.getRFQID()+"";

        }

        //键盘自动隐藏
        HideUtil.init(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ld = new LoadingDialog(this);
        initEvent();
        initListener();
    }

    private void initView() {
        ll_back = findViewById(R.id.ll_back);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("采购询价单");
        tv_title = findViewById(R.id.tv_title);
        tv_title.setText("附件");
        iv_fun = findViewById(R.id.iv_fun);
        iv_fun.setImageDrawable(getResources().getDrawable(R.drawable.icon_white_go_28));
        tv_project_collect = findViewById(R.id.tv_project_collect);
        tv_statues = findViewById(R.id.tv_statues);
        tv_desc = findViewById(R.id.tv_desc);
        tv_enquiry_type = findViewById(R.id.tv_enquiry_type);
        tv_duty_dep = findViewById(R.id.tv_duty_dep);
        tv_enquiry_by = findViewById(R.id.tv_enquiry_by);
        tv_request_dep = findViewById(R.id.tv_request_dep);
        tv_request_team = findViewById(R.id.tv_request_team);
        tv_contract = findViewById(R.id.tv_contract);
        tv_baojia_amount = findViewById(R.id.tv_baojia_amount);
        tv_auth_amount1 = findViewById(R.id.tv_auth_amount1);
        tv_auth_amount2 = findViewById(R.id.tv_auth_amount2);
        tv_note = findViewById(R.id.tv_note);
        //报价供应商
        ll_top = findViewById(R.id.ll_top);
        //供应商报价
        ll_button = findViewById(R.id.ll_button);
        tv_start = findViewById(R.id.tv_start);
//        tv_approval = findViewById(R.id.tv_approval);
    }

    private void initEvent() {
        if (needGet){
            getDetail();
        }else {
            tv_project_collect.setText("项目汇总："+mResultlistBean.getRFQNUM());
            tv_statues.setText(mResultlistBean.getSTATUS());
            tv_desc.setText("描述："+mResultlistBean.getDESCRIPTION());
            tv_enquiry_type.setText("询价类型："+mResultlistBean.getRFQTYPE());
            tv_duty_dep.setText("职能部门:"+mResultlistBean.getA_PURCATALOG());
            tv_enquiry_by.setText("采购员:"+mResultlistBean.getENTERBYDESC());
            tv_request_dep.setText("申请部门:"+mResultlistBean.getA_DEPT());
            tv_request_team.setText("申请班组:"+mResultlistBean.getRFQ3DESC());
            tv_contract.setText("合同："+mResultlistBean.getR_MASTERDESC());
            tv_baojia_amount.setText("报价合计金额（含税）:"+mResultlistBean.getHJJE());
            tv_auth_amount1.setText("授权合计金额（含税）:"+mResultlistBean.getCYHJJE());
            tv_auth_amount2.setText("授权合计金额（不含税）:"+mResultlistBean.getJHCOST());
            tv_note.setText("备注:"+mResultlistBean.getA_MEMO());
            getBaoJiaSupport();
        }

    }

    /**
     * {
     * "objectname" : "RFQ",
     * "option" : "read",
     * "condition" : {
     * "RFQID" : 15969
     * },
     * "orderby" : "RFQNUM desc",
     * "curpage" : 0,
     * "showcount" : 1,
     * "appid" : "RFQ"
     * }
     */
    private void getDetail() {
        LogUtils.d("getDetail");
        ld.show();
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "RFQ");
        object.put("objectname", "RFQ");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "RFQNUM desc");
        JSONObject conditionObject = new JSONObject();
        conditionObject.put("RFQID", waitdolistbean.getOWNERID());
        object.put("condition", conditionObject);
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
                PuarchaseEnquiryBean puarchaseEnquiryBean;
                if (!response.isEmpty()) {
                    puarchaseEnquiryBean = JSONObject.parseObject(response, new TypeReference<PuarchaseEnquiryBean>() {
                    });
                    if (puarchaseEnquiryBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<PuarchaseEnquiryBean.ResultBean.ResultlistBean> resultlist = puarchaseEnquiryBean.getResult().getResultlist();
                        rfqnum=resultlist.get(0).getRFQNUM();
                        siteid=resultlist.get(0).getSITEID();
                        statues=resultlist.get(0).getSTATUS();
                        if (statues.equals("已关闭")||statues.equals("取消")||statues.equals("关闭")||statues.equals("已取消")){
                            tv_start.setVisibility(View.GONE);
                        }else {
                            if (statues.equals("等待批准")){//可启动
                                tv_start.setText("启动工作流");
                            }else {
                                tv_start.setText("工作流审批");
                            }
                        }
                        RFQID=resultlist.get(0).getRFQID()+"";

                        tv_project_collect.setText("项目汇总："+resultlist.get(0).getRFQNUM());
                        tv_statues.setText(resultlist.get(0).getSTATUS());
                        tv_desc.setText("描述："+resultlist.get(0).getDESCRIPTION());
                        tv_enquiry_type.setText("询价类型："+resultlist.get(0).getRFQTYPE());
                        tv_duty_dep.setText("职能部门:"+resultlist.get(0).getA_PURCATALOG());
                        tv_enquiry_by.setText("采购员:"+resultlist.get(0).getENTERBYDESC());
                        tv_request_dep.setText("申请部门:"+resultlist.get(0).getA_DEPT());
                        tv_request_team.setText("申请班组:"+resultlist.get(0).getRFQ3DESC());
                        tv_contract.setText("合同:"+resultlist.get(0).getR_MASTERDESC());
                        tv_baojia_amount.setText("报价合计金额（含税）:"+resultlist.get(0).getHJJE());
                        tv_auth_amount1.setText("授权合计金额（含税）:"+resultlist.get(0).getCYHJJE());
                        tv_auth_amount2.setText("授权合计金额（不含税）:"+resultlist.get(0).getJHCOST());
                        tv_note.setText("备注:"+resultlist.get(0).getA_MEMO());

                        getBaoJiaSupport();

                    }
                }

            }
        });
    }
    private void initListener() {
        ll_back.setOnClickListener(this);
//        tv_approval.setOnClickListener(this);
        tv_start.setOnClickListener(this);
        tv_title.setOnClickListener(this);
        iv_fun.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_start:
                if (statues.equals("等待批准")) {
                    //启动工作流
                    ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems1, tv_start);
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
                            }
                        }
                    });
                } else {
                    ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems2, tv_start);
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
                            }
                        }
                    });
                }
                break;
            case R.id.tv_title:
            case R.id.iv_fun:
                startActivity(new Intent(this, AttachListActivity.class).putExtra("RFQID",RFQID));
                break;
        }
    }

    private void start() {
        /**
         * --启动流程：“等待批准”,"进行中","已发送" 状态下可启动流程
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfservicestartWF creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:processname>RFQ</max:processname>
         *          <max:mbo>RFQ</max:mbo>
         *          <max:keyValue>2245</max:keyValue>
         *          <max:key>RFQNUM</max:key>
         *          <max:loginid>maxadmin</max:loginid>
         *       </max:wfservicestartWF>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>RFQ</max:processname>\n" +
                "         <max:mbo>RFQ</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>RFQNUM</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, rfqnum, SharedPreferencesUtil.getString(this, "personId"));
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
                //解析xml 如果审批同意 则底部审批按钮消失
                if (!response.isEmpty()) {
                    if(response.contains("<return>")&&response.contains("</return>")) {
                        int start = response.indexOf("<return>");
                        int end = response.indexOf("</return>");
                        String substring = response.substring(start + 8, end);
                        LogUtils.d("substring==" + substring);
                        StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                        });
                        if (startWorkProcessBean.getMsg().equals("流程启动成功！")) {
                            tv_start.setText("工作流审批");
                            statues = startWorkProcessBean.getNextStatus();
                            tv_statues.setText(startWorkProcessBean.getNextStatus());
                            PostData postData=new PostData();
                            postData.setTag("采购询价单");
                            EventBus.getDefault().post(postData);
                            getBaoJiaSupport();
                        } else {

                        }
                        ToastUtils.showShort(startWorkProcessBean.getMsg());
                    }else
                        ToastUtils.showShort(R.string.UNKNOW_ERROR);

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
        /**
         * --审批（推送）状态不等于【“完成"，“关闭”，“取消”】，调用审批接口
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfservicewfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:processname>RFQ</max:processname>
         *          <max:mboName>RFQ</max:mboName>
         *          <max:keyValue>15461</max:keyValue>
         *          <max:key>RFQID</max:key>
         *          <max:ifAgree>1</max:ifAgree>
         *          <max:opinion>同意1</max:opinion>
         *          <max:loginid>MAXADMIN</max:loginid>
         *       </max:wfservicewfGoOn>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\" >" +
                "<max:processname>RFQ</max:processname>" +
                "<max:mboName>RFQ</max:mboName>" +
                "<max:keyValue>%s</max:keyValue>" +
                "<max:key>RFQID</max:key>" +
                "<max:ifAgree>%s</max:ifAgree>" +
                "<max:opinion>%s</max:opinion>" +
                "<max:loginid>%s</max:loginid>" +
                "</max:wfservicewfGoOn>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
        // ifAgree ：1 同意  2 不同意   opinion：输入内容
        if (StringUtils.isEmpty(opinion)){
            if (isAgree==1){
                opinion="同意";
            }else {
                opinion="驳回";
            }
        }
        request = String.format(request, RFQID, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
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
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {});
                    if (startWorkProcessBean.getMsg().equals("审批成功")) {
                        statues = startWorkProcessBean.getNextStatus();
                        tv_statues.setText(startWorkProcessBean.getNextStatus());
                        PostData postData=new PostData();
                        postData.setTag("采购询价单");
                        EventBus.getDefault().post(postData);
                        getBaoJiaSupport();
                    } else {

                    }
                    ToastUtils.showShort(startWorkProcessBean.getMsg());
                }
            }
        });

    }

    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) this).getWindow().setAttributes(lp);
    }

    void getBaoJiaSupport(){
        /**
         * { 报价供应商
         *   "objectname" : "RFQVENDOR",
         *   "option" : "read",
         *   "orderby" : "",
         *   "curpage" : 1,
         *   "showcount" : 20,
         *   "sqlSearch" : "rfqnum='2520' and siteid='1000'",
         *   "appid" : "RFQVENDOR"
         * }
         */
        LogUtils.d("getDetail");
        ld.show();
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "RFQVENDOR");
        object.put("objectname", "RFQVENDOR");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        object.put("sqlSearch", "rfqnum="+"'"+rfqnum+"'"+" and siteid="+"'"+siteid+"'");
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
                PuarchaseEnquirySupportBean enquirySupportBean;
                if (!response.isEmpty()) {
                    enquirySupportBean = JSONObject.parseObject(response, new TypeReference<PuarchaseEnquirySupportBean>() {
                    });
                    if (enquirySupportBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<PuarchaseEnquirySupportBean.ResultBean.ResultlistBean> resultlist = enquirySupportBean.getResult().getResultlist();
                        ll_top.removeAllViews();
                        if (resultlist.size()>0){
                            for (int i = 0; i <resultlist.size() ; i++) {
                                View inflate= LayoutInflater.from(PurchaseEnquiryDetailActivity.this).inflate(R.layout.parchase_enquiry_support_item,ll_top,false);
                                TextView tv_supporter=inflate.findViewById(R.id.tv_supporter);
                                TextView tv_contacts=inflate.findViewById(R.id.tv_contacts);
                                TextView tv_phone=inflate.findViewById(R.id.tv_phone);
                                TextView tv_enquiry_sum=inflate.findViewById(R.id.tv_enquiry_sum);
                                TextView tv_enquiry_tax=inflate.findViewById(R.id.tv_enquiry_tax);
                                TextView tv_sum_tax=inflate.findViewById(R.id.tv_sum_tax);
                                TextView tv_no_tax=inflate.findViewById(R.id.tv_no_tax);

                                tv_supporter.setText("供应商："+resultlist.get(i).getVENDORDESC());
                                tv_contacts.setText("联系人："+resultlist.get(i).getCONTACT());
                                tv_phone.setText("联系电话："+resultlist.get(i).getPHONE());
                                tv_enquiry_sum.setText("报价金额："+resultlist.get(i).getA_REPORTCOST());
                                tv_enquiry_tax.setText("税额："+resultlist.get(i).getVENDORTOTALCOST());
                                tv_sum_tax.setText("授权金额（含税）："+resultlist.get(i).getCYVENDORTOTALCOST());
                                tv_no_tax.setText("授权金额（不含税）："+resultlist.get(i).getA_AWARDCOST());
                                int finalI = i;
                                inflate.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        getSupportBaojia(resultlist.get(finalI).getVENDOR());

                                    }
                                });
                                ll_top.addView(inflate);
                            }
                            getSupportBaojia(resultlist.get(0).getVENDOR());

                        }

                    }
                }

            }
        });


    }
    void getSupportBaojia(String vendor){
        /**
         * { 供应商报价
         *   "objectname" : "QUOTATIONLINE",
         *   "option" : "read",
         *   "orderby" : "",
         *   "curpage" : 1,
         *   "showcount" : 20,
         *   "sqlSearch" : "rfqnum = '2520' and vendor = 'GK13478' and siteid='1000'",
         *   "appid" : "QUOTATIONLINE"
         * }
         */
        LogUtils.d("getDetail");
        ld.show();
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "QUOTATIONLINE");
        object.put("objectname", "QUOTATIONLINE");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        object.put("sqlSearch", "rfqnum="+"'"+rfqnum+"'"+" and vendor = "+"'"+vendor+"'"+" and siteid="+"'"+siteid+"'");
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
                PuarchaseSupportQuoteBean puarchaseSupportQuoteBean;
                if (!response.isEmpty()) {
                    puarchaseSupportQuoteBean = JSONObject.parseObject(response, new TypeReference<PuarchaseSupportQuoteBean>() {
                    });
                    if (puarchaseSupportQuoteBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<PuarchaseSupportQuoteBean.ResultBean.ResultlistBean> resultlist = puarchaseSupportQuoteBean.getResult().getResultlist();
                        ll_button.removeAllViews();
                        if (resultlist.size()>0){
                            for (int i = 0; i <resultlist.size() ; i++) {
                                View inflate= LayoutInflater.from(PurchaseEnquiryDetailActivity.this).inflate(R.layout.parchase_enquiry_quote_item,ll_top,false);
                                TextView tv_supporter=inflate.findViewById(R.id.tv_supporter);
                                TextView tv_desc=inflate.findViewById(R.id.tv_desc);
                                TextView tv_model=inflate.findViewById(R.id.tv_model);

                                TextView tv_contacts=inflate.findViewById(R.id.tv_contacts);
                                TextView tv_phone=inflate.findViewById(R.id.tv_phone);
                                TextView tv_enquiry_sum=inflate.findViewById(R.id.tv_enquiry_sum);
                                TextView tv_enquiry_tax=inflate.findViewById(R.id.tv_enquiry_tax);
                                TextView tv_sum_tax=inflate.findViewById(R.id.tv_sum_tax);
                                TextView tv_no_tax=inflate.findViewById(R.id.tv_no_tax);

                                tv_supporter.setText("项目编号："+resultlist.get(i).getITEMNUM());
                                tv_desc.setText("项目描述："+resultlist.get(i).getITEMDESC());
                                tv_model.setText("规格型号："+resultlist.get(i).getA_MODEL());
                                tv_contacts.setText("数量："+resultlist.get(i).getORDERQTY());
                                tv_phone.setText("单位："+resultlist.get(i).getORDERUNIT());
                                tv_enquiry_sum.setText("单价："+resultlist.get(i).getUNITCOST());
                                tv_enquiry_tax.setText("总价："+resultlist.get(i).getLINECOST());
                                tv_sum_tax.setText("税率："+resultlist.get(i).getA_FL());
                                tv_no_tax.setText("是否已授权："+resultlist.get(i).getISAWARDED());

                                ll_button.addView(inflate);
                            }
                        }
                    }
                }

            }
        });
    }
}
