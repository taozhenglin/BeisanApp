package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.SpannableString;
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
import com.cn.beisanproject.adapter.AssertCzDetailLineAdapter;
import com.cn.beisanproject.adapter.AssertJsDetailLineAdapter;
import com.cn.beisanproject.modelbean.AssertCheckCzListBean;
import com.cn.beisanproject.modelbean.AssertCheckJsListBean;
import com.cn.beisanproject.modelbean.AssertCzDetailLineBean;
import com.cn.beisanproject.modelbean.CountEqumentRequestListBean;
import com.cn.beisanproject.modelbean.PostData;
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

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2020/11/3
 */
public class AssertCzDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private AssertCheckCzListBean.ResultBean.ResultlistBean resultlistBean;
    private TextView tv_check_no;
    private TextView tv_check_desc;
    TextView tv_statues;
    private TextView tv_check_by;
    private TextView tv_check_starttime;
    private TextView tv_check_endtime;
    private TextView tv_created_by;
    private TextView tv_created_time;
    TextView tv_owner_companny;
    private LinearLayout ll_assert_container;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private boolean isRefresh = true;
    private AssertCzDetailLineAdapter assertDetailLineAdapter;
    TextView tv_title;
    private TextView tv_approval;
    private LoadingDialog ld;
    private View top_bar;
    private LinearLayout ll_back;
    TextView tv_common_title;
    private String status;
    private boolean needGet;
    private WaitDoListBean.ResultBean.ResultlistBean mWitdolistBean;
    private String[] stringItems1 = new String[]{"启动工作流"};
    private String[] stringItems2 = new String[]{"工作流审批"};
    private PopupWindow pop;
    private int isAgree=1;
    private String FIXEASSETRETNUM;
    String FIXEASSETRETID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assert_detail_fragment);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            mWitdolistBean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
        } else {
            resultlistBean = (AssertCheckCzListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            status = resultlistBean.getSTATUS();
            FIXEASSETRETNUM=resultlistBean.getFIXEASSETRETNUM();
            FIXEASSETRETID=resultlistBean.getFIXEASSETRETID();
        }
        initView();
    }

    private void initView() {
        top_bar = findViewById(R.id.top_bar);
        top_bar.setVisibility(View.VISIBLE);
        ll_back = findViewById(R.id.ll_back);
        ll_back.setOnClickListener(this);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_check_no = findViewById(R.id.tv_check_no);
        tv_check_desc = findViewById(R.id.tv_check_desc);
        tv_check_by = findViewById(R.id.tv_check_by);
        tv_check_starttime = findViewById(R.id.tv_check_starttime);
        tv_check_endtime = findViewById(R.id.tv_check_endtime);
        tv_created_by = findViewById(R.id.tv_created_by);
        tv_created_time = findViewById(R.id.tv_created_time);
        tv_owner_companny= findViewById(R.id.tv_owner_companny);
        tv_statues = findViewById(R.id.tv_statues);
        tv_title = findViewById(R.id.tvtitle);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = findViewById(R.id.refreshLayout);
        tv_title.setText("处置明细行");
        tv_approval = findViewById(R.id.tv_approval);
        tv_approval.setVisibility(View.VISIBLE);
        tv_approval.setOnClickListener(this::onClick);
        ld = new LoadingDialog(this);
        tv_common_title.setText("处置详情");

        if (needGet) {
            getDetail();
        } else {
            tv_check_no.setText("申请单号: " + resultlistBean.getFIXEASSETRETNUM());
            tv_statues.setVisibility(View.VISIBLE);
            tv_statues.setText(resultlistBean.getSTATUS());
            tv_check_desc.setText("描述: " + resultlistBean.getDESCRIPTION());
            tv_check_by.setText("创建人: " + resultlistBean.getENTERBYDESC());
            tv_check_starttime.setText("申请日期: " + resultlistBean.getENTERDATE());
            tv_check_endtime.setText("申请事由: " + resultlistBean.getREASON());
            tv_created_by.setText("管理部门: " + resultlistBean.getMANAGEMENT());
            tv_owner_companny.setText("所属公司:"+resultlistBean.getUDCOMPANY());
            tv_created_time.setVisibility(View.GONE);
            if (status.equals("已取消") || status.equals("取消") || status.equals("已关闭") || status.equals("关闭") || status.equals("已审批")) {
                tv_approval.setVisibility(View.GONE);
            } else {
                if (status.equals("等待核准")) {
                    tv_approval.setText("启动工作流");
                } else {
                    tv_approval.setText("工作流审批");
                }
            }
            getAssertLineDetail();
        }


        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                getAssertLineDetail();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                getAssertLineDetail();
            }
        });
    }
    /**
     * 固定资产处置详情查询
     * --固定资产接收详情查询
     * http://10.169.87.216:7001/mobile/common/api?data=
     * {"appid":"FIXEASSETRET","objectname":"FIXEASSETRET","curpage":1,"showcount":20,"option":"read","orderby":"FIXEASSETRETNUM DESC",
     * "sqlSearch":"FIXEASSETRETNUM = '1070'"}
     */

    private void getDetail() {

        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "FIXEASSETRET");
        object.put("objectname", "FIXEASSETRET");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "FIXEASSETRETNUM DESC");

        object.put("sqlSearch", "FIXEASSETRETID = "+"'"+mWitdolistBean.getOWNERID()+"'");
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
                    AssertCheckCzListBean assertCheckCzListBean= JSONObject.parseObject(response, new TypeReference<AssertCheckCzListBean>() {});
                    if (assertCheckCzListBean.getErrcode().equals("GLOBAL-S-0")) {
                        AssertCheckCzListBean.ResultBean.ResultlistBean resultlistBean = assertCheckCzListBean.getResult().getResultlist().get(0);
                        status = resultlistBean.getSTATUS();
                        FIXEASSETRETNUM=resultlistBean.getFIXEASSETRETNUM();
                        FIXEASSETRETID=resultlistBean.getFIXEASSETRETID();

                        if (status.equals("已取消") || status.equals("取消")||status.equals("已关闭") || status.equals("关闭")|| status.equals("已审批")) {
                            tv_approval.setVisibility(View.GONE);
                        }else {
                            if (status.equals("等待核准")){
                                tv_approval.setText("启动工作流");
                            }else {
                                tv_approval.setText("工作流审批");
                            }
                        }
                        tv_check_no.setText("申请单号: " + resultlistBean.getFIXEASSETRETNUM());
                        tv_statues.setVisibility(View.VISIBLE);
                        tv_statues.setText(resultlistBean.getSTATUS());
                        tv_check_desc.setText("描述: " + resultlistBean.getDESCRIPTION());
                        tv_check_by.setText("创建人: " + resultlistBean.getENTERBY());
                        tv_check_starttime.setText("申请日期: " + resultlistBean.getENTERDATE());
                        tv_check_endtime.setText("申请事由: " + resultlistBean.getREASON());
                        tv_created_by.setText("管理部门: " + resultlistBean.getMANAGEMENT());
                        tv_owner_companny.setText("所属公司："+resultlistBean.getUDCOMPANY());

                        tv_created_time.setVisibility(View.GONE);

                        getAssertLineDetail();
                    }

                }

            }


        });

    }
    /**
     * -- 固定资产处置明细行查询
     * http://192.168.1.180:7009/maximo/mobile/common/api?data=
     * {"appid":"FIXEASSETRETLINE","objectname":"FIXEASSETRETLINE","curpage":1,"showcount":20,"option":"read","orderby":"",
     * "sqlSearch":" ASSETRETNUM=:FIXEASSETRETNUM "}
     */
    public void getAssertLineDetail() {
        ld.show();
        LogUtils.d("getAssertLineDetail");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "FIXEASSETRETLINE");
        object.put("objectname", "FIXEASSETRETLINE");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        LogUtils.d("222222" + FIXEASSETRETNUM);
        object.put("sqlSearch", "ASSETRETNUM=" + FIXEASSETRETNUM);
        //请求头
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure=" + e.toString());
                finishRefresh();
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse=" + response);
                finishRefresh();
                ld.close();
                if (!response.isEmpty()) {
                    AssertCzDetailLineBean assertCzDetailLineBean = JSONObject.parseObject(response, new TypeReference<AssertCzDetailLineBean>() {
                    });
                    if (assertCzDetailLineBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (assertCzDetailLineBean.getResult().getResultlist().size() > 0) {
                            List<AssertCzDetailLineBean.ResultBean.ResultlistBean> resultlist = assertCzDetailLineBean.getResult().getResultlist();
                            int totalPage = assertCzDetailLineBean.getResult().getTotalpage();
                            if (currentPageNum == 1) {
                                if (assertDetailLineAdapter == null) {
                                    assertDetailLineAdapter = new AssertCzDetailLineAdapter(AssertCzDetailActivity.this, resultlist);
                                    recyclerView.setAdapter(assertDetailLineAdapter);
                                } else {
                                    assertDetailLineAdapter.setData(resultlist);
                                    assertDetailLineAdapter.notifyDataSetChanged();
                                }

                            } else {
                                if (currentPageNum <= totalPage) {
                                    assertDetailLineAdapter.addAllList(resultlist);
                                    assertDetailLineAdapter.notifyDataSetChanged();
                                } else {
                                    ToastUtils.showShort("没有更多数据了");
                                }

                            }
                        }

                    }

                }

            }


        });

    }

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_approval:
                if (status.equals("等待核准")) {//启动工作流
                    ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems1, tv_approval);
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

                }else {
                    ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems2, tv_approval);
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
         *          <max:processname>UDFIXBF</max:processname>
         *          <max:mbo>FIXEASSETRET</max:mbo>
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
                "         <max:processname>UDFIXBF</max:processname>\n" +
                "         <max:mbo>FIXEASSETRET</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>FIXEASSETRETID</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, FIXEASSETRETID, SharedPreferencesUtil.getString(this, "personId"));
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
                        StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {});
                        if (startWorkProcessBean.getMsg().equals("流程启动成功！")){
                            status=startWorkProcessBean.getNextStatus();
                            tv_approval.setText("工作流审批");
                            tv_statues.setText(startWorkProcessBean.getNextStatus());
                            PostData postData=new PostData();
                            postData.setTag("固定资产处置");
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

    private void goApproval(int ifAgree, String opinion) {
        ld.show();
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
         * 			<max:processname>UDFIXBF</max:processname>
         * 			<max:mboName>FIXEASSETRET</max:mboName>
         * 			<max:keyValue>102</max:keyValue>
         * 			<max:key>FIXEASSETRETID</max:key>
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
                "\t\t\t<max:processname>UDFIXBF</max:processname>\n" +
                "\t\t\t<max:mboName>FIXEASSETRET</max:mboName>\n" +
                "\t\t\t<max:keyValue>%s</max:keyValue>\n" +
                "\t\t\t<max:key>FIXEASSETRETID</max:key>\n" +
                "\t\t\t<max:ifAgree>%s</max:ifAgree>\n" +
                "\t\t\t<max:opinion>%s</max:opinion>\n" +
                "\t\t\t<max:loginid>%s</max:loginid>\n" +
                "\t\t</max:wfservicewfGoOn>\n" +
                "\t</soapenv:Body>\n" +
                "</soapenv:Envelope>";
        request = String.format(request, FIXEASSETRETID, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
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
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {});
                    if (startWorkProcessBean.getMsg().equals("审批成功")) {
                        status = startWorkProcessBean.getNextStatus();
                        tv_statues.setText(startWorkProcessBean.getNextStatus());
                        PostData postData=new PostData();
                        postData.setTag("固定资产处置");
                        EventBus.getDefault().post(postData);
                    } else {

                    }
                    ToastUtils.showShort(startWorkProcessBean.getMsg());
                }else
                    ToastUtils.showShort(R.string.UNKNOW_ERROR);

            }
        });
    }
}
