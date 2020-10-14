package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.modelbean.AssertScanDetailResult;
import com.cn.beisanproject.modelbean.StockScanDetailResult;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import java.io.Serializable;
import java.util.HashMap;

import okhttp3.Call;

/**
 * 斑马  扫一扫
 */
public class StockScanZerbaActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout ll_back;
    private TextView tv_common_title;
    ImageView iv_fun;
    //定义Intent的操作字串
    private String INTENT_ACTION = "com.symbol.mybroadcast";
    //定义Intent的类别字串
    private String INTENT_CATEGORY = "com.symbol.category.DEFAULT";

    //API中定义，通过Intent捕获到的Datawedge返回的条码数据字串名
    private String DATA_STRING_TAG = "com.symbol.datawedge.data_string";

    String softScanTrigger = "com.symbol.datawedge.api.ACTION";
    String extraData = "com.symbol.datawedge.api.SOFT_SCAN_TRIGGER";

    private boolean flag;
    private Button bstart;
    private Button bstop;
    private int interval;
    private LoadingDialog ld;
    private PopupWindow pop;
    private LinearLayout ll_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_scan_for_zebra_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ll_back = findViewById(R.id.ll_back);
        ll_back.setOnClickListener(this);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("扫一扫");
        iv_fun = findViewById(R.id.iv_fun);
        ll_button= findViewById(R.id.ll_button);
        ll_button.setVisibility(View.GONE);
        //添加对Datawedge数据Intent的捕获
        IntentFilter filter = new IntentFilter();
        filter.addAction(INTENT_ACTION);
        filter.addCategory(INTENT_CATEGORY);
        registerReceiver(receiver, filter);

