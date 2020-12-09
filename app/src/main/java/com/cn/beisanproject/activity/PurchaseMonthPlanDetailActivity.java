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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.adapter.PurchaseEnquiryAdapter;
import com.cn.beisanproject.adapter.PurchaseMonthPlanLineAdapter;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.ProjectMonthLineBean;
import com.cn.beisanproject.modelbean.PurchaseMonthPlanDetailBean;
import com.cn.beisanproject.modelbean.PurchaseMonthPlanLineBean;
import com.cn.beisanproject.modelbean.PurchaseMonthPlanListBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.WaitDoListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yinglan.keyboard.HideUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

//采购月度计划
public class PurchaseMonthPlanDetailActivity extends AppCompatActivity {
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
    @BindView(R.id.tv_approval)
    TextView tvApproval;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private boolean needGet;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;

    WaitDoListBean.ResultBean.ResultlistBean waitdolistbean;
    PurchaseMonthPlanListBean.ResultBean.ResultlistBean mResultlistBean;
    private LoadingDialog ld;
    String rfqnum;
    String siteid;
    String vendor;
    //    private TextView tv_start;
//    private int isAgree;
    private PopupWindow pop;
    static String PRID;
    private String PRNUM;
    private String[] stringItems1 = new String[]{"启动工作流"};

