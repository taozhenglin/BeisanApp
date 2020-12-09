package com.cn.beisanproject.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.modelbean.AssertScanDetailResult;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.StockScanDetailResult;
import com.cn.beisanproject.modelbean.StockingLineListBean;
import com.cn.beisanproject.modelbean.StockingTakeListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import okhttp3.Call;

/**
 * created by tzl for 库存盘点详情之扫码
 */
public class StockCheckScanActivity extends AppCompatActivity implements QRCodeView.Delegate, View.OnClickListener {
    private ZXingView mZXingView;
    private LinearLayout ll_back;
    private TextView tv_common_title;
    private TextView tv_pici_no;
    private TextView tv_count;
    List<String> list;
    private ImageView iv_fun;
    private boolean close = true;
    private PopupWindow pop;
    private TextView tv_finish;
    private String from;
    private List<StockingLineListBean.ResultBean.ResultlistBean> resultlist;
    private LinearLayout ll_button;
    private List<JSONObject> jsonlist;
    private StockingTakeListBean.ResultBean.ResultlistBean mResultlistBean;
    private LoadingDialog ld;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_scan_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ld = new LoadingDialog(this);

        if (!StringUtils.isEmpty(getIntent().getStringExtra("from"))) {
            from = getIntent().getStringExtra("from");
            LogUtils.d("222222from=" + from);
        }
        if (getIntent().getExtras().get("mResultlistBean") != null) {
            mResultlistBean = (StockingTakeListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("mResultlistBean");
        }
        mZXingView = findViewById(R.id.zxingview);
        mZXingView.setDelegate(this);
        ll_back = findViewById(R.id.ll_back);
        ll_back.setOnClickListener(this);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("库存盘点");
        iv_fun = findViewById(R.id.iv_fun);
        ll_button = findViewById(R.id.ll_button);
        iv_fun.setBackground(getResources().getDrawable(R.drawable.light));
        iv_fun.setOnClickListener(this::onClick);
        if (!StringUtils.isEmpty(from) && from.equals("PersonalCenterFragment")) {
            tv_common_title.setText("扫一扫");
            ll_button.setVisibility(View.GONE);
        } else {
            //获取所有明细行列表数据
            getStockLine();
        }
//        if (resultlist != null) {
//            LogUtils.d("222222resultlist = " + resultlist);
//        } else {
//            LogUtils.d("222222resultlist = null");
//        }
        tv_pici_no = findViewById(R.id.tv_pici_no);
        tv_count = findViewById(R.id.tv_count);
        tv_finish = findViewById(R.id.tv_finish);
        tv_finish.setOnClickListener(this);
        list = new ArrayList<>();
        jsonlist = new ArrayList<>();
        String s="^XA^CW1,E:ANMDS.TTF^FS^CI28^PA0,1,1,1^FT50,42^A1,25,25^FDWhat is Unicode?^FS^FT50,88^A1,25,25^FD什麽是Unicode(統一碼)? in Traditional Chinese^FS^FT50,134^A1,25,25^FD什么是Unicode(统一码)? in Simplified Chinese^FS^FT50,180^A1,25,25^FDユニコードとは何か？in Japanese^FS^FT50,226^A1,25,25^FD유니코드에 대해? in Korean^FS^FT50,272^A1,25,25^FDUnicode คืออะไร? in Thai^FS^FT50,318^A1,25,25^FDUnicode là gì? in Vietnamese^FS^FT50,364^A1,25,25^FDما هي الشفرة الموحدة \"يونِكود\" ؟ in Arabic^FS^XZ";

    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        LogUtils.d("222222", "result:" + result);
        //来自个人中心只是展示
        if (!StringUtils.isEmpty(from) && from.equals("PersonalCenterFragment")) {
            if (result.startsWith("B1")) {//库存盘点展示
                LogUtils.d("222222 result.startsWith  B1");

                getStockDetail(result);

            } else if (result.startsWith("A1")) {//固定资产展示

                getAssertDetail(result);

            } else {
                mZXingView.startSpot(); // 开始识别
                mZXingView.startCamera();
            }
        }
        //来自库存盘点
        else {

            if (result.startsWith("B1")) {
                tv_pici_no.setText("批次号：" + result);
                for (int i = 0; i < resultlist.size(); i++) {
                    //BSJS30453-1-20190619
                    if (resultlist.get(i).getUDLOTNUM().equals(result)) {
                        LogUtils.d("222222 resultlist.get(i).getLOTNUM().equals(result)");
                        list.add(result);
                        tv_count.setText("本次盘点数量合计：" + list.size());

                    }
                }
                tv_finish.setText("结束盘点 " + "(" + list.size() + ")");

                if (list.size() > 0) {//如果匹配上了
                    LogUtils.d("222222 list.size() > 0");
                    mZXingView.stopCamera();
                    vibrate();
                    showRemarkPopupwindow3(resultlist, result);
                } else {//如果没有
                    LogUtils.d("222222 list.size() = 0");
                    mZXingView.startSpot(); // 开始识别
                    mZXingView.startCamera();
                }


            } else {// 如果不是来自库存盘点 则继续扫描
                mZXingView.startSpot(); // 开始识别
                mZXingView.startCamera();
            }
        }


    }

