package com.cn.beisanproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.handler.RFIDHandler;
import com.cn.beisanproject.modelbean.AssertCheckListBean;
import com.cn.beisanproject.modelbean.AssertDetailLineBean;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.zebra.rfid.api3.TagData;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * created by tzl 2020 8 12  固定资产盘点操作类
 */
public class AssertCheckActivity extends AppCompatActivity implements View.OnClickListener, RFIDHandler.ResponseHandlerInterface {

    private LinearLayout ll_back;
    TextView tv_common_title;
    private RFIDHandler rfidHandler;
    private List<String> list;
    private List<AssertDetailLineBean.ResultBean.ResultlistBean> resultlist;
    private LoadingDialog ld;
    private AssertCheckListBean.ResultBean.ResultlistBean mResultlistBean;
    private LinearLayout ll_container;
    private Button btn_commit;
    List<JSONObject> jsonList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assert_check_activity);
        ButterKnife.bind(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ll_back = findViewById(R.id.ll_back);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("固定资产盘点");
        ll_back.setOnClickListener(this);
        ll_container = findViewById(R.id.ll_container);
        btn_commit = findViewById(R.id.btn_commit);
        btn_commit.setOnClickListener(this);
        // RFID Handler
        rfidHandler = new RFIDHandler();
        rfidHandler.onCreate(this);
        ld = new LoadingDialog(this);
        if (getIntent().getExtras().get("resultlistBean") != null) {
            mResultlistBean = (AssertCheckListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("resultlistBean");

        }
        list = new ArrayList<>();
        //获取所有明细行列表进行匹配
        getAssertLineDetail();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.btn_commit:
                if (jsonList.size()>0){
                    commitCheck();
                }else {
                    ToastUtils.showShort("没有可提交的数据");
                }
                break;

        }
    }
    /**
     * 多条盘点
     */
    private void commitCheck() {
        /**
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *        <max:mobileserviceUpdateMbo creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:json>
         *          {"relationShip" : [{"FIXPDLINE" :""}],"FIXPDLINE" :
         *          [
         *          {"FIXPDNUM":"1065","RFIDNUM":"1000000028","PDJGCFWZ":"宁波28","PDHSYBM":"信息部28","YPD":1,"TYPE":"update"};
         *           {"FIXPDNUM":"1065","RFIDNUM":"1000000027","PDJGCFWZ":"宁波27","PDHSYBM":"信息部27","YPD":1,"TYPE":"update"}
         *
         *          ]}
         *          </max:json>
         *          <max:mboObjectName>FIXPD</max:mboObjectName>
         *          <max:mboKey>FIXPDNUM</max:mboKey>
         *          <max:mboKeyValue>1065</max:mboKeyValue>
         *       </max:mobileserviceUpdateMbo>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "       <max:mobileserviceUpdateMbo creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:json>\n" +
                "          %s \n" +
                "         </max:json>\n" +
                "         <max:mboObjectName>FIXPD</max:mboObjectName>\n" +
                "         <max:mboKey>FIXPDNUM</max:mboKey>\n" +
                "         <max:mboKeyValue>%s</max:mboKeyValue>\n" +
                "      </max:mobileserviceUpdateMbo>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        JSONObject jsonObject=new JSONObject();

        JSONArray relationShip=new JSONArray();
        JSONObject obj1=new JSONObject();
        obj1.put("FIXPDLINE","");
        relationShip.add(obj1);
        jsonObject.put("relationShip",relationShip);

        JSONArray FIXPDLINE=new JSONArray();
        FIXPDLINE.addAll(jsonList);
        jsonObject.put("FIXPDLINE",FIXPDLINE);

        String request1=String.valueOf(jsonObject);
        request=String.format(request,request1,mResultlistBean.getFIXPDNUM());
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
                        data.setTag("assert check scuess");
                        //通知固定资产盘点明细行和固定资产盘点差异列表刷新数据
                        EventBus.getDefault().post(data);
                    } else {
                        ToastUtils.showShort(startWorkProcessBean.getErrorMsg());
                    }
                }
            }
        });



    }
    @Override
    public void handleTagdata(TagData[] tagData) {
        Log.d("222222", "handleTagdata");
        ToastUtils.showShort("handleTagdata");
        final StringBuilder sb = new StringBuilder();
        for (int index = 0; index < tagData.length; index++) {
//            sb.append(tagData[index].getTagID() + "\n");
            if (!list.contains(tagData[index].getTagID())) {
                list.add(tagData[index].getTagID());
            }
        }
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + "\n");

        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                textrfid.append(sb.toString());
                Log.d("222222", "sb.toString()=" + sb.toString() + "tagData.size" + tagData.length + "list.size=" + list.size());
                ToastUtils.showShort(sb.toString() + "list.size=" + list.size());

            }
        });
    }

    @Override
    public void handleTriggerPress(boolean pressed) {
        if (pressed) {
            Log.d("222222", "handleTriggerPress pressed=true");

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    textrfid.setText("");
                }
            });
            rfidHandler.performInventory();
        } else {
            Log.d("222222", "handleTriggerPress pressed=false");
            rfidHandler.stopInventory();
            if (resultlist != null && resultlist.size() > 0) {
                createList(list);
            }

        }
    }

    private void createList(List<String> list) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ll_container.removeAllViews();
                for (int i = 0; i < resultlist.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (resultlist.get(i).getRFIDNUM().equals(list.get(j))) {
                            View view = LayoutInflater.from(AssertCheckActivity.this).inflate(R.layout.asseert_line_item, ll_container, false);
                            TextView tvAssertName = view.findViewById(R.id.tv_assert_name);
                            TextView tvAssertAdmin = view.findViewById(R.id.tv_assert_admin);
                            TextView tvDepartment = view.findViewById(R.id.tv_department);
                            TextView tvShiyongStatue = view.findViewById(R.id.tv_shiyong_statue);
                            TextView tvShiyongPeople = view.findViewById(R.id.tv_shiyong_people);
                            TextView tvShigongDeparment = view.findViewById(R.id.tv_shigong_deparment);
                            TextView tvProjectDeparment = view.findViewById(R.id.tv_project_deparment);
                            TextView tvOwnerCompanny = view.findViewById(R.id.tv_owner_companny);
                            TextView tvAssertType = view.findViewById(R.id.tv_assert_type);
                            TextView tvXinghao = view.findViewById(R.id.tv_xinghao);
                            TextView tvCountDate = view.findViewById(R.id.tv_count_date);
                            TextView tvBuyTime = view.findViewById(R.id.tv_buy_time);
                            TextView tvStartTime = view.findViewById(R.id.tv_start_time);
                            TextView tvStoreAddress = view.findViewById(R.id.tv_store_address);
                            TextView tvZhejiu = view.findViewById(R.id.tv_zhejiu);
                            TextView tvOriginValue = view.findViewById(R.id.tv_origin_value);
                            TextView tvHasChecked = view.findViewById(R.id.tv_has_checked);

                            tvAssertName.setText("固定资产名称：" + resultlist.get(i).getDESCRIPTION());
                            tvAssertAdmin.setText("资产管理员：" + resultlist.get(i).getADMINISTRATOR());
                            tvDepartment.setText("使用部门：" + resultlist.get(i).getDEPARTMENT());
                            tvShiyongStatue.setText("使用情况：" + resultlist.get(i).getSYQK());
                            tvShiyongPeople.setText("使用人：" + resultlist.get(i).getDISPLAYNAME());
                            tvShigongDeparment.setText("施工单位：" + resultlist.get(i).getSGCOM());
                            tvProjectDeparment.setText("项目主办方：" + resultlist.get(i).getMANAGEMENT());
                            tvOwnerCompanny.setText("所属公司：" + resultlist.get(i).getOWNERSITE());
                            tvAssertType.setText("固定资产类别：" + resultlist.get(i).getASSETTYPE());
                            tvXinghao.setText("固定资产型号：" + resultlist.get(i).getPRODUCTMODEL());
                            tvCountDate.setText("财务入账时间：" + resultlist.get(i).getFIXASSETDATE());
                            tvBuyTime.setText("购买时间：" + resultlist.get(i).getDATEOFPURCHASE());
                            tvStartTime.setText("启用时间：" + resultlist.get(i).getDATEPLACEDINSERVICE());
                            tvStoreAddress.setText("存放地点：" + resultlist.get(i).getCFDD());
                            tvZhejiu.setText("折旧年限：" + resultlist.get(i).getDEPRECIATIONPERIOD());
                            tvOriginValue.setText("资产原值：" + resultlist.get(i).getCOST());
                            tvHasChecked.setText("是否已盘点：" + resultlist.get(i).getYPD());
                            JSONObject jsonObj = new JSONObject();
                            jsonObj.put("FIXPDNUM",mResultlistBean.getFIXPDNUM());
                            jsonObj.put("RFIDNUM",resultlist.get(i).getRFIDNUM());
                            jsonObj.put("PDJGCFWZ",resultlist.get(i).getPDJGCFWZ());
                            jsonObj.put("PDHSYBM",resultlist.get(i).getPDHSYBM());
                            jsonObj.put("YPD","1");
                            jsonObj.put("TYPE","update");
                            jsonList.add(jsonObj);

                            int finalI = i;
                            view.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(AssertCheckActivity.this, AssertListItemDetailActivity.class).putExtra("resultlistBean", mResultlistBean).putExtra("data", resultlist.get(finalI)).putExtra("from", "AssertCheckActivity"));
                                }
                            });
                            ll_container.addView(view);
                        }
                    }
                }
            }
        });


    }


    @Override
    protected void onPause() {
        super.onPause();
        rfidHandler.onPause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        String onResume = rfidHandler.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rfidHandler.onDestroy();
    }

    /**
     * -- 固定资产盘点明细行查询
     * http://192.168.1.180:7009/maximo/mobile/common/api?data=
     * {"appid":"FIXPDLINE","objectname":"FIXPDLINE","curpage":1,"showcount":20,"option":"read","orderby":"",
     * "sinorsearch":{"FIXASSETNUM":"","YPD":""},"sqlSearch":" FIXPDNUM=:FIXPDNUM "}
     */
    public void getAssertLineDetail() {
        ld.show();
        LogUtils.d("222222getAssertLineDetail");
//
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "FIXPDLINE");
        object.put("objectname", "FIXPDLINE");
        object.put("curpage", 0);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        //模糊查询
        JSONObject sinorsearchobject = new JSONObject();
        sinorsearchobject.put("FIXASSETNUM", "");
        sinorsearchobject.put("YPD", "");
        object.put("sinorsearch", sinorsearchobject);
        object.put("sqlSearch", "FIXPDNUM=" + mResultlistBean.getFIXPDNUM());
        //请求头
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
                if (!response.isEmpty()) {
                    AssertDetailLineBean assertDetailLineBean = JSONObject.parseObject(response, new TypeReference<AssertDetailLineBean>() {
                    });
                    if (assertDetailLineBean.getErrcode().equals("GLOBAL-S-0")) {
                        if (assertDetailLineBean.getResult().getResultlist().size() > 0) {
                            resultlist = assertDetailLineBean.getResult().getResultlist();

                        }

                    }

                }

            }


        });

    }
}
