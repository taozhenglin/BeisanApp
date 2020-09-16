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
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.modelbean.LoginBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.yinglan.keyboard.HideUtil;

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
        LogUtils.d("222222 uesrname = "+SharedPreferencesUtil.getString(this, "username"));
        LogUtils.d("222222 pwd = "+SharedPreferencesUtil.getString(this, "pwd"));

        etUser.setText(SharedPreferencesUtil.getString(this, "username"));
        etPwd.setText(SharedPreferencesUtil.getString(this, "pwd"));
    }

    private void initEvent() {
        btnLogin.setOnClickListener(this);
        tvVersion.setOnClickListener(this);
        iv_clear1.setOnClickListener(this);
        iv_clear2.setOnClickListener(this);
    }

    private void initView() {
        btnLogin = (Button) findViewById(R.id.login);
        etUser = findViewById(R.id.username);
        etPwd = findViewById(R.id.password);
        pb = findViewById(R.id.loading);
        tvVersion = findViewById(R.id.tvVersion);
        iv_clear1 = findViewById(R.id.iv_clear1);
        iv_clear2 = findViewById(R.id.iv_clear2);

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
            if (StringUtils.isEmpty(etUser.getText().toString())){
                ToastUtils.showShort("请输入用户名");
                return;
            }
            if (StringUtils.isEmpty(etPwd.getText().toString())){
                ToastUtils.showShort("请输入密码");
                return;
            }
            try {
                login(etUser.getText().toString().toUpperCase(), etPwd.getText().toString().toUpperCase());
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
        String url = Constants.BASE_URL+Constants.LOGIN;
        JSONObject object = new JSONObject();
//        object.put("loginid", name);
//        object.put("password", pwd);
//        object.put("imei", "android");

        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        OkhttpUtil.okHttpPost(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222 onFailure " + e.toString());
                ToastUtils.showShort("登陆失败");

            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222 onResponse" + response);

                if (!response.isEmpty()) {
                    LoginBean loginBean = JSONObject.parseObject(response, new TypeReference<LoginBean>() {});
                    if (loginBean.getErrcode().equals("USER-S-101")) {
                        SharedPreferencesUtil.setString(LoginActivity.this, "username", loginBean.getResult().getUserLoginDetails().getUserName());
                        SharedPreferencesUtil.setString(LoginActivity.this,"pwd",pwd);
                        SharedPreferencesUtil.setString(LoginActivity.this,"personId",loginBean.getResult().getUserLoginDetails().getPersonId());
                        SharedPreferencesUtil.saveObject(LoginActivity.this,"userLoginDetails",loginBean.getResult().getUserLoginDetails());
                        LogUtils.d("userLoginDetails="+loginBean.getResult().getUserLoginDetails());

                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        ToastUtils.showShort(loginBean.getErrmsg());
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