    private void getAssertDetail(String result) {
        ld.show();
        /**
         * -- 固定资产台账RFID扫码查询
         *
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"FIXEDASSETCARD","objectname":"FIXEDASSETCARD","curpage":1,"showcount":20,"option":"read","orderby":"","sqlSearch":" RFIDNUM=:RFIDNUM "}
         */
        LogUtils.d("query==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "FIXEDASSETCARD");
        object.put("objectname", "FIXEDASSETCARD");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        object.put("sqlSearch", " RFIDNUM= " + "'" + result + "'");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure=" + e.toString());
                ld.close();
                mZXingView.startSpot(); // 开始识别
                mZXingView.startCamera();
                mZXingView.showScanRect();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse=" + response);
                ld.close();
                AssertScanDetailResult asserScanResult;
                if (!response.isEmpty()) {
                    asserScanResult = JSONObject.parseObject(response, new TypeReference<AssertScanDetailResult>() {
                    });
                    if (asserScanResult.getErrcode().equals("GLOBAL-S-0")) {
                        if (asserScanResult.getResult().getResultlist().size() > 0) {
                            mZXingView.stopCamera();
                            vibrate();
                            showAssertPopupwindow(asserScanResult.getResult().getResultlist().get(0));

                        }

                    }

                }

            }


        });
    }


    private void getStockDetail(String result) {
        ld.show();
        /**
         * 通用扫码-物资
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"INVBALANCES","objectname":"INVBALANCES","option":"read","sqlSearch":" UDTOLOT=:扫到的码 "}
         */
        LogUtils.d("222222query==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "INVBALANCES");
        object.put("objectname", "INVBALANCES");
        object.put("option", "read");
        object.put("sqlSearch", " UDLOTNUM= " + "'" + result + "'");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure=" + e.toString());
                ld.close();
                mZXingView.startSpot(); // 开始识别
                mZXingView.startCamera();
                mZXingView.showScanRect();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse=" + response);
                ld.close();
                StockScanDetailResult stockScanDetailResult;
                if (!response.isEmpty()) {
                    stockScanDetailResult = JSONObject.parseObject(response, new TypeReference<StockScanDetailResult>() {});
                    if (stockScanDetailResult.getErrcode().equals("GLOBAL-S-0")) {
                        if (stockScanDetailResult.getResult().size()>0) {
                            mZXingView.stopCamera();
                            vibrate();
                            showStockPopupwindow(stockScanDetailResult.getResult().get(0));
                        }

                    }

                }

            }


        });
    }


    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mZXingView.startCamera(); // 打开后置摄像头开始预览，但是并未开始识别
