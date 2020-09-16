package com.cn.beisanproject.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.AppUtils;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.activity.LoginActivity;
import com.cn.beisanproject.activity.StockScanZerbaActivity;
import com.cn.beisanproject.activity.StockCheckScanActivity;
import com.cn.beisanproject.modelbean.ResultBean;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

@SuppressLint("ValidFragment")
public class PersonalCenterFragment extends Fragment implements View.OnClickListener {
    private Context mContext;
    private ResultBean.UserLoginDetailsBean userLoginDetails;
    private TextView tv_name;
    private TextView tv_num;
    private TextView tv_current_env;
    private TextView tv_current_version;
    private  TextView txtCurVersion;
    private Button btnLogOut;
    LinearLayout ll_scan;
    String   model;
    String   carrier;
    private static final int REQUEST_CODE_QRCODE_PERMISSIONS = 1;


    public PersonalCenterFragment(Context context) {
        this.mContext = context;
           model= android.os.Build.MODEL;//手机型号
           carrier= Build.MANUFACTURER;//手机厂商
        LogUtils.d("model== "+model + "       carrie=r="+carrier);

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
        txtCurVersion = view.findViewById(R.id.txtCurVersion);
        ll_scan= view.findViewById(R.id.ll_scan);
        btnLogOut = view.findViewById(R.id.btnLogOut);
        tv_name.setText(userLoginDetails.getDisplayName());
        tv_num.setText(userLoginDetails.getUserName());
        tv_current_env.setText("开发环境");
        txtCurVersion.setText(AppUtils.getAppVersionName());
        btnLogOut.setOnClickListener(this);
        ll_scan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogOut:
                mContext.startActivity(new Intent(mContext, LoginActivity.class).putExtra("from","PersonalCenterFragment"));
                SharedPreferencesUtil.setString(mContext,"username","");
                SharedPreferencesUtil.setString(mContext,"pwd","");

                getActivity().finish();
                break;
            case R.id.ll_scan:
                if (!carrier.equals("Zebra Technologies")){//非斑马设备
                    requestCodeQRCodePermissions();
                }else {
                    Intent intent=new Intent(mContext, StockScanZerbaActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private void requestCodeQRCodePermissions() {
        LogUtils.d("222222", "requestCodeQRCodePermissions()");
        String[] perms = {Manifest.permission.CAMERA};
        if (!EasyPermissions.hasPermissions(mContext, perms)) {
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_QRCODE_PERMISSIONS, perms);
        } else {
            if (!carrier.equals("Zebra Technologies")){//非斑马设备
                Intent intent=new Intent(mContext, StockCheckScanActivity.class);
                intent.putExtra("from","PersonalCenterFragment");
                startActivity(intent);
            }

        }
    }
}
