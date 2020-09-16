package com.cn.beisanproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.Utils.Tools;
import com.cn.beisanproject.modelbean.ChossenProjectListBean;
import com.cn.beisanproject.modelbean.ChossenStoreListBean;
import com.cn.beisanproject.modelbean.DetailForProjectBean;
import com.cn.beisanproject.modelbean.DetailForStoreBean;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class NewMaterialLineActivity extends AppCompatActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_common_title)
    TextView tvCommonTitle;
    @BindView(R.id.iv_fun)
    ImageView ivFun;
    @BindView(R.id.iv_project)
    ImageView ivProject;
    @BindView(R.id.edt_project)
    EditText edtProject;

    @BindView(R.id.edt_desc)
    EditText edtDesc;
    @BindView(R.id.edt_store)
    EditText edtStore;
    @BindView(R.id.iv_store)
    ImageView ivStore;
    @BindView(R.id.edt_small_type)
    EditText edtSmallType;
    @BindView(R.id.edt_xhgg)
    EditText edtXhgg;
    @BindView(R.id.edt_brand)
    EditText edtBrand;
    @BindView(R.id.edt_department)
    EditText edtDepartment;
    @BindView(R.id.edt_count)
    EditText edtCount;
    @BindView(R.id.edt_unit_cost)
    EditText edtUnitCost;
    @BindView(R.id.edt_line_cost)
    EditText edtLineCost;
    @BindView(R.id.edt_store_count)
    EditText edtStoreCount;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    private int REQUEST_FOR_PROJECT = 1;
    private int REQUEST_FOR_STORE = 2;
    private String SITEID;
    private String TYPE;
    private String WONUM;
    private LoadingDialog ld;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_material_line_activity);
        ButterKnife.bind(this);
//        double aa = Double.parseDouble("0.40");
//        double d = aa / 100;
//        String resultStr1 = String .format("%.2f",aa);
//        Log.d("222222","result="+resultStr1);
//        int i = Integer.parseInt(resultStr1);
//        Log.d("222222","result="+i*3);


