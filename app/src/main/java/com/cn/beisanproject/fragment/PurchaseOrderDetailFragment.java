package com.cn.beisanproject.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSONArray;
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
import com.cn.beisanproject.activity.PurchaseOrderDetailActivity;
import com.cn.beisanproject.modelbean.AssaginListBean;
import com.cn.beisanproject.modelbean.CommonAttachBean;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.PurchaseOrderListBean;
import com.cn.beisanproject.modelbean.PurchseAttachBean;
import com.cn.beisanproject.modelbean.PurchseContractDetailBean;
import com.cn.beisanproject.modelbean.PurchseContractListBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

public class PurchaseOrderDetailFragment extends Fragment {
    private  Context mContext;
    private  PurchaseOrderListBean.ResultBean.ResultlistBean mResultlistBean;
    TextView tv_contract_no;
    TextView tv_contract_statue;
    TextView tv_contract_desc;
    TextView tv_xunjia_no;
    TextView tv_xunjia_desc;
    TextView tv_isyear_contract;
    TextView tv_department;
    TextView tv_contract_jia;
    TextView tv_contract_yi;
    TextView tv_company;
    TextView tv_request_department;
    TextView tv_contract_created;
    TextView tv_contract_signtime;
    TextView tv_contract_starttime;
    TextView tv_contract_endtime;
    TextView tv_contract_cost;
    private LinearLayout ll_contract_attachment;
    PurchseContractDetailBean mPurchseContractDetailBean;
    private LinearLayout ll_assginman;
    private TextView tv_assginman;
    boolean mNeedGet;
    String ownerid;
    String contractnum;
    String orgid;
    String company;
    private LoadingDialog ld;
    private TextView tv_line;