//        TextView tv = (TextView) findViewById(R.id.textView);
//        tv.setText("ready");

        BarcodeInputSetting();
        IntentOutputPluginConfiguration();
        KeystrokeOutputPluginConfiguration();
        SwitchToProfile();
        flag = false;
        ld = new LoadingDialog(this);

    }

    /*
     * 对条码扫描的输入部分进行设置  ，本函数中设置的参数均属于DataWedge中配置文件的“条码输入”部分
     */
    public void BarcodeInputSetting() {

        Bundle bMain = new Bundle();
        Bundle bConfig = new Bundle();
        Bundle bParams = new Bundle();

        bParams.putString("scanner_selection", "auto");            //设置“扫描器选择”选项为自动
        bParams.putString("scanner_input_enabled", "true");        //启用扫描器输入
        //bParams.putString("decode_audio_feedback_uri","content://media/internal/audio/media/72");	//设置解码反馈的声音为静音
        //bParams.putString("aim_type","5");						//设置扫描模式为连扫，即在按下扫码键不放的情况下，设备连续读取条码


        bConfig.putBundle("PARAM_LIST", bParams);                //赋值参数组
        bConfig.putString("PLUGIN_NAME", "BARCODE");                //声明以上参数均属于“条码输入”部分
        bConfig.putString("RESET_CONFIG", "true");                //设置前重置该部分原参数，以排除用户在设备上手动修改DataWedge参数可能带来的意外情况

        bMain.putBundle("PLUGIN_CONFIG", bConfig);                //赋值配置对象
        bMain.putString("PROFILE_NAME", "DEMO");                    //定义要修改的DataWedge的配置文件名称
        bMain.putString("PROFILE_ENABLED", "true");                //启用该配置文件
        bMain.putString("CONFIG_MODE", "CREATE_IF_NOT_EXIST");    //如果该名称的配置文件不存在，则创建一个该名称的配置文件

        Intent i = new Intent();
        i.setAction("com.symbol.datawedge.api.ACTION");                //声明该Intent的操作是属于DataWedge的API操作，以便于设备后台系统捕捉并处理
        i.putExtra("com.symbol.datawedge.api.SET_CONFIG", bMain);    //声明调用的API为set config部分
        i.putExtra("SEND_RESULT", "true");                            //启用结果发送
        i.putExtra("COMMAND_IDENTIFIER", "BARCODE_SETTING_API");    //设置发送结果标识
        this.sendBroadcast(i);
    }

    /*
     * 对Intent部分进行设置  ，本函数中设置的参数均属于DataWedge中配置文件的“Intent输出”部分
     */
    public void IntentOutputPluginConfiguration() {

        Bundle bMain = new Bundle();
        Bundle bConfig = new Bundle();
        Bundle bParams = new Bundle();

        bParams.putString("intent_output_enabled", "true");                    //启用Intent输出
        bParams.putString("intent_action", "com.symbol.mybroadcast");        //设置Intent操作字串
        bParams.putString("intent_category", "com.symbol.category.DEFAULT");    //设置Intent类别
        bParams.putInt("intent_delivery", 2);                                //设置Intent交付方式为广播

        bConfig.putBundle("PARAM_LIST", bParams);                            //赋值参数组
        bConfig.putString("PLUGIN_NAME", "INTENT");                            //声明以上参数均属于“条码输入”部分
        bConfig.putString("RESET_CONFIG", "true");                            //设置前重置该部分原参数，以排除用户在设备上手动修改DataWedge参数可能带来的意外情况


        bMain.putBundle("PLUGIN_CONFIG", bConfig);                            //赋值配置对象
        bMain.putString("PROFILE_NAME", "DEMO");                                //定义要修改的DataWedge的配置文件名称
        bMain.putString("PROFILE_ENABLED", "true");                            //启用该配置文件
        bMain.putString("CONFIG_MODE", "CREATE_IF_NOT_EXIST");                //如果该名称的配置文件不存在，则创建一个该名称的配置文件

        Intent i = new Intent();
        i.setAction("com.symbol.datawedge.api.ACTION");                        //声明该Intent的操作是属于DataWedge的API操作，以便于设备后台系统捕捉并处理
        i.putExtra("com.symbol.datawedge.api.SET_CONFIG", bMain);            //声明调用的API为set config部分
        i.putExtra("SEND_RESULT", "true");                                    //启用结果发送
        i.putExtra("COMMAND_IDENTIFIER", "INTENT_API");                        //设置发送结果标识
        this.sendBroadcast(i);
    }

    /*
     * 对按键输出进行设置  ，本函数中设置的参数均属于DataWedge中配置文件的“按键输出”部分
     */
    public void KeystrokeOutputPluginConfiguration() {

        Bundle bMain = new Bundle();
        Bundle bConfig = new Bundle();
        Bundle bParams = new Bundle();

        bParams.putString("keystroke_output_enabled", "false");                //禁用按键输出，即扫描数据的键盘模拟输出方式

        bConfig.putBundle("PARAM_LIST", bParams);                            //赋值参数组
        bConfig.putString("PLUGIN_NAME", "KEYSTROKE");                        //声明以上参数均属于“按键输出”部分
        bConfig.putString("RESET_CONFIG", "true");                            //设置前重置该部分原参数，以排除用户在设备上手动修改DataWedge参数可能带来的意外情况

        bMain.putBundle("PLUGIN_CONFIG", bConfig);                            //赋值配置对象
        bMain.putString("PROFILE_NAME", "DEMO");                                //定义要修改的DataWedge的配置文件名称
        bMain.putString("PROFILE_ENABLED", "true");                            //启用该配置文件
        bMain.putString("CONFIG_MODE", "CREATE_IF_NOT_EXIST");                //如果该名称的配置文件不存在，则创建一个该名称的配置文件

        Intent i = new Intent();
        i.setAction("com.symbol.datawedge.api.ACTION");                        //声明该Intent的操作是属于DataWedge的API操作，以便于设备后台系统捕捉并处理
        i.putExtra("com.symbol.datawedge.api.SET_CONFIG", bMain);            //声明调用的API为set config部分
        i.putExtra("SEND_RESULT", "true");                                    //启用结果发送
        i.putExtra("COMMAND_IDENTIFIER", "KEYSTROKE_API");                    //设置发送结果标识
        this.sendBroadcast(i);
    }

    /*
     * 切换使用指定的DataWedge配置文件，需要注意的是，切换到的配置文件应当没有关联其他应用程序，同时，当前应用也必须未关联到其他DataWedge的配置文件
     */
    public void SwitchToProfile() {
        Intent i = new Intent();
        i.setAction("com.symbol.datawedge.api.ACTION");                        //声明该Intent的操作是属于DataWedge的API操作，以便于设备后台系统捕捉并处理
        i.putExtra("com.symbol.datawedge.api.SWITCH_TO_PROFILE", "DEMO");    //切换使用DataWedge中名称为“DEMO”的配置文件
        this.sendBroadcast(i);
    }

    @Override
    public void onClick(View view) {
        finish();
    }

    /*
     * DataWedge Intent接收处理
     */
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        private String output_text = "";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (pop!=null&&pop.isShowing()){
                pop.dismiss();
            }
            String data = "";
            data = intent.getStringExtra(DATA_STRING_TAG);
            output_text = data + "\n";
//            TextView tv = (TextView) findViewById(R.id.textView);
            if (data.startsWith("G1")) {//库存盘点
                getStockDetail(data);

            }
            if (data.startsWith("A1")) {//固定资产盘点
                getAssertDetail(data);
            }
