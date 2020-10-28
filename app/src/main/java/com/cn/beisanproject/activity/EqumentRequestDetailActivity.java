package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
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
import com.cn.beisanproject.modelbean.EqumentRequestListBean;
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

/**
 * 设备台账增减申请
 */
public class EqumentRequestDetailActivity extends AppCompatActivity {
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
    @BindView(R.id.tv_eq_no)
    TextView tvEqNo;
    @BindView(R.id.tv_is_imporment)
    TextView tvIsImporment;
    @BindView(R.id.tv_big_type)
    TextView tvBigType;
    @BindView(R.id.tv_middle_type)
    TextView tvMiddleType;
    @BindView(R.id.tv_small_type)
    TextView tvSmallType;
    @BindView(R.id.tv_origin_value)
    TextView tvOriginValue;
    @BindView(R.id.tv_own_dept)
    TextView tvOwnDept;
    @BindView(R.id.tv_used_dept)
    TextView tvUsedDept;
    @BindView(R.id.tv_eq_location)
    TextView tvEqLocation;
    @BindView(R.id.tv_eq_statue)
    TextView tvEqStatue;
    @BindView(R.id.tv_get_time)
    TextView tvGetTime;
    @BindView(R.id.tv_chuchang_no)
    TextView tvChuchangNo;
    @BindView(R.id.tv_eq_model)
    TextView tvEqModel;
    @BindView(R.id.tv_manufacturer)
    TextView tvManufacturer;
    @BindView(R.id.tv_vender)
    TextView tvVender;
    @BindView(R.id.tv_right_dept)
    TextView tvRightDept;
    @BindView(R.id.tv_electric_brand)
    TextView tvElectricBrand;
    @BindView(R.id.tv_jishuzhibiao)
    TextView tvJishuzhibiao;
    @BindView(R.id.tv_jingjizhibiao)
    TextView tvJingjizhibiao;
    @BindView(R.id.tv_youhua)
    TextView tvYouhua;
    @BindView(R.id.tv_note)
    TextView tvNote;
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
    private String[] stringItems1 = new String[]{"启动工作流"};