    /**
     *
     * @param context
     * @param resultlistBean 外部列表带过来的
     * @param needGet
     * @param purchseContractDetailBean  拉取详情获取的
     */
    public PurchaseOrderDetailFragment(Context context, PurchaseOrderListBean.ResultBean.ResultlistBean resultlistBean, boolean needGet, PurchseContractDetailBean purchseContractDetailBean) {
        this.mContext = context;
        this.mResultlistBean = resultlistBean;
        mPurchseContractDetailBean = purchseContractDetailBean;
        mNeedGet = needGet;
        ld=new LoadingDialog(mContext);
        LogUtils.d("mResultlistBean== " + mResultlistBean);
        LogUtils.d("mNeedGet== " + mNeedGet);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contract_detail_fragment, container, false);
        tv_contract_no = view.findViewById(R.id.tv_contract_no);
        tv_contract_statue = view.findViewById(R.id.tv_contract_statue);
        tv_contract_desc = view.findViewById(R.id.tv_contract_desc);
        tv_xunjia_no = view.findViewById(R.id.tv_xunjia_no);
        tv_xunjia_desc = view.findViewById(R.id.tv_xunjia_desc);
        tv_isyear_contract = view.findViewById(R.id.tv_isyear_contract);
        tv_department = view.findViewById(R.id.tv_department);
        tv_contract_jia = view.findViewById(R.id.tv_contract_jia);
        tv_contract_yi = view.findViewById(R.id.tv_contract_yi);
        tv_company = view.findViewById(R.id.tv_company);
        tv_request_department = view.findViewById(R.id.tv_request_department);
        tv_contract_created = view.findViewById(R.id.tv_contract_created);
        tv_contract_signtime = view.findViewById(R.id.tv_contract_signtime);
        tv_contract_cost = view.findViewById(R.id.tv_contract_cost);
        tv_contract_starttime = view.findViewById(R.id.tv_contract_starttime);
        tv_contract_endtime = view.findViewById(R.id.tv_contract_endtime);
        ll_assginman = view.findViewById(R.id.ll_assginman);
        tv_assginman = view.findViewById(R.id.tv_assginman);
        //合同附件
        tv_line = view.findViewById(R.id.tv_line);
        ll_contract_attachment = view.findViewById(R.id.ll_contract_attachment);
        EventBus.getDefault().register(this);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void checkNeedPermissions() {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this.getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //多个权限一起申请
            ActivityCompat.requestPermissions(this.getActivity(), new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, 1);
        } else {
            String current_documentid = SharedPreferencesUtil.getString(mContext, "current_documentid");
            getUrl(current_documentid);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            boolean hasAllPermission = true;
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    hasAllPermission = false;
                }
            }
            if (hasAllPermission) {
                String current_documentid = SharedPreferencesUtil.getString(mContext, "current_documentid");
                getUrl(current_documentid);
            } else {
                ToastUtils.showShort("无读取存储权限");

            }

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mNeedGet) {
            ownerid = mPurchseContractDetailBean.getResult().getResultlist().get(0).getCONTRACTID() + "";
            contractnum = mPurchseContractDetailBean.getResult().getResultlist().get(0).getCONTRACTNUM();
            orgid = mPurchseContractDetailBean.getResult().getResultlist().get(0).getORGID();
            company = mPurchseContractDetailBean.getResult().getResultlist().get(0).getVENDOR();
            tv_contract_no.setText("合同编号：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getCONTRACTNUM());
            tv_contract_statue.setText(mPurchseContractDetailBean.getResult().getResultlist().get(0).getSTATUS());
            if (mPurchseContractDetailBean.getResult().getResultlist().get(0).getSTATUS().equals("总经理审批")) {
                ll_assginman.setEnabled(true);
            } else {
                ll_assginman.setEnabled(false);
            }
            tv_assginman.setText("授权代表:" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getQIANMING());

            tv_contract_desc.setText("合同描述：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getDESCRIPTION());
            tv_xunjia_no.setText("询价单号：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getA_RFQNUM());
            tv_xunjia_desc.setText("询价描述：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getA_RFQDESC());
            tv_isyear_contract.setText("是否年度招标合同：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getHASINSURANCE());
            tv_department.setText("主管部门: " + mPurchseContractDetailBean.getResult().getResultlist().get(0).getJFQZDB());
            tv_contract_jia.setText("甲方：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getHTJF());
            tv_contract_yi.setText("乙方：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getHTYF());
            tv_company.setText("公司：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getA_COMP());
            tv_request_department.setText("申请部门：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getA_DEPT());
            tv_contract_created.setText("合同编制人：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getHTJF());
            tv_contract_signtime.setText("合同签订日期：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getJ_CONTRACTDATE());
            tv_contract_cost.setText("合同金额：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getTOTALCOST());
            tv_contract_starttime.setText("合同开始日期：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getSTARTDATE());
            tv_contract_endtime.setText("合同结束日期：" + mPurchseContractDetailBean.getResult().getResultlist().get(0).getENDDATE());
            getContractAttach();

        } else {
            ownerid = mResultlistBean.getCONTRACTID() + "";
            contractnum = mResultlistBean.getCONTRACTNUM();
            orgid = mResultlistBean.getORGID();
            company = mResultlistBean.getVENDOR();
            tv_contract_no.setText("合同编号：" + mResultlistBean.getCONTRACTNUM());
            tv_contract_statue.setText(mResultlistBean.getSTATUS());
            if (mResultlistBean.getSTATUS().equals("总经理审批")) {
                ll_assginman.setEnabled(true);
            } else {
                ll_assginman.setEnabled(false);
            }
            tv_assginman.setText("授权代表:" + mResultlistBean.getQIANMING());
            tv_contract_desc.setText("合同描述：" + mResultlistBean.getDESCRIPTION());
            tv_xunjia_no.setText("询价单号：" + mResultlistBean.getA_RFQNUM());
            tv_xunjia_desc.setText("询价描述：" + mResultlistBean.getA_RFQDESC());
            tv_isyear_contract.setText("是否年度招标合同：" + mResultlistBean.getHASINSURANCE());
            tv_department.setText("主管部门: ");
            tv_contract_jia.setText("甲方：" + mResultlistBean.getHTJF());
            tv_contract_yi.setText("乙方：" + mResultlistBean.getVENDORDESC());
            tv_company.setText("公司：");
            tv_request_department.setText("申请部门：");
            tv_contract_created.setText("合同编制人：" + mResultlistBean.getHTJF());
            tv_contract_signtime.setText("合同签订日期：" + mResultlistBean.getJ_CONTRACTDATE());
            tv_contract_cost.setText("合同金额：" + mResultlistBean.getTOTALCOST());
            tv_contract_starttime.setText("合同开始日期：" + mResultlistBean.getSTARTDATE());
            tv_contract_endtime.setText("合同结束日期：" + mResultlistBean.getENDDATE());
            getContractAttach();
        }
        tv_line.setText("订单相关附件");
        ll_assginman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //拉取列表
                getAssaginList();
            }
        });

    }


    /**
     * --采购合同附件查询
     * http://192.168.1.180:7009/maximo/mobile/common/api?data=
     * {"appid":"DOCLINKS","objectname":"DOCLINKS","curpage":1,"showcount":20,"option":"read","orderby":"CREATEDATE DESC",
     * "sqlSearch":" (ownertable='PURCHVIEW' and ownerid=:contractid) or (ownertable='RFQLINE' and ownerid in (select rfqlineid from rfqline where contractnum=:contractnum and orgid=:orgid)) or (ownertable='PRLINE' and ownerid in (select prlineid from prline where contractnum=:contractnum and orgid=:orgid)) or (ownertable='COMPANIES' and ownerid = (select companiesid from companies where company=:vendor and orgid=:orgid)) "}
     */

    private void getContractAttach() {
        LogUtils.d("getContractDetail");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "DOCLINKS");
        object.put("objectname", "DOCLINKS");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "CREATEDATE DESC");
        String sqlSearch = " (ownertable='PURCHVIEW' and ownerid=%s) " +
                "or (ownertable='RFQLINE' and ownerid in (select rfqlineid from rfqline where contractnum=%s and orgid=%s))" +
                " or (ownertable='PRLINE' and ownerid in (select prlineid from prline where contractnum=%s and orgid=%s)) " +
                "or (ownertable='COMPANIES' and ownerid = (select companiesid from companies where company=%s and orgid=%s)) ";
        sqlSearch = String.format(sqlSearch, "'" + ownerid + "'", "'" + contractnum + "'", "'" + orgid + "'", "'" + contractnum + "'", "'" + orgid + "'", "'" + company + "'", "'" + orgid + "'");
        object.put("sqlSearch", sqlSearch);
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
                if (!response.isEmpty()) {
                    PurchseAttachBean attachBean = JSONObject.parseObject(response, new TypeReference<PurchseAttachBean>() {
                    });
                    if (attachBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<PurchseAttachBean.ResultBean.ResultlistBean> resultlist = attachBean.getResult().getResultlist();
                        ll_contract_attachment.removeAllViews();
                        if (resultlist.size() > 0) {
                            for (int i = 0; i < resultlist.size(); i++) {
                                View inflate = LayoutInflater.from(mContext).inflate(R.layout.contract_detail_attach, null, false);
                                TextView tv_attach_no = inflate.findViewById(R.id.tv_attach_no);
                                TextView tv_attach_desc = inflate.findViewById(R.id.tv_attach_desc);
                                TextView tv_upload_time = inflate.findViewById(R.id.tv_upload_time);
                                tv_attach_no.setText("附件编号：" + resultlist.get(i).getDOCINFOID());
                                tv_attach_desc.setText(HighLightUtils.highlight(mContext, "附件描述：" + resultlist.get(i).getDOCDESC(), resultlist.get(i).getDOCDESC(), "#1B88EE", 0, 0));
                                tv_upload_time.setText("上传日期：" + resultlist.get(i).getCREATEDATE());
                                int finalI = i;
                                inflate.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        if (!StringUtils.isEmpty(SharedPreferencesUtil.getString(mContext, resultlist.get(finalI).getDOCUMENT()))) {
                                            String savePath = SharedPreferencesUtil.getString(mContext, resultlist.get(finalI).getDOCUMENT());
                                            LogUtils.d("222222 sp savePath=" + savePath);
                                            File file = new File(savePath);
                                            try {
                                                LogUtils.d("222222 打开");
                                                OpenFileUtils.openFile(mContext, file);
                                            } catch (Exception e) {
                                                LogUtils.d("222222 无打开方式" + e.toString());
                                                e.printStackTrace();
                                            }
                                        } else {
                                            SharedPreferencesUtil.setString(mContext, "current_documentid", resultlist.get(finalI).getDOCUMENT());
                                            showConfirmWindow(resultlist.get(finalI).getDOCUMENT());
                                        }
                                    }
                                });
                                ll_contract_attachment.addView(inflate);
                            }
                        }


                    }

                }

            }

        });
    }


    //    @Override
//    public void refresh(StartWorkProcessBean startWorkProcessBean) {
//        LogUtils.d("startWorkProcessBean=="+startWorkProcessBean);
//    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(PostData postData) {
        LogUtils.d("onEvent==");
        if (postData.getTag().equals("采购订单")) {
            tv_contract_statue.setText(postData.getNextStatus());
            getContractAttach();
        }

    }
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEventString( String s){
//        LogUtils.d("onEvent=="+"    s="+s);
//
//
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

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
                    if (!StringUtils.isEmpty(commonAttachBean.getUrlnew())) {
                        LogUtils.d("url==" + commonAttachBean.getUrlnew());
                        String url = commonAttachBean.getUrlnew();
                        // http://192.168.1.180:7009/doclinks/attachments/测试.xls
                        int urlstart = url.lastIndexOf("/");
                        int urlend = url.length();
                        String filename = url.substring(urlstart + 1);
                        LogUtils.d("filename222222" + filename);
                        downLoad(mContext, url, filename, documentId);
                    }
                }
            }
        });

    }

    private void showConfirmWindow(String documentId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("确定下载并查看？");
        builder.setPositiveButton("确定下载", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                checkNeedPermissions();
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

    private void downLoad(Context mContext, String downloadUrl, String filename, String documentId) {
        //配置progressDialog
        final ProgressDialog dialog = new ProgressDialog(mContext);
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
                dialog.setProgress(progress);
                LogUtils.d("222222  onDownloading" + progress);

            }

            @Override
            public void onDownloadFailed() {
                dialog.dismiss();
                LogUtils.d("222222  onDownloadFailed");

            }
        });
    }

    private void getAssaginList() {
/**
 * {"appid":"ALNDOMAIN",
 * "objectname":"ALNDOMAIN",
 * "curpage":1,"showcount":20,
 * "option":"read","orderby":"",
 * "sinorsearch":{"VALUE":"","DESCRIPTION":""},
 * "sqlSearch":" DOMAINID='QIANMING' "}
 */
        LogUtils.d("getContractDetail==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "ALNDOMAIN");
        object.put("objectname", "ALNDOMAIN");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        JSONObject sinorsearch = new JSONObject();
        sinorsearch.put("VALUE", "");
        sinorsearch.put("DESCRIPTION", "");
        object.put("sinorsearch", sinorsearch);
        object.put("sqlSearch", "DOMAINID='QIANMING'");
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
                if (!response.isEmpty()) {
                    AssaginListBean assaginListBean = JSONObject.parseObject(response, new TypeReference<AssaginListBean>() {
                    });
                    if (assaginListBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<AssaginListBean.ResultBean.ResultlistBean> resultlist = assaginListBean.getResult().getResultlist();
                        if (resultlist.size() > 0) {
                            String[] array = new String[resultlist.size()];
                            for (int i = 0; i < resultlist.size(); i++) {
                                array[i] = resultlist.get(i).getVALUE();
                            }
                            ActionSheetDialog dialog = new ActionSheetDialog(mContext, array, null);
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
                                    tv_assginman.setText("授权代表：" + array[position]);
                                    upLoad(array[position]);
                                    dialog.dismiss();
                                }
                            });
                        }


                    }

                }

            }

        });
    }

    private void upLoad(String s) {
        ld.show();
/**
 * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
 *    <soap:Header/>
 *    <soap:Body>
 *       <max:mobileserviceUpdateMbo creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
 *          <max:json>{" QIANMING " : "MR","TYPE":"update","relationShip" : [{"A_BUDGETNUM" :""}]}</max:json>
 *          <max:mboObjectName> PURCHVIEW </max:mboObjectName>
 *          <max:mboKey> contractnum </max:mboKey>
 *          <max:mboKeyValue>3586</max:mboKeyValue>
 *       </max:mobileserviceUpdateMbo>
 *    </soap:Body>
 * </soap:Envelope>
 */
        String request = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:mobileserviceUpdateMbo creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:json>%s</max:json>\n" +
                "         <max:mboObjectName>PURCHVIEW</max:mboObjectName>\n" +
                "         <max:mboKey>CONTRACTNUM</max:mboKey>\n" +
                "         <max:mboKeyValue>%s</max:mboKeyValue>\n" +
                "      </max:mobileserviceUpdateMbo>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        JSONObject object=new JSONObject();
        object.put("QIANMING",s);
        object.put("TYPE","update");

        JSONArray relationShip=new JSONArray();
        JSONObject obj=new JSONObject();
        obj.put("A_BUDGETNUM","");
        relationShip.add(obj);
        object.put("relationShip",relationShip);

        JSONArray A_BUDGETNUM=new JSONArray();
        JSONObject obj2=new JSONObject();
        obj2.put("","");
        A_BUDGETNUM.add(obj2);
        object.put("A_BUDGETNUM",A_BUDGETNUM);
        request = String.format(request, String.valueOf(object),contractnum);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");
        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP2, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ld.close();
                LogUtils.d("222222onFailure" + e.toString());
                ToastUtils.showShort(R.string.upLoadfailed);
            }

            @Override
            public void onResponse(String response) {
                ld.close();
                LogUtils.d("onResponse222222" + response);
                if (response.contains("<return>") && response.contains("</return>")) {
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {});
                    if (startWorkProcessBean.getErrorNo()==0){
                        ToastUtils.showShort("修改"+startWorkProcessBean.getSuccess());
                    }

                }
            }
        });

    }
}