//        mZXingView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT); // 打开前置摄像头开始预览，但是并未开始识别
        mZXingView.changeToScanBarcodeStyle(); // 切换成扫描条码样式
        mZXingView.setType(BarcodeType.ONE_DIMENSION, null); // 只识别一维条码
        mZXingView.startSpotAndShowRect(); // 显示扫描框，并开始识别
    }

    @Override
    protected void onStop() {
        mZXingView.stopCamera(); // 关闭摄像头预览，并且隐藏扫描框
        mZXingView.closeFlashlight(); // 关闭闪光灯
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mZXingView.onDestroy(); // 销毁二维码扫描控件
        mZXingView.closeFlashlight(); // 关闭闪光灯

        super.onDestroy();
    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {
// 这里是通过修改提示文案来展示环境是否过暗的状态，接入方也可以根据 isDark 的值来实现其他交互效果
        String tipText = mZXingView.getScanBoxView().getTipText();
        String ambientBrightnessTip = "\n环境过暗，请打开闪光灯";
        if (isDark) {
            if (!tipText.contains(ambientBrightnessTip)) {
                mZXingView.getScanBoxView().setTipText(tipText + ambientBrightnessTip);
            }
        } else {
            if (tipText.contains(ambientBrightnessTip)) {
                tipText = tipText.substring(0, tipText.indexOf(ambientBrightnessTip));
                mZXingView.getScanBoxView().setTipText(tipText);
            }
        }
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        LogUtils.d("222222", "打开相机出错");
    }

    public boolean hasPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    public void requestPermission() {
        //申请WRITE_EXTERNAL_STORAGE权限
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                if (list.size() > 0) {
                    if (pop!=null&&pop.isShowing()){
                        pop.dismiss();
                    }
                    showWarmPopupwindow();

                } else
                    finish();
                break;
            case R.id.tv_finish:
                //上传扫描结果
                if (list.size() > 0) {
                    Notify();
                }else {
                    ToastUtils.showShort("没有可上传数据，请扫描盘点");
                }
//                PostData data = new PostData();
//                data.setTag("库存盘点");
//                data.setStringList(list);
//                EventBus.getDefault().post(data);

                break;
            case R.id.iv_fun:
                if (close) {
                    mZXingView.openFlashlight(); // 打开闪光灯
                    close = false;
                } else {
                    mZXingView.closeFlashlight(); // 关闭闪光灯
                    close = true;
                }
                break;
        }
    }

    @SuppressLint("WrongConstant")
    private void showWarmPopupwindow() {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View inflate = LayoutInflater.from(this).inflate(R.layout.check_exit_warm_dialog, null);
        pop = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(false);// 点击空白处时，隐藏掉pop窗口
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
//                setBackgroundAlpha(1.0f);
            }
        });
        TextView title_tv = inflate.findViewById(R.id.title_tv);
        TextView tv_go = inflate.findViewById(R.id.tv_go);
        TextView tv_close = inflate.findViewById(R.id.tv_close);
        title_tv.setText("您有" + list.size() + "条数据未上传 是否继续退出？");
        tv_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
                mZXingView.startSpot(); // 开始识别
                mZXingView.startCamera();
                mZXingView.showScanRect();


            }
        });
        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
                finish();

            }
        });
    }

    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow3(List<StockingLineListBean.ResultBean.ResultlistBean> list, String result) {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.stock_check_detail_dialog, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(false);// 点击空白处时，隐藏掉pop窗口
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
//                setBackgroundAlpha(1.0f);
            }
        });
        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
        TextView tv_go = (TextView) remarkView.findViewById(R.id.tv_go);
        TextView tv_close = (TextView) remarkView.findViewById(R.id.tv_close);
        tv_go.setText("继续盘点");
        tv_close.setText("取消");
        TextView tv_line_no = remarkView.findViewById(R.id.tv_line_no);
        TextView tv_product_location = remarkView.findViewById(R.id.tv_product_location);
        TextView tv_line_batch = remarkView.findViewById(R.id.tv_line_batch);
        TextView tv_prodution_no = remarkView.findViewById(R.id.tv_prodution_no);
        TextView tv_prodution_desc = remarkView.findViewById(R.id.tv_prodution_desc);
        TextView tv_tag_id = remarkView.findViewById(R.id.tv_tag_id);
        TextView tv_stock_count = remarkView.findViewById(R.id.tv_stock_count);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUDLOTNUM().equals(result)) {
                LogUtils.d("222222 list.get(i).getUDLOTNUM().equals(result");

                tv_line_no.setText("明细行序号:" + list.get(i).getLINENUM());
                tv_product_location.setText("货位:" + list.get(i).getBINNUM());
                tv_line_batch.setText("批次:" + list.get(i).getLOTNUM());
                tv_prodution_no.setText("物资编码:" + list.get(i).getITEMNUM());
                tv_prodution_desc.setText("物资描述:" + list.get(i).getITEMNUMDESC());
                tv_stock_count.setText("库存数量:" + list.get(i).getYPQUANTITY());
                tv_tag_id.setText("唯一标识码:" + result);
            }
        }
        tv_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mZXingView.startSpot(); // 开始识别
                mZXingView.startCamera();
                mZXingView.showScanRect();
                pop.dismiss();

            }
        });

        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();

            }
        });
    }

    @SuppressLint("WrongConstant")
    private void showStockPopupwindow(StockScanDetailResult.ResultBean resultBean) {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.stock_check_detail_dialog2, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(false);// 点击空白处时，隐藏掉pop窗口
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
//                setBackgroundAlpha(1.0f);
            }
        });
        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
        title_tv.setText("物资详情");
        TextView tv_go = (TextView) remarkView.findViewById(R.id.tv_go);
        TextView tv_close = (TextView) remarkView.findViewById(R.id.tv_close);
        tv_go.setText("继续");
        tv_close.setText("取消");
        TextView tv_line_no = remarkView.findViewById(R.id.tv_line_no);
        TextView tv_product_location = remarkView.findViewById(R.id.tv_product_location);
        TextView tv_line_batch = remarkView.findViewById(R.id.tv_line_batch);
        TextView tv_prodution_no = remarkView.findViewById(R.id.tv_prodution_no);
        TextView tv_prodution_desc = remarkView.findViewById(R.id.tv_prodution_desc);
        TextView tv_stock_count = remarkView.findViewById(R.id.tv_stock_count);
        TextView tv_vendor = remarkView.findViewById(R.id.tv_vendor);
        TextView tv_vendor_name = remarkView.findViewById(R.id.tv_vendor_name);
        TextView tv_store_count = remarkView.findViewById(R.id.tv_store_count);
        TextView tv_store_location = remarkView.findViewById(R.id.tv_store_location);
        tv_line_no.setText("货位：" + resultBean.getBINNUM());
        tv_line_batch.setText("物资编码：" + resultBean.getITEMNUM());
        tv_product_location.setText("批次：" + resultBean.getLOTNUM());
        tv_prodution_no.setText("物资描述：" + resultBean.getITEMDESC());
        tv_prodution_desc.setText("库存数量：" + resultBean.getCURBAL());
        tv_stock_count.setVisibility(View.GONE);
        tv_vendor.setVisibility(View.GONE);
        tv_vendor_name.setVisibility(View.GONE);
        tv_store_count.setVisibility(View.GONE);
        tv_store_location.setVisibility(View.GONE);



        tv_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mZXingView.startSpot(); // 开始识别
                mZXingView.startCamera();
                mZXingView.showScanRect();
                pop.dismiss();

            }
        });

        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                finish();
            }
        });
    }

    /**
     * 固定资产 弹框 扫一扫
     *
     * @param resultlistBean
     */
    @SuppressLint("WrongConstant")
    private void showAssertPopupwindow(AssertScanDetailResult.ResultBean.ResultlistBean resultlistBean) {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.assert_scan_detail_dialog, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(false);// 点击空白处时，隐藏掉pop窗口
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
//                setBackgroundAlpha(1.0f);
            }
        });
        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
        TextView tv_assert_no = (TextView) remarkView.findViewById(R.id.tv_assert_no);
        TextView tv_assert_name = (TextView) remarkView.findViewById(R.id.tv_assert_name);
        TextView tv_assert_type = (TextView) remarkView.findViewById(R.id.tv_assert_type);
        TextView tv_assert_xh = (TextView) remarkView.findViewById(R.id.tv_assert_xh);
        TextView tv_assert_statues = (TextView) remarkView.findViewById(R.id.tv_assert_statues);
        TextView tv_assert_count = (TextView) remarkView.findViewById(R.id.tv_assert_count);
        TextView tv_management = (TextView) remarkView.findViewById(R.id.tv_management);
        TextView tv_count_unit = (TextView) remarkView.findViewById(R.id.tv_count_unit);
        TextView tv_jjyt = (TextView) remarkView.findViewById(R.id.tv_jjyt);
        TextView tv_department = (TextView) remarkView.findViewById(R.id.tv_department);
        TextView tv_syqk = (TextView) remarkView.findViewById(R.id.tv_syqk);
        TextView tv_buy_time = (TextView) remarkView.findViewById(R.id.tv_buy_time);
        TextView tv_cfdd = (TextView) remarkView.findViewById(R.id.tv_cfdd);

        title_tv.setText("固定资产详情");
        tv_assert_no.setText("固定资产编码:" + resultlistBean.getCWBM());
        tv_assert_name.setText("固定资产名称:" + resultlistBean.getDESCRIPTION());
        tv_assert_type.setText("固定资产类别:" + resultlistBean.getASSETTYPE());
        tv_assert_xh.setText("固定资产型号" + resultlistBean.getPRODUCTMODEL());
        tv_assert_statues.setText("状态:" + resultlistBean.getSTATUS());
        tv_assert_count.setText("资产数量:" + resultlistBean.getAMOUNT());
        tv_management.setText("项目主办部门:" + resultlistBean.getMANAGEMENT());
        tv_count_unit.setText("计量单位:" + resultlistBean.getUNITS());
        tv_jjyt.setText("经济用途:" + resultlistBean.getJJYT());
        tv_department.setText("使用部门:" + resultlistBean.getDEPARTMENT());
        tv_syqk.setText("使用情况:" + resultlistBean.getSYQK());
        tv_buy_time.setText("购买日期:" + resultlistBean.getDATEOFPURCHASE());
        tv_cfdd.setText("存放地点:" + resultlistBean.getCFDD());

        TextView tv_go = (TextView) remarkView.findViewById(R.id.tv_go);
        TextView tv_close = (TextView) remarkView.findViewById(R.id.tv_close);
        tv_go.setText("继续");
        tv_close.setText("取消");
        tv_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mZXingView.startSpot(); // 开始识别
                mZXingView.startCamera();
                mZXingView.showScanRect();
                pop.dismiss();

            }
        });

        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                finish();
            }
        });

    }

    public void Notify() {
        LogUtils.d("222222", "Notify");
        LogUtils.d("222222", "stringList= " + list);
        if (resultlist != null && resultlist.size() > 0) {
            for (int i = 0; i < resultlist.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (resultlist.get(i).getUDLOTNUM().equals(list.get(j))) {
                        String STOCKNUM = resultlist.get(i).getSTOCKNUM();
                        String UDLOTNUM = resultlist.get(i).getUDLOTNUM();
                        if (StringUtils.isEmpty(SharedPreferencesUtil.getString(this, resultlist.get(i).getUDLOTNUM()))) {
                            String fristStringSP = resultlist.get(i).getSPQUANTITY();
                            int fristIntSP = (int) Double.parseDouble(fristStringSP) + 1;
                            SharedPreferencesUtil.setString(this, resultlist.get(i).getUDLOTNUM(), fristIntSP + "");
                        } else {
                            String SPQUANTITY = SharedPreferencesUtil.getString(this, resultlist.get(i).getUDLOTNUM());
                            int SP = (int) Double.parseDouble(SPQUANTITY) + 1;
                            SharedPreferencesUtil.setString(this, resultlist.get(i).getUDLOTNUM(), SP + "");

                        }

                        String CYQUANTITY = resultlist.get(i).getCYQUANTITY();
                        String TYPE = "update";

                        JSONObject object = new JSONObject();
                        object.put("STOCKNUM", STOCKNUM);
                        object.put("UDLOTNUM", UDLOTNUM);
                        object.put("SPQUANTITY", SharedPreferencesUtil.getString(this, resultlist.get(i).getUDLOTNUM()));
                        object.put("CYQUANTITY", CYQUANTITY);
                        object.put("TYPE", TYPE);
                        jsonlist.add(object);
                    }
                }

            }
            if (jsonlist.size() > 0) {
                upLoad(mResultlistBean.getSTOCKNUM());

            }

        }


    }

    private void upLoad(String stocknum) {
        LogUtils.d("222222", "upLoad");
        ld.show();
/**
 *
 *
 * 裴蓉蓉 8-20 08:52:30
 * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
 *    <soap:Header/>
 *    <soap:Body>
 *       <max:mobileserviceUpdateMbo creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
 *          <max:json>
 *            {"relationShip" : [{"STOCKLINE" :""}],"STOCKLINE" : [
 *            {"STOCKNUM":"1004","UDLOTNUM":"W100000000021","SPQUANTITY":"4","CYQUANTITY":"-4","TYPE":"update"};
 *            {"STOCKNUM":"1004","UDLOTNUM":"W100000000022","SPQUANTITY":"1","CYQUANTITY":"-1","TYPE":"update"} ]}
 *          </max:json>
 *          <max:mboObjectName>UDSTOCK</max:mboObjectName>
 *          <max:mboKey>STOCKNUM</max:mboKey>
 *          <max:mboKeyValue>1004</max:mboKeyValue>
 *       </max:mobileserviceUpdateMbo>
 *    </soap:Body>
 * </soap:Envelope>
 */
        String request = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:mobileserviceUpdateMbo creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:json>\n" +
                "         %s \n" +
                "         </max:json>\n" +
                "         <max:mboObjectName>UDSTOCK</max:mboObjectName>\n" +
                "         <max:mboKey>STOCKNUM</max:mboKey>\n" +
                "         <max:mboKeyValue>%s</max:mboKeyValue>\n" +
                "      </max:mobileserviceUpdateMbo>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");

        JSONArray array1 = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("STOCKLINE", "");
        array1.add(obj);

        JSONArray array2 = new JSONArray();
        array2.addAll(jsonlist);

        JSONObject object = new JSONObject();
        object.put("relationShip", array1);
        object.put("STOCKLINE", array2);
        String request1 = String.valueOf(object);
        request = String.format(request, request1, stocknum);

        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP2, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure" + e.toString());
                ToastUtils.showShort(R.string.upLoadfailed);
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse222222" + response);
                ld.close();
                if (response.contains("<return>") && response.contains("</return>")) {
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                    });
                    if (startWorkProcessBean.getErrorNo() == 0 && startWorkProcessBean.getSuccess().equals("成功")) {
                        ToastUtils.showShort(startWorkProcessBean.getSuccess());
                        PostData data = new PostData();
                        data.setTag("stock check scuess");
                        EventBus.getDefault().post(data);
                        list.clear();
                        LogUtils.d("222222 list.size()" + list.size());
                        finish();
                    } else {
                        ToastUtils.showShort(startWorkProcessBean.getErrorMsg());
                    }
                }
            }
        });

    }

    /**
     * --库存盘点明细查询
     * http://192.168.1.180:7009/maximo/mobile/common/api?data=
     * {"appid":"UDSTOCKLINE","objectname":"UDSTOCKLINE","curpage":1,"showcount":20,"option":"read","orderby":"LINENUM asc","sqlSearch":" stocknum=:stocknum "}
     */
    private void getStockLine() {
        ld.show();
        LogUtils.d("getStockLine");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "UDSTOCKLINE");
        object.put("objectname", "UDSTOCKLINE");
        object.put("curpage", 0);
        object.put("showcount", 999);
        object.put("option", "read");
        object.put("orderby", "LINENUM asc");
        String sqlSearch = "stocknum=" + mResultlistBean.getSTOCKNUM();
        object.put("sqlSearch", sqlSearch);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure=" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse=" + response);
                ld.close();
                StockingLineListBean stockingLineListBean;
                if (!response.isEmpty()) {
                    stockingLineListBean = JSONObject.parseObject(response, new TypeReference<StockingLineListBean>() {
                    });

                    if (stockingLineListBean.getErrcode().equals("GLOBAL-S-0")) {
                        resultlist = stockingLineListBean.getResult().getResultlist();
                    }
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (list.size() > 0) {
            if (pop!=null&&pop.isShowing()){
                pop.dismiss();
            }
            showWarmPopupwindow();

        } else
            finish();
    }
}