//            tv.setText(data);

           /*
            int index = et.getSelectionStart();					//获取光标所在位置
            Editable edit = et.getEditableText();				//获取EditText的文字
            if (index < 0 || index >= edit.length() ){
                edit.append(output_text);
            }else{
                edit.insert(index,output_text);					//光标所在位置插入文字
            }
            */
        }
    };
    private void getStockDetail(String result) {
        ld.show();
        /**
         * 通用扫码-物资
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"INVBALANCES","objectname":"INVBALANCES","option":"read","sqlSearch":" UDLOTNUM=:扫到的码 "}
         */
        LogUtils.d("query==");
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

            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse=" + response);
                ld.close();
                StockScanDetailResult stockScanDetailResult;
                if (!response.isEmpty()) {
                    stockScanDetailResult = JSONObject.parseObject(response, new TypeReference<StockScanDetailResult>() {});
                    if (stockScanDetailResult.getErrcode().equals("GLOBAL-S-0")) {
                        if (stockScanDetailResult.getResult().size()>0){
                            showStockPopupwindow(stockScanDetailResult.getResult().get(0));

                        }

                    }

                }

            }


        });
    }
    @SuppressLint("WrongConstant")
    private void showStockPopupwindow(StockScanDetailResult.ResultBean resultBean) {

        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.stock_check_detail_dialog2, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(false);// 点击空白处时，隐藏掉pop窗口
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.showAtLocation(rootView, Gravity.CENTER, -30, 0);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
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
        tv_line_no.setText("物资编码：" + resultBean.getITEMNUM());
        tv_product_location.setText("物资描述：" + resultBean.getDESCRIPTION());
        tv_line_batch.setText("采购单号：" + resultBean.getPONUM());
        tv_prodution_no.setText("仓库：" + resultBean.getTOSTORELOCDESC());
        tv_prodution_desc.setText("批次号：" + resultBean.getTOLOT());
        tv_stock_count.setText("识别码："+resultBean.getUDTOLOT());
        tv_vendor.setText("供应商：" + resultBean.getVENDOR());
        tv_vendor_name.setText("供应商名称：" +resultBean.getVENDORNAME());
        tv_store_count.setText("库存数量：" +resultBean.getINVBLANCE());
        tv_store_location.setText("仓库：" +resultBean.getTOSTORELOC());



        tv_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
    private void getAssertDetail(String data) {
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
        object.put("sqlSearch", " RFIDNUM= "+"'"+data+"'");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure=" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222onResponse=" + response);
                ld.close();
                AssertScanDetailResult asserScanResult;
                if (!response.isEmpty()) {
                    asserScanResult = JSONObject.parseObject(response, new TypeReference<AssertScanDetailResult>() {});
                    if (asserScanResult.getErrcode().equals("GLOBAL-S-0")) {
                        showAssertPopupwindow(asserScanResult.getResult().getResultlist().get(0));

                    }

                }

            }


        });
    }

    /**
     * 固定资产 弹框 扫一扫
     * @param resultlistBean
     */
    @SuppressLint("WrongConstant")
    private void showAssertPopupwindow(AssertScanDetailResult.ResultBean.ResultlistBean resultlistBean) {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.assert_scan_detail_dialog, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(false);// 点击空白处时，隐藏掉pop窗口
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.showAtLocation(rootView, Gravity.CENTER, -30, 0);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
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
        tv_assert_no.setText("固定资产编码:"+resultlistBean.getCWBM());
        tv_assert_name.setText("固定资产名称:"+resultlistBean.getDESCRIPTION());
        tv_assert_type.setText("固定资产类别:"+resultlistBean.getASSETTYPE());
        tv_assert_xh.setText("固定资产型号"+resultlistBean.getPRODUCTMODEL());
        tv_assert_statues.setText("状态:"+resultlistBean.getSTATUS());
        tv_assert_count.setText("资产数量:"+resultlistBean.getAMOUNT());
        tv_management.setText("项目主办部门:"+resultlistBean.getMANAGEMENT());
        tv_count_unit.setText("计量单位:"+resultlistBean.getUNITS());
        tv_jjyt.setText("经济用途:"+resultlistBean.getJJYT());
        tv_department.setText("使用部门:"+resultlistBean.getDEPARTMENT());
        tv_syqk.setText("使用情况:"+resultlistBean.getSYQK());
        tv_buy_time.setText("购买日期:"+resultlistBean.getASSETTYPE());
        tv_cfdd.setText("存放地点:"+resultlistBean.getCFDD());

        TextView tv_go = (TextView) remarkView.findViewById(R.id.tv_go);
        TextView tv_close = (TextView) remarkView.findViewById(R.id.tv_close);
        tv_go.setText("继续");
        tv_close.setText("取消");
        tv_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) this).getWindow().setAttributes(lp);
    }
}