//        String roundByScale = roundByScale(0.40, 0);
//        Log.d("222222", "roundByScale=" + roundByScale);

        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        WONUM=getIntent().getStringExtra("WONUM");
        edtCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = editable.toString();
                if (!StringUtils.isEmpty(s)) {
                    int count = Integer.parseInt(s);
                    LogUtils.d("222222 count = " + count);

                    Double unitcost;
                    if (!StringUtils.isEmpty(edtUnitCost.getText().toString())) {
                        unitcost = Double.parseDouble(edtUnitCost.getText().toString());
                        LogUtils.d("222222 unitcost  = " + unitcost);
                        Double aDouble = count * unitcost;
                        LogUtils.d("222222 aDouble  = " + aDouble);
                        double aa = Double.parseDouble(String.valueOf(aDouble));
                        double d = aa / 100;
                        String resultStr1 = String.format("%.2f", aa);
                        LogUtils.d("222222 resultStr1  = " + resultStr1);
                        edtLineCost.setText(resultStr1);

//
                    }


                }
            }
        });
        ld=new LoadingDialog(this);
    }

    public static String roundByScale(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        if (scale == 0) {
            return new DecimalFormat("0").format(v);
        }
        String formatStr = "0.";
        for (int i = 0; i < scale; i++) {
            formatStr = formatStr + "0";
        }
        Log.d("222222", "result=" + new DecimalFormat(formatStr).format(v));
        return new DecimalFormat(formatStr).format(v);


    }

    @OnClick({R.id.ll_back, R.id.iv_project, R.id.iv_store,R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.iv_project://选择项目
                startActivityForResult(new Intent(this, ChossenProjectACctivity.class), REQUEST_FOR_PROJECT);
                break;
            case R.id.iv_store://选择库房
//                if (!StringUtils.isEmpty(edtProject.getText().toString())){
                startActivityForResult(new Intent(this, ChossenStoreACctivity.class), REQUEST_FOR_STORE);
//                }
                break;
            case R.id.btn_commit://提交修改
               commit();
                break;
        }
    }

    private void commit() {
        ld.show();
        /**
         * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:max="http://www.ibm.com/maximo">
         *    <soapenv:Header/>
         *    <soapenv:Body>
         *       <max:mobileserviceUpdateMbo creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:json>
         *    {"relationShip" : [{"SHOWPLANMATERIAL" :""}],"SHOWPLANMATERIAL" : [{"DESCRIPTION" : "口111111罩","ITEMNUM" : "282010010","ITEMQTY" : "20",
         *    "UNITCOST" : "0.78","LINECOST" : "15.6","ITEMSETID":"ITEMSET10","LINETYPE":"项目","LOCATION":"GJ","STORELOCSITE":"1000","ORDERUNIT":"只",
         *    "ORGID":"10","SITEID":"1000","REQUESTBY":"MAXADMIN","REQUIREDATE":"2019-8-7 12:12:14","RESTYPE":"自动","WONUM":"43190","TYPE":"add"}]}
         *       </max:json>
         *          <max:mboObjectName>WORKORDER</max:mboObjectName>
         *          <max:mboKey>WONUM</max:mboKey>
         *          <max:mboKeyValue>43190</max:mboKeyValue>
         *       </max:mobileserviceUpdateMbo>
         *    </soapenv:Body>
         * </soapenv:Envelope>
         */
        String request="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <max:mobileserviceUpdateMbo creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:json>\n" +
                "   %s \n" +
                "      </max:json>\n" +
                "         <max:mboObjectName>WORKORDER</max:mboObjectName>\n" +
                "         <max:mboKey>WONUM</max:mboKey>\n" +
                "         <max:mboKeyValue>%s</max:mboKeyValue>\n" +
                "      </max:mobileserviceUpdateMbo>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        LogUtils.d("==commit");
        String url = Constants.COMMONSOAP2;
        JSONObject object = new JSONObject();
// relationShip
        JSONArray array1=new JSONArray();
        JSONObject obj1 = new JSONObject();
        obj1.put("SHOWPLANMATERIAL","");
        array1.add(obj1);
        object.put("relationShip",array1);
// SHOWPLANMATERIAL
        JSONArray array2=new JSONArray();
        JSONObject obj2 = new JSONObject();
        obj2.put("DESCRIPTION",edtDesc.getText().toString());
        obj2.put("ITEMNUM",edtProject.getText().toString());
        obj2.put("ITEMQTY",edtCount.getText().toString());//领用数量
        obj2.put("UNITCOST",edtUnitCost.getText().toString());
        obj2.put("LINECOST",edtLineCost.getText().toString());
        obj2.put("ITEMSETID","ITEMSET10");
        obj2.put("LINETYPE","项目");
        obj2.put("LOCATION",edtStore.getText().toString());
        obj2.put("STORELOCSITE","1000");
        obj2.put("ORDERUNIT",edtDepartment.getText().toString());
        obj2.put("ORGID","10");
        obj2.put("SITEID","1000");
        obj2.put("REQUESTBY", SharedPreferencesUtil.getString(this,"personId"));
        obj2.put("REQUIREDATE", Tools.dateString2(new Date()));
        obj2.put("RESTYPE","自动");
        obj2.put("WONUM",WONUM);
        obj2.put("TYPE","add");
        array2.add(obj2);
        object.put("SHOWPLANMATERIAL",array2);
        String request1 = String.valueOf(object);
        request = String.format(request, request1, WONUM);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");
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
                        data.setTag("new  line  scuess");
                        EventBus.getDefault().post(data);
                        finish();
                    } else {
                        ToastUtils.showShort(startWorkProcessBean.getErrorMsg());
                    }
                }
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_FOR_PROJECT) {
                DetailForProjectBean.ResultBean.ResultlistBean resultlistBean = (DetailForProjectBean.ResultBean.ResultlistBean) data.getExtras().get("data");
//                领用单位、小类、规格型号、品牌
                edtProject.setText(resultlistBean.getITEMNUM());
                if (!StringUtils.isEmpty(edtStore.getText().toString())) {
                    getDetail(edtProject.getText().toString(), edtStore.getText().toString());
                }
                edtBrand.setText(resultlistBean.getA_BRAND());
                edtXhgg.setText(resultlistBean.getA_MODEL());
                edtSmallType.setText(resultlistBean.getA_3CLASS());
                edtDepartment.setText(resultlistBean.getISSUEUNIT());

            }
            if (requestCode == REQUEST_FOR_STORE) {
                ChossenStoreListBean.ResultBean.ResultlistBean resultlistBean = (ChossenStoreListBean.ResultBean.ResultlistBean) data.getExtras().get("data");
                edtStore.setText(resultlistBean.getLOCATION());
                SITEID=resultlistBean.getSITEID();
                TYPE=resultlistBean.getTYPE();
                if (!StringUtils.isEmpty(edtProject.getText().toString())) {
                    getDetail(edtProject.getText().toString(), edtStore.getText().toString());
                }
            }
        }
    }

    private void getDetail(String itemnum, String location) {
        /**
         * ---物料明细行-根据明细行 【项目编号、库房】从INVENTORY获取【库存余量、单位成本】
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"INVENTORY","objectname":"INVENTORY","curpage":1,"showcount":20,"option":"read","orderby":"",
         * "sqlSearch":" ITEMNUM=:ITEMNUM and LOCATION=:LOCATION "}
         */
        LogUtils.d("==query");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "INVENTORY");
        object.put("objectname", "INVENTORY");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        String sqlSearch = " ITEMNUM= %s and LOCATION= %s";
        sqlSearch = String.format(sqlSearch, "'" + itemnum + "'", "'" + location + "'");
        object.put("sqlSearch", sqlSearch);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                DetailForStoreBean detailForStoreBean;
                if (!response.isEmpty()) {
                    detailForStoreBean = JSONObject.parseObject(response, new TypeReference<DetailForStoreBean>() {
                    });
                    if (detailForStoreBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (detailForStoreBean.getResult().getResultlist().size() > 0) {
                            edtStoreCount.setText(detailForStoreBean.getResult().getResultlist().get(0).getAVBLBALANCE());//库存余量
                            edtUnitCost.setText(detailForStoreBean.getResult().getResultlist().get(0).getLASTCOST());//单位成本
                            if (!StringUtils.isEmpty(edtCount.getText().toString())) {
                                int count = Integer.parseInt(edtCount.getText().toString());
                                Double unitcost = Double.parseDouble(edtUnitCost.getText().toString());
                                LogUtils.d("222222 unitcost  = " + unitcost);
                                Double aDouble = count * unitcost;
                                LogUtils.d("222222 aDouble  = " + aDouble);
                                double aa = Double.parseDouble(String.valueOf(aDouble));
                                double d = aa / 100;
                                String resultStr1 = String.format("%.2f", aa);
                                LogUtils.d("222222 resultStr1  = " + resultStr1);
                                edtLineCost.setText(resultStr1);
                            }
                        } else {
                            edtUnitCost.setText("0.00");
                            edtLineCost.setText("0.00");
                        }

                    }

                }

            }
        });
    }
}
