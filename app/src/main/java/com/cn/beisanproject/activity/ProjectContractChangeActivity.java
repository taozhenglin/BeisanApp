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
import com.cn.beisanproject.modelbean.ProjectChangeBean;
import com.cn.beisanproject.modelbean.ProjectContractChangeBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.WaitDoListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.yinglan.keyboard.HideUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 *项目合同变更 详情页
 */
public class ProjectContractChangeActivity extends AppCompatActivity  {
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.tv_common_title)
    TextView tvCommonTitle;
    @BindView(R.id.iv_fun)
    ImageView ivFun;
    @BindView(R.id.tv_mchange_no)
    TextView tvMchangeNo;
    @BindView(R.id.tv_change_statue)
    TextView tvChangeStatue;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_contract_no)
    TextView tvContractNo;
    @BindView(R.id.tv_contract_desc)
    TextView tvContractDesc;
    @BindView(R.id.tv_created_by)
    TextView tvCreatedBy;
    @BindView(R.id.tv_created_time)
    TextView tvCreatedTime;
    @BindView(R.id.tv_orgin_acount)
    TextView tvOrginAcount;
    @BindView(R.id.tv_new_acount)
    TextView tvNewAcount;
    @BindView(R.id.tv_orgin_start)
    TextView tvOrginStart;
    @BindView(R.id.tv_new_start)
    TextView tvNewStart;
    @BindView(R.id.tv_orgin_end)
    TextView tvOrginEnd;
    @BindView(R.id.tv_new_end)
    TextView tvNewEnd;
    @BindView(R.id.tv_change_detail)
    TextView tvChangeDetail;
    @BindView(R.id.tv_approval)
    TextView tvApproval;
    private LoadingDialog ld;
    WaitDoListBean.ResultBean.ResultlistBean mWitdolistBean;
    ProjectContractChangeBean.ResultBean.ResultlistBean resultlistBean;
    private int isAgree=1;
    private PopupWindow pop;
    private boolean needGet;
    private String OWNERID;
    String statues;
    private String[] stringItems = new String[]{"工作流审批"};
    private String UDBGNUM;
    String UDPURCHBGID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_change_activity);
        ButterKnife.bind(this);
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            mWitdolistBean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            OWNERID = mWitdolistBean.getOWNERID() + "";
            LogUtils.d("OWNERID=" + OWNERID);
        }else {
            resultlistBean = (ProjectContractChangeBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页 项目合同变更
            statues=resultlistBean.getSTATUS();
            UDBGNUM=resultlistBean.getUDBGNUM();
            UDPURCHBGID=resultlistBean.getUDPURCHBGID()+"";
            if (statues.equals("已取消")||statues.equals("取消")||statues.equals("关闭")||statues.equals("已关闭")){
                tvApproval.setVisibility(View.GONE);
            }else {
                if (statues.equals("等待核准")){
                    tvApproval.setText("启动工作流");
                }else {
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
        initView();
        initListener();
    }

    private void initListener() {
    }

    private void initEvent() {
        if (needGet){
            getDetail();
        }else {
            tvMchangeNo.setText("合同变更单：" + resultlistBean.getUDBGNUM());
            tvChangeStatue.setText(resultlistBean.getSTATUS());
            tvDesc.setText("描述：" + resultlistBean.getDESCRIPTION());
            tvContractNo.setText("合同编号：" + resultlistBean.getCONTRACTNUM());
            tvContractDesc.setText("合同描述：" + resultlistBean.getCONTRACTDESC());
            tvCreatedBy.setText("创建人：" + resultlistBean.getCREATEBYDESC());
            tvCreatedTime.setText("创建时间：" + resultlistBean.getCREATEDATE());
            tvOrginAcount.setText("原始合同总金额（元）：" + resultlistBean.getTOTALCOST());
            tvNewAcount.setText("新合同总金额（元）：");
            tvOrginStart.setText("原合同开始时间：" + resultlistBean.getSTARTDATE());
            tvNewStart.setText("新合同开始时间：");
            tvOrginEnd.setText("原合同结束时间：" + resultlistBean.getENDDATE());
            tvNewEnd.setText("新合同结束时间：");
            tvChangeDetail.setText("变更详情：");

        }

    }

    private void getDetail() {
        /**
         * {
         *   "objectname" : "UDPURCHBG",
         *   "option" : "read",
         *   "condition" : {
         *     "UDPURCHBGID" : 46
         *   },
         *   "orderby" : "UDBGNUM  desc",
         *   "curpage" : 0,
         *   "showcount" : 1,
         *   "appid" : "UDPURCHBG"
         * }
         */
        ld.show();
        LogUtils.d("getContractDetail");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "UDPURCHBG");
        object.put("objectname", "UDPURCHBG");
        object.put("curpage", 0);
        object.put("showcount", 1);
        object.put("option", "read");
        object.put("orderby", "UDBGNUM  desc");
        JSONObject conditionObject = new JSONObject();
        conditionObject.put("UDPURCHBGID", OWNERID);
        object.put("condition", conditionObject);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ToastUtils.showShort(R.string.getDatafailed);
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (!response.isEmpty()) {
                    ProjectChangeBean projectChangeBean = JSONObject.parseObject(response, new TypeReference<ProjectChangeBean>() {
                    });
                    if (projectChangeBean.getErrcode().equals("GLOBAL-S-0")) {
                        ProjectChangeBean.ResultBean.ResultlistBean resultlistBean = projectChangeBean.getResult().getResultlist().get(0);

                        tvMchangeNo.setText("合同变更单：" + resultlistBean.getUDBGNUM());
                        statues=resultlistBean.getSTATUS();
                        if (statues.equals("已批准")||statues.equals("已取消")){
                            tvApproval.setVisibility(View.GONE);
                        }else {
                            if (statues.equals("等待核准")){
                                tvApproval.setText("启动工作流");
                            }else {
                                tvApproval.setText("工作流审批");
                            }

                        }
                        UDPURCHBGID=resultlistBean.getUDPURCHBGID()+"";
                        UDBGNUM=resultlistBean.getUDBGNUM();
                        tvChangeStatue.setText(resultlistBean.getSTATUS());
                        tvDesc.setText("描述：" + resultlistBean.getDESCRIPTION());
                        tvContractNo.setText("合同编号：" + resultlistBean.getCONTRACTNUM());
                        tvContractDesc.setText("合同描述：" + resultlistBean.getCONTRACTDESC());
                        tvCreatedBy.setText("创建人：" + resultlistBean.getCREATEBYDESC());
                        tvCreatedTime.setText("创建时间：" + resultlistBean.getCREATEDATE());
                        tvOrginAcount.setText("原始合同总金额（元）：" + resultlistBean.getTOTALCOST());
                        tvNewAcount.setText("新合同总金额（元）：");
                        tvOrginStart.setText("原合同开始时间：" + resultlistBean.getSTARTDATE());
                        tvNewStart.setText("新合同开始时间：");
                        tvOrginEnd.setText("原合同结束时间：" + resultlistBean.getENDDATE());
                        tvNewEnd.setText("新合同结束时间：");
                        tvChangeDetail.setText("变更详情：");

                    }

                }

            }

        });
    }

    private void initView() {
        tvCommonTitle.setText("项目合同变更");
    }


    @OnClick({R.id.ll_back, R.id.tv_approval})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_approval:
                if (statues.equals("等待核准")){
                    start();
                }else {
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
         *          <max:processname>UDXMHTBG</max:processname>
         *          <!--Optional:-->
         *          <max:mbo>UDPURCHBG</max:mbo>
         *          <!--Optional:-->
         *          <max:keyValue>1004</max:keyValue>
         *          <!--Optional:-->
         *          <max:key>UDBGNUM</max:key>
         *          <!--Optional:-->
         *          <max:loginid>maxadmin</max:loginid>
         *       </max:wfservicestartWF>
         *    </soap:Body>
         * </soap:Envelope>
         */
        ld.show();

        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>UDXMHTBG</max:processname>\n" +
                "         <max:mbo>UDPURCHBG</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>UDBGNUM</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, UDBGNUM, SharedPreferencesUtil.getString(this, "personId"));
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
                        tvChangeStatue.setText(startWorkProcessBean.getNextStatus());
                        tvApproval.setText("工作流审批");
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
        ImageView iv_agree= (ImageView) remarkView.findViewById(R.id.iv_agree);
        iv_agree.setBackgroundResource(R.drawable.selected);
        ImageView iv_disagree= (ImageView) remarkView.findViewById(R.id.iv_disagree);
        iv_disagree.setBackgroundResource(R.drawable.unselected);
        iv_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_agree.setBackgroundResource(R.drawable.selected);
                iv_disagree.setBackgroundResource(R.drawable.unselected);
                isAgree=1;
                input_et.setHint("同意");
                LogUtils.d("同意==");
            }
        });
        iv_disagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_disagree.setBackgroundResource(R.drawable.selected);
                iv_agree.setBackgroundResource(R.drawable.unselected);
                isAgree=0;
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
                goApproval(isAgree,txt);
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
    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) this).getWindow().setAttributes(lp);
    }
    private void goApproval(int ifAgree, String opinion) {
        ld.show();
        /**
         * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:max="http://www.ibm.com/maximo">
         * 	<soapenv:Header />
         * 	<soapenv:Body>
         * 		<max:wfservicewfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         * 			<max:processname>UDXMHTBG</max:processname>
         * 			<max:mboName>UDPURCHBG</max:mboName>
         * 			<max:keyValue>46</max:keyValue>
         * 			<max:key>UDPURCHBGID</max:key>
         * 			<max:ifAgree>1</max:ifAgree>
         * 			<max:opinion>Ooooo</max:opinion>
         * 			<max:loginid>MAXADMIN</max:loginid>
         * 		</max:wfservicewfGoOn>
         * 	</soapenv:Body>
         * </soapenv:Envelope>
         */
        String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\" >" +
                "<max:processname>UDXMHTBG</max:processname>" +
                "<max:mboName>UDPURCHBG</max:mboName>" +
                "<max:keyValue>%s</max:keyValue>" +
                "<max:key>UDPURCHBGID</max:key>" +
                "<max:ifAgree>%s</max:ifAgree>" +
                "<max:opinion>%s</max:opinion>" +
                "<max:loginid>%s</max:loginid>" +
                "</max:wfservicewfGoOn>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
        // ifAgree ：1 同意  2 不同意   opinion：输入内容
        request = String.format(request, UDPURCHBGID, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");
        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP, request,headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                int start = response.indexOf("<return>");
                int end = response.indexOf("</return>");
                String substring = response.substring(start + 8, end);
                LogUtils.d("substring==" + substring);
                StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                });
                if (startWorkProcessBean.getMsg().equals("审批成功")) {
                    if (ifAgree == 1&&startWorkProcessBean.getNextStatus().equals("已批准")) {
                        tvApproval.setVisibility(View.GONE);
                    }
                    statues = startWorkProcessBean.getNextStatus();
                    tvChangeStatue.setText(startWorkProcessBean.getNextStatus());
                } else {

                }
                ToastUtils.showShort(startWorkProcessBean.getMsg());

                //解析xml 如果审批同意 则底部审批按钮消失

            }
        });

    }
}
