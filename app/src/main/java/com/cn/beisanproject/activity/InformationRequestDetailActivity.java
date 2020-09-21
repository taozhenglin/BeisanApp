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
import com.cn.beisanproject.modelbean.InformationRequestDetailBean;
import com.cn.beisanproject.modelbean.InformationRequestListBean;
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

public class InformationRequestDetailActivity extends AppCompatActivity {
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
    @BindView(R.id.tv_ID)
    TextView tvID;
    @BindView(R.id.tv_categroy)
    TextView tvCategroy;
    @BindView(R.id.tv_write_by)
    TextView tvWriteBy;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_write_time)
    TextView tvWriteTime;
    @BindView(R.id.tv_line)
    TextView tvLine;
    @BindView(R.id.tv_system_no)
    TextView tvSystemNo;
    @BindView(R.id.tv_system_name)
    TextView tvSystemName;
    @BindView(R.id.tv_model)
    TextView tvModel;
    @BindView(R.id.tv_brand)
    TextView tvBrand;
    @BindView(R.id.tv_duty_by)
    TextView tvDutyBy;
    @BindView(R.id.tv_right_dept)
    TextView tvRightDept;
    @BindView(R.id.tv_big_type)
    TextView tvBigType;
    @BindView(R.id.tv_small_type)
    TextView tvSmallType;
    @BindView(R.id.tv_purchase_date)
    TextView tvPurchaseDate;
    @BindView(R.id.tv_own_dept)
    TextView tvOwnDept;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.tv_count_unit)
    TextView tvCountUnit;
    @BindView(R.id.tv_bianhao)
    TextView tvBianhao;
    @BindView(R.id.tv_used_dept)
    TextView tvUsedDept;
    @BindView(R.id.tv_weihu_dept)
    TextView tvWeihuDept;
    @BindView(R.id.tv_zhejiu)
    TextView tvZhejiu;
    @BindView(R.id.tv_origin_value)
    TextView tvOriginValue;
    @BindView(R.id.tv_note)
    TextView tvNote;
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
    private InformationRequestListBean.ResultBean.ResultlistBean mResultlistBean;
    private WaitDoListBean.ResultBean.ResultlistBean mWitdolistBean;
    String JD_INFORMANAGEID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO
        //根据分类不同  显示的布局也不同
        setContentView(R.layout.information_request_detail_activity);
        ButterKnife.bind(this);
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            mWitdolistBean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            JD_INFORMANAGEID = mWitdolistBean.getOWNERID() + "";
        } else {
            mResultlistBean = (InformationRequestListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页 项目立项/项目月度计划
            status = mResultlistBean.getSTATUS();
            JD_INFORMANAGEID = mResultlistBean.getJD_INFORMANAGEID();
            if (status.equals("已确认") || status.equals("取消")) {
                tvApproval.setVisibility(View.GONE);
            } else {
                if (status.equals("等待批准")) {
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
        initView();
        initEvent();
    }

    private void initEvent() {
        if (needGet) {
            getDetail();
        } else {
            tvRequestNo.setText("申请单号:" + mResultlistBean.getJD_INFORMANAGENUM());
            tvRequestStatue.setText(mResultlistBean.getSTATUS());
            tvID.setText("ID:" + mResultlistBean.getJD_INFORMANAGEID());
            tvRequestNo.setText("分类:" + mResultlistBean.getFL());
            tvWriteTime.setText("创建人:" + mResultlistBean.getENTERBYDESC());
            tvPhone.setText("联系电话:" + mResultlistBean.getPHONE());
            tvWriteTime.setText("创建时间:" + mResultlistBean.getENTERDATE());
            tvSystemNo.setText("系统编号:" + mResultlistBean.getASSETNUM());
            tvSystemName.setText("系统名称:" + mResultlistBean.getNAME());
            tvModel.setText("型号:" + mResultlistBean.getXH());
            tvBrand.setText("品牌:" + mResultlistBean.getPP());
            tvDutyBy.setText("责任人:" + mResultlistBean.getZRR());
            tvRightDept.setText("产权单位:" + mResultlistBean.getCCDW());
            tvBigType.setText("硬件大类:" + mResultlistBean.getHARDWAREDL());
            tvSmallType.setText("硬件小类:" + mResultlistBean.getHARDWAREXL());
            tvPurchaseDate.setText("采购时间:" + mResultlistBean.getCGSJ());
            tvOwnDept.setText("所属单位:" + mResultlistBean.getSSDW());
            tvLocation.setText("安装地址:" + mResultlistBean.getAZDZ());
            tvCount.setText("数量:" + mResultlistBean.getATTR1());
            tvCountUnit.setText("计量单位:" + mResultlistBean.getDW());
            tvBianhao.setText("编号:" + mResultlistBean.getJD_INFORMANAGENUM());
            tvUsedDept.setText("使用单位:" + mResultlistBean.getSYDW());
            tvWeihuDept.setText("维护单位:" + mResultlistBean.getWHDW());
            tvZhejiu.setText("财务折旧年限:" + mResultlistBean.getCWZJNX());
            tvOriginValue.setText("原值:" + mResultlistBean.getNDYWF());
            tvNote.setText("说明/备注:");
        }
    }

    private void getDetail() {
        /**
         * {
         *   "objectname" : "JD_INFORMANAGE",
         *   "option" : "read",
         *   "condition" : {
         *     "JD_INFORMANAGEID" : 144
         *   },
         *   "orderby" : "JD_INFORMANAGEID desc",
         *   "curpage" : 0,
         *   "showcount" : 1,
         *   "appid" : "JD_INFORMANAGE"
         * }
         */
        LogUtils.d("getDetail==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "JD_INFORMANAGE");
        object.put("objectname", "JD_INFORMANAGE");
        object.put("curpage", 0);
        object.put("showcount", 1);
        object.put("option", "read");
        object.put("orderby", "JD_INFORMANAGEID desc");
        JSONObject condition = new JSONObject();
        condition.put("JD_INFORMANAGEID", JD_INFORMANAGEID);
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
                InformationRequestDetailBean informationRequestDetailBean;
                if (!response.isEmpty()) {
                    informationRequestDetailBean = JSONObject.parseObject(response, new TypeReference<InformationRequestDetailBean>() {
                    });
                    InformationRequestDetailBean.ResultBean.ResultlistBean resultlistBean = informationRequestDetailBean.getResult().getResultlist().get(0);
                    status = resultlistBean.getSTATUS();
                    if (status.equals("已确认") || status.equals("取消")) {
                        tvApproval.setVisibility(View.GONE);
                    } else {
                        if (status.equals("等待批准")) {
                            tvApproval.setText("启动工作流");
                        } else {
                            tvApproval.setText("工作流审批");
                        }
                    }
                    JD_INFORMANAGEID=resultlistBean.getJD_INFORMANAGEID();
                    tvRequestNo.setText("申请单号:" + resultlistBean.getJD_INFORMANAGENUM());
                    tvRequestStatue.setText(resultlistBean.getSTATUS());
                    tvID.setText("ID:" + resultlistBean.getJD_INFORMANAGEID());
                    tvRequestNo.setText("分类:" + resultlistBean.getFL());
                    tvWriteTime.setText("创建人:" + resultlistBean.getENTERBYDESC());
                    tvPhone.setText("联系电话:" + resultlistBean.getPHONE());
                    tvWriteTime.setText("创建时间:" + resultlistBean.getENTERDATE());
                    tvSystemNo.setText("系统编号:" + resultlistBean.getASSETNUM());
                    tvSystemName.setText("系统名称:" + resultlistBean.getNAME());
                    tvModel.setText("型号:" + resultlistBean.getXH());
                    tvBrand.setText("品牌:" + resultlistBean.getPP());
                    tvDutyBy.setText("责任人:" + resultlistBean.getZRR());
                    tvRightDept.setText("产权单位:" + resultlistBean.getCCDW());
                    tvBigType.setText("硬件大类:" + resultlistBean.getHARDWAREDL());
                    tvSmallType.setText("硬件小类:" + resultlistBean.getHARDWAREXL());
                    tvPurchaseDate.setText("采购时间:" + resultlistBean.getCGSJ());
                    tvOwnDept.setText("所属单位:" + resultlistBean.getSSDW());
                    tvLocation.setText("安装地址:" + resultlistBean.getAZDZ());
                    tvCount.setText("数量:" + resultlistBean.getATTR1());
                    tvCountUnit.setText("计量单位:" + resultlistBean.getDW());
                    tvBianhao.setText("编号:" + resultlistBean.getJD_INFORMANAGENUM());
                    tvUsedDept.setText("使用单位:" + resultlistBean.getSYDW());
                    tvWeihuDept.setText("维护单位:" + resultlistBean.getWHDW());
                    tvZhejiu.setText("财务折旧年限:" + resultlistBean.getCWZJNX());
                    tvOriginValue.setText("原值:" + resultlistBean.getNDYWF());
                    tvNote.setText("说明/备注:");

                }

            }


        });

    }

    private void initView() {
        tvCommonTitle.setText("信息化台账增减申请");
    }

    @OnClick({R.id.tv_back, R.id.tv_approval})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_approval:
                if (status.equals("等待批准")) {
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
         *          <max:processname>XXHTZ</max:processname>
         *          <max:mbo>JD_INFORMANAGE</max:mbo>
         *          <max:keyValue>121</max:keyValue>
         *          <max:key>JD_INFORMANAGEID</max:key>
         *          <max:loginid>MAXADMIN</max:loginid>
         *       </max:wfservicestartWF>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>XXHTZ</max:processname>\n" +
                "         <max:mbo>JD_INFORMANAGE</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>JD_INFORMANAGEID</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, JD_INFORMANAGEID, SharedPreferencesUtil.getString(this, "personId"));
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
                            postData.setTag("信息化台账增减申请");
                            EventBus.getDefault().post(postData);
                        }else {

                        }
                        ToastUtils.showShort(startWorkProcessBean.getMsg());
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
         * 			<max:processname>XXHTZ</max:processname>
         * 			<max:mboName>JD_INFORMANAGE</max:mboName>
         * 			<max:keyValue>143</max:keyValue>
         * 			<max:key>JD_INFORMANAGEID</max:key>
         * 			<max:ifAgree>1</max:ifAgree>
         * 			<max:opinion>Ggggggg</max:opinion>
         * 			<max:loginid>MAXADMIN</max:loginid>
         * 		</max:wfservicewfGoOn>
         * 	</soapenv:Body>
         * </soapenv:Envelope>
         */
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "\t<soapenv:Header />\n" +
                "\t<soapenv:Body>\n" +
                "\t\t<max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "\t\t\t<max:processname>XXHTZ</max:processname>\n" +
                "\t\t\t<max:mboName>JD_INFORMANAGE</max:mboName>\n" +
                "\t\t\t<max:keyValue>%s</max:keyValue>\n" +
                "\t\t\t<max:key>JD_INFORMANAGEID</max:key>\n" +
                "\t\t\t<max:ifAgree>%s</max:ifAgree>\n" +
                "\t\t\t<max:opinion>%s</max:opinion>\n" +
                "\t\t\t<max:loginid>%s</max:loginid>\n" +
                "\t\t</max:wfservicewfGoOn>\n" +
                "\t</soapenv:Body>\n" +
                "</soapenv:Envelope>";
        request = String.format(request, JD_INFORMANAGEID, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
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
                    if (ifAgree == 1 ) {
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
