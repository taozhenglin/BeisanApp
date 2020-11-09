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
import com.cn.beisanproject.modelbean.CountEqmentRequestListBean;
import com.cn.beisanproject.modelbean.CountEqumentRequestListBean;
import com.cn.beisanproject.modelbean.PostData;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class CountEqmentRequestDetailActivity extends AppCompatActivity {
    String status;
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
    @BindView(R.id.tv_system_no)
    TextView tvSystemNo;
    @BindView(R.id.tv_eq_name)
    TextView tvEqName;
    @BindView(R.id.tv_eq_model)
    TextView tvEqModel;
    @BindView(R.id.tv_eq_statue)
    TextView tvEqStatue;
    @BindView(R.id.tv_own_dept)
    TextView tvOwnDept;
    @BindView(R.id.tv_used_dept)
    TextView tvUsedDept;
    @BindView(R.id.tv_level)
    TextView tvLevel;
    @BindView(R.id.tv_manufacturer)
    TextView tvManufacturer;
    @BindView(R.id.tv_celiang_fanwei)
    TextView tvCeliangFanwei;
    @BindView(R.id.tv_jishuzhibiao)
    TextView tvJishuzhibiao;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_dept_no)
    TextView tvDeptNo;
    @BindView(R.id.tv_out_no)
    TextView tvOutNo;
    @BindView(R.id.tv_xiaozhun_statue)
    TextView tvXiaozhunStatue;
    @BindView(R.id.tv_xiaozhun_date)
    TextView tvXiaozhunDate;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.tv_created_by)
    TextView tvCreatedBy;
    @BindView(R.id.tv_created_time)
    TextView tvCreatedTime;
    @BindView(R.id.sc)
    ScrollView sc;
    @BindView(R.id.tv_approval)
    TextView tvApproval;
    private LoadingDialog ld;
    private String[] stringItems1 = new String[]{"启动工作流"};
    private String[] stringItems2 = new String[]{"工作流审批"};
    private PopupWindow pop;
    int isAgree = 1;
    private CountEqmentRequestListBean.ResultBean.ResultlistBean mResultlistBean;
    private WaitDoListBean.ResultBean.ResultlistBean mWitdolistBean;
    private boolean needGet;
    private String JD_MEASUREMENTID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_request_detail_activity);
        ButterKnife.bind(this);
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            mWitdolistBean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            JD_MEASUREMENTID = mWitdolistBean.getOWNERID() + "";
            LogUtils.d("JD_MEASUREMENTID=" + JD_MEASUREMENTID);
        } else {
            mResultlistBean = (CountEqmentRequestListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页 项目立项/项目月度计划
            JD_MEASUREMENTID = mResultlistBean.getJD_MEASUREMENTID() + "";
            status = mResultlistBean.getSTATUS();
            if (status.equals("已取消") || status.equals("取消")||status.equals("已关闭") || status.equals("关闭")) {
                tvApproval.setVisibility(View.GONE);
            }else {
                if (status.equals("等待批准")){
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
        initView();
        initEvent();
    }

    private void initEvent() {
        if (needGet) {
            getDetail();
        } else {
            tvRequestNo.setText("申请单号:" + mResultlistBean.getJD_MEASUREMENTID());
            tvRequestStatue.setText(mResultlistBean.getSTATUS());
            tvSystemNo.setText("系统编号:" + mResultlistBean.getASSETNUM());
            tvEqName.setText("设备名称:" + mResultlistBean.getNAME());
            tvEqModel.setText("型号规格:" + mResultlistBean.getXH());
            tvEqStatue.setText("设备状态:" + mResultlistBean.getASSETSTATUS());
            tvEqStatue.setText("设备状态:" + mResultlistBean.getASSETSTATUS());
            tvOwnDept.setText("所属单位:" + mResultlistBean.getSSDW());
            tvUsedDept.setText("使用单位:" + mResultlistBean.getSYDW());
            tvLevel.setText("准确度等级:" + mResultlistBean.getDJ());
            tvManufacturer.setText("生产厂家:" + mResultlistBean.getSCCJ());
            tvCeliangFanwei.setText("测量范围:");
            tvLocation.setText("安装使用地点及用途:" + mResultlistBean.getAZDZ());
            tvDeptNo.setText("用能单位管理编号:" + mResultlistBean.getYNDWGL());
            tvOutNo.setText("出厂编号:" + mResultlistBean.getJD_MEASUREMENTNUM());
            tvXiaozhunStatue.setText("检定/校准状态:" + mResultlistBean.getXZSTATUS());
            tvXiaozhunDate.setText("检定/校准有效期:" + mResultlistBean.getXZDATE());
            tvNote.setText("备注:" + mResultlistBean.getREMARKS());
            tvCreatedBy.setText("创建人:" + mResultlistBean.getENTERBYDESC());
            tvCreatedTime.setText("创建时间:" + mResultlistBean.getENTERDATE());


        }
    }

    private void getDetail() {
        /**
         * {
         *   "objectname" : "JD_MEASUREMENT",
         *   "option" : "read",
         *   "condition" : {
         *     "JD_MEASUREMENTID" : 125
         *   },
         *   "orderby" : "JD_MEASUREMENTID desc",
         *   "curpage" : 0,
         *   "showcount" : 1,
         *   "appid" : "JD_MEASUREMENT"
         * }
         */
        LogUtils.d("query==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "JD_MEASUREMENT");
        object.put("objectname", "JD_MEASUREMENT");
        object.put("curpage", 0);
        object.put("showcount", 1);
        object.put("option", "read");
        object.put("orderby", "JD_MEASUREMENTID desc");
        JSONObject condition = new JSONObject();
        condition.put("JD_MEASUREMENTID", JD_MEASUREMENTID);
        object.put("condition", condition);
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
                CountEqumentRequestListBean countEqumentRequestListBean;
                if (!response.isEmpty()) {
                    countEqumentRequestListBean = JSONObject.parseObject(response, new TypeReference<CountEqumentRequestListBean>() {
                    });
                    if (countEqumentRequestListBean.getErrcode().equals("GLOBAL-S-0")) {
                        CountEqumentRequestListBean.ResultBean.ResultlistBean resultlistBean = countEqumentRequestListBean.getResult().getResultlist().get(0);
                        status = resultlistBean.getSTATUS();
                        if (status.equals("已取消") || status.equals("取消")||status.equals("已关闭") || status.equals("关闭")) {
                            tvApproval.setVisibility(View.GONE);
                        }else {
                            if (status.equals("等待批准")){
                                tvApproval.setText("启动工作流");
                            }else {
                                tvApproval.setText("工作流审批");
                            }
                        }
                        tvRequestNo.setText("申请单号:" + resultlistBean.getJD_MEASUREMENTID());
                        tvEqStatue.setText(resultlistBean.getSTATUS());
                        tvSystemNo.setText("系统编号:" + resultlistBean.getASSETNUM());
                        tvEqName.setText("设备名称:" + resultlistBean.getNAME());
                        tvEqModel.setText("型号规格:" + resultlistBean.getXH());
                        tvEqStatue.setText("设备状态:" + resultlistBean.getASSETSTATUS());
                        tvOwnDept.setText("所属单位:" + resultlistBean.getSSDW());
                        tvUsedDept.setText("使用单位:" + resultlistBean.getSYDW());
                        tvLevel.setText("准确度等级:" + resultlistBean.getDJ());
                        tvManufacturer.setText("生产厂家:" + resultlistBean.getSCCJ());
                        tvCeliangFanwei.setText("测量范围:");
                        tvLocation.setText("安装使用地点及用途:" + resultlistBean.getAZDZ());
                        tvDeptNo.setText("用能单位管理编号:" + resultlistBean.getYNDWGL());
                        tvOutNo.setText("出厂编号:" + resultlistBean.getJD_MEASUREMENTNUM());
                        tvXiaozhunStatue.setText("检定/校准状态:" + resultlistBean.getXZSTATUS());
                        tvXiaozhunDate.setText("检定/校准有效期:" + resultlistBean.getXZDATE());
                        tvNote.setText("备注:" + resultlistBean.getREMARKS());
                        tvCreatedBy.setText("创建人:" + resultlistBean.getENTERBYDESC());
                        tvCreatedTime.setText("创建时间:" + resultlistBean.getENTERDATE());
                    }

                }

            }


        });

    }

    private void initView() {
        tvCommonTitle.setText("计量设备台账增减申请");
    }

    @OnClick({R.id.tv_back, R.id.tv_approval})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_approval:
                if (status.equals("等待批准")) {//启动工作流
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
                            }
                        }
                    });

                } else {//流程审批
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
         *          <max:processname>JLTZ</max:processname>
         *          <max:mbo>JD_MEASUREMENT</max:mbo>
         *          <max:keyValue>101</max:keyValue>
         *          <max:key>JD_MEASUREMENTID</max:key>
         *          <max:loginid>MAXADMIN</max:loginid>
         *       </max:wfservicestartWF>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>JLTZ</max:processname>\n" +
                "         <max:mbo>JD_MEASUREMENT</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>JD_MEASUREMENTID</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, JD_MEASUREMENTID, SharedPreferencesUtil.getString(this, "personId"));
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
                            status=startWorkProcessBean.getNextStatus();
                            tvApproval.setText("工作流审批");
                            tvRequestStatue.setText(startWorkProcessBean.getNextStatus());
                            PostData postData=new PostData();
                            postData.setTag("计量设备台账增减申请");
                            EventBus.getDefault().post(postData);
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
                input_et.setHint("不同意");
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
        ld.show();
        /**
         * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:max="http://www.ibm.com/maximo">
         * 	<soapenv:Header />
         * 	<soapenv:Body>
         * 		<max:wfservicewfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         * 			<max:processname>JLTZ</max:processname>
         * 			<max:mboName>JD_MEASUREMENT</max:mboName>
         * 			<max:keyValue>102</max:keyValue>
         * 			<max:key>JD_MEASUREMENTID</max:key>
         * 			<max:ifAgree>1</max:ifAgree>
         * 			<max:opinion>666666</max:opinion>
         * 			<max:loginid>MAXADMIN</max:loginid>
         * 		</max:wfservicewfGoOn>
         * 	</soapenv:Body>
         * </soapenv:Envelope>
         */
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "\t<soapenv:Header />\n" +
                "\t<soapenv:Body>\n" +
                "\t\t<max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "\t\t\t<max:processname>JLTZ</max:processname>\n" +
                "\t\t\t<max:mboName>JD_MEASUREMENT</max:mboName>\n" +
                "\t\t\t<max:keyValue>%s</max:keyValue>\n" +
                "\t\t\t<max:key>JD_MEASUREMENTID</max:key>\n" +
                "\t\t\t<max:ifAgree>%s</max:ifAgree>\n" +
                "\t\t\t<max:opinion>%s</max:opinion>\n" +
                "\t\t\t<max:loginid>%s</max:loginid>\n" +
                "\t\t</max:wfservicewfGoOn>\n" +
                "\t</soapenv:Body>\n" +
                "</soapenv:Envelope>";
        request = String.format(request, JD_MEASUREMENTID, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
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
                if (response.contains("<return>")&&response.contains("</return>")){
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                    });
                    if (startWorkProcessBean.getMsg().equals("审批成功")) {
                        if (isAgree == 1 && startWorkProcessBean.getNextStatus().equals("已确认")) {
                            tvApproval.setVisibility(View.GONE);
                        }
                        status = startWorkProcessBean.getNextStatus();
                        tvRequestStatue.setText(startWorkProcessBean.getNextStatus());
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
