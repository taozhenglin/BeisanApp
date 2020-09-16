package com.cn.beisanproject.Utils;

import android.os.Build;

public class DevicesUtil {
  static   String   model;
    static String   carrier;
    public static String getDevicesType(){
        model= android.os.Build.MODEL;//手机型号
        carrier= Build.MANUFACTURER;//手机厂商
        LogUtils.d("model== "+model + "       carrie=r="+carrier);
        return carrier;
    }
}
