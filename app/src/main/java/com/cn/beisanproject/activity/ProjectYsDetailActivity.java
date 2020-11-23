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
import com.cn.beisanproject.modelbean.AssertCheckJsListBean;
import com.cn.beisanproject.modelbean.CommonAttachBean;
import com.cn.beisanproject.modelbean.CountEqumentRequestListBean;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.ProjectMonthListBean;
import com.cn.beisanproject.modelbean.ProjectYsListBean;
import com.cn.beisanproject.modelbean.PurchseAttachBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.WaitDoListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by tzl
 * on 2020/11/11
 */
public class ProjectYsDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean needGet;
    private WaitDoListBean.ResultBean.ResultlistBean mWitdolistBean;
    private String OWNERID;
    private ProjectYsListBean.ResultBean.ResultlistBean mResultlistBean;
    private String status;
    private LoadingDialog ld;
    private TextView tvApproval;
    private String[] stringItems1 = new String[]{"启动工作流"};
    private String[] stringItems2 = new String[]{"工作流审批"};
    private PopupWindow pop;
    private int isAgree = 1;
    private String UDPRYSID;
    private LinearLayout ll_back;
    private TextView tv_common_title;
    private TextView tv_ys_no;
    private TextView tv_des;
    private TextView tv_con_des;
    private TextView tv_cost;
    private TextView tv_statues;
    private LinearLayout ll_attach;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;
    private TextView tv11;
    private TextView tv12;
    private TextView tv13;
    private TextView tv14;
    private TextView tv15;
    private TextView tv16;
    private TextView tv17;
    private TextView tv18;
    private TextView tv19;
    private TextView tv_finish_date;
    private TextView tv_contact_total;
    TextView tv_otherdep;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.project_ys_detail_activity);
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            mWitdolistBean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            LogUtils.d("OWNERID=" + OWNERID);
        } else {
            mResultlistBean = (ProjectYsListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页 项目立项/项目月度计划
            status = mResultlistBean.getSTATUS();
            UDPRYSID = mResultlistBean.getUDPRYSID() + "";


        }
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ld = new LoadingDialog(this);
        initEvent();
        initView();
    }

    private void initEvent() {
        ll_back = findViewById(R.id.ll_back);
        ll_back.setOnClickListener(this);
        tv_common_title = findViewById(R.id.tv_common_title);
//        tv_ys_no = findViewById(R.id.tv_ys_no);
//        tv_statues= findViewById(R.id.tv_statues);
//        tv_des= findViewById(R.id.tv_des);
//        tv_con_des= findViewById(R.id.tv_con_des);
//        tv_cost= findViewById(R.id.tv_cost);
        tv1= findViewById(R.id.tv_1);
        tv_statues= findViewById(R.id.tv_statues);
        tv2= findViewById(R.id.tv_2);
        tv3= findViewById(R.id.tv_3);
        tv4= findViewById(R.id.tv_4);
        tv5= findViewById(R.id.tv_5);
        tv6= findViewById(R.id.tv_6);
        tv7= findViewById(R.id.tv_7);
        tv8= findViewById(R.id.tv_8);
        tv9= findViewById(R.id.tv_9);
        tv10= findViewById(R.id.tv_10);
        tv11= findViewById(R.id.tv_11);
        tv12= findViewById(R.id.tv_12);
        tv13= findViewById(R.id.tv_13);
        tv14= findViewById(R.id.tv_14);
        tv15= findViewById(R.id.tv_15);
        tv16= findViewById(R.id.tv_16);
        tv17= findViewById(R.id.tv_17);
        tv18= findViewById(R.id.tv_18);
        tv19= findViewById(R.id.tv_19);
        tv_contact_total= findViewById(R.id.tv_contact_total);
        tv_finish_date= findViewById(R.id.tv_finish_date);
        tv_otherdep= findViewById(R.id.tv_otherdep);
        ll_attach= findViewById(R.id.ll_attach);
        tvApproval= findViewById(R.id.tv_approval);
        tvApproval.setOnClickListener(this);
        if (needGet) {
            //网络请求
            getDetail();
        } else {
            //直接赋值
            tv1.setText("验收编号：" + mResultlistBean.getUDPRYSNUM());
            tv_statues.setText(mResultlistBean.getSTATUS());
            tv2.setText("描述：" + mResultlistBean.getDESCRIPTION());
            tv3.setText("询价单号：" + mResultlistBean.getUDRFQNUM());
            tv4.setText("合同序列号：" + mResultlistBean.getCONTRACTNUM());
            tv5.setText("合同编号：" + mResultlistBean.getCONTNUM());
            tv6.setText("合同描述：" + mResultlistBean.getCONTRACTDESC());
            tv7.setText("立项编号：" + mResultlistBean.getPROJECTNUM());
            tv8.setVisibility(View.GONE);
            tv9.setText("立项描述：" + mResultlistBean.getPRODESC());
            tv10.setText("本次结算金额：" + mResultlistBean.getCONTCOST());
            tv_contact_total.setText("合同总金额："+mResultlistBean.getTOTALCOST());
            tv_finish_date.setText("完工日期："+mResultlistBean.getUDWGTIME());
            tv11.setText("开工日期：" + mResultlistBean.getUDKGTIME());
            tv12.setText("专业组：" + mResultlistBean.getCREWID());
            tv13.setText("使用部门：" + mResultlistBean.getXMSYDEPT());
            tv14.setText("主管部门：" + mResultlistBean.getXMZGDEPT());
            tv15.setText("申报部门：" + mResultlistBean.getSBBM());
            tv16.setText("实施部门：" + mResultlistBean.getXMSSDEPT());
            tv_otherdep.setText("其他部门：" + mResultlistBean.getXMJBDEPT());
            tv17.setText("验收主要内容：" + mResultlistBean.getREMARK1());
            tv18.setText("遗留问题：" + mResultlistBean.getREMARK2());
            tv19.setText("备注：" + mResultlistBean.getREMARK3());
            if (status.equals("已取消") || status.equals("取消") || status.equals("关闭") || status.equals("已关闭")|| status.equals("已批准")) {
                tvApproval.setVisibility(View.GONE);
            } else {
                if (status.equals("等待核准")) {
                    tvApproval.setText("启动工作流");
                } else {
                    tvApproval.setText("流程审批");

                }
            }
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
        String sqlSearch = "ownertable='UDPRYS' and ownerid= %s";
        sqlSearch = String.format(sqlSearch, "'"+UDPRYSID+"'");
        object.put("sqlSearch", sqlSearch);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure==" + e.toString());
                ld.close();
            }
            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse==" + response);
                ld.close();
                PurchseAttachBean attachBean;
                if (!response.isEmpty()) {
                    attachBean = JSONObject.parseObject(response, new TypeReference<PurchseAttachBean>() {});
                    if (attachBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<PurchseAttachBean.ResultBean.ResultlistBean> resultlist = attachBean.getResult().getResultlist();
                        ll_attach.removeAllViews();
                        if (resultlist.size() > 0) {
                            for (int i = 0; i < resultlist.size(); i++) {
                                View inflate = LayoutInflater.from(ProjectYsDetailActivity.this).inflate(R.layout.contract_detail_attach, null, false);
                                TextView tv_attach_no = inflate.findViewById(R.id.tv_attach_no);
                                TextView tv_attach_desc = inflate.findViewById(R.id.tv_attach_desc);
                                TextView tv_upload_time = inflate.findViewById(R.id.tv_upload_time);
                                tv_attach_no.setText("附件编号:" + resultlist.get(i).getDOCLINKSID());
                                tv_attach_desc.setText(HighLightUtils.highlight(ProjectYsDetailActivity.this, "附件描述:" + resultlist.get(i).getDOCDESC(), resultlist.get(i).getDOCDESC(), "#1B88EE", 0, 0));
                                tv_upload_time.setText("上传日期:" + resultlist.get(i).getCREATEDATE());
                                int finalI = i;
                                inflate.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (!StringUtils.isEmpty(SharedPreferencesUtil.getString(ProjectYsDetailActivity.this, resultlist.get(finalI).getDOCUMENT()))) {
                                            String savePath = SharedPreferencesUtil.getString(ProjectYsDetailActivity.this, resultlist.get(finalI).getDOCUMENT());
                                            LogUtils.d("222222 sp savePath=" + savePath);
                                            File file = new File(savePath);
                                            try {
                                                LogUtils.d("222222 打开");
                                                OpenFileUtils.openFile(ProjectYsDetailActivity.this, file);
                                            } catch (Exception e) {
                                                LogUtils.d("222222 无打开方式" + e.toString());
                                                e.printStackTrace();
                                            }
                                        } else {
                                            SharedPreferencesUtil.setString(ProjectYsDetailActivity.this, "current_documentid", resultlist.get(finalI).getDOCUMENT());
                                            showConfirmWindow(resultlist.get(finalI).getDOCUMENT());

                                        }

                                    }
                                });
                                ll_attach.addView(inflate);
                            }
                        }
                    }

                }
            }
        });

    }

    private void showConfirmWindow(String document) {
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
            String current_documentid=SharedPreferencesUtil.getString(ProjectYsDetailActivity.this,"current_documentid");
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
                            downLoad(ProjectYsDetailActivity.this, url, filename, documentId);
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
        final ProgressDialog dialog = new ProgressDialog(ProjectYsDetailActivity.this);
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


    private void getDetail() {
        JSONObject object = new JSONObject();
        object.put("appid", "UDPRYS");
        object.put("objectname", "UDPRYS");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "UDPRYSNUM DESC");
        object.put("sqlSearch", "UDPRYSID = "+"'"+mWitdolistBean.getOWNERID()+"'");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(Constants.COMMONURL, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure=" + e.toString());
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse=" + response);
                ProjectYsListBean projectYsListBean;
                if (!response.isEmpty()) {
                    projectYsListBean= JSONObject.parseObject(response, new TypeReference<ProjectYsListBean>() {});
                    if (projectYsListBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (projectYsListBean.getResult().getResultlist().size()>0){
                            ProjectYsListBean.ResultBean.ResultlistBean resultlistBean = projectYsListBean.getResult().getResultlist().get(0);
                            status = resultlistBean.getSTATUS();
                            UDPRYSID=resultlistBean.getUDPRYSID()+"";
                            tv1.setText("验收编号：" + resultlistBean.getUDPRYSNUM());
                            tv_statues.setText(resultlistBean.getSTATUS());
                            tv2.setText("描述：" + resultlistBean.getDESCRIPTION());
                            tv3.setText("询价单号：" + resultlistBean.getUDRFQNUM());
                            tv4.setText("合同序列号：" + resultlistBean.getCONTRACTNUM());
                            tv5.setText("合同编号：" + resultlistBean.getCONTNUM());
                            tv6.setText("合同描述：" + resultlistBean.getCONTRACTDESC());
                            tv7.setText("立项编号：" + resultlistBean.getPROJECTNUM());
                            tv8.setVisibility(View.GONE);
                            tv9.setText("立项描述：" + resultlistBean.getPRODESC());
                            tv10.setText("本次结算金额：" + resultlistBean.getCONTCOST());
                            tv_contact_total.setText("合同总金额："+resultlistBean.getTOTALCOST());
                            tv_finish_date.setText("完工日期："+resultlistBean.getUDWGTIME());
                            tv11.setText("开工日期：" + resultlistBean.getUDKGTIME());
                            tv12.setText("专业组：" + resultlistBean.getCREWID());
                            tv13.setText("使用部门：" + resultlistBean.getXMSYDEPT());
                            tv14.setText("主管部门：" + resultlistBean.getXMZGDEPT());
                            tv15.setText("申报部门：" + resultlistBean.getSBBM());
                            tv16.setText("实施部门：" + resultlistBean.getXMSSDEPT());
                            tv_otherdep.setText("其他部门：" + resultlistBean.getXMJBDEPT());
                            tv17.setText("验收主要内容：" + resultlistBean.getREMARK1());
                            tv18.setText("遗留问题：" + resultlistBean.getREMARK2());
                            tv19.setText("备注：" + resultlistBean.getREMARK3());
                            if (status.equals("已取消") || status.equals("取消")||status.equals("已关闭") || status.equals("关闭")|| status.equals("已批准")) {
                                tvApproval.setVisibility(View.GONE);
                            }else {
                                if (status.equals("等待核准")){
                                    tvApproval.setText("启动工作流");
                                }else {
                                    tvApproval.setText("工作流审批");
                                }
                            }

                        }else {

                        }
                        getAttachMent();

                    }

                }

            }


        });
    }

    private void initView() {
        tv_common_title.setText("项目验收详情");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_approval:
                if (status.equals("等待核准")) {//启动工作流
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
                                case 0:
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

    private void startWork() {
        ld.show();
/**
 * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
 *    <soap:Header/>
 *    <soap:Body>
 *       <max:wfservicestartWF creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
 *          <max:processname>UDPRYS</max:processname>
 *          <max:mbo>UDPRYS</max:mbo>
 *          <max:keyValue>PROJ00179</max:keyValue>
 *          <max:key>UDPRYSID</max:key>
 *          <max:loginid>MAXADMIN</max:loginid>
 *       </max:wfservicestartWF>
 *    </soap:Body>
 * </soap:Envelope>
 */
        String request = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>UDPRYS</max:processname>\n" +
                "         <max:mbo>UDPRYS</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>UDPRYSID</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, UDPRYSID, SharedPreferencesUtil.getString(this, "personId"));
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
                    if (response.contains("<return>") && response.contains("</return>")) {
                        int start = response.indexOf("<return>");
                        int end = response.indexOf("</return>");
                        String substring = response.substring(start + 8, end);
                        LogUtils.d("substring==" + substring);
                        StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                        });
                        if (startWorkProcessBean.getMsg().equals("流程启动成功！")) {
                            status = startWorkProcessBean.getNextStatus();
//                            tvStatue.setText(startWorkProcessBean.getNextStatus());
                            tvApproval.setText("工作流审批");
                            PostData postData = new PostData();
                            postData.setTag("项目验收");
                            EventBus.getDefault().post(postData);
                        } else {

                        }
                        ToastUtils.showShort(startWorkProcessBean.getMsg());
                    } else
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
            if (ifAgree==1){
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
 * 			<max:processname>UDPRYS</max:processname>
 * 			<max:mboName>UDPRYS</max:mboName>
 * 			<max:keyValue>PROJ00185</max:keyValue>
 * 			<max:key>UDPRYSID</max:key>
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
                "<max:processname>UDPRYS</max:processname>" +
                "<max:mboName>UDPRYS</max:mboName>" +
                "<max:keyValue>%s</max:keyValue>" +
                "<max:key>UDPRYSID</max:key>" +
                "<max:ifAgree>%s</max:ifAgree>" +
                "<max:opinion>%s</max:opinion>" +
                "<max:loginid>%s</max:loginid>" +
                "</max:wfservicewfGoOn>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
        // ifAgree :1 同意  2 不同意   opinion:输入内容
        request = String.format(request, UDPRYSID, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
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
                if (response.contains("<return>") && response.contains("<return>")) {
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                    });
                    if (startWorkProcessBean.getMsg().equals("审批成功")) {
                        status = startWorkProcessBean.getNextStatus();
//                        tvStatue.setText(startWorkProcessBean.getNextStatus());
                        PostData postData = new PostData();
                        postData.setTag("项目验收");
                        EventBus.getDefault().post(postData);
                    } else {
                    }
                    ToastUtils.showShort(startWorkProcessBean.getMsg());

                } else
                    ToastUtils.showShort(R.string.UNKNOW_ERROR);
            }
        });


    }
}
