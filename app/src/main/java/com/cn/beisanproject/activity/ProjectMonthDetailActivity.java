package com.cn.beisanproject.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.DownloadUtil;
import com.cn.beisanproject.Utils.HighLightUtils;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.OpenFileUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.modelbean.CommonAttachBean;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.ProjectMonthAttachBean;
import com.cn.beisanproject.modelbean.ProjectMonthLineBean;
import com.cn.beisanproject.modelbean.ProjectMonthListBean;
import com.cn.beisanproject.modelbean.PurchseAttachBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.WaitDoListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.yinglan.keyboard.HideUtil;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 项目立项/月度计划 详情页面
 */
public class ProjectMonthDetailActivity extends AppCompatActivity {
    String OWNERID;
    ProjectMonthListBean.ResultBean.ResultlistBean mResultlistBean;
    WaitDoListBean.ResultBean.ResultlistBean mWitdolistBean;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    @BindView(R.id.tv_common_title)
    TextView tvCommonTitle;
    @BindView(R.id.iv_fun)
    ImageView ivFun;
    @BindView(R.id.tv_project_request)
    TextView tvProjectRequest;
    @BindView(R.id.tv_statue)
    TextView tvStatue;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_categroy)
    TextView tvCategroy;
    @BindView(R.id.tv_yusuan_no)
    TextView tvYusuanNo;
    @BindView(R.id.tv_yusuan_ndesc)
    TextView tvYusuanNdesc;
    @BindView(R.id.tv_huizong_date)
    TextView tvHuizongDate;
    @BindView(R.id.tv_sum_amount)
    TextView tvSumAmount;
    @BindView(R.id.tv_dept)
    TextView tvDept;
    @BindView(R.id.tv_requset_dep)
    TextView tvRequsetDep;
    @BindView(R.id.tv_requset_team)
    TextView tvRequsetTeam;
    @BindView(R.id.tv_requset_type)
    TextView tvRequsetType;
    @BindView(R.id.tv_owner_companny)
    TextView tvOwnerCompanny;
    @BindView(R.id.tv_plan_type)
    TextView tvPlanType;
    @BindView(R.id.tv_has_checked)
    TextView tvHasChecked;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.tv_plan_start)
    TextView tvPlanStart;
    @BindView(R.id.tv_plan_end)
    TextView tvPlanEnd;
    @BindView(R.id.tv_created_by)
    TextView tvCreatedBy;
    @BindView(R.id.tv_created_time)
    TextView tvCreatedTime;
    @BindView(R.id.ll_plan_line)
    LinearLayout llPlanLine;
    @BindView(R.id.ll_attach)
    LinearLayout llAttach;
    @BindView(R.id.tv_approval)
    TextView tvApproval;
    private boolean needGet;
    private String prnum;
    private String siteid;
    String company;
    String orgid;
    String contractnum;
    String revisionnum = "0";
    String status;
    private LoadingDialog ld;
    private String[] stringItems1 = new String[]{"启动工作流"};
    private String[] stringItems2 = new String[]{"工作流审批"};
    private PopupWindow pop;
    int isAgree = 1;
    private StartWorkProcessBean startWorkProcessBean;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_month_detail_activity);
        ButterKnife.bind(this);
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            mWitdolistBean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            OWNERID = mWitdolistBean.getOWNERID() + "";

            LogUtils.d("OWNERID=" + OWNERID);
        } else {
            mResultlistBean = (ProjectMonthListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页 项目立项/项目月度计划
            company = mResultlistBean.getA_COMPANY();
            orgid = mResultlistBean.getORGID();
            contractnum = mResultlistBean.getCONTRACTREFNUM();
            OWNERID = mResultlistBean.getPRID() + "";
            prnum = mResultlistBean.getPRNUM();
            siteid = mResultlistBean.getSITEID();
            status = mResultlistBean.getSTATUS();
            if ( status.equals("已取消")||status.equals("取消")||status.equals("关闭")||status.equals("已关闭")) {
                tvApproval.setVisibility(View.GONE);
            } else {
                if (status.equals("等待批准")) {
                    tvApproval.setText("启动工作流");
                } else {
                    tvApproval.setText("流程审批");

                }
            }

        }
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ld = new LoadingDialog(this);
        initView();
        initEvent();

    }

    private void initEvent() {
        if (needGet) {
            //网络请求
            getDetail();
        } else {
            //直接赋值
            tvProjectRequest.setText("项目立项:" + mResultlistBean.getPRNUM());
            tvStatue.setText(mResultlistBean.getSTATUS());
            tvDesc.setText("描述:" + mResultlistBean.getDESCRIPTION());
            tvType.setText("立项类型:" + mResultlistBean.getLXLX());
            tvCategroy.setText("类别:" + mResultlistBean.getXMLB());
            tvYusuanNo.setText("预算编号:" + mResultlistBean.getA_BUDGETNUM());
            tvYusuanNdesc.setText("预算描述:" + mResultlistBean.getA_BUDGETDESC());
            tvHuizongDate.setText("汇总年月:" + mResultlistBean.getA_PRKEY());
            tvSumAmount.setText("总金额:" + mResultlistBean.getTOTALCOST());
            tvDept.setText("主管部门:" + mResultlistBean.getA_DEPT());
            tvRequsetDep.setText("申请部门:" + mResultlistBean.getA_PURCATALOG());
            tvRequsetTeam.setText("申请班组:");
            tvRequsetType.setText("申请类型:" + mResultlistBean.getA_PURTYPE());
            tvOwnerCompanny.setText("所属公司:" + mResultlistBean.getA_COMPANY());
            tvPlanType.setText("计划类型:" + mResultlistBean.getA_PRTYPE());
            tvHasChecked.setText("是否已验收:" + mResultlistBean.getA_TOSUM());
            tvNote.setText("备注:" + mResultlistBean.getMEMO());
            tvPlanStart.setText("计划开始时间:" + mResultlistBean.getCHANGEDATE());
            tvPlanEnd.setText("计划结束时间:");
            tvCreatedBy.setText("创建人:" + mResultlistBean.getR_DEPTDESC());
            tvCreatedTime.setText("创建时间:" + mResultlistBean.getISSUEDATE());
            getPlanLine();
            getAttachMent();
        }


    }

    private void getAttachMent() {
        ld.show();
        /**
         * {
         *   "objectname" : "DOCLINKS",
         *   "option" : "read",
         *   "orderby" : "CREATEDATE DESC",
         *   "curpage" : 1,
         *   "showcount" : 20,
         *   "sqlSearch" : "(ownertable='PR' and ownerid='(null)')
         *   or (ownertable = 'COMPANIES' and ownerid = (select companiesid from companies where company='(null)' and orgid='(null)'))
         *   or (ownertable = 'CONTRACT' and ownerid = (select contractid from contract where contractnum=:contractrefnum and revisionnum='(null)' and orgid='(null)'))
         *   or (ownertable = 'MRLINE' and ownerid in (select mrlineid from mrline where mrnum in (select mrnum from prline where prnum='(null)' and siteid='(null)')))",
         *   "appid" : "DOCLINKS"
         * }
         */
        LogUtils.d("getAttachMent==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "DOCLINKS");
        object.put("objectname", "DOCLINKS");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "CREATEDATE DESC");

        String sqlSearch = "(ownertable='PR' and ownerid=%s) " +
                "or (ownertable = 'COMPANIES' and ownerid = (select companiesid from companies where company=%s and orgid=%s)) " +
                "or (ownertable = 'CONTRACT' and ownerid = (select contractid from contract where contractnum= %s and revisionnum=%s and orgid=%s)) " +
                "or (ownertable = 'MRLINE' and ownerid in (select mrlineid from mrline where mrnum in (select mrnum from prline where prnum=%s and siteid=%s)))";
        sqlSearch = String.format(sqlSearch, "'" + OWNERID + "'", "'" + company + "'", "'" + orgid + "'", "'" + contractnum + "'", "'" + revisionnum + "'", "'" + orgid + "'", "'" + prnum + "'", "'" + siteid + "'");
        object.put("sqlSearch", sqlSearch);
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
                PurchseAttachBean attachBean;
                if (!response.isEmpty()) {
                    attachBean = JSONObject.parseObject(response, new TypeReference<PurchseAttachBean>() {
                    });
                    if (attachBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<PurchseAttachBean.ResultBean.ResultlistBean> resultlist = attachBean.getResult().getResultlist();
                        llAttach.removeAllViews();
                        if (resultlist.size() > 0) {
                            for (int i = 0; i < resultlist.size(); i++) {
                                View inflate = LayoutInflater.from(ProjectMonthDetailActivity.this).inflate(R.layout.contract_detail_attach, null, false);
                                TextView tv_attach_no = inflate.findViewById(R.id.tv_attach_no);
                                TextView tv_attach_desc = inflate.findViewById(R.id.tv_attach_desc);
                                TextView tv_upload_time = inflate.findViewById(R.id.tv_upload_time);
                                tv_attach_no.setText("附件编号:" + resultlist.get(i).getDOCLINKSID());
                                tv_attach_desc.setText(HighLightUtils.highlight(ProjectMonthDetailActivity.this, "附件描述:" + resultlist.get(i).getDOCDESC(), resultlist.get(i).getDOCDESC(), "#1B88EE", 0, 0));
                                tv_upload_time.setText("上传日期:" + resultlist.get(i).getCREATEDATE());
                                int finalI = i;
                                inflate.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        if (!StringUtils.isEmpty(SharedPreferencesUtil.getString(ProjectMonthDetailActivity.this, resultlist.get(finalI).getDOCUMENT()))) {
                                            String savePath = SharedPreferencesUtil.getString(ProjectMonthDetailActivity.this, resultlist.get(finalI).getDOCUMENT());
                                            LogUtils.d("222222 sp savePath=" + savePath);
                                            File file = new File(savePath);
                                            try {
                                                LogUtils.d("222222 打开");
                                                OpenFileUtils.openFile(ProjectMonthDetailActivity.this, file);
                                            } catch (Exception e) {
                                                LogUtils.d("222222 无打开方式" + e.toString());

                                                e.printStackTrace();
                                            }
                                        } else {
                                            SharedPreferencesUtil.setString(ProjectMonthDetailActivity.this, "current_documentid", resultlist.get(finalI).getDOCUMENT());
                                            showConfirmWindow(resultlist.get(finalI).getDOCUMENT());

                                        }

                                    }
                                });
                                llAttach.addView(inflate);
                            }
                        }


                    }

                }
            }
        });

    }

    private void showConfirmWindow(String documentId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("确定下载并查看？");
        builder.setPositiveButton("确定下载", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                checkNeedPermissions();
//                getUrl(documentId);
                dialogInterface.dismiss();

            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void getUrl(String documentId) {
        /**
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:mobileservicedockAdress creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:document>6753</max:document>
         *       </max:mobileservicedockAdress>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:mobileservicedockAdress creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:document>%s</max:document>\n" +
                "      </max:mobileservicedockAdress>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, documentId);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");
        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP2, request, headermap, new CallBackUtil.CallBackString() {

            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure" + e.toString());
                ToastUtils.showShort(R.string.upLoadfailed);
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse222222" + response);
                if (response.contains("<return>") && response.contains("</return>")) {
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    CommonAttachBean commonAttachBean = JSONObject.parseObject(substring, new TypeReference<CommonAttachBean>() {
                    });
                    if (commonAttachBean.getCode().equals("成功")) {
                        if (!StringUtils.isEmpty(commonAttachBean.getUrlnew())) {
                            LogUtils.d("url==" + commonAttachBean.getUrlnew());
                            String url = commonAttachBean.getUrlnew();
                            // http://192.168.1.180:7009/doclinks/attachments/测试.xls
                            int urlstart = url.lastIndexOf("/");
                            int urlend = url.length();
                            String filename = url.substring(urlstart + 1);
                            LogUtils.d("filename222222" + filename);
                            downLoad(ProjectMonthDetailActivity.this, url, filename, documentId);
                        }
                    } else {
                        ToastUtils.showShort(commonAttachBean.getErrorMsg());
                    }

                }
            }
        });

    }

    private void downLoad(Context mContext, String downloadUrl, String filename, String documentId) {
//配置progressDialog
        final ProgressDialog dialog = new ProgressDialog(ProjectMonthDetailActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        dialog.setTitle("正在下载中");
        dialog.setMessage("请稍后...");
        dialog.setProgress(0);
        dialog.setMax(100);
        dialog.show();
        DownloadUtil.get().download(mContext, downloadUrl, "/download/", filename, new DownloadUtil.OnDownloadListener() {
            @Override
            public void onDownloadSuccess() {
                LogUtils.d("222222  onDownloadSuccess");
                dialog.dismiss();
                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    LogUtils.d("222222  没有内存卡");
                    return;
                }
                File file = new File(Environment.getExternalStorageDirectory().getPath() + "/download/" + filename);
                LogUtils.d("222222 sp downloadUrl=" + downloadUrl);
                LogUtils.d("222222 sp savepath=" + file.getAbsolutePath());
                SharedPreferencesUtil.setString(mContext, documentId, file.getAbsolutePath());
                try {
                    LogUtils.d("222222 打开");
                    OpenFileUtils.openFile(mContext, file);
                } catch (Exception e) {
                    LogUtils.d("222222 无打开方式" + e.toString());

                    e.printStackTrace();
                }

            }

            @Override
            public void onDownloading(int progress) {
                LogUtils.d("222222  onDownloading" + progress);
                dialog.setProgress(progress);
            }

            @Override
            public void onDownloadFailed() {
                LogUtils.d("222222  onDownloadFailed");
                dialog.dismiss();
            }
        });
    }

    private void getPlanLine() {
        /**  获取明细行
         * {
         *   "objectname" : "PRLINE",
         *   "option" : "read",
         *   "orderby" : "PRLINENUM ASC",
         *   "curpage" : 1,
         *   "showcount" : 20,
         *   "sqlSearch" : "prnum='PROJ00187' and siteid='1000'",
         *   "appid" : "PRLINE"
         * }
         */
        LogUtils.d("getPlanLine==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PRLINE");
        object.put("objectname", "PRLINE");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "PRLINENUM ASC");
        object.put("sqlSearch", "prnum='" + prnum + "' " + "and siteid='" + siteid + "'");
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
                    projectMonthLineBean = JSONObject.parseObject(response, new TypeReference<ProjectMonthLineBean>() {
                    });

                    if (projectMonthLineBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<ProjectMonthLineBean.ResultBean.ResultlistBean> resultlist = projectMonthLineBean.getResult().getResultlist();
                        llPlanLine.removeAllViews();
                        for (int i = 0; i < resultlist.size(); i++) {
                            View inflate = LayoutInflater.from(ProjectMonthDetailActivity.this).inflate(R.layout.project_month_line_item, llPlanLine, false);
                            TextView tv_line_no = inflate.findViewById(R.id.tv_line_no);
                            TextView tv_line_desc = inflate.findViewById(R.id.tv_line_desc);
                            TextView tv_yusuan_no = inflate.findViewById(R.id.tv_yusuan_no);
                            TextView tv_xunjiadan = inflate.findViewById(R.id.tv_xunjiadan);
                            TextView tv_yusuan_desc = inflate.findViewById(R.id.tv_yusuan_desc);
                            TextView tv_count = inflate.findViewById(R.id.tv_count);
                            TextView tv_unit = inflate.findViewById(R.id.tv_unit);
                            TextView tv_unit_cost = inflate.findViewById(R.id.tv_unit_cost);
                            TextView tv_line_cost = inflate.findViewById(R.id.tv_line_cost);

                            tv_line_no.setText("计划行:" + resultlist.get(i).getPRLINENUM());
                            tv_line_desc.setText("行描述:" + resultlist.get(i).getDESCRIPTION());
                            tv_yusuan_no.setText("子集预算编号:" + resultlist.get(i).getA_BUDGETNUM());
                            tv_xunjiadan.setText("询价单:" + resultlist.get(i).getITEMNUM());
                            tv_yusuan_desc.setText("子集预算描述:" + resultlist.get(i).getA_BUDGETDESC());
                            tv_count.setText("数量:" + resultlist.get(i).getORDERQTY());
                            tv_unit.setText("订购单位:" + resultlist.get(i).getORDERUNIT());
                            tv_unit_cost.setText("单位成本:" + resultlist.get(i).getUNITCOST());
                            tv_line_cost.setText("行成本:" + resultlist.get(i).getLINECOST());

                            llPlanLine.addView(inflate);

                        }


                    }

                }

            }


        });

    }


    private void getDetail() {
        /**  获取详情
         * {
         *   "objectname" : "PR",
         *   "option" : "read",
         *   "condition" : {
         *     "PRID" : 3081
         *   },
         *   "orderby" : "PRNUM desc",
         *   "curpage" : 0,
         *   "showcount" : 1,
         *   "appid" : "PR"
         * }
         */
        ld.show();
        LogUtils.d("getDetail");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PR");
        object.put("objectname", "PR");
        object.put("curpage", 0);
        object.put("showcount", 1);
        object.put("option", "read");
        object.put("orderby", "PRNUM desc");
        JSONObject conditionObject = new JSONObject();
        conditionObject.put("PRID", OWNERID);
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
                LogUtils.d("onResponse=" + response);
                ld.close();
                ProjectMonthListBean projectMonthListBean;
                if (!response.isEmpty()) {
                    projectMonthListBean = JSONObject.parseObject(response, new TypeReference<ProjectMonthListBean>() {
                    });

                    if (projectMonthListBean.getErrcode().equals("GLOBAL-S-0")) {
                        ProjectMonthListBean.ResultBean.ResultlistBean resultlistBean = projectMonthListBean.getResult().getResultlist().get(0);
                        tvProjectRequest.setText("项目立项:" + resultlistBean.getPRNUM());

                        prnum = resultlistBean.getPRNUM();
                        siteid = resultlistBean.getSITEID();
                        company = resultlistBean.getA_COMPANY();
                        orgid = resultlistBean.getORGID();
                        contractnum = resultlistBean.getCONTRACTREFNUM();
                        status = resultlistBean.getSTATUS();
                        if (status.equals("已批准") || status.equals("已取消")) {
                            tvApproval.setVisibility(View.GONE);
                        }
                        if (status.equals("等待批准")) {
                            tvApproval.setText("启动工作流");
                        }
                        if (!status.equals("等待批准") && !status.equals("已批准") && !status.equals("已取消")) {
                            tvApproval.setText("流程审批");
                        }
                        tvStatue.setText(resultlistBean.getSTATUS());
                        tvDesc.setText("描述:" + resultlistBean.getDESCRIPTION());
                        tvType.setText("立项类型:" + resultlistBean.getLXLX());
                        tvCategroy.setText("类别:" + resultlistBean.getXMLB());
                        tvYusuanNo.setText("预算编号:" + resultlistBean.getA_BUDGETNUM());
                        tvYusuanNdesc.setText("预算描述:" + resultlistBean.getA_BUDGETDESC());
                        tvHuizongDate.setText("汇总年月:" + resultlistBean.getA_PRKEY());
                        tvSumAmount.setText("总金额:" + resultlistBean.getTOTALCOST());
                        tvDept.setText("主管部门:" + resultlistBean.getA_DEPT());
                        tvRequsetDep.setText("申请部门:" + resultlistBean.getA_PURCATALOG());
                        tvRequsetTeam.setText("申请班组:");
                        tvRequsetType.setText("申请类型:" + resultlistBean.getA_PURTYPE());
                        tvOwnerCompanny.setText("所属公司:" + resultlistBean.getA_COMPANY());
                        tvPlanType.setText("计划类型:" + resultlistBean.getA_PRTYPE());
                        tvHasChecked.setText("是否已验收:" + resultlistBean.getA_TOSUM());
                        tvNote.setText("备注" + resultlistBean.getMEMO());
                        tvPlanStart.setText("计划开始时间:" + resultlistBean.getCHANGEDATE());
                        tvPlanEnd.setText("计划结束时间:");
                        tvCreatedBy.setText("创建人:" + resultlistBean.getR_DEPTDESC());
                        tvCreatedTime.setText("创建时间:" + resultlistBean.getISSUEDATE());
                        getPlanLine();
                        getAttachMent();
                    }

                }

            }


        });
    }

    private void initView() {
        tvCommonTitle.setText("项目立项/项目月度计划");

    }


    @OnClick({R.id.ll_back, R.id.tv_approval})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_approval://
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
                                case 0://拍照
                                    startWork();
                                    dialog.dismiss();
                                    break;
                                case 1:
                                    break;
                            }
                        }
                    });

                } else {//审批
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
                                case 0://拍照
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

    private void startWork() {
        ld.show();
/**
 * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
 *    <soap:Header/>
 *    <soap:Body>
 *       <max:wfservicestartWF creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
 *          <max:processname>PRPROJ</max:processname>
 *          <max:mbo>PR</max:mbo>
 *          <max:keyValue>PROJ00179</max:keyValue>
 *          <max:key>PRNUM</max:key>
 *          <max:loginid>MAXADMIN</max:loginid>
 *       </max:wfservicestartWF>
 *    </soap:Body>
 * </soap:Envelope>
 */
        String request = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>PRPROJ</max:processname>\n" +
                "         <max:mbo>PR</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>PRNUM</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, prnum, SharedPreferencesUtil.getString(this, "personId"));
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
                        startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                        });
                        if (startWorkProcessBean.getMsg().equals("流程启动成功！")) {
                            status = startWorkProcessBean.getNextStatus();
                            tvStatue.setText(startWorkProcessBean.getNextStatus());
                            tvApproval.setText("工作流审批");
                            PostData postData=new PostData();
                            postData.setTag("项目立项/项目月度计划");
                            EventBus.getDefault().post(postData);
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
        if (StringUtils.isEmpty(opinion)){
            if (ifAgree==1){
                opinion="同意";
            }else {
                opinion="驳回";
            }
        }

        ld.show();
/**
 * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:max="http://www.ibm.com/maximo">
 * 	<soapenv:Header />
 * 	<soapenv:Body>
 * 		<max:wfservicewfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
 * 			<max:processname>PRPROJ</max:processname>
 * 			<max:mboName>PR</max:mboName>
 * 			<max:keyValue>PROJ00185</max:keyValue>
 * 			<max:key>PRNUM</max:key>
 * 			<max:ifAgree>1</max:ifAgree>
 * 			<max:opinion>Bbbbbbbhbbh</max:opinion>
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
                "<max:processname>PRPROJ</max:processname>" +
                "<max:mboName>PR</max:mboName>" +
                "<max:keyValue>%s</max:keyValue>" +
                "<max:key>PRNUM</max:key>" +
                "<max:ifAgree>%s</max:ifAgree>" +
                "<max:opinion>%s</max:opinion>" +
                "<max:loginid>%s</max:loginid>" +
                "</max:wfservicewfGoOn>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
        // ifAgree :1 同意  2 不同意   opinion:输入内容
        request = String.format(request, prnum, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
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
                if (response.contains("<return>")&&response.contains("<return>")){
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                    });
                    if (startWorkProcessBean.getMsg().equals("审批成功")) {
                        status = startWorkProcessBean.getNextStatus();
                        tvStatue.setText(startWorkProcessBean.getNextStatus());
                        getAttachMent();
                        getPlanLine();
                    } else {

                    }
                    ToastUtils.showShort(startWorkProcessBean.getMsg());

                }else
                    ToastUtils.showShort(R.string.UNKNOW_ERROR);


            }
        });


    }

    private void checkNeedPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //多个权限一起申请
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, 1);
        }else {
            String current_documentid=SharedPreferencesUtil.getString(ProjectMonthDetailActivity.this,"current_documentid");
            getUrl(current_documentid);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            boolean hasAllPermission=true;
            for (int grantResult:grantResults) {
                if (grantResult!=PackageManager.PERMISSION_GRANTED){
                    hasAllPermission=false;
                }
            }
            if (hasAllPermission) {
                String current_documentid = SharedPreferencesUtil.getString(this, "current_documentid");
                getUrl(current_documentid);
            }else {
                ToastUtils.showShort("无读取存储权限");

            }

        }
    }
}
