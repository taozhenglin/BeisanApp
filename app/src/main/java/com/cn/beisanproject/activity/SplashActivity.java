package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.Base.MyApplication;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.adapter.AttachListAdapter;
import com.cn.beisanproject.modelbean.LoginBean;
import com.cn.beisanproject.modelbean.WaitDoListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;

    ImageView ivImage;
    TextView tvTime;
    LinearLayout llGuide;
    private Timer timer;
    int count = 3;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int arg1 = msg.arg1;

            if (arg1 > -1) {
                tvTime.setText(arg1 + "");
                LogUtils.d("222222arg1=" + arg1);
            }
            if (arg1 == 0) {
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
                String username = SharedPreferencesUtil.getString(mContext, "username");
                String pwd = SharedPreferencesUtil.getString(mContext, "pwd");
                LogUtils.d("222222 username = " + username + "pwd=" + pwd);
                if (!StringUtils.isEmpty(username)) {
                    login(username.toUpperCase(), pwd);
                } else {
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        ivImage = findViewById(R.id.iv_image);
        tvTime = findViewById(R.id.tv_time);
        llGuide = findViewById(R.id.ll_guide);
        llGuide.setOnClickListener(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
//        if (StringUtils.isEmpty(SharedPreferencesUtil.getString(MyApplication.applicationContext, "envirment"))) {
//        } else {
//            if (SharedPreferencesUtil.getString(MyApplication.applicationContext, "envirment").equals("测试")) {
//                Constants.BASE_URL="http://192.168.1.181:7009";
//                Constants. LOGIN="/login";
//                Constants. COMMONURL="http://192.168.1.181:7009/api";
//                Constants. COMMONSOAP="http://192.168.1.181:7009/WFSERVICE";
//                Constants. COMMONSOAP2="http://192.168.1.181:7009/MOBILESERVICE";
//            } else {
//
//            }
//        }
        mContext = MyApplication.getInstance();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                LogUtils.d("222222count="+count);
                if (count > -1) {
                    count -= 1;
                    Message message = handler.obtainMessage();
                    message.arg1 = count;
                    handler.sendMessage(message);
                }
            }
        }, 1500, 1000);
        queryData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    public void login(String name, final String pwd) {
        LogUtils.d("response222222 login");
        HashMap<String, String> map = new HashMap<>();
        map.put("loginid", name);
        map.put("password", pwd);
        map.put("imei", "android");
        String url = Constants.BASE_URL + Constants.LOGIN;
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
                ToastUtils.showShort("自动登陆失败");
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222 onResponse" + response);

                if (!response.isEmpty()) {
                    LoginBean loginBean = JSONObject.parseObject(response, new TypeReference<LoginBean>() {
                    });
                    if (loginBean.getErrcode().equals("USER-S-101")) {
                        SharedPreferencesUtil.setString(mContext, "username", loginBean.getResult().getUserLoginDetails().getUserName());
                        SharedPreferencesUtil.setString(mContext, "pwd", pwd);
                        SharedPreferencesUtil.setString(mContext, "personId", loginBean.getResult().getUserLoginDetails().getPersonId());
                        SharedPreferencesUtil.saveObject(mContext, "userLoginDetails", loginBean.getResult().getUserLoginDetails());
                        LogUtils.d("userLoginDetails=" + loginBean.getResult().getUserLoginDetails());

                        Intent intent = new Intent(mContext, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        ToastUtils.showShort(loginBean.getErrmsg());
                    }
                }

            }
        });

    }

    private void queryData() {
        /**
         * ---代办任务记录
         * {"appid":"WFASSIGNMENT","objectname":"WFASSIGNMENT","curpage":1,"showcount":20,"option":"read","orderby":"startdate desc",
         * "sqlSearch":"  exists (select personid from maxuser where loginid='HUYUE'
         * and wfassignment.assigncode=maxuser.personid)
         * and assignstatus='活动' and processname in('PO','RFQ','CONTPURCH','PRSUM','PR','GPDTZ','VENAPPLY','JLTZ','MATREQ','SBTZ','SSTZ','XMHT','UDXMHTBG','PRPROJ','XBJ','PROJSUM','XXHTZ','CONTRACTPO','INVUSEZY')"}
         */
        LogUtils.d("query");
        JSONObject object = new JSONObject();
        object.put("appid", "WFASSIGNMENT");
        object.put("objectname", "WFASSIGNMENT");
        object.put("curpage", 0);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "startdate desc");
        String sqlSearch = " exists (select personid from maxuser where loginid=%s " +
                "and wfassignment.assigncode=maxuser.personid)  " +
                "and assignstatus='活动' and processname in('PO','RFQ','CONTPURCH','PRSUM','PR','GPDTZ','VENAPPLY','JLTZ','MATREQ','SBTZ','SSTZ','XMHT','UDXMHTBG','PRPROJ','XBJ','PROJSUM','XXHTZ','CONTRACTPO','INVUSEZY','UDFIXYSRG','UDFIXBF','UDFIXZZ','UDPRYS')";
        sqlSearch = String.format(sqlSearch, "'" + SharedPreferencesUtil.getString(mContext, "personId") + "'");
        object.put("sqlSearch", sqlSearch);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(Constants.COMMONURL, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure=" + e.toString());
            }

            @Override
            public void onResponse(String response) {
                LogUtils.longD("onResponse==" ,response);

                WaitDoListBean waitDoListBean = null;
                if (!response.isEmpty()) {
                    if (response.startsWith("Error")) {
                        ToastUtils.showShort(R.string.GETDATAFAILED);
                    } else {
                        waitDoListBean = JSONObject.parseObject(response, new TypeReference<WaitDoListBean>() {
                        });
                        if (waitDoListBean.getErrcode().equals("GLOBAL-S-0")) {
                            int totalresult = waitDoListBean.getResult().getTotalresult();
                            LogUtils.d("totalresult==" + totalresult);
                            SharedPreferencesUtil.setInt(SplashActivity.this, "waitdototalresult", totalresult);
                        }
                    }
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        String username = SharedPreferencesUtil.getString(mContext, "username");
        String pwd = SharedPreferencesUtil.getString(mContext, "pwd");
        LogUtils.d("222222 username = " + username + "  pwd=" + pwd);
        if (!StringUtils.isEmpty(username)) {
            login(username.toUpperCase(), pwd);
        } else {
            Intent intent = new Intent(mContext, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
