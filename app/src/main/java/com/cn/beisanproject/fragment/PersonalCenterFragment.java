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
import com.blankj.utilcode.util.StringUtils;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.activity.LoginActivity;
import com.cn.beisanproject.activity.StockScanZerbaActivity;
import com.cn.beisanproject.activity.StockCheckScanActivity;
import com.cn.beisanproject.modelbean.ResultBean;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;

import java.util.Arrays;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class PersonalCenterFragment extends Fragment implements View.OnClickListener {
    private Context mContext;
    private ResultBean.UserLoginDetailsBean userLoginDetails;
    private TextView tv_name;
    private TextView tv_num;
    private TextView tv_current_env;
    private TextView tv_Version;
    private Button btnLogOut;
    LinearLayout ll_scan;
    String model;
    String carrier;
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
        tv_name.setText(userLoginDetails.getDisplayName());
        tv_num.setText(userLoginDetails.getUserName());
        tv_current_env.setText("开发环境");
        String appVersionName = AppUtils.getAppVersionName();
        LogUtils.d("222222 appVersionName=" + appVersionName);
        tv_Version.setText(appVersionName);
        btnLogOut.setOnClickListener(this);
        ll_scan.setOnClickListener(this);
        tv_current_env.setOnClickListener(this);
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
            case R.id.tv_current_env:
                DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=7c7a11fc1758fcbce12c6082119344c94b1ac635f79e8c34d5de5317213f5ab1");
                OapiRobotSendRequest request = new OapiRobotSendRequest();
                request.setMsgtype("text");
                OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
                text.setContent("测试文本消息");
                request.setText(text);
                OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
                at.setAtMobiles(Arrays.asList("15501198266"));
// isAtAll类型如果不为Boolean，请升级至最新SDK
                at.setIsAtAll(true);
                request.setAt(at);

                request.setMsgtype("link");
                OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
                link.setMessageUrl("https://www.dingtalk.com/");
                link.setPicUrl("");
                link.setTitle("时代的火车向前开");
                link.setText("这个即将发布的新版本，创始人xx称它为红树林。而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是红树林");
                request.setLink(link);

                request.setMsgtype("markdown");
                OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
                markdown.setTitle("杭州天气");
                markdown.setText("#### 杭州天气 @156xxxx8827\n" +
                        "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
                        "> ![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png)\n"  +
                        "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
                request.setMarkdown(markdown);
                try {
                    OapiRobotSendResponse response = client.execute(request);
                } catch (ApiException e) {
                    e.printStackTrace();
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
            if (!carrier.equals("Zebra Technologies")) {//非斑马设备
                Intent intent = new Intent(mContext, StockCheckScanActivity.class);
                intent.putExtra("from", "PersonalCenterFragment");
                startActivity(intent);
            }

        }
    }
}
