package com.cn.beisanproject.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.StringUtils;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.DownloadUtil;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.activity.LoginActivity;
import com.cn.beisanproject.activity.StockScanZerbaActivity;
import com.cn.beisanproject.activity.StockCheckScanActivity;
import com.cn.beisanproject.modelbean.ResultBean;

import java.io.File;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class PersonalCenterFragment extends Fragment implements View.OnClickListener {
    private Context mContext;
    private ResultBean.UserLoginDetailsBean userLoginDetails;
    private TextView tv_name;
    private TextView tv_num;
    private TextView tv_current_env;
    private TextView tv_Version, tv_download;
    private Button btnLogOut;
    LinearLayout ll_scan;
    String model;
    String carrier;
    File file;
    private static final int REQUEST_CODE_QRCODE_PERMISSIONS = 1;


    public PersonalCenterFragment(Context context) {
        this.mContext = context;
        model = android.os.Build.MODEL;//手机型号
        carrier = Build.MANUFACTURER;//手机厂商
        LogUtils.d("model== " + model + "       carrier=" + carrier);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userLoginDetails = (ResultBean.UserLoginDetailsBean) SharedPreferencesUtil.getObject(mContext, "userLoginDetails");
//        LogUtils.d("userLoginDetails="+userLoginDetails);
        tv_name = view.findViewById(R.id.tv_name);
        tv_num = view.findViewById(R.id.tv_num);
        tv_current_env = view.findViewById(R.id.tv_current_env);
        tv_Version = view.findViewById(R.id.tv_Version);
        ll_scan = view.findViewById(R.id.ll_scan);
        btnLogOut = view.findViewById(R.id.btnLogOut);
        tv_download = view.findViewById(R.id.tv_download);
        tv_name.setText(userLoginDetails.getDisplayName());
        tv_num.setText(userLoginDetails.getUserName());
        tv_current_env.setText("正式环境");
        String appVersionName = AppUtils.getAppVersionName();
        LogUtils.d("222222 appVersionName=" + appVersionName);
        tv_Version.setText(appVersionName);
        btnLogOut.setOnClickListener(this);
        ll_scan.setOnClickListener(this);
        tv_download.setOnClickListener(this);
        checkNeedPermissions();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogOut:
                mContext.startActivity(new Intent(mContext, LoginActivity.class).putExtra("from", "PersonalCenterFragment"));
                SharedPreferencesUtil.setString(mContext, "username", "");
                SharedPreferencesUtil.setString(mContext, "pwd", "");

                getActivity().finish();
                break;
            case R.id.ll_scan:
                if (!carrier.equals("Zebra Technologies")) {//非斑马设备
                    requestCodeQRCodePermissions();
                } else {
                    Intent intent = new Intent(mContext, StockScanZerbaActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.tv_download:
                downLoad(mContext, "http://192.168.1.180:7010/maximo/webclient/login/app-debug.apk", "app-debug.apk", "001");
                break;
        }
    }

    private void checkNeedPermissions() {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(mContext, Manifest.permission.INSTALL_PACKAGES)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(mContext, Manifest.permission.REQUEST_INSTALL_PACKAGES)
                != PackageManager.PERMISSION_GRANTED) {
            //多个权限一起申请
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.INSTALL_PACKAGES,
                    Manifest.permission.REQUEST_INSTALL_PACKAGES
            }, 1);
        } else {
            downLoad(mContext, "http://192.168.1.180:7010/maximo/webclient/login/app-debug.apk", "app-debug.apk", "001");
        }
//        else {
//            String current_documentid=SharedPreferencesUtil.getString(ProjectMonthDetailActivity.this,"current_documentid");
//            getUrl(current_documentid);
//        }
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
                file = new File(Environment.getExternalStorageDirectory().getPath() + "/download/" + filename);
                LogUtils.d("222222 sp downloadUrl=" + downloadUrl);
                LogUtils.d("222222 sp savepath=" + file.getAbsolutePath());
                SharedPreferencesUtil.setString(mContext, documentId, file.getAbsolutePath());

                check(file);
//                try {
//                    LogUtils.d("222222 打开");
//                    OpenFileUtils.openFile(mContext, file);
//                } catch (Exception e) {
//                    LogUtils.d("222222 无打开方式" + e.toString());
//
//                    e.printStackTrace();
//                }

            }

            @Override
            public void onDownloading(int progress) {
//                LogUtils.d("222222  onDownloading" + progress);
                dialog.setProgress(progress);
            }

            @Override
            public void onDownloadFailed() {
                LogUtils.d("222222  onDownloadFailed");
                dialog.dismiss();
            }
        });
    }

    private void check(File file) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LogUtils.d("222222  " + Build.VERSION.SDK_INT);
            boolean b = getActivity().getPackageManager().canRequestPackageInstalls();
            LogUtils.d("222222  " + b);
            if (!b) {
                requestPermissions(new String[]{Manifest.permission.REQUEST_INSTALL_PACKAGES, Manifest.permission.INSTALL_PACKAGES}, 996);
            } else {
                installApk(file);
            }
        } else {
            installApk(file);
        }
    }

    private void installApk(File file) {

        if (file != null) {
            LogUtils.d("222222  installApk。。。。。");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            Uri fileUri = null;
//            intent.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
            if (Build.VERSION.SDK_INT >= 24) {
                fileUri = FileProvider.getUriForFile(mContext, getActivity().getPackageName() + ".fileProvider", file);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else {
                fileUri = Uri.fromFile(file);
            }
            intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
            startActivity(intent);
//            Process.killProcess(Process.myPid());
        } else {
            LogUtils.d("222222  安装失败");
        }

    }

    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private void requestCodeQRCodePermissions() {
        LogUtils.d("222222", "requestCodeQRCodePermissions()");
        String[] perms = {Manifest.permission.CAMERA};
        if (!EasyPermissions.hasPermissions(mContext, perms)) {
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_QRCODE_PERMISSIONS, perms);
        } else {
            if (!carrier.equals("Zebra Technologies")) {//非斑马设备
                Intent intent = new Intent(mContext, StockCheckScanActivity.class);
                intent.putExtra("from", "PersonalCenterFragment");
                startActivity(intent);
            }
        }
    }

    //    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LogUtils.d("222222  onRequestPermissionsResult");

        switch (requestCode) {
            case 996:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    LogUtils.d("222222  已授权");
                    installApk(file);
                } else {
                    LogUtils.d("222222  没有授权");
                    Uri uri = Uri.parse("package:" + getActivity().getPackageName());
                    Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, uri);
                    try {
                        startActivityForResult(intent, 996);
                        startActivity(intent);
                    } catch (ActivityNotFoundException exception) {
                        exception.getMessage();
                        LogUtils.d("222222  " + exception.getMessage());
                    }
                }
                break;
        }
    }
}
