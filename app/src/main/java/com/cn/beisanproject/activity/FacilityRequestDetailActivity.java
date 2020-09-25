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
import com.cn.beisanproject.modelbean.FacilityRequestDetailBean;
import com.cn.beisanproject.modelbean.FacilityRequestListBean;
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

public class FacilityRequestDetailActivity extends AppCompatActivity {
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
    @BindView(R.id.tv_faclity_name)
    TextView tvFaclityName;
    @BindView(R.id.tv_big_type)
    TextView tvBigType;
    @BindView(R.id.tv_small_type)
    TextView tvSmallType;
    @BindView(R.id.tv_own_dept)
    TextView tvOwnDept;
    @BindView(R.id.tv_assert_no)
    TextView tvAssertNo;
    @BindView(R.id.tv_finish_date)
    TextView tvFinishDate;
    @BindView(R.id.tv_orgin_assert)
    TextView tvOrginAssert;
    @BindView(R.id.tv_skill_level)
    TextView tvSkillLevel;
    @BindView(R.id.tv_quality_level)
    TextView tvQualityLevel;
    @BindView(R.id.tv_jiegou)
    TextView tvJiegou;
    @BindView(R.id.tv_used_dept)
    TextView tvUsedDept;
    @BindView(R.id.tv_sheji_dept)
    TextView tvShejiDept;
    @BindView(R.id.tv_shigong_dept)
    TextView tvShigongDept;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_yongtu)
    TextView tvYongtu;
    @BindView(R.id.tv_dijijichu)
    TextView tvDijijichu;
    @BindView(R.id.tv_jianzhumianji)
    TextView tvJianzhumianji;
    @BindView(R.id.tv_zhandimianji)
    TextView tvZhandimianji;
    @BindView(R.id.tv_tudi_no)
    TextView tvTudiNo;
    @BindView(R.id.tv_house_no)
    TextView tvHouseNo;
    @BindView(R.id.tv_write_by)
    TextView tvWriteBy;
    @BindView(R.id.tv_write_time)
    TextView tvWriteTime;
    @BindView(R.id.sc)
    ScrollView sc;
    @BindView(R.id.tv_approval)
    TextView tvApproval;
    private boolean needGet;

    String status;
    private LoadingDialog ld;
    private String[] stringItems = new String[]{"工作流审批"};
    private PopupWindow pop;
    int isAgree = 1;
    private FacilityRequestListBean.ResultBean.ResultlistBean mResultlistBean;
    private WaitDoListBean.ResultBean.ResultlistBean mWitdolistBean;
    private String JD_SSTZID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faclity_request_detail_activity);
        ButterKnife.bind(this);
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            mWitdolistBean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            JD_SSTZID = mWitdolistBean.getOWNERID() + "";
            LogUtils.d("OWNERID==" + JD_SSTZID);
        } else {
            mResultlistBean = (FacilityRequestListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页 项目立项/项目月度计划
            JD_SSTZID=mResultlistBean.getJD_SSTZID()+"";
            status = mResultlistBean.getSTATUS();
            if (status.equals("已确认") || status.equals("取消")) {
                tvApproval.setVisibility(View.GONE);
            }else {
                if(status.equals("草稿")){
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
        if (needGet){
            getDetail();
        }else {
            tvRequestNo.setText("申请编号："+mResultlistBean.getJD_SSTZID());
            tvRequestStatue.setText(mResultlistBean.getSTATUS());
            tvSystemNo.setText("系统编码：");
            tvFaclityName.setText("设施名称:"+mResultlistBean.getNAME());
            tvBigType.setText("设施大类:"+mResultlistBean.getSSDL());
            tvSmallType.setText("设施小类:"+mResultlistBean.getSSZL());
            tvOwnDept.setText("所属单位:"+mResultlistBean.getSSDW());
            tvAssertNo.setText("资产编号:"+mResultlistBean.getASSETNUM());
            tvFinishDate.setText("建成投产日期:"+mResultlistBean.getJCTCRQ());
            tvOrginAssert.setText("资产原值(万元):"+mResultlistBean.getZCYZ());
            tvSkillLevel.setText("目前技术等级:"+mResultlistBean.getMQJSDJ());
            tvQualityLevel.setText("竣工验收质量等级:"+mResultlistBean.getJGYSZLDJ());
            tvJiegou.setText("结构形式:"+mResultlistBean.getMCJG());
            tvUsedDept.setText("使用单位:"+mResultlistBean.getSYDW());
            tvShejiDept.setText("设计单位:"+mResultlistBean.getSJDW());
            tvShigongDept.setText("施工单位:"+mResultlistBean.getSGDW());
            tvLocation.setText("所在地址:"+mResultlistBean.getSZDZ());
            tvYongtu.setText("用途:"+mResultlistBean.getYT());
            tvDijijichu.setText("地基基础:"+mResultlistBean.getDJJC());
            tvJianzhumianji.setText("建筑面积(m2):"+mResultlistBean.getJZMJ());
            tvZhandimianji.setText("占地面积(m2):"+mResultlistBean.getYXMJ());
            tvTudiNo.setText("对应土地证号:"+mResultlistBean.getDYTDZH());
            tvHouseNo.setText("房产证号:"+mResultlistBean.getQZH());
            tvWriteBy.setText("创建人:"+mResultlistBean.getCREATEBYDESC());
            tvWriteTime.setText("创建时间:"+mResultlistBean.getCREATETIME());
        }
    }

    private void getDetail() {
        /**
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"JD_SSTZ",
         * "objectname":"JD_SSTZ",
         * "curpage":1,
         * "showcount":20
         * ,"option":"read"
         * ,"orderby":""
         * ,"sqlSearch":" JD_SSTZID=:JD_SSTZID  "}
         */
        LogUtils.d("query==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "JD_SSTZ");
        object.put("objectname", "JD_SSTZ");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        object.put("sqlSearch", "JD_SSTZID="+JD_SSTZID);
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
                FacilityRequestDetailBean equmentRequestListBean;
                if (!response.isEmpty()) {
                    equmentRequestListBean = JSONObject.parseObject(response, new TypeReference<FacilityRequestDetailBean>() {});
                    if (equmentRequestListBean.getErrcode().equals("GLOBAL-S-0")) {
                        FacilityRequestDetailBean.ResultBean.ResultlistBean resultlistBean = equmentRequestListBean.getResult().getResultlist().get(0);
                        status=resultlistBean.getSTATUS();
                        if (status.equals("已确认") || status.equals("取消")) {
                            tvApproval.setVisibility(View.GONE);
                        }else {
                            if(status.equals("草稿")){
                                tvApproval.setText("启动工作流");
                            }else {
                                tvApproval.setText("工作流审批");
                            }
                        }
                        JD_SSTZID=resultlistBean.getJD_SSTZID()+"";
                        tvRequestNo.setText("申请编号:"+resultlistBean.getJD_SSTZID());
                        tvRequestStatue.setText(resultlistBean.getSTATUS());
                        tvSystemNo.setText("系统编码:");
                        tvFaclityName.setText("设施名称:"+resultlistBean.getNAME());
                        tvBigType.setText("设施大类:"+resultlistBean.getSSDL());
                        tvSmallType.setText("设施小类:"+resultlistBean.getSSZL());
                        tvOwnDept.setText("所属单位:"+resultlistBean.getSSDW());
                        tvAssertNo.setText("资产编号:"+resultlistBean.getASSETNUM());
                        tvFinishDate.setText("建成投产日期:"+resultlistBean.getJCTCRQ());
                        tvOrginAssert.setText("资产原值(万元):"+resultlistBean.getZCYZ());
                        tvSkillLevel.setText("目前技术等级:"+resultlistBean.getMQJSDJ());
                        tvQualityLevel.setText("竣工验收质量等级:"+resultlistBean.getJGYSZLDJ());
                        tvJiegou.setText("结构形式:"+resultlistBean.getMCJG());
                        tvUsedDept.setText("使用单位:"+resultlistBean.getSYDW());
                        tvShejiDept.setText("设计单位:"+resultlistBean.getSJDW());
                        tvShigongDept.setText("施工单位:"+resultlistBean.getSGDW());
                        tvLocation.setText("所在地址:"+resultlistBean.getSZDZ());
                        tvYongtu.setText("用途:"+resultlistBean.getYT());
                        tvDijijichu.setText("地基基础:"+resultlistBean.getDJJC());
                        tvJianzhumianji.setText("建筑面积(m2):"+resultlistBean.getJZMJ());
                        tvZhandimianji.setText("占地面积(m2):"+resultlistBean.getYXMJ());
                        tvTudiNo.setText("对应土地证号:"+resultlistBean.getDYTDZH());
                        tvHouseNo.setText("房产证号:"+resultlistBean.getQZH());
                        tvWriteBy.setText("创建人:"+resultlistBean.getCREATEBYDESC());
                        tvWriteTime.setText("创建时间:"+resultlistBean.getCREATETIME());
                    }

                }

            }


        });

    }

    private void initView() {
        tvCommonTitle.setText("设施台账增减申请");
    }

    @OnClick({R.id.tv_back, R.id.tv_approval})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_approval:
                if (status.equals("草稿")) {//启动工作流
                    start();
                } else {//工作流审批
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
         * <<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfservicestartWF creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:processname>SSTZ</max:processname>
         *          <max:mbo>JD_SSTZ</max:mbo>
         *          <max:keyValue>241</max:keyValue>
         *          <max:key>JD_SSTZID</max:key>
         *          <max:loginid>MAXADMIN</max:loginid>
         *       </max:wfservicestartWF>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>SSTZ</max:processname>\n" +
                "         <max:mbo>JD_SSTZ</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>JD_SSTZID</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, JD_SSTZID, SharedPreferencesUtil.getString(this, "personId"));
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");
        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP, request, headermap, new CallBackUtil.CallBackString() {
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
                            postData.setTag("设施台账增减申请");
                            EventBus.getDefault().post(postData);
                        }else {

                        }
                        ToastUtils.showShort(startWorkProcessBean.getMsg());
                    }else {
                        ToastUtils.showShort(R.string.getDatafailed);
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
         * 			<max:processname>SSTZ</max:processname>
         * 			<max:mboName>JD_SSTZ</max:mboName>
         * 			<max:keyValue>262</max:keyValue>
         * 			<max:key>JD_SSTZID</max:key>
         * 			<max:ifAgree>1</max:ifAgree>
         * 			<max:opinion>Zzzxxxx</max:opinion>
         * 			<max:loginid>MAXADMIN</max:loginid>
         * 		</max:wfservicewfGoOn>
         * 	</soapenv:Body>
         * </soapenv:Envelope>
         */
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "\t<soapenv:Header />\n" +
                "\t<soapenv:Body>\n" +
                "\t\t<max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "\t\t\t<max:processname>SSTZ</max:processname>\n" +
                "\t\t\t<max:mboName>JD_SSTZ</max:mboName>\n" +
                "\t\t\t<max:keyValue>%s</max:keyValue>\n" +
                "\t\t\t<max:key>JD_SSTZID</max:key>\n" +
                "\t\t\t<max:ifAgree>%s</max:ifAgree>\n" +
                "\t\t\t<max:opinion>%s</max:opinion>\n" +
                "\t\t\t<max:loginid>%s</max:loginid>\n" +
                "\t\t</max:wfservicewfGoOn>\n" +
                "\t</soapenv:Body>\n" +
                "</soapenv:Envelope>";
        request = String.format(request, JD_SSTZID, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
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
                int start = response.indexOf("<return>");
                int end = response.indexOf("</return>");
                String substring = response.substring(start + 8, end);
                LogUtils.d("substring==" + substring);
                StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                });
                if (startWorkProcessBean.getMsg().equals("审批成功")) {
                    if (isAgree == 1) {
                        tvApproval.setVisibility(View.GONE);
                    }
                    status = startWorkProcessBean.getNextStatus();
                    tvRequestStatue.setText(startWorkProcessBean.getNextStatus());
                } else {

                }
                ToastUtils.showShort(startWorkProcessBean.getMsg());
            }
        });
    }


}
