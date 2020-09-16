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
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.StockingLineListBean;
import com.cn.beisanproject.modelbean.StockingTakeListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 库存盘点明细行条目点击跳转详情页
 */
public class StockListItemDetailActivity extends AppCompatActivity {
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
    @BindView(R.id.tv_line_no)
    TextView tvLineNo;
    @BindView(R.id.tv_product_location)
    TextView tvProductLocation;
    @BindView(R.id.tv_line_batch)
    TextView tvLineBatch;
    @BindView(R.id.tv_prodution_no)
    TextView tvProdutionNo;
    @BindView(R.id.tv_prodution_desc)
    TextView tvProdutionDesc;
    @BindView(R.id.tv_stock_count)
    TextView tvStockCount;
    @BindView(R.id.tv_actually_count)
    TextView tvActuallyCount;
    @BindView(R.id.edt_sp)
    EditText edtSp;
    @BindView(R.id.tv_diff_count)
    TextView tvDiffCount;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    StockingTakeListBean.ResultBean.ResultlistBean mResultlistBean;
    private StockingLineListBean.ResultBean.ResultlistBean resultlistBean;
    private LoadingDialog ld;
    private String sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_list_item_detail_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ButterKnife.bind(this);
        ld = new LoadingDialog(this);
        if (getIntent().getExtras().get("resultlistBean") != null) {
            mResultlistBean = (StockingTakeListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("resultlistBean");
        }
        if (getIntent().getExtras().get("data") != null) {
            resultlistBean = (StockingLineListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("data");
            sp=resultlistBean.getSPQUANTITY();
        }
        initView();
    }

    private void initView() {
        tvCommonTitle.setText("库存盘点明细");
        tvLineNo.setText("明细行序号:" + resultlistBean.getLINENUM());
        tvProductLocation.setText("货位：" + resultlistBean.getBINNUM());
        tvLineBatch.setText("批次：" + resultlistBean.getLOTNUM());
        tvProdutionNo.setText("物资编码：" + resultlistBean.getITEMNUM());
        tvProdutionDesc.setText("物资描述：" + resultlistBean.getITEMNUMDESC());
        tvStockCount.setText("库存数量：" + resultlistBean.getYPQUANTITY());
        edtSp.setText(resultlistBean.getSPQUANTITY());
        edtSp.setSelection(resultlistBean.getSPQUANTITY().length());
        tvDiffCount.setText("差异数量：" + resultlistBean.getCYQUANTITY());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.ll_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.btn_commit:
                int ori= (int) Double.parseDouble(sp);
                int now= (int) Double.parseDouble(edtSp.getText().toString());
                if (ori==now){
                    ToastUtils.showShort("未做更改");
                    return;
                }
                if (StringUtils.isEmpty(edtSp.getText().toString())) {
                    ToastUtils.showShort("请输入实盘数");
                    return;
                }
                commit();
                break;
        }
    }

    private void commit() {
        ld.show();
/**
 * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
 *    <soap:Header/>
 *    <soap:Body>
 *       <max:mobileserviceUpdateMbo creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
 *          <max:json>
 *            {"relationShip" : [{"STOCKLINE" :""}],"STOCKLINE" : [{"STOCKNUM":"1004","UDLOTNUM":"W100000000021","SPQUANTITY":"2","CYQUANTITY":"-2","TYPE":"update"}  ]}
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
                "           %s \n" +
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
        JSONObject obj2 = new JSONObject();
        String STOCKNUM = resultlistBean.getSTOCKNUM();
        String UDLOTNUM = resultlistBean.getUDLOTNUM();
        String SPQUANTITY = edtSp.getText().toString();
//        int SP = (int) Double.parseDouble(SPQUANTITY) + 1;
        String CYQUANTITY = resultlistBean.getCYQUANTITY();
        String TYPE = "update";
        obj2.put("STOCKNUM", STOCKNUM);
        obj2.put("UDLOTNUM", UDLOTNUM);
        obj2.put("SPQUANTITY", SPQUANTITY);
        obj2.put("CYQUANTITY", CYQUANTITY);
        obj2.put("TYPE", TYPE);
        array2.add(obj2);

        JSONObject object = new JSONObject();
        object.put("relationShip", array1);
        object.put("STOCKLINE", array2);
        String request1 = String.valueOf(object);
        request = String.format(request, request1, mResultlistBean.getSTOCKNUM());
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
                        ToastUtils.showShort("修改"+startWorkProcessBean.getSuccess());
                        PostData data = new PostData();
                        data.setTag("stock check scuess");
                        EventBus.getDefault().post(data);
                        finish();
                    } else {
                        ToastUtils.showShort(startWorkProcessBean.getErrorMsg());
                    }
                }
            }
        });
    }
}
