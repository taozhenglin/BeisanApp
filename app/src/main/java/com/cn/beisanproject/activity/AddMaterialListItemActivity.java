package com.cn.beisanproject.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.Serializable;

public class AddMaterialListItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView();
//        setContentView();
    }


    public void addOne(){
        /**
         * 新建
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         * <soap:Header/>
         * <soap:Body>
         * <max:mobileserviceInsertMbo creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         * <max:json>
         * {"A_WOTYPE" : "MR","DESCRIPTION" : "领料申请单测试","A_TODEPT" : "党群工作部","A_USEFOR" : "车辆用（柴油）","relationShip" : [{"SHOWPLANMATERIAL" :""}]}
         * </max:json>
         * <max:mboObjectName>WORKORDER</max:mboObjectName>
         * <max:mboKey>WORKORDERID</max:mboKey>
         * <max:personId>MAXADMIN</max:personId>
         * </max:mobileserviceInsertMbo>
         * </soap:Body>
         * </soap:Envelope>
         */
        String request = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:mobileserviceInsertMbo creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:json>" +
                "          %s" +
                "        </max:json>\n" +
                "         <max:mboObjectName>WORKORDER</max:mboObjectName>\n" +
                "         <max:mboKey>WORKORDERID</max:mboKey>\n" +
                "         <max:personId>%s</max:personId>\n" +
                "      </max:mobileserviceInsertMbo>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        JSONObject object=new JSONObject();
        object.put("A_WOTYPE","");
        object.put("DESCRIPTION","");
        object.put("A_TODEPT","");
        object.put("A_USEFOR","");
        JSONArray relationShip=new JSONArray();
        JSONObject obj=new JSONObject();
        obj.put("SHOWPLANMATERIAL","");
        relationShip.add(obj);
        object.put("relationShip",relationShip);
        request=String.format(request,String.valueOf(object), SharedPreferencesUtil.getString(this,"personId"));

    }


}
