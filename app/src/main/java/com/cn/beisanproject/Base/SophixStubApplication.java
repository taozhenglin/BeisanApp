package com.cn.beisanproject.Base;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Keep;

import com.pgyer.pgyersdk.PgyerSDKManager;
import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixApplication;
import com.taobao.sophix.SophixEntry;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

/**
 * Created by tzl
 * on 2020/9/30
 */
public class SophixStubApplication extends SophixApplication {
    private final String TAG = "SophixStubApplication";
    // 此处SophixEntry应指定真正的Application，并且保证RealApplicationStub类名不被混淆。
    @Keep
    @SophixEntry(MyApplication.class)
    static class RealApplicationStub {}
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//         如果需要使用MultiDex，需要在此处调用。
//         MultiDex.install(this);
        initSophix();
    }
    private void initSophix() {
        String appVersion = "0.0.0";
        try {
            appVersion = this.getPackageManager()
                    .getPackageInfo(this.getPackageName(), 0)
                    .versionName;
        } catch (Exception e) {
        }
        final SophixManager instance = SophixManager.getInstance();
        instance.setContext(this)
                .setAppVersion(appVersion)
                .setSecretMetaData(null, null, null)
                .setEnableDebug(true)
                .setEnableFullLog()
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            Log.i(TAG, "sophix load patch success!");
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 如果需要在后台重启，建议此处用SharePreference保存状态。
                            Log.i(TAG, "sophix preload patch success. restart app to make effect.");
                        }
                    }
                }).initialize();
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        SophixManager.getInstance().queryAndLoadNewPatch();
        initPGY(this);
    }
    private void initPGY(SophixStubApplication sophixStubApplication) {
        String apiKey = "6fde8fad44da000ff7a1338ef5088d05";
        String frontJSToken = "c13f720272a2f5391728234a7a4049a4";
        try {
            new PgyerSDKManager.InitSdk()
                    .setContext(sophixStubApplication)
                    .setApiKey(apiKey)
                    .setFrontJSToken(frontJSToken)
                    .build();
        } catch (Exception e) {
            PgyerSDKManager.reportException(e);

        }

    }
}
