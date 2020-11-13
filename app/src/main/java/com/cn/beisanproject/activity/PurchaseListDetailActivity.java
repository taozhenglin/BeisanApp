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
import android.widget.LinearLayout;
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
import com.cn.beisanproject.modelbean.ProjectMonthLineBean;
import com.cn.beisanproject.modelbean.PurchaseListBean;
import com.cn.beisanproject.modelbean.PurchaseListDetailBean;
import com.cn.beisanproject.modelbean.PurchaseListLineBean;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 入库单详情
 */
public class PurchaseListDetailActivity extends AppCompatActivity {
    WaitDoListBean.ResultBean.ResultlistBean waitdolistbean;

    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_common_title)
    TextView tvCommonTitle;
    @BindView(R.id.iv_fun)
    ImageView ivFun;
    @BindView(R.id.tv_purchase_request)
    TextView tvPurchaseRequest;
    @BindView(R.id.tv_statue)
    TextView tvStatue;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_purchase_by)
    TextView tvPurchaseBy;
    @BindView(R.id.tv_vendor)
    TextView tvVendor;
    @BindView(R.id.tv_purchase_date)
    TextView tvPurchaseDate;
    @BindView(R.id.tv_get_date)
    TextView tvGetDate;
    @BindView(R.id.tv_sum_notax)
    TextView tvSumNotax;
    @BindView(R.id.tv_tax)
    TextView tvTax;
    @BindView(R.id.tv_sum_tax)
    TextView tvSumTax;
    @BindView(R.id.ll_purchase_line)
    LinearLayout llPurchaseLine;
    @BindView(R.id.sc)
    ScrollView sc;
    @BindView(R.id.tv_approval)
    TextView tvApproval;
    private String prnum;
    private String[] stringItems = new String[]{"工作流审批"};
    private int isAgree = 1;
    private String statues = "";
    private boolean needGet;
    String siteid = "";
    String ponum = "";
    private LoadingDialog ld;
    String POID;

    private PurchaseListBean.ResultBean.ResultlistBean mResultlistBean;
    private PopupWindow pop;
    private String PONUM;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_list_detail_activity);
        ButterKnife.bind(this);
        initView();
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            waitdolistbean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            POID = waitdolistbean.getOWNERID() + "";
            LogUtils.d("OWNERID=" + POID);
        } else {
            mResultlistBean = (PurchaseListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页列表
            ponum = mResultlistBean.getPONUM();
            statues = mResultlistBean.getSTATUS();
            siteid = mResultlistBean.getSITEID();
            POID = mResultlistBean.getPOID() + "";
            PONUM=mResultlistBean.getPONUM();

            if ( statues.equals("已完成") || statues.equals("已取消")||statues.equals("完成") || statues.equals("取消")) {
                tvApproval.setVisibility(View.GONE);
            } else {
                if (statues.equals("等待批准")) {
                    tvApproval.setText("启动工作流");
                } else {
                    tvApproval.setText("工作流审批");

                }
            }
        }
        //键盘自动隐藏
        HideUtil.init(this);
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
            tvPurchaseRequest.setText("采购单:" + mResultlistBean.getPONUM());
            tvStatue.setText(mResultlistBean.getSTATUS());
            tvDesc.setText("描述:" + mResultlistBean.getDESCRIPTION());
            tvPurchaseBy.setText("采购员：" + mResultlistBean.getSHIPTOATTN());
            tvVendor.setText("供应商：" + mResultlistBean.getVENDORDESC());
            tvPurchaseDate.setText("订购日期：" + mResultlistBean.getORDERDATE());
            tvGetDate.setText("要求到货日期：" + mResultlistBean.getREQUIREDDATE());
            tvSumNotax.setText("合计金额（不含税）：" + mResultlistBean.getTOTALCOST());
            tvTax.setText("税额合计：" + mResultlistBean.getTOTSHUIE());
            tvSumTax.setText("合计金额（含税）：" + mResultlistBean.getTOTJINE());
            getPurchaseLine();
        }
    }

    private void getDetail() {
        /**
         *{
         *   "objectname" : "PO",
         *   "option" : "read",
         *   "condition" : {
         *     "POID" : 31023
         *   },
         *   "orderby" : "PONUM desc",
         *   "curpage" : 0,
         *   "showcount" : 1,
         *   "appid" : "PO"
         * }
         */
        LogUtils.d("getDetail");
        ld.show();
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PO");
        object.put("objectname", "PO");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "PONUM desc");
        JSONObject conditionObject = new JSONObject();
        conditionObject.put("POID", POID);
        object.put("condition", conditionObject);
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
                ld.close();
                if (!response.isEmpty()) {
                    PurchaseListDetailBean purchaseListDetailBean = JSONObject.parseObject(response, new TypeReference<PurchaseListDetailBean>() {
                    });
                    if (purchaseListDetailBean.getErrcode().equals("GLOBAL-S-0")) {
                        PurchaseListDetailBean.ResultBean.ResultlistBean resultlistBean = purchaseListDetailBean.getResult().getResultlist().get(0);
                        ponum = resultlistBean.getPONUM();
                        siteid = resultlistBean.getSITEID();
                        POID = resultlistBean.getPOID() + "";
                        PONUM=resultlistBean.getPONUM();

                        statues = resultlistBean.getSTATUS();
                        if (statues.equals("已完成") || statues.equals("已取消")) {
                            tvApproval.setVisibility(View.GONE);
                        } else {
                            if (statues.equals("等待批准")) {
                                tvApproval.setText("启动工作流");
                            } else {
                                tvApproval.setText("工作流审批");

                            }
                        }
                        tvPurchaseRequest.setText("采购单" + resultlistBean.getPONUM());
                        tvStatue.setText(resultlistBean.getSTATUS());
                        tvDesc.setText("描述" + resultlistBean.getDESCRIPTION());
                        tvPurchaseBy.setText("采购员：" + resultlistBean.getSHIPTOATTN());
                        tvVendor.setText("供应商：" + resultlistBean.getVENDORDESC());
                        tvPurchaseDate.setText("订购日期：" + resultlistBean.getORDERDATE());
                        tvGetDate.setText("要求到货日期：" + resultlistBean.getREQUIREDDATE());
                        tvSumNotax.setText("合计金额（不含税）：" + resultlistBean.getTOTALCOST());
                        tvTax.setText("税额合计：" + resultlistBean.getTOTSHUIE());
                        tvSumTax.setText("合计金额（含税）：" + resultlistBean.getTOTJINE());
                        getPurchaseLine();
                    }
                }
            }

        });
    }

    private void getPurchaseLine() {
        /**
         * {
         *   "objectname" : "POLINE",
         *   "option" : "read",
         *   "orderby" : "polinenum ASC",
         *   "curpage" : 1,
         *   "showcount" : 20,
         *   "sqlSearch" : "ponum='31928' and siteid = '(null)'",
         *   "appid" : "POLINE"
         * }
         */

        LogUtils.d("getPlanLine==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "POLINE");
        object.put("objectname", "POLINE");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "polinenum ASC");
        object.put("sqlSearch", "ponum='" + ponum + "' " + "and siteid='" + siteid + "'");
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
                ProjectMonthLineBean projectMonthLineBean;
                if (!response.isEmpty()) {
                    PurchaseListLineBean purchaseListLineBean = JSONObject.parseObject(response, new TypeReference<PurchaseListLineBean>() {
                    });

                    if (purchaseListLineBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<PurchaseListLineBean.ResultBean.ResultlistBean> resultlist = purchaseListLineBean.getResult().getResultlist();
                        llPurchaseLine.removeAllViews();
                        for (int i = 0; i < resultlist.size(); i++) {
                            View inflate = LayoutInflater.from(PurchaseListDetailActivity.this).inflate(R.layout.purchase_list_detail_line_item, llPurchaseLine, false);
                            TextView tv_project_no = inflate.findViewById(R.id.tv_project_no);
                            TextView tv_line_desc = inflate.findViewById(R.id.tv_line_desc);
                            TextView tv_model = inflate.findViewById(R.id.tv_model);
                            TextView tv_count = inflate.findViewById(R.id.tv_count);
                            TextView tv_unit = inflate.findViewById(R.id.tv_unit);
                            TextView tv_unit_notax = inflate.findViewById(R.id.tv_unit_notax);
                            TextView tv_total_notax = inflate.findViewById(R.id.tv_total_notax);
                            TextView tv_tax_ratio = inflate.findViewById(R.id.tv_tax_ratio);
                            TextView tv_tax_count = inflate.findViewById(R.id.tv_tax_count);
                            TextView tv_unit_tax = inflate.findViewById(R.id.tv_unit_tax);
                            TextView tv_location = inflate.findViewById(R.id.tv_location);

                            tv_project_no.setText("项目编号：" + resultlist.get(i).getITEMNUM());
                            tv_line_desc.setText("项目描述：" + resultlist.get(i).getITEMDESC());
                            tv_model.setText("规格型号：" + resultlist.get(i).getA_MODEL());
                            tv_count.setText("数量：" + resultlist.get(i).getORDERQTY());
                            tv_unit.setText("单位：" + resultlist.get(i).getORDERUNIT());
                            tv_unit_notax.setText("不含税单价：" + resultlist.get(i).getUNITCOST());
                            tv_total_notax.setText("不含税总价：" + resultlist.get(i).getLINECOST());
                            tv_tax_ratio.setText("税率：" + resultlist.get(i).getPL4());
                            tv_tax_count.setText("税额：" + resultlist.get(i).getSHUIE());
                            tv_unit_tax.setText("含税单价：" + resultlist.get(i).getJINE());
                            tv_location.setText("仓库：" + resultlist.get(i).getSTORELOC());

                            llPurchaseLine.addView(inflate);

                        }


                    }

                }

            }


        });
    }

    private void initView() {
        tvCommonTitle.setText("入库单详情");
    }

    @OnClick({R.id.ll_back, R.id.tv_approval})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_approval:
                if (statues.equals("等待批准")) {
                    start();
                } else {
                    ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems, tvApproval);
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
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfservicestartWF creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <!--Optional:-->
         *          <max:processname>PO</max:processname>
         *          <!--Optional:-->
         *          <max:mbo>PO</max:mbo>
         *          <!--Optional:-->
         *          <max:keyValue>31921</max:keyValue>
         *          <!--Optional:-->
         *          <max:key>PONUM</max:key>
         *          <!--Optional:-->
         *          <max:loginid>maxadmin</max:loginid>
         *       </max:wfservicestartWF>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>PO</max:processname>\n" +
                "         <max:mbo>PO</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>PONUM</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, PONUM, SharedPreferencesUtil.getString(this, "personId"));
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
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                    });
                    if (startWorkProcessBean.getMsg().equals("流程启动成功！")) {
                        statues = startWorkProcessBean.getNextStatus();
                        tvStatue.setText(startWorkProcessBean.getNextStatus());
                        tvApproval.setText("工作流审批");
                        PostData postData=new PostData();
                        postData.setTag("入库单");
                        EventBus.getDefault().post(postData);
                    } else {

                    }
                    ToastUtils.showShort(startWorkProcessBean.getMsg());
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
                input_et.setHint("不同意");
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

    private void goApproval(int isAgree, String opinion) {
        if (StringUtils.isEmpty(opinion)){
            if (isAgree==1){
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
         * 			<max:processname>PO</max:processname>
         * 			<max:mboName>PO</max:mboName>
         * 			<max:keyValue>31021</max:keyValue>
         * 			<max:key>POID</max:key>
         * 			<max:ifAgree>1</max:ifAgree>
         * 			<max:opinion>Fffffff</max:opinion>
         * 			<max:loginid>JIAWF</max:loginid>
         * 		</max:wfservicewfGoOn>
         * 	</soapenv:Body>
         * </soapenv:Envelope>
         */
        String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\" >" +
                "<max:processname>PO</max:processname>" +
                "<max:mboName>PO</max:mboName>" +
                "<max:keyValue>%s</max:keyValue>" +
                "<max:key>POID</max:key>" +
                "<max:ifAgree>%s</max:ifAgree>" +
                "<max:opinion>%s</max:opinion>" +
                "<max:loginid>%s</max:loginid>" +
                "</max:wfservicewfGoOn>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
        // ifAgree ：1 同意  2 不同意   opinion：输入内容
        request = String.format(request, POID, isAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
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
                int start = response.indexOf("<return>");
                int end = response.indexOf("</return>");
                String substring = response.substring(start + 8, end);
                LogUtils.d("substring==" + substring);
                StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                });
                if (startWorkProcessBean.getMsg().equals("审批成功")) {
                    statues = startWorkProcessBean.getNextStatus();
                    tvStatue.setText(startWorkProcessBean.getNextStatus());
//                    tvApproval.setVisibility(View.GONE);
                    startWorkProcessBean.setTag("采购单");
                    EventBus.getDefault().post(startWorkProcessBean);
                    getPurchaseLine();
                } else {

                }
                ToastUtils.showShort(startWorkProcessBean.getMsg());
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
