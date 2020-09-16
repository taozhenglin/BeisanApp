package com.cn.beisanproject.Utils;

import android.util.Log;

import com.cn.beisanproject.Base.Constants;

import java.util.Locale;

/**
 * Created by tzl on 2020/6/22.
 * log进行封装
 */

public class LogUtils {
    private static boolean isLogAll = Constants.DeBug;
    private static boolean LOGV = true;
    private static boolean LOGD = true;
    private static boolean LOGI = true;
    private static boolean LOGW = true;
    private static boolean LOGE = true;

    public static void v(String tag, String mess) {
        if (LOGV &&isLogAll) {
            Log.v(tag, mess); }
    }
    public static void d(String tag, String mess) {
        if (LOGD && isLogAll) {
            Log.d(tag, mess); }
    }
    public static void i(String tag, String mess) {
        if (LOGI && isLogAll) { Log.i(tag, mess); }
    }
    public static void w(String tag, String mess) {
        if (LOGW && isLogAll) { Log.w(tag, mess); }
    }
    public static void e(String tag, String mess) {
        if (LOGE && isLogAll) { Log.e(tag, mess); }
    }


//    public static void v(String mess) {
//        if (LOGV) { Log.v(getTag(), mess); }
//    }
//    public static void d(String mess) {
//        if (LOGD) { Log.d(getTag(), mess); }
//    }
//    public static void i(String mess) {
//        if (LOGI) { Log.i(getTag(), mess); }
//    }
//    public static void w(String mess) {
//        if (LOGW) { Log.w(getTag(), mess); }
//    }
//    public static void e(String mess) {
//        if (LOGE) { Log.e(getTag(), mess); }
//    }
//

    /**
     * 在调试程序时，我们会经常打印一些信息，
     * 包括方法名/行号之类的，下面一个方法就可以省去这些麻烦
     * @param mess
     */
    public static void v(String mess) {
        if (LOGV && isLogAll) { Log.v(getTag(), buildMessage(mess)); }
    }
    public static void d(String mess) {
        if (LOGD && isLogAll) { Log.d(getTag(), buildMessage(mess)); }
    }
    public static void i(String mess) {
        if (LOGI && isLogAll) { Log.i(getTag(), buildMessage(mess)); }
    }
    public static void w(String mess) {
        if (LOGW &&isLogAll) { Log.w(getTag(), buildMessage(mess)); }
    }
    public static void e(String mess) {
        if (LOGE && isLogAll) { Log.e(getTag(), buildMessage(mess)); }
    }


    private static String getTag() {
        StackTraceElement[] trace = new Throwable().fillInStackTrace()
                .getStackTrace();
        String callingClass = "";
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(LogUtils.class)) {
                callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass
                        .lastIndexOf('.') + 1);
                break;
            }
        }
        return callingClass;
    }


    private static String buildMessage(String msg) {
        StackTraceElement[] trace = new Throwable().fillInStackTrace()
                .getStackTrace();
        String caller = "";
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(LogUtils.class)) {
                caller = trace[i].getMethodName();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Thread.currentThread()
                .getId(), caller, msg);
    }

}
