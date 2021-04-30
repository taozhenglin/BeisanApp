package com.cn.beisanproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.Base.MyApplication;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.modelbean.LoginBean;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.yinglan.keyboard.HideUtil;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import java.util.HashMap;

import okhttp3.Call;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private EditText etUser;
    private EditText etPwd;
    private TextView tvVersion;//版本
    private ProgressBar pb;
    private LoadingDialog ld;
//    private SmartApplication application;

    private long[] mHits;
    private ImageView iv_clear1;
    private ImageView iv_clear2;
    private boolean showPwd = false;
    ImageView iv_agree;
    ImageView iv_disagree;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
        initEvent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d("222222 uesrname = " + SharedPreferencesUtil.getString(this, "username"));
        LogUtils.d("222222 pwd = " + SharedPreferencesUtil.getString(this, "pwd"));

        etUser.setText(SharedPreferencesUtil.getString(this, "username"));
        etPwd.setText(SharedPreferencesUtil.getString(this, "pwd"));
    }

    private void initEvent() {
        btnLogin.setOnClickListener(this);
        tvVersion.setOnClickListener(this);
        iv_clear1.setOnClickListener(this);
        iv_clear2.setOnClickListener(this);

//        iv_agree.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                iv_agree.setBackgroundResource(R.drawable.selected);
//                iv_disagree.setBackgroundResource(R.drawable.unselected);
//              Constants.BASE_URL="http://10.169.87.216";
//                Constants. LOGIN="/login";
//                Constants. COMMONURL="http://10.169.87.216/api";
//                Constants. COMMONSOAP="http://10.169.87.216:7001/meaweb/services/WFSERVICE";
//                Constants. COMMONSOAP2="http://10.169.87.216:7001/meaweb/services/MOBILESERVICE";
//                SharedPreferencesUtil.setString(MyApplication.applicationContext, "envirment", "测试");
//            }
//        });
//        iv_disagree.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                iv_disagree.setBackgroundResource(R.drawable.selected);
//                iv_agree.setBackgroundResource(R.drawable.unselected);
//                Constants.BASE_URL = "http://csct.nbport.com.cn:9080";
//                Constants.LOGIN = "/login";
//                Constants.COMMONURL = "http://csct.nbport.com.cn:9080/api";
//                Constants.COMMONSOAP = "http://csct.nbport.com.cn:9080/WFSERVICE";
//                Constants.COMMONSOAP2 = "http://csct.nbport.com.cn:9080/MOBILESERVICE";
//                SharedPreferencesUtil.setString(MyApplication.applicationContext, "envirment", "开发");
//
//            }
//        });
    }

    private void initView() {
        btnLogin = (Button) findViewById(R.id.login);
        etUser = findViewById(R.id.username);
        etPwd = findViewById(R.id.password);
        pb = findViewById(R.id.loading);
        tvVersion = findViewById(R.id.tvVersion);
        iv_clear1 = findViewById(R.id.iv_clear1);
        iv_clear2 = findViewById(R.id.iv_clear2);
        iv_agree = (ImageView) findViewById(R.id.iv_agree);
        iv_disagree = (ImageView) findViewById(R.id.iv_disagree);

//        if (StringUtils.isEmpty(SharedPreferencesUtil.getString(MyApplication.applicationContext, "envirment"))) {
//            iv_agree.setBackgroundResource(R.drawable.selected);
//            iv_disagree.setBackgroundResource(R.drawable.unselected);
//        } else {
//            if (SharedPreferencesUtil.getString(MyApplication.applicationContext, "envirment").equals("测试")) {
//                iv_agree.setBackgroundResource(R.drawable.selected);
//                iv_disagree.setBackgroundResource(R.drawable.unselected);
//            } else {
//                iv_disagree.setBackgroundResource(R.drawable.selected);
//                iv_agree.setBackgroundResource(R.drawable.unselected);
//                Constants.BASE_URL = "http://csct.nbport.com.cn:9080/maximo/mobile";
//                Constants.LOGIN = "/system/login";
//                Constants.COMMONURL = "http://csct.nbport.com.cn:9080/maximo/mobile/common/api";
//                Constants.COMMONSOAP = "http://csct.nbport.com.cn:9080/maximo/meaweb/services/WFSERVICE";
//                Constants.COMMONSOAP2 = "http://csct.nbport.com.cn:9080/maximo/meaweb/services/MOBILESERVICE";
//            }
//        }

        //键盘自动隐藏
        HideUtil.init(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        // getWindow().setStatusBarColor(Color.TRANSPARENT);

        ld = new LoadingDialog(this).setLoadingText("登陆中");
    }

    void initData() {
        tvVersion.setText("版本 " + AppUtils.getAppVersionName());

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login) {
//            presenter.onLoginClick(etUser.getText().toString(), etPwd.getText().toString());
            LogUtils.d("点击了登录");
            if (StringUtils.isEmpty(etUser.getText().toString())) {
                ToastUtils.showShort("请输入用户名");
                return;
            }
            if (StringUtils.isEmpty(etPwd.getText().toString())) {
                ToastUtils.showShort("请输入密码");
                return;
            }
            try {
//                login(etUser.getText().toString().toUpperCase(), etPwd.getText().toString().toUpperCase());
                login(etUser.getText().toString().toUpperCase(),etPwd.getText().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else if (v.getId() == R.id.tvVersion) {
            LogUtils.d("点击了版本号");
            if (mHits == null) {
                mHits = new long[5];
            }

            //把从第二位至最后一位之间的数字复制到第一位至倒数第一位
            System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);

            mHits[mHits.length - 1] = SystemClock.uptimeMillis();//记录一个时间
            if (SystemClock.uptimeMillis() - mHits[0] <= 3000) {//3秒内连续点击。
                mHits = null;
//                if (!mSetIPShow) {
//                    String oldIp = application.getIP();
//                    TangramDialog dialog = new TangramDialog.Builder(LoginActivity.this)
//                            .title("输入ip或域名")
//                            .input("末尾不要加 /", oldIp, false, null)
//                            .positiveText("确定")
//                            .negativeText("取消")
//                            .onPositive(new ButtonCallback() {
//                                @Override
//                                public void onClick(@NonNull DialogBase dialog, @NonNull View v) {
//                                    String input = ((TangramDialog) dialog).getInputEditText().getText().toString();
//                                    LogUtils.d("222222",input);
//                                    SmartSharedPreferences.setIP(application, input);
//                                    application.setIP(input);
//                                }
//                            })
//                            .onNegative(new ButtonCallback() {
//                                @Override
//                                public void onClick(@NonNull DialogBase dialog, @NonNull View v) {
//                                    dialog.dismiss();
//                                }
//                            }).show();
//                    mSetIPShow = false;
//
//                } else {

//                    mSetIPShow = true;
//                }

            }
        } else if (v.getId() == R.id.iv_clear1) {
            etUser.setText("");
        } else if (v.getId() == R.id.iv_clear2) {
            if (!showPwd) {
                //显示
                showPwd = true;
                etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                iv_clear2.setBackgroundResource(R.drawable.eye_open);
            } else {
                //隐藏
                etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                showPwd = false;
                iv_clear2.setBackgroundResource(R.drawable.eye_close);
            }
        }
    }

    public void login(String name, final String pwd) throws JSONException {
        LogUtils.d("response222222 login");
        HashMap<String, String> map = new HashMap<>();
        map.put("loginid", name);
        map.put("password", pwd);
        map.put("imei", "android");
        String url = Constants.BASE_URL + Constants.LOGIN;
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        OkhttpUtil.okHttpPost(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222 onFailure ==" + e.toString());
                ToastUtils.showShort("登陆失败");
            }
            @Override
            public void onResponse(String response) {
                LogUtils.d("222222 onResponse==" + response);

                if (!response.isEmpty()) {
                    try {
                        LoginBean loginBean = JSONObject.parseObject(response, new TypeReference<LoginBean>() {});
                        if (loginBean.getErrcode().equals("USER-S-101")) {
                            SharedPreferencesUtil.setString(LoginActivity.this, "username", loginBean.getResult().getUserLoginDetails().getUserName());
                            SharedPreferencesUtil.setString(LoginActivity.this, "pwd", pwd);
                            SharedPreferencesUtil.setString(LoginActivity.this, "personId", loginBean.getResult().getUserLoginDetails().getPersonId());
                            SharedPreferencesUtil.saveObject(LoginActivity.this, "userLoginDetails", loginBean.getResult().getUserLoginDetails());
                            LogUtils.d("userLoginDetails=" + loginBean.getResult().getUserLoginDetails());

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            ToastUtils.showShort("登录成功");

                            finish();
                        } else {
                            ToastUtils.showShort(loginBean.getErrmsg());
                        }
                    }catch (com.alibaba.fastjson.JSONException exception){
                        ToastUtils.showShort(exception.toString());
                    }
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}