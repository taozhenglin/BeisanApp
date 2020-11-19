package com.cn.beisanproject.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.DownloadUtil;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.OpenFileUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.adapter.AttachListAdapter;
import com.cn.beisanproject.modelbean.CommonAttachBean;
import com.cn.beisanproject.modelbean.PurchseAttachBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yinglan.keyboard.HideUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2020/11/18
 */
public class AttachListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private int currentPageNum = 1;
    private AttachListAdapter attachListAdapter;
    private TextView tv_back;
    private TextView tv_common_title;
    private LinearLayout ll_back;
    private LoadingDialog ld;


    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private String RFQID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attach_list);
        RFQID=getIntent().getStringExtra("RFQID");
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        initView();
        initEvent();
        initListener();
    }
    private void initListener() {
        ll_back.setOnClickListener(this);

    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = findViewById(R.id.refreshLayout);
        ll_back = findViewById(R.id.ll_back);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("附件列表");
    }

    private void initEvent() {
        ld=new LoadingDialog(this);
        query();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                query();


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                query();

            }
        });

    }

    private void query() {
        ld.show();
        LogUtils.d("getAttachMent==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "DOCLINKS");
        object.put("objectname", "DOCLINKS");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "CREATEDATE DESC");
        String sqlSearch = "ownertable='RFQ' and ownerid= %s";
        sqlSearch = String.format(sqlSearch, "'"+RFQID+"'");
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
                finishRefresh();
            }
            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse==" + response);
                finishRefresh();
                ld.close();
                PurchseAttachBean attachBean;
                if (!response.isEmpty()) {
                    attachBean = JSONObject.parseObject(response, new TypeReference<PurchseAttachBean>() {});
                    if (attachBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<PurchseAttachBean.ResultBean.ResultlistBean> resultlist = attachBean.getResult().getResultlist();
                        if (resultlist.size() > 0) {
                            int  totalPage=attachBean.getResult().getTotalpage();
                            if (currentPageNum == 1) {
                                if (attachListAdapter==null){
                                    attachListAdapter = new AttachListAdapter(AttachListActivity.this, resultlist);
                                    recyclerView.setAdapter(attachListAdapter);
                                }else {
                                    attachListAdapter.setData(resultlist);
                                    attachListAdapter.notifyDataSetChanged();
                                }

                            } else {
                                if (currentPageNum<=totalPage){
                                    attachListAdapter.addAllList(resultlist);
                                    attachListAdapter.notifyDataSetChanged();
                                }else {
                                    ToastUtils.showShort("没有更多数据了");
                                }

                            }
                            attachListAdapter.setListener(new AttachListAdapter.OnclickListsner() {
                                @Override
                                public void onclick(String document) {
                                    if (!StringUtils.isEmpty(SharedPreferencesUtil.getString(AttachListActivity.this, document))) {
                                        String savePath = SharedPreferencesUtil.getString(AttachListActivity.this, document);
                                        LogUtils.d("222222 sp savePath=" + savePath);
                                        File file = new File(savePath);
                                        try {
                                            LogUtils.d("222222 打开");
                                            OpenFileUtils.openFile(AttachListActivity.this, file);
                                        } catch (Exception e) {
                                            LogUtils.d("222222 无打开方式" + e.toString());
                                            e.printStackTrace();
                                        }
                                    } else {
                                        SharedPreferencesUtil.setString(AttachListActivity.this, "current_documentid", document);
                                        showConfirmWindow(document);

                                    }
                                }
                            });
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
            String current_documentid=SharedPreferencesUtil.getString(AttachListActivity.this,"current_documentid");
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
                            downLoad(AttachListActivity.this, url, filename, documentId);
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
        final ProgressDialog dialog = new ProgressDialog(AttachListActivity.this);
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


    @Override
    public void onClick(View view) {
        finish();
    }
}
