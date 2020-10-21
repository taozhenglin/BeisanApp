package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.StockMoveDetailBean;
import com.cn.beisanproject.modelbean.StockMoveLineBean;
import com.cn.beisanproject.modelbean.StockMoveListBean;
import com.cn.beisanproject.modelbean.WaitDoListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.yinglan.keyboard.HideUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class StockMoveDetailActivity extends AppCompatActivity {
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
    @BindView(R.id.tv_huizong_statues)
    TextView tvHuizongStatues;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_huizong_date)
    TextView tvHuizongDate;
    @BindView(R.id.tv_sum_cost)
    TextView tvSumCost;
    @BindView(R.id.tv_dept)
    TextView tvDept;
    @BindView(R.id.tv_requset_dep)
    TextView tvRequsetDep;
    @BindView(R.id.tv_requset_team)
    TextView tvRequsetTeam;
    @BindView(R.id.tv_requset_by)
    TextView tvRequsetBy;
    @BindView(R.id.tv_get_time)
    TextView tvGetTime;
    @BindView(R.id.tv_request_time)
    TextView tvRequestTime;
    @BindView(R.id.ll_request_line)
    LinearLayout llRequestLine;
    @BindView(R.id.sc)
    ScrollView sc;
    @BindView(R.id.tv_approval)
    TextView tvApproval;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private WaitDoListBean.ResultBean.ResultlistBean waitdolistbean;
    private StockMoveListBean.ResultBean.ResultlistBean mResultlistBean;
    private String INVUSENUM;
    private boolean needGet;
    private LoadingDialog ld;
    private String siteid;
    private String statues;
    private PopupWindow pop;
    private int selected=1;
    private String INVUSEID;
    private int isAgree = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_month_plan_detail);
        ButterKnife.bind(this);
        initView();
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            waitdolistbean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            INVUSENUM = waitdolistbean.getOWNERID() + "";
            LogUtils.d("INVUSENUM=" + INVUSENUM);
        } else {
            mResultlistBean = (StockMoveListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页列表
            INVUSENUM = mResultlistBean.getINVUSENUM();
            siteid = mResultlistBean.getSITEID();
            INVUSEID = mResultlistBean.getINVUSEID() + "";
            statues = mResultlistBean.getSTATUS();
            if (statues.equals("关闭") || statues.equals("已取消") || statues.equals("已关闭") || statues.equals("取消")) {
                tvApproval.setVisibility(View.GONE);
            } else {
                if (statues.equals("已输入")) {
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

    private void initView() {
        tvCommonTitle.setText("库存转移");
        tvTitle.setText("库存转移明细行");
    }

    private void initEvent() {
        if (needGet) {
            getDetail();
        } else {
            getDetail();
            tvPurchaseRequest.setText("编号：" + mResultlistBean.getINVUSENUM());
            tvStatue.setText(mResultlistBean.getSTATUS());
            tvDesc.setText("职能部门：" + mResultlistBean.getA_TODEPT());
            tvHuizongStatues.setText("使用方向：" + mResultlistBean.getA_USEFOR());
            tvType.setText("申请人：" + mResultlistBean.getREPORTEDBY());
            tvHuizongDate.setText("申请部门：" + mResultlistBean.getA_DEPT());
            tvSumCost.setVisibility(View.GONE);
            tvDept.setText("申请班组：" + mResultlistBean.getCREWID());
            tvRequsetDep.setText("原库房 ：" + mResultlistBean.getFROMSTORELOC());
            tvRequsetBy.setText("申请日期：" + mResultlistBean.getREPORTDATE());
            tvRequsetTeam.setVisibility(View.GONE);
            tvGetTime.setVisibility(View.GONE);
            tvRequestTime.setVisibility(View.GONE);
            getRequestLine();
        }
    }

    private void getDetail() {
        /**
         * {"appid":"INVUSE","objectname":"INVUSE",
         * "curpage":1,"showcount":20,
         * "option":"read","orderby":"INVUSENUM DESC",
         * "sqlSearch":"INVUSENUM = '1021'"}
         */
        LogUtils.d("getDetail==");
        ld.show();
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "INVUSE");
        object.put("objectname", "INVUSE");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "INVUSENUM desc");
        object.put("sqlSearch", "INVUSENUM = " + "'" + INVUSENUM + "'");
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
                if (!response.isEmpty()) {
                    LogUtils.d("onResponse==" + response);
                    ld.close();
                    StockMoveDetailBean stockMoveDetailBean = JSONObject.parseObject(response, new TypeReference<StockMoveDetailBean>() {
                    });
                    if (stockMoveDetailBean.getErrcode().equals("GLOBAL-S-0")) {
                        StockMoveDetailBean.ResultBean.ResultlistBean resultlistBean = stockMoveDetailBean.getResult().getResultlist().get(0);
                        INVUSENUM = resultlistBean.getINVUSENUM();
                        siteid = resultlistBean.getSITEID();
                        if (statues.equals("关闭") || statues.equals("已取消") || statues.equals("已关闭") || statues.equals("取消")) {
                            tvApproval.setVisibility(View.GONE);
                        } else {
                            if (statues.equals("已输入")) {
                                tvApproval.setText("启动工作流");
                            } else {
                                tvApproval.setText("工作流审批");
                            }
                        }
                        tvPurchaseRequest.setText("编号：" + mResultlistBean.getINVUSENUM());
                        tvStatue.setText(mResultlistBean.getSTATUS());
                        tvDesc.setText("职能部门：" + mResultlistBean.getA_TODEPT());
                        tvHuizongStatues.setText("使用方向：" + mResultlistBean.getA_USEFOR());
                        tvType.setText("申请人：" + mResultlistBean.getREPORTEDBY());
                        tvHuizongDate.setText("申请部门：" + mResultlistBean.getA_DEPT());
                        tvSumCost.setText("申请日期：" + mResultlistBean.getREPORTDATE());
                        tvDept.setText("申请班组：" + mResultlistBean.getCREWID());
                        tvRequsetDep.setText("原库房 ：" + mResultlistBean.getFROMSTORELOC());
                        tvRequsetBy.setVisibility(View.GONE);
                        tvRequsetTeam.setVisibility(View.GONE);
                        tvGetTime.setVisibility(View.GONE);
                        tvRequestTime.setVisibility(View.GONE);
                        getRequestLine();
                    }
                }
            }

        });
    }

    private void getRequestLine() {
        /**
         * {"appid":"INVUSELINE","objectname":"INVUSELINE",
         * "curpage":1,"showcount":20,"option":"read",
         * "orderby":"INVUSELINENUM ASC",
         * "sqlSearch":" INVUSENUM=:INVUSENUM and siteid = :siteid "}
         */
        LogUtils.d("getPlanLine==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "INVUSELINE");
        object.put("objectname", "INVUSELINE");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "INVUSELINENUM ASC");
        object.put("sqlSearch", "INVUSENUM='" + INVUSENUM + "' " + "and siteid='" + siteid + "'");
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
                ProjectMonthLineBean projectMonthLineBean;
                if (!response.isEmpty()) {
                    StockMoveLineBean stockMoveLineBean = JSONObject.parseObject(response, new TypeReference<StockMoveLineBean>() {
                    });
//
                    if (stockMoveLineBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<StockMoveLineBean.ResultBean.ResultlistBean> resultlist = stockMoveLineBean.getResult().getResultlist();
                        llRequestLine.removeAllViews();
                        for (int i = 0; i < resultlist.size(); i++) {
                            View inflate = LayoutInflater.from(StockMoveDetailActivity.this).inflate(R.layout.stock_move_line_item, llRequestLine, false);
                            TextView tv_no = inflate.findViewById(R.id.tv_no);
                            TextView tv_use_statue = inflate.findViewById(R.id.tv_use_statue);
                            TextView tv_line_type = inflate.findViewById(R.id.tv_line_type);
                            TextView tv_count = inflate.findViewById(R.id.tv_count);
                            TextView tv_desc = inflate.findViewById(R.id.tv_desc);
                            TextView tv_ori_store = inflate.findViewById(R.id.tv_ori_store);
                            TextView tv_ori_num = inflate.findViewById(R.id.tv_ori_num);
                            TextView tv_target_store = inflate.findViewById(R.id.tv_target_store);
                            TextView tv_target_draw = inflate.findViewById(R.id.tv_target_draw);
                            TextView tv_target_num = inflate.findViewById(R.id.tv_target_num);

                            tv_no.setText("物资编码：" + resultlist.get(i).getITEMNUM());
                            tv_use_statue.setText("使用情况类型：" + resultlist.get(i).getUSETYPE());
                            tv_line_type.setText("行类型：" + resultlist.get(i).getLINETYPE());
                            tv_count.setText("数量：" + resultlist.get(i).getQUANTITY());
                            tv_desc.setText("物资描述：" + resultlist.get(i).getDESCRIPTION());
                            tv_ori_store.setText("原货柜：" + resultlist.get(i).getFROMBIN());
                            tv_ori_num.setText("原批次：" + resultlist.get(i).getFROMLOT());
                            tv_target_store.setText("目标库房：" + resultlist.get(i).getTOSTORELOC());
                            tv_target_draw.setText("目标货柜：" + resultlist.get(i).getTOBIN());
                            tv_target_num.setText("目标批次：" + resultlist.get(i).getTOLOT());


                            llRequestLine.addView(inflate);

                        }


                    }

                }

            }


        });
    }

    @OnClick({R.id.ll_back, R.id.tv_approval})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_approval:
                if (statues.equals("已输入")) {
                    showRemarkPopupwindow1();//启动工作流
                } else {
                    if (statues.equals("成本控制主管审批")) {
                        showRemarkPopupwindow2();
                    } else {
                        showRemarkPopupwindow3();
                    }
                }
                break;
        }
    }

    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow1() {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.dialog_for_material, null);
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
        TextView finish_tv = (TextView) remarkView.findViewById(R.id.finish_tv);
        TextView cancel_tv = (TextView) remarkView.findViewById(R.id.cancel_tv);
        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
        ImageView iv_close = (ImageView) remarkView.findViewById(R.id.iv_close);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });
        ImageView iv_agree = (ImageView) remarkView.findViewById(R.id.iv_agree);
        iv_agree.setBackgroundResource(R.drawable.selected);
        ImageView iv_disagree = (ImageView) remarkView.findViewById(R.id.iv_disagree);
        iv_disagree.setBackgroundResource(R.drawable.unselected);
        iv_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_agree.setBackgroundResource(R.drawable.selected);
                iv_disagree.setBackgroundResource(R.drawable.unselected);
                selected = 1;
                LogUtils.d("常规==");
            }
        });
        iv_disagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_disagree.setBackgroundResource(R.drawable.selected);
                iv_agree.setBackgroundResource(R.drawable.unselected);
                selected = 2;
                LogUtils.d("特殊==");
            }
        });
        finish_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWork(selected);
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

    /**
     * 成本控制主管审批 状态的弹窗
     */
    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow2() {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.dialog_for_material, null);
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
        TextView finish_tv = (TextView) remarkView.findViewById(R.id.finish_tv);
        TextView cancel_tv = (TextView) remarkView.findViewById(R.id.cancel_tv);
        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
        title_tv.setText("完成工作流任务分配");
        TextView tv_text1 = (TextView) remarkView.findViewById(R.id.tv_text1);
        TextView tv_text2 = (TextView) remarkView.findViewById(R.id.tv_text2);
        tv_text1.setText("批准领料单，请保管员确认");
        tv_text2.setText("工程部主任工程师审批");
        EditText input_et = (EditText) remarkView.findViewById(R.id.input_et);
        input_et.setVisibility(View.VISIBLE);
        input_et.setHint("批准领料单，请保管员确认");
        ImageView iv_close = (ImageView) remarkView.findViewById(R.id.iv_close);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });
        ImageView iv_agree = (ImageView) remarkView.findViewById(R.id.iv_agree);
        iv_agree.setBackgroundResource(R.drawable.selected);
        ImageView iv_disagree = (ImageView) remarkView.findViewById(R.id.iv_disagree);
        iv_disagree.setBackgroundResource(R.drawable.unselected);
        iv_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_agree.setBackgroundResource(R.drawable.selected);
                iv_disagree.setBackgroundResource(R.drawable.unselected);
                selected = 1;
                input_et.setHint("批准领料单，请保管员确认");
                LogUtils.d("批准领料单，请保管员确认==");
            }
        });
        iv_disagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_disagree.setBackgroundResource(R.drawable.selected);
                iv_agree.setBackgroundResource(R.drawable.unselected);
                selected = 2;
                input_et.setHint("工程部主任工程师审批");
                LogUtils.d("工程部主任工程师审批==");
            }
        });
        finish_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = input_et.getText().toString().trim();
                goAproval(selected, txt);
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

    /**
     * 除 成本控制主管审批 状态外的弹窗
     */
    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow3() {
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
                goAproval(isAgree, txt);
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

    private void goAproval(int selected, String opinion) {
        ld.show();
        /**
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfservicewfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:processname>INVUSEZY</max:processname>
         *          <max:mboName>INVUSE</max:mboName>
         *          <max:keyValue>62719</max:keyValue>
         *          <max:key>INVUSEID</max:key>
         *          <max:ifAgree>1</max:ifAgree>
         *          <max:opinion>同意</max:opinion>
         *          <max:loginid>JIAWF</max:loginid>
         *       </max:wfservicewfGoOn>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>INVUSEZY</max:processname>\n" +
                "         <max:mboName>INVUSE</max:mboName>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>INVUSEID</max:key>\n" +
                "         <max:ifAgree>%s</max:ifAgree>\n" +
                "         <max:opinion>%s</max:opinion>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicewfGoOn>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        // ifAgree ：1 同意  2 不同意   opinion：输入内容
        // ifAgree ：1 批准领料单，请保管员确认  2 工程部主任工程师审批   opinion：输入内容
        request = String.format(request, INVUSEID, selected, opinion, SharedPreferencesUtil.getString(this, "personId"));
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
                if (response.contains("<return>")&&response.contains("/<return>")) {
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                    });
                    if (startWorkProcessBean.getMsg().equals("审批成功")) {
                        statues = startWorkProcessBean.getNextStatus();
                        tvStatue.setText(startWorkProcessBean.getNextStatus());
                        startWorkProcessBean.setTag("库存转移");//领料单列表刷新
                        EventBus.getDefault().post(startWorkProcessBean);
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

    private void startWork(int selected) {
        ld.show();
/**
 * <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
 * 	<soap:Header />
 * 	<soap:Body>
 * 		<wfservicestartWF2 xmlns="http://www.ibm.com/maximo">
 * 			<processname>MATREQ</processname>
 * 			<mbo>WORKORDER</mbo>
 * 			<keyValue>41696</keyValue>
 * 			<key>WONUM</key>
 * 			<nodenum>1</nodenum>
 * 			<loginid>SHENKK</loginid>
 * 		</wfservicestartWF2>
 * 	</soap:Body>
 * </soap:Envelope>
 */
        String request = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "\t<soap:Header />\n" +
                "\t<soap:Body>\n" +
                "\t\t<wfservicestartWF2 xmlns=\"http://www.ibm.com/maximo\">\n" +
                "\t\t\t<processname>INVUSEZY</processname>\n" +
                "\t\t\t<mbo>INVUSE</mbo>\n" +
                "\t\t\t<keyValue>%s</keyValue>\n" +
                "\t\t\t<key>INVUSENUM</key>\n" +
                "\t\t\t<nodenum>%s</nodenum>\n" +
                "\t\t\t<loginid>%s</loginid>\n" +
                "\t\t</wfservicestartWF2>\n" +
                "\t</soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, INVUSENUM, selected, SharedPreferencesUtil.getString(this, "personId"));
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
                    if (startWorkProcessBean.getMsg().equals("流程启动成功！")) {
                        tvApproval.setText("工作流审批");
                        statues = startWorkProcessBean.getNextStatus();
                        tvStatue.setText(startWorkProcessBean.getNextStatus());
                        PostData postData=new PostData();
                        postData.setTag("库存转移");//库存转移列表刷新
                        EventBus.getDefault().post(postData);
                    }
                    ToastUtils.showShort(startWorkProcessBean.getMsg());
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