    private String[] stringItems2 = new String[]{"工作流审批"};
    private int isAgree = 1;
    private String statues;
    private int totalpage;
    private int totalresult;
    PurchaseMonthPlanLineAdapter purchaseMonthPlanLineAdapter;
    private boolean isRefresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_month_plan_detail);
        ButterKnife.bind(this);
        initView();
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            waitdolistbean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            LogUtils.d("OWNERID=" + PRID);
        } else {
            mResultlistBean = (PurchaseMonthPlanListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页列表
            PRNUM = mResultlistBean.getPRNUM();
            siteid = mResultlistBean.getSITEID();
            statues = mResultlistBean.getSTATUS();
            PRID = mResultlistBean.getPRID() + "";
            if (statues.equals("关闭") || statues.equals("已取消") || statues.equals("已关闭") || statues.equals("取消") || statues.equals("已批准")) {
                tvApproval.setVisibility(View.GONE);
            } else {
                if (statues.equals("等待批准")) {
                    tvApproval.setText("启动工作流");
                } else {
                    tvApproval.setText("工作流审批");
                }
            }
        }

        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setNestedScrollingEnabled(false);
        ld = new LoadingDialog(this);
        initEvent();
    }

    private void initEvent() {
        if (needGet) {
            getDetail();
        } else {
            tvPurchaseRequest.setText("采购申请：" + mResultlistBean.getPRNUM());
            tvStatue.setText(mResultlistBean.getSTATUS());
            tvDesc.setText("描述：" + mResultlistBean.getDESCRIPTION());
            tvHuizongStatues.setText("汇总状态：" + mResultlistBean.getR_PRSTATUS());
            tvType.setText("计划类型：" + mResultlistBean.getA_PRTYPE());
            tvHuizongDate.setText("汇总年月：" + mResultlistBean.getA_PRKEY());
            tvSumCost.setText("总成本：" + mResultlistBean.getTOTALCOST());
            tvDept.setText("主管部门：" + mResultlistBean.getA_PURCATALOG());
            tvRequsetDep.setText("申请部门：" + mResultlistBean.getA_DEPT());
            tvRequsetBy.setText("申请人：" + mResultlistBean.getREQUESTEDBY());
            tvRequsetTeam.setText("申请班组：");
            tvGetTime.setText("要求到货时间：" + mResultlistBean.getREQUIREDDATE());
            tvRequestTime.setText("申请时间：" + mResultlistBean.getISSUEDATE());
            getRequestLine();
        }
    }


    private void initView() {
        tvCommonTitle.setText("采购月度计划");
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                getRequestLine();


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                getRequestLine();

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void getDetail() {
        /**
         * {
         *   "objectname" : "PR",
         *   "option" : "read",
         *   "condition" : {
         *     "PRID" : 3013
         *   },
         *   "orderby" : "PRNUM desc",
         *   "curpage" : 0,
         *   "showcount" : 1,
         *   "appid" : "PR"
         * }
         */
        LogUtils.d("getDetail");
        ld.show();
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PR");
        object.put("objectname", "PR");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "PRNUM desc");
        JSONObject conditionObject = new JSONObject();
        conditionObject.put("PRID", waitdolistbean.getOWNERID() + "");
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
                if (!response.isEmpty()) {
                    PurchaseMonthPlanDetailBean purchaseMonthPlanDetailBean = JSONObject.parseObject(response, new TypeReference<PurchaseMonthPlanDetailBean>() {
                    });
                    if (purchaseMonthPlanDetailBean.getErrcode().equals("GLOBAL-S-0")) {
                        PurchaseMonthPlanDetailBean.ResultBean.ResultlistBean resultlistBean = purchaseMonthPlanDetailBean.getResult().getResultlist().get(0);
                        PRNUM = resultlistBean.getPRNUM();
                        PRID = resultlistBean.getPRID() + "";
                        siteid = resultlistBean.getSITEID();
                        statues = resultlistBean.getSTATUS();
                        if (statues.equals("关闭") || statues.equals("已取消") || statues.equals("已关闭") || statues.equals("取消") || statues.equals("已批准")) {
                            tvApproval.setVisibility(View.GONE);
                        } else {
                            if (statues.equals("等待批准")) {
                                tvApproval.setText("启动工作流");
                            } else {
                                tvApproval.setText("工作流审批");
                            }
                        }
                        tvPurchaseRequest.setText("采购申请：" + resultlistBean.getPRNUM());
                        tvStatue.setText(resultlistBean.getSTATUS());
                        tvDesc.setText("描述：" + resultlistBean.getDESCRIPTION());
                        tvHuizongStatues.setText("汇总状态：" + resultlistBean.getR_PRSTATUS());
                        tvType.setText("计划类型：" + resultlistBean.getA_PRTYPE());
                        tvHuizongDate.setText("汇总年月：" + resultlistBean.getA_PRKEY());
                        tvSumCost.setText("总成本：" + resultlistBean.getTOTALCOST());
                        tvDept.setText("主管部门：" + resultlistBean.getA_PURCATALOG());
                        tvRequsetDep.setText("申请部门：" + resultlistBean.getA_DEPT());
                        tvRequsetBy.setText("申请人：" + resultlistBean.getREQUESTEDBY());
                        tvRequsetTeam.setText("申请班组：");
                        tvGetTime.setText("要求到货时间：" + resultlistBean.getREQUIREDDATE());
                        tvRequestTime.setText("申请时间：" + resultlistBean.getISSUEDATE());
                        getRequestLine();
                    }
                }
            }

        });


    }

    private void getRequestLine() {
        /**
         * {
         *   "objectname" : "PRLINE",
         *   "option" : "read",
         *   "orderby" : "",
         *   "curpage" : 1,
         *   "showcount" : 20,
         *   "sqlSearch" : "prnum='WZ00527' and siteid='1000'",
         *   "appid" : "PRLINE"
         * }
         */
        LogUtils.d("getPlanLine==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PRLINE");
        object.put("objectname", "PRLINE");
        object.put("curpage", currentPageNum);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "PRLINENUM ASC");
        object.put("sqlSearch", "prnum='" + PRNUM + "' " + "and siteid='" + siteid + "'");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
                finishRefresh();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                finishRefresh();
                if (!response.isEmpty()) {
                    PurchaseMonthPlanLineBean purchaseMonthPlanLineBean = JSONObject.parseObject(response, new TypeReference<PurchaseMonthPlanLineBean>() {});
                    if (purchaseMonthPlanLineBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<PurchaseMonthPlanLineBean.ResultBean.ResultlistBean> resultlist = purchaseMonthPlanLineBean.getResult().getResultlist();
                        if (resultlist.size() > 0) {
                                totalpage = purchaseMonthPlanLineBean.getResult().getTotalpage();
                                totalresult = purchaseMonthPlanLineBean.getResult().getTotalresult();
                                if (currentPageNum == 1) {
                                    if (purchaseMonthPlanLineAdapter == null) {
                                        purchaseMonthPlanLineAdapter = new PurchaseMonthPlanLineAdapter(PurchaseMonthPlanDetailActivity.this, purchaseMonthPlanLineBean.getResult().getResultlist());
                                        recyclerView.setAdapter(purchaseMonthPlanLineAdapter);
                                    } else {
                                        purchaseMonthPlanLineAdapter.setData(purchaseMonthPlanLineBean.getResult().getResultlist());
                                        purchaseMonthPlanLineAdapter.notifyDataSetChanged();
                                    }

                                } else {
                                    if (currentPageNum<=totalpage){
                                        purchaseMonthPlanLineAdapter.addAllList(purchaseMonthPlanLineBean.getResult().getResultlist());
                                        purchaseMonthPlanLineAdapter.notifyDataSetChanged();
                                    }else {
                                        ToastUtils.showShort("没有更多数据了");
                                    }
                                }


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
                if (statues.equals("等待批准")) {

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
                    if (!statues.equals("部门领导已批准")) {
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
                    } else {

                    }


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
         *          <max:processname>PR</max:processname>
         *          <max:mbo>PR</max:mbo>
         *          <max:keyValue>WZ00526</max:keyValue>
         *          <max:key>PRNUM</max:key>
         *          <max:loginid>maxadmin</max:loginid>
         *       </max:wfservicestartWF>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>PR</max:processname>\n" +
                "         <max:mbo>PR</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>PRNUM</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, PRNUM, SharedPreferencesUtil.getString(this, "personId"));
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
                        PostData data = new PostData();
                        data.setTag("采购月度计划");
                        EventBus.getDefault().post(data);
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


    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) this).getWindow().setAttributes(lp);
    }

    //流程审批
    private void goApproval(int ifAgree, String opinion) {
        /**
         *<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:max="http://www.ibm.com/maximo">
         * 	<soapenv:Header />
         * 	<soapenv:Body>
         * 		<max:wfservicewfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         * 			<max:processname>PR</max:processname>
         * 			<max:mboName>PR</max:mboName>
         * 			<max:keyValue>WZ00532</max:keyValue>
         * 			<max:key>PRNUM</max:key>
         * 			<max:ifAgree>1</max:ifAgree>
         * 			<max:opinion>Hhhhhhh</max:opinion>
         * 			<max:loginid>XIAXF</max:loginid>
         * 		</max:wfservicewfGoOn>
         * 	</soapenv:Body>
         * </soapenv:Envelope>
         */
        if (StringUtils.isEmpty(opinion)) {
            if (ifAgree == 1) {
                opinion = "同意";
            } else {
                opinion = "驳回";
            }
        }
        String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\" >" +
                "<max:processname>PR</max:processname>" +
                "<max:mboName>PR</max:mboName>" +
                "<max:keyValue>%s</max:keyValue>" +
                "<max:key>PRNUM</max:key>" +
                "<max:ifAgree>%s</max:ifAgree>" +
                "<max:opinion>%s</max:opinion>" +
                "<max:loginid>%s</max:loginid>" +
                "</max:wfservicewfGoOn>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
        // ifAgree ：1 同意  2 不同意   opinion：输入内容
        request = String.format(request, PRNUM, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
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
                    PostData postData=new PostData();
                    postData.setTag("采购月度计划");
                    EventBus.getDefault().post(postData);
                    getRequestLine();
                } else {

                }
                ToastUtils.showShort(startWorkProcessBean.getMsg());
            }
        });
    }
    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();

    }
}