    private String[] stringItems2 = new String[]{"工作流审批"};
    private PopupWindow pop;
    int isAgree = 1;
    private EqumentRequestListBean.ResultBean.ResultlistBean mResultlistBean;
    private WaitDoListBean.ResultBean.ResultlistBean mWitdolistBean;
    private String OWNERID;
    String JD_SBTZID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equment_request_detail_activity);
        ButterKnife.bind(this);
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            mWitdolistBean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            JD_SBTZID = mWitdolistBean.getOWNERID() + "";
            LogUtils.d("OWNERID=" + OWNERID);
        } else {
            mResultlistBean = (EqumentRequestListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页 项目立项/项目月度计划
            JD_SBTZID = mResultlistBean.getJD_SBTZID() + "";
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

    private void initView() {
        tvCommonTitle.setText("设备台账增减申请");
    }

    private void initEvent() {
        if (needGet) {
            getDetail();
        } else {
            tvRequestNo.setText("申请单号：" + mResultlistBean.getJD_SBTZID());
            tvRequestStatue.setText(mResultlistBean.getSTATUS());
            tvSystemNo.setText("系统编码：");
            tvEqNo.setText("设备编号：" + mResultlistBean.getASSETNUM());
            tvRequestNo.setText("申请单号：" + mResultlistBean.getJD_SBTZID());
            tvIsImporment.setText("是否重点设备：" + mResultlistBean.getISZDSB());
            tvBigType.setText("设备大类：" + mResultlistBean.getSBDL());
            tvMiddleType.setText("设备中类：" + mResultlistBean.getSBZL());
            tvSmallType.setText("设备小类：" + mResultlistBean.getSBXL());
            tvOriginValue.setText("原值：" + mResultlistBean.getYZ());
            tvOwnDept.setText("所属单位：" + mResultlistBean.getSSDW());
            tvUsedDept.setText("使用单位：" + mResultlistBean.getSYDW());
            tvEqLocation.setText("设备位置：" + mResultlistBean.getSBWZ());
            tvEqStatue.setText("设备状态：" + mResultlistBean.getSBZT());
            tvGetTime.setText("购入时间：" + mResultlistBean.getGRDATE());
            tvChuchangNo.setText("出场编号：" + mResultlistBean.getJD_SBTZID());
            tvEqModel.setText("规格型号：" + mResultlistBean.getXH());
            tvManufacturer.setText("生产厂家：" + mResultlistBean.getSCCJ());
            tvVender.setText("供应商：" + mResultlistBean.getVENDOR());
            tvRightDept.setText("产权单位：");
            tvElectricBrand.setText("电控品牌：" + mResultlistBean.getDKPP());
            tvJishuzhibiao.setText("技术指标：" + mResultlistBean.getJSZB());
            tvJingjizhibiao.setText("经济指标：" + mResultlistBean.getJJZB());
            tvYouhua.setText("优化提升需求指标：");
            tvNote.setText("备注：" + mResultlistBean.getBZ());
            tvWriteBy.setText("创建人：" + mResultlistBean.getCREATEBYDESC());
            tvWriteTime.setText("创建时间：" + mResultlistBean.getCREATETIME());


        }

    }

    private void getDetail() {
        /**
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"JD_SBTZ",
         * "objectname":"JD_SBTZ",
         * "curpage":1,
         * "showcount":20
         * ,"option":"read"
         * ,"orderby":""
         * ,"sqlSearch":“ JD_SBTZID=:JD_SBTZID”}
         */
        LogUtils.d("query==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "JD_SBTZ");
        object.put("objectname", "JD_SBTZ");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        object.put("sqlSearch", " JD_SBTZID=" + JD_SBTZID);
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
                EqumentRequestListBean equmentRequestListBean;
                if (!response.isEmpty()) {
                    equmentRequestListBean = JSONObject.parseObject(response, new TypeReference<EqumentRequestListBean>() {
                    });
                    if (equmentRequestListBean.getErrcode().equals("GLOBAL-S-0")) {
                        EqumentRequestListBean.ResultBean.ResultlistBean resultlistBean = equmentRequestListBean.getResult().getResultlist().get(0);
                        status = resultlistBean.getSTATUS();
                        if (status.equals("已确认") || status.equals("取消")) {
                            tvApproval.setVisibility(View.GONE);
                        }else {
                            if(status.equals("草稿")){
                                tvApproval.setText("启动工作流");
                            }else {
                                tvApproval.setText("工作流审批");
                            }
                        }
                        JD_SBTZID = resultlistBean.getJD_SBTZID() + "";
                        tvRequestNo.setText("申请单号：" + resultlistBean.getJD_SBTZID());
                        tvRequestStatue.setText(resultlistBean.getSTATUS());
                        tvSystemNo.setText("系统编码：" + resultlistBean.getEQUNUM());
                        tvEqNo.setText("设备编号：" + resultlistBean.getASSETNUM());
                        tvRequestNo.setText("申请单号：" + resultlistBean.getJD_SBTZID());
                        tvIsImporment.setText("是否重点设备：" + resultlistBean.getISZDSB());
                        tvBigType.setText("设备大类：" + resultlistBean.getSBDL());
                        tvMiddleType.setText("设备中类：" + resultlistBean.getSBZL());
                        tvSmallType.setText("设备小类：" + resultlistBean.getSBXL());
                        tvOriginValue.setText("原值：" + resultlistBean.getYZ());
                        tvOwnDept.setText("所属单位：" + resultlistBean.getSSDW());
                        tvUsedDept.setText("使用单位：" + resultlistBean.getSYDW());
                        tvEqLocation.setText("设备位置：" + resultlistBean.getSBWZ());
                        tvEqStatue.setText("设备状态：" + resultlistBean.getSBZT());
                        tvGetTime.setText("购入时间：" + resultlistBean.getGRDATE());
                        tvChuchangNo.setText("出场编号：" + resultlistBean.getJD_SBTZID());
                        tvEqModel.setText("规格型号：" + resultlistBean.getXH());
                        tvManufacturer.setText("生产厂家：" + resultlistBean.getSCCJ());
                        tvVender.setText("供应商：" + resultlistBean.getVENDOR());
                        tvRightDept.setText("产权单位：");
                        tvElectricBrand.setText("电控品牌：" + resultlistBean.getDKPP());
                        tvJishuzhibiao.setText("技术指标：" + resultlistBean.getJSZB());
                        tvJingjizhibiao.setText("经济指标：" + resultlistBean.getJJZB());
                        tvYouhua.setText("优化提升需求指标：");
                        tvNote.setText("备注：" + resultlistBean.getBZ());
                        tvWriteBy.setText("创建人：" + resultlistBean.getCREATEBYDESC());
                        tvWriteTime.setText("创建时间：" + resultlistBean.getCREATETIME());
                    }

                }

            }


        });

    }

    @OnClick({R.id.tv_back, R.id.tv_approval})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_approval:
                if (status.equals("草稿")) {//启动工作流

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
                } else {//工作流审批
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
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfservicestartWF creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:processname>SBTZ</max:processname>
         *          <max:mbo>JD_SBTZ</max:mbo>
         *          <max:keyValue>201</max:keyValue>
         *          <max:key>JD_SBTZID</max:key>
         *          <max:loginid>MAXADMIN</max:loginid>
         *       </max:wfservicestartWF>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>SBTZ</max:processname>\n" +
                "         <max:mbo>JD_SBTZ</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>JD_SBTZID</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, JD_SBTZID, SharedPreferencesUtil.getString(this, "personId"));
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
                            postData.setTag("设备台账增减申请");
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
        ld.show();
        /**
         //         * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:max="http://www.ibm.com/maximo">
         //         * 	<soapenv:Header />
         //         * 	<soapenv:Body>
         //         * 		<max:wfservicewfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         //         * 			<max:processname>SBTZ</max:processname>
         //         * 			<max:mboName>JD_SBTZ</max:mboName>
         //         * 			<max:keyValue>227</max:keyValue>
         //         * 			<max:key>JD_SBTZID</max:key>
         //         * 			<max:ifAgree>1</max:ifAgree>
         //         * 			<max:opinion>Bbbhhhhjj</max:opinion>
         //         * 			<max:loginid>MAXADMIN</max:loginid>
         //         * 		</max:wfservicewfGoOn>
         //         * 	</soapenv:Body>
         //         * </soapenv:Envelope>
         */
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "\t<soapenv:Header />\n" +
                "\t<soapenv:Body>\n" +
                "\t\t<max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "\t\t\t<max:processname>SBTZ</max:processname>\n" +
                "\t\t\t<max:mboName>JD_SBTZ</max:mboName>\n" +
                "\t\t\t<max:keyValue>%s</max:keyValue>\n" +
                "\t\t\t<max:key>JD_SBTZID</max:key>\n" +
                "\t\t\t<max:ifAgree>%s</max:ifAgree>\n" +
                "\t\t\t<max:opinion>%s</max:opinion>\n" +
                "\t\t\t<max:loginid>%s</max:loginid>\n" +
                "\t\t</max:wfservicewfGoOn>\n" +
                "\t</soapenv:Body>\n" +
                "</soapenv:Envelope>";
        request = String.format(request, JD_SBTZID, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
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

    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) this).getWindow().setAttributes(lp);
    }
}
