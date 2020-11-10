package com.cn.beisanproject.activity;

import android.os.Bundle;
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
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.modelbean.AssertCheckListBean;
import com.cn.beisanproject.modelbean.AssertDetailLineBean;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

import java.sql.Struct;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * created by tzl 2020 8 12  固定资产盘点明细行列表 和 固定资产盘点操作类列表的条目点击跳转详情页
 */
public class AssertListItemDetailActivity extends AppCompatActivity {
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_common_title)
    TextView tvCommonTitle;
    @BindView(R.id.iv_fun)
    ImageView ivFun;
    @BindView(R.id.tv_assert_name)
    TextView tvAssertName;
    @BindView(R.id.tv_assert_admin)
    TextView tvAssertAdmin;
    @BindView(R.id.tv_shiyong_statue)
    TextView tvShiyongStatue;
    @BindView(R.id.tv_shiyong_people)
    TextView tvShiyongPeople;
    @BindView(R.id.tv_shigong_deparment)
    TextView tvShigongDeparment;
    @BindView(R.id.tv_project_deparment)
    TextView tvProjectDeparment;
    @BindView(R.id.tv_owner_companny)
    TextView tvOwnerCompanny;
    @BindView(R.id.tv_assert_type)
    TextView tvAssertType;
    @BindView(R.id.tv_xinghao)
    TextView tvXinghao;
    @BindView(R.id.tv_count_date)
    TextView tvCountDate;
    @BindView(R.id.tv_buy_time)
    TextView tvBuyTime;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_zhejiu)
    TextView tvZhejiu;
    @BindView(R.id.tv_origin_value)
    TextView tvOriginValue;
    @BindView(R.id.tv_has_checked)
    TextView tvHasChecked;
    @BindView(R.id.iv_haschecked)
    ImageView ivHaschecked;
    @BindView(R.id.tv_department)
    TextView tvDepartment;
    @BindView(R.id.edt_department)
    EditText edtDepartment;
    @BindView(R.id.ll_1)
    LinearLayout ll1;
    @BindView(R.id.tv_store_address)
    TextView tvStoreAddress;
    @BindView(R.id.edt_store_address)
    EditText edtStoreAddress;
    @BindView(R.id.ll_2)
    LinearLayout ll2;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    private AssertCheckListBean.ResultBean.ResultlistBean mResultlistBean;
    AssertDetailLineBean.ResultBean.ResultlistBean data;
    private String from;
    private LoadingDialog ld;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assert_list_item_detail_activity);
        ButterKnife.bind(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        tvCommonTitle.setText("固定资产盘点明细");
        if (getIntent().getExtras().get("resultlistBean") != null) {
            mResultlistBean = (AssertCheckListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("resultlistBean");

        }
        if (getIntent().getExtras().get("from") != null) {// AssertDetailLineAdapter 则来自固定资产盘点明细行列表
            from =getIntent().getStringExtra("from"); // AssertCheckActivity  则来自盘点操作界面列表
            
        }
        
        if (getIntent().getExtras().get("data") != null) {
            data = (AssertDetailLineBean.ResultBean.ResultlistBean) getIntent().getExtras().get("data");
            tvAssertName.setText("固定资产名称：" + data.getDESCRIPTION());
            tvAssertAdmin.setText("资产管理员：" + data.getADMINISTRATOR());
            tvDepartment.setText("使用部门:"+data.getDEPARTMENT());
            edtDepartment.setText( data.getPDHSYBM());
            edtDepartment.setSelection(data.getPDHSYBM().length());
            tvShiyongStatue.setText("使用情况：" + data.getSYQK());
            tvShiyongPeople.setText("使用人：" + data.getDISPLAYNAME());
            tvShigongDeparment.setText("施工单位：" + data.getSGCOM());
            tvProjectDeparment.setText("项目主办方：" + data.getMANAGEMENT());
            tvOwnerCompanny.setText("所属公司：" + data.getOWNERSITE());
            tvAssertType.setText("固定资产类别：" + data.getASSETTYPE());
            tvXinghao.setText("固定资产型号：" + data.getPRODUCTMODEL());
            tvCountDate.setText("财务入账时间：" + data.getFIXASSETDATE());
            tvBuyTime.setText("购买时间：" + data.getDATEOFPURCHASE());
            tvStartTime.setText("启用时间：" + data.getDATEPLACEDINSERVICE());
            tvStoreAddress.setText("存放地点:"+data.getCFDD());
            edtStoreAddress.setText( data.getPDJGCFWZ());
            edtStoreAddress.setSelection(data.getPDJGCFWZ().length());
            tvZhejiu.setText("折旧年限：" + data.getDEPRECIATIONPERIOD());
            tvOriginValue.setText("资产原值：" + data.getCOST());
            tvHasChecked.setText("是否已盘点：" + data.getYPD());
        }
        ld = new LoadingDialog(this);

    }

    @OnClick({R.id.ll_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.btn_commit:
                if (StringUtils.isEmpty(edtStoreAddress.getText().toString())&&StringUtils.isEmpty(edtDepartment.getText().toString())){
                    ToastUtils.showShort("请输入盘点后存放地点/盘点后使用部门");
                    return;
                }

                commitCheck();
                break;
        }
    }

    /**
     * 单条盘点
     */
    private void commitCheck() {
        ld.show();
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
        JSONObject obj2=new JSONObject();
        obj2.put("FIXPDNUM",mResultlistBean.getFIXPDNUM());
        obj2.put("RFIDNUM",data.getRFIDNUM());
        obj2.put("PDJGCFWZ",edtStoreAddress.getText().toString());
        obj2.put("PDHSYBM",edtDepartment.getText().toString());
        obj2.put("YPD",1);
        obj2.put("TYPE","update");
        FIXPDLINE.add(obj2);
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
                        ToastUtils.showShort("修改成功");
                        finish();
                    } else {
                        ToastUtils.showShort(startWorkProcessBean.getErrorMsg());
                    }
                }
            }
        });



    }
}
