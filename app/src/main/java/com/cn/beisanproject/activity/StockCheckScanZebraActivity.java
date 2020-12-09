package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
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
import androidx.appcompat.view.menu.MenuBuilder;

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
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.StockingLineListBean;
import com.cn.beisanproject.modelbean.StockingTakeListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;


public class StockCheckScanZebraActivity extends AppCompatActivity implements View.OnClickListener {
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
    private TextView tv_count;

    private boolean flag;
    private Button bstart;
    private Button bstop;
    private int interval;
    private LoadingDialog ld;
    private PopupWindow pop;
    private StockingTakeListBean.ResultBean.ResultlistBean mResultlistBean;
    private List<StockingLineListBean.ResultBean.ResultlistBean> resultlist;
    private List<String> list;
    private List<JSONObject> jsonlist;
    private TextView tv_finish;
    private TextView tv_pici_no;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_scan_for_zebra_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        if (getIntent().getExtras().get("mResultlistBean") != null) {
            mResultlistBean = (StockingTakeListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("mResultlistBean");
        }
        ld = new LoadingDialog(this);

        getStockLine();
        ll_back = findViewById(R.id.ll_back);
        ll_back.setOnClickListener(this);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("固定资产盘点");
        iv_fun = findViewById(R.id.iv_fun);

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
        tv_count = findViewById(R.id.tv_count);
        tv_pici_no = findViewById(R.id.tv_pici_no);
        tv_finish= findViewById(R.id.tv_finish);
        tv_finish.setOnClickListener(this);

        flag = false;
        list = new ArrayList<>();
        jsonlist = new ArrayList<>();

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

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        private String output_text = "";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (pop!=null){
                pop.dismiss();
            }
            String data = "";
            data = intent.getStringExtra(DATA_STRING_TAG);
            output_text = data + "\n";
//            TextView tv = (TextView) findViewById(R.id.textView);
            tv_pici_no.setText("批次号：" + data);

            if (data.startsWith("W1")) {//库存盘点
                for (int i = 0; i < resultlist.size(); i++) {
                    //BSJS30453-1-20190619
                    //BSJS30292-1-20190605
                    if (resultlist.get(i).getUDLOTNUM().equals(data)) {
                        Log.d("222222","resultlist.get(i).getLOTNUM().equals(result)"+"   i="+i);
                        list.add(data);
                        tv_count.setText("本次盘点数量合计：" + list.size());
                    }
                }
                tv_finish.setText("结束盘点 " + "(" + list.size() + ")");

                if (list.size() > 0) {//如果匹配上了
                    LogUtils.d("222222 list.size() > 0"+"  list.size()="+list.size());
                    showRemarkPopupwindow(resultlist, data);
                }


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

    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow(List<StockingLineListBean.ResultBean.ResultlistBean> list, String result) {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.stock_check_detail_dialog, null);
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
        TextView tv_go = (TextView) remarkView.findViewById(R.id.tv_go);
        TextView tv_close = (TextView) remarkView.findViewById(R.id.tv_close);
        tv_go.setText("继续盘点");
        tv_close.setText("取消");
        TextView tv_line_no = remarkView.findViewById(R.id.tv_line_no);
        TextView tv_product_location = remarkView.findViewById(R.id.tv_product_location);
        TextView tv_line_batch = remarkView.findViewById(R.id.tv_line_batch);
        TextView tv_prodution_no = remarkView.findViewById(R.id.tv_prodution_no);
        TextView tv_prodution_desc = remarkView.findViewById(R.id.tv_prodution_desc);
        TextView tv_stock_count = remarkView.findViewById(R.id.tv_stock_count);
        TextView tv_tag_id = remarkView.findViewById(R.id.tv_tag_id);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUDLOTNUM().equals(result)) {

                tv_line_no.setText("明细行序号:" + list.get(i).getLINENUM());
                tv_product_location.setText("货位:" + list.get(i).getBINNUM());
                tv_line_batch.setText("批次:" + list.get(i).getLOTNUM());
                tv_prodution_no.setText("物资编码:" + list.get(i).getITEMNUM());
                tv_prodution_desc.setText("物资描述:" + list.get(i).getITEMNUMDESC());
                tv_stock_count.setText("库存数量:" + list.get(i).getYPQUANTITY());
                tv_tag_id.setText("唯一标识码:" +result);
            }
        }
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

            }
        });
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

                break;
        }
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
                        LogUtils.d("222222 list.size()"+list.size());
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
    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) this).getWindow().setAttributes(lp);
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
    @SuppressLint("WrongConstant")
    private void showWarmPopupwindow() {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View inflate = LayoutInflater.from(this).inflate(R.layout.check_exit_warm_dialog, null);
        pop = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());

        pop.setFocusable(false);// 点击空白处时，隐藏掉pop窗口
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
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
}
