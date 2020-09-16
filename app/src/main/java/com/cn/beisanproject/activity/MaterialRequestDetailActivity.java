package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.modelbean.CommmonForMaterialDetailBean;
import com.cn.beisanproject.modelbean.MaterialDetailBean;
import com.cn.beisanproject.modelbean.MaterialDetailLineBean;
import com.cn.beisanproject.modelbean.MaterialRequestListBean;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.WaitDoListBean;
import com.cn.beisanproject.modelbean.YuSuanListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.yinglan.keyboard.HideUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

public class MaterialRequestDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private MaterialRequestListBean.ResultBean.ResultlistBean mResultlistBean;
    private TextView tv_material_no;
    private TextView tv_material_statue;
    private EditText edt_desc;
    private EditText edt_yusuan_no;
    private EditText edt_yusuanno_desc;
    private EditText edt_zhineng_dep;
    private EditText edt_shiyong_fangiang;
    private TextView tv_order_type;
    private TextView tv_cost;
    private TextView tv_iswar_material;
    private TextView tv_write_by;
    private TextView tv_requset_dep;
    private TextView tv_write_time;
    private TextView tv_material_team;
    private TextView tv_material_phone;
    private LinearLayout ll_1;
    private LinearLayout ll_2;
    private LinearLayout ll_3;
    private LinearLayout ll_4;
    private LinearLayout ll_5;
    private LinearLayout ll_material_line;
    private LoadingDialog ld;
    private TextView tv_common_title;
//    private TextView tv_new_line;
    TextView tv_start;
    WaitDoListBean.ResultBean.ResultlistBean mWitdolistBean;
    private boolean needGet;
    private String OWNERID;
    private String statues="";
    int REQUEST_FOR_YUSUAN = 1;
    int REQUEST_FOR_DEPT = 2;
    int REQUEST_FOR_USED = 3;
    int REQUEST_FOR_TYPE = 4;
    private ImageView iv_fun;
    private PopupWindow pop;
    private int selected = 1;
    private String WONUM;
    private String A_WOTYPE = "";
    private String A_USEFOR = "";
    private LinearLayout ll_back;
    private String SITEID;
    private String WORKORDERID;
    private int isAgree;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_request_detailactivity);
        initView();
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ld = new LoadingDialog(this);
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            mWitdolistBean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            OWNERID = mWitdolistBean.getOWNERID() + "";
            LogUtils.d("OWNERID=" + OWNERID);
        } else {
            mResultlistBean = (MaterialRequestListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            statues = mResultlistBean.getSTATUS();
            WONUM = mResultlistBean.getWONUM();
            SITEID=mResultlistBean.getSITEID();
            WORKORDERID=mResultlistBean.getWORKORDERID()+"";
            if (statues.equals("已取消")||statues.equals("取消")||statues.equals("关闭")||statues.equals("已关闭")){
            tv_start.setVisibility(View.GONE);
            }else {
                if (statues.equals("起草")){
                    tv_start.setText("启动工作流");
                }else {
                    tv_start.setText("工作流审批");
                }
            }
        }

        initEvent();
        EventBus.getDefault().register(this);

    }

    private void initView() {
        ll_back = findViewById(R.id.ll_back);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("领料物料");
        iv_fun = findViewById(R.id.iv_fun);
//        iv_fun.setBackgroundResource(R.drawable.upload);
        tv_material_no = findViewById(R.id.tv_material_no);
        tv_material_statue = findViewById(R.id.tv_material_statue);
        edt_desc = findViewById(R.id.edt_desc);
        edt_yusuan_no = findViewById(R.id.edt_yusuan_no);
        edt_yusuanno_desc = findViewById(R.id.edt_yusuanno_desc);
        edt_zhineng_dep = findViewById(R.id.edt_zhineng_dep);
        edt_shiyong_fangiang = findViewById(R.id.edt_shiyong_fangiang);
        tv_order_type = findViewById(R.id.tv_order_type);
        tv_cost = findViewById(R.id.tv_cost);
        tv_iswar_material = findViewById(R.id.tv_iswar_material);
        tv_write_by = findViewById(R.id.tv_write_by);
        tv_requset_dep = findViewById(R.id.tv_requset_dep);
        tv_write_time = findViewById(R.id.tv_write_time);
        tv_material_team = findViewById(R.id.tv_material_team);
        tv_material_phone = findViewById(R.id.tv_material_phone);

        ll_1 = findViewById(R.id.ll_1);
        ll_2 = findViewById(R.id.ll_2);
        ll_3 = findViewById(R.id.ll_3);
        ll_4 = findViewById(R.id.ll_4);
        ll_5 = findViewById(R.id.ll_5);
        //容器
        ll_material_line = findViewById(R.id.ll_material_line);
        //新建行
//        tv_new_line = findViewById(R.id.tv_new_line);
        //启动工作流
        tv_start = findViewById(R.id.tv_start);


    }

    private void initEvent() {
        edt_yusuan_no.setEnabled(false);
        edt_zhineng_dep.setEnabled(false);
        edt_shiyong_fangiang.setEnabled(false);
//
//        ll_1.setOnClickListener(this);
//        ll_3.setOnClickListener(this);
//        ll_4.setOnClickListener(this);
//        ll_5.setOnClickListener(this);
        ll_back.setOnClickListener(this);
//        tv_new_line.setOnClickListener(this);
        tv_start.setOnClickListener(this);
        if (needGet) {
            getDetail();
        } else {
            if (statues.equals("已批准")) {
                ll_1.setEnabled(false);
                ll_2.setEnabled(false);
                ll_3.setEnabled(false);
                ll_4.setEnabled(false);
                ll_5.setEnabled(false);
                edt_desc.setEnabled(false);
                edt_yusuan_no.setEnabled(false);
                edt_yusuanno_desc.setEnabled(false);
                edt_zhineng_dep.setEnabled(false);
                edt_shiyong_fangiang.setEnabled(false);
                tv_start.setVisibility(View.GONE);
                iv_fun.setVisibility(View.GONE);
//                tv_new_line.setVisibility(View.GONE);
            } else  {
                edt_desc.setEnabled(true);
            }
            tv_material_no.setText("领料单编号:" + mResultlistBean.getWONUM());
            tv_material_statue.setText(mResultlistBean.getSTATUS());
            edt_desc.setText("" + mResultlistBean.getDESCRIPTION());
            edt_yusuan_no.setText("");
            edt_yusuanno_desc.setText(mResultlistBean.getYSDESCRIPTION());
            edt_zhineng_dep.setText(mResultlistBean.getA_TODEPT());//职能部门
            edt_shiyong_fangiang.setText(mResultlistBean.getA_USEFOR());//使用方向
            tv_order_type.setText(mResultlistBean.getWOTYPEDESC());//通用领料单
            tv_cost.setText("总成本:" + mResultlistBean.getESTMATCOST());
            tv_iswar_material.setText("是否战略物资:" + mResultlistBean.getA_MARKA());
            tv_write_by.setText("申请人:" + mResultlistBean.getREPORTEDBYDESC());
            tv_requset_dep.setText("申请部门:" + mResultlistBean.getA_DEPT());
            tv_write_time.setText("申请日期:" + mResultlistBean.getREPORTDATE());
            tv_material_team.setText("申请班组:" + mResultlistBean.getBZ());
            tv_material_phone.setText("申请电话:" + mResultlistBean.getPRIMARYPHONE());
            getMaterialLine();
        }

    }

    private void getDetail() {
        /**
         * -- 领料单代办进详情：:OWNERID代办列表获取到的值
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"WORKORDER","objectname":"WORKORDER","curpage":1,"showcount":20,"option":"read","sqlSearch":" WORKORDERID=:OWNERID "}
         */
        ld.show();
        LogUtils.d("getContractDetail");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "WORKORDER");
        object.put("objectname", "WORKORDER");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("sqlSearch", "WORKORDERID= "+OWNERID);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ToastUtils.showShort(R.string.getDatafailed);
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (!response.isEmpty()) {
                    MaterialDetailBean materialDetaiBean = JSONObject.parseObject(response, new TypeReference<MaterialDetailBean>() {});
                    if (materialDetaiBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<MaterialDetailBean.ResultBean.ResultlistBean> resultlist = materialDetaiBean.getResult().getResultlist();
                        ll_material_line.removeAllViews();
                        if (resultlist.size() > 0) {
                            statues=resultlist.get(0).getSTATUS();
                            WONUM=resultlist.get(0).getWONUM();
                            SITEID=resultlist.get(0).getSITEID();
                            WORKORDERID=resultlist.get(0).getWORKORDERID()+"";

                            if (statues.equals("已取消")){
                                tv_start.setVisibility(View.GONE);
                            }else {
                                if (statues.equals("起草")){
                                    tv_start.setText("启动工作流");
                                }else {
                                    tv_start.setText("工作流审批");
                                }
                            }
                            if (statues.equals("已批准")) {
                                ll_1.setEnabled(false);
                                ll_2.setEnabled(false);
                                ll_3.setEnabled(false);
                                ll_4.setEnabled(false);
                                ll_5.setEnabled(false);
                                edt_desc.setEnabled(false);
                                edt_yusuan_no.setEnabled(false);
                                edt_yusuanno_desc.setEnabled(false);
                                edt_zhineng_dep.setEnabled(false);
                                edt_shiyong_fangiang.setEnabled(false);
                                tv_start.setVisibility(View.GONE);
                                iv_fun.setVisibility(View.GONE);
//                                tv_new_line.setVisibility(View.GONE);
                            } else  {
                                edt_desc.setEnabled(true);
                            }
                            tv_material_no.setText("领料单编号:" + resultlist.get(0).getWONUM());
                            tv_material_statue.setText(resultlist.get(0).getSTATUS());
                            edt_desc.setText("" + resultlist.get(0).getDESCRIPTION());
                            edt_yusuan_no.setText("");
                            edt_yusuanno_desc.setText(resultlist.get(0).getYSDESCRIPTION());
                            edt_zhineng_dep.setText(resultlist.get(0).getA_TODEPT());//职能部门
                            edt_shiyong_fangiang.setText(resultlist.get(0).getA_USEFOR());//使用方向
                            tv_order_type.setText(resultlist.get(0).getWOTYPEDESC());//通用领料单
                            tv_cost.setText("总成本:" + resultlist.get(0).getESTMATCOST());
                            tv_iswar_material.setText("是否战略物资:" + resultlist.get(0).getA_MARKA());
                            tv_write_by.setText("申请人:" + resultlist.get(0).getREPORTEDBYDESC());
                            tv_requset_dep.setText("申请部门:" + resultlist.get(0).getA_DEPT());
                            tv_write_time.setText("申请日期:" + resultlist.get(0).getREPORTDATE());
                            tv_material_team.setText("申请班组:" + resultlist.get(0).getBZ());
                            tv_material_phone.setText("申请电话:" + resultlist.get(0).getPRIMARYPHONE());
                                getMaterialLine();
                        }


                    }

                }

            }

        });
    }

    /**
     * -- 领料单明细行查询
     * http://192.168.1.180:7009/maximo/mobile/common/api?data=
     * {"appid":"WPMATERIAL","objectname":"WPMATERIAL","curpage":1,"showcount":20,"option":"read",
     * "orderby":"","sqlSearch":" wonum in (select wonum from workorder where (wonum=:wonum or (parent=:wonum )) and siteid=:siteid ) "}
     */
    private void getMaterialLine() {
        ld.show();
        LogUtils.d("getContractDetail");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "WPMATERIAL");
        object.put("objectname", "WPMATERIAL");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("orderby", "");
        String sqlSearch = "wonum in (select wonum from workorder where (wonum=%s or (parent=%s )) and siteid=%s ) ";
        sqlSearch = String.format(sqlSearch, "'" + WONUM + "'", "'" + WONUM + "'", "'" + SITEID + "'");
        object.put("sqlSearch", sqlSearch);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ToastUtils.showShort(R.string.getDatafailed);
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (!response.isEmpty()) {
                    MaterialDetailLineBean materialDetailLineBean = JSONObject.parseObject(response, new TypeReference<MaterialDetailLineBean>() {
                    });
                    if (materialDetailLineBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<MaterialDetailLineBean.ResultBean.ResultlistBean> resultlist = materialDetailLineBean.getResult().getResultlist();
                        ll_material_line.removeAllViews();
                        if (resultlist.size() > 0) {
                            for (int i = 0; i < resultlist.size(); i++) {
                                View inflate = LayoutInflater.from(MaterialRequestDetailActivity.this).inflate(R.layout.material_detail_attach, ll_material_line, false);
                                TextView tv_attach_no = inflate.findViewById(R.id.tv_attach_no);
                                TextView tv_wuzi_no = inflate.findViewById(R.id.tv_wuzi_no);
                                TextView tv_wuzi_desc = inflate.findViewById(R.id.tv_wuzi_desc);
                                TextView tv_store = inflate.findViewById(R.id.tv_store);
                                TextView tv_count = inflate.findViewById(R.id.tv_count);
                                TextView tv_unit_cost = inflate.findViewById(R.id.tv_unit_cost);
                                TextView tv_line_cost = inflate.findViewById(R.id.tv_line_cost);
                                TextView tv_xinghao = inflate.findViewById(R.id.tv_xinghao);
                                TextView tv_brand = inflate.findViewById(R.id.tv_brand);


                                tv_attach_no.setText("明细行序号：" + resultlist.get(i).getITEMNUM());
                                tv_wuzi_no.setText("物资编码：" + resultlist.get(i).getITEMNUM());
                                tv_wuzi_desc.setText("物资描述：" + resultlist.get(i).getWPMATERIALDESC());
                                tv_store.setText("库房：" + resultlist.get(i).getLOCATION());
                                tv_count.setText("领用数量：" + resultlist.get(i).getITEMQTY());
                                tv_unit_cost.setText("单位成本：" + resultlist.get(i).getUNITCOST());
                                tv_line_cost.setText("行成本：" + resultlist.get(i).getLINECOST());
                                tv_xinghao.setText("型号规格：" + resultlist.get(i).getA_MODEL());
                                tv_brand.setText("品牌：" + resultlist.get(i).getA_BRAND());
                                ll_material_line.addView(inflate);
                            }
                        }


                    }

                }

            }

        });

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.iv_fun:
//                update();
                break;
            case R.id.ll_1://预算编号
                intent = new Intent(this, YuSuanListActivity.class);
                intent.putExtra("tag", "预算");
                startActivityForResult(intent, REQUEST_FOR_YUSUAN);
                break;
            case R.id.ll_3://职能部门
                intent = new Intent(this, YuSuanListActivity.class);
                intent.putExtra("tag", "职能部门");
                startActivityForResult(intent, REQUEST_FOR_DEPT);
                break;
            case R.id.ll_4://使用方向
                intent = new Intent(this, YuSuanListActivity.class);
                intent.putExtra("tag", "使用方向");
                startActivityForResult(intent, REQUEST_FOR_USED);
                break;
            case R.id.ll_5://工单类型
                intent = new Intent(this, YuSuanListActivity.class);
                intent.putExtra("tag", "工单类型");
                startActivityForResult(intent, REQUEST_FOR_TYPE);
                break;
//            case R.id.tv_new_line://新建行
////                startActivity(new Intent(this, NewMaterialLineActivity.class).putExtra("WONUM",WONUM));
//
//                break;
            case R.id.tv_start://启动工作流
                if (statues.equals("起草")){
                    showRemarkPopupwindow1();//启动工作流
                }else {
                    if (statues.equals("成本控制主管审批")) {
                        showRemarkPopupwindow2();
                    }else {
                        showRemarkPopupwindow3();
                    }
                }
              
                break;
        }
    }

    /**
     *  除 成本控制主管审批 状态外的弹窗
     */
    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow3() {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.commondialog, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(true);// 点击空白处时，隐藏掉pop窗口
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
        final EditText input_et = (EditText) remarkView.findViewById(R.id.input_et);
        TextView finish_tv = (TextView) remarkView.findViewById(R.id.finish_tv);
        TextView cancel_tv = (TextView) remarkView.findViewById(R.id.cancel_tv);
        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
        ImageView iv_agree = (ImageView) remarkView.findViewById(R.id.iv_agree);
        iv_agree.setBackgroundResource(R.drawable.selected);
        ImageView iv_disagree = (ImageView) remarkView.findViewById(R.id.iv_disagree);
        iv_disagree.setBackgroundResource(R.drawable.unselected);
        iv_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_agree.setBackgroundResource(R.drawable.selected);
                iv_disagree.setBackgroundResource(R.drawable.unselected);
                isAgree = 1;
                input_et.setHint("同意");
                LogUtils.d("同意==");
            }
        });
        iv_disagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_disagree.setBackgroundResource(R.drawable.selected);
                iv_agree.setBackgroundResource(R.drawable.unselected);
                isAgree = 0;
                input_et.setHint("不同意");
                LogUtils.d("不同意==");
            }
        });
        //用于检测输入的字数
        input_et.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;
            private int selectionStart;
            private int selectionEnd;
            private int num = 10;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp = s;
            }

            @Override
            public void afterTextChanged(Editable s) {
                int number = s.length();

            }
        });

        //确定后，添加标签页

        finish_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = input_et.getText().toString().trim();
                goAproval(isAgree, txt);
                pop.dismiss(); //不管有否字符串都应该去dismiss
            }
        });

        cancel_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
    }

    /**
     * 成本控制主管审批 状态的弹窗
     */
    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow2() {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.dialog_for_material, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(true);// 点击空白处时，隐藏掉pop窗口
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
        TextView finish_tv = (TextView) remarkView.findViewById(R.id.finish_tv);
        TextView cancel_tv = (TextView) remarkView.findViewById(R.id.cancel_tv);
        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
        title_tv.setText("完成工作流任务分配");
        TextView tv_text1= (TextView) remarkView.findViewById(R.id.tv_text1);
        TextView  tv_text2= (TextView) remarkView.findViewById(R.id.tv_text2);
        tv_text1.setText("批准领料单，请保管员确认");
        tv_text2.setText("工程部主任工程师审批");
        EditText input_et= (EditText) remarkView.findViewById(R.id.input_et);
        input_et.setVisibility(View.VISIBLE);
        input_et.setHint("批准领料单，请保管员确认");
        ImageView iv_close = (ImageView) remarkView.findViewById(R.id.iv_close);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });
        ImageView iv_agree = (ImageView) remarkView.findViewById(R.id.iv_agree);
        iv_agree.setBackgroundResource(R.drawable.selected);
        ImageView iv_disagree = (ImageView) remarkView.findViewById(R.id.iv_disagree);
        iv_disagree.setBackgroundResource(R.drawable.unselected);
        iv_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_agree.setBackgroundResource(R.drawable.selected);
                iv_disagree.setBackgroundResource(R.drawable.unselected);
                selected = 1;
                input_et.setHint("批准领料单，请保管员确认");
                LogUtils.d("批准领料单，请保管员确认==");
            }
        });
        iv_disagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_disagree.setBackgroundResource(R.drawable.selected);
                iv_agree.setBackgroundResource(R.drawable.unselected);
                selected = 2;
                input_et.setHint("工程部主任工程师审批");
                LogUtils.d("工程部主任工程师审批==");
            }
        });
        finish_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = input_et.getText().toString().trim();
                goAproval(selected,txt);
                pop.dismiss(); //不管有否字符串都应该去dismiss
            }
        });

        cancel_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });

    }

    private void goAproval(int selected,String opinion) {
        ld.show();
        /**
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfservicewfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:processname>MATREQ</max:processname>
         *          <max:mboName>WORKORDER</max:mboName>
         *          <max:keyValue>62719</max:keyValue>
         *          <max:key>WORKORDERID</max:key>
         *          <max:ifAgree>1</max:ifAgree>
         *          <max:opinion>同意</max:opinion>
         *          <max:loginid>JIAWF</max:loginid>
         *       </max:wfservicewfGoOn>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>MATREQ</max:processname>\n" +
                "         <max:mboName>WORKORDER</max:mboName>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>WORKORDERID</max:key>\n" +
                "         <max:ifAgree>%s</max:ifAgree>\n" +
                "         <max:opinion>%s</max:opinion>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicewfGoOn>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        // ifAgree ：1 同意  2 不同意   opinion：输入内容
        // ifAgree ：1 批准领料单，请保管员确认  2 工程部主任工程师审批   opinion：输入内容
        request = String.format(request, WORKORDERID, selected, opinion, SharedPreferencesUtil.getString(this, "personId"));
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");
        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                ld.close();
                LogUtils.d("onResponse==" + response);
                int start = response.indexOf("<return>");
                int end = response.indexOf("</return>");
                String substring = response.substring(start + 8, end);
                LogUtils.d("substring==" + substring);
                StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                });
                if (startWorkProcessBean.getMsg().equals("审批成功")) {
                    statues = startWorkProcessBean.getNextStatus();
                    tv_material_statue.setText(startWorkProcessBean.getNextStatus());
                    startWorkProcessBean.setTag("领料单");//领料单列表刷新
                    EventBus.getDefault().post(startWorkProcessBean);
                } else {

                }
                ToastUtils.showShort(startWorkProcessBean.getMsg());


            }
        });

    }

    private void update() {

        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "<soapenv:Body>\n" +
                "<max:mobileserviceUpdateMbo creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                " <max:json>{\n" +
                "\"A_WOTYPE\" : \"%s\",\n" +//工单类型
                "\"YSDESCRIPTION\" : \"%s\",\n" +//预算编号描述
                "\"A_USEFOR\" : \"%s\",\n" +//用途
                "\"A_BUDGETNUM\" : \"%s\",\n" +//预算编号
                "\"relationShip\" : [\n" +
                "{\n" +
                "      \"SHOWPLANMATERIAL\" : \"\"\n" +
                "}\n" +
                "],\n" +
                "\"TYPE\" : \"update\",\n" +
                "\"DESCRIPTION\" : \"6666666666\"\n" +//描述
                "}</max:json>\n" +
                "<flag>1</flag>\n" +
                "<max:mboObjectName>WORKORDER</max:mboObjectName\n" +
                "><max:mboKey>%s</max:mboKey>\n" +
                "<max:mboKeyValue>41696</max:mboKeyValue>\n" +
                "</max:mobileserviceUpdateMbo>\n" +
                "</soapenv:Body>\n" +
                "</soapenv:Envelope>";

        request = String.format(request, A_WOTYPE, edt_yusuanno_desc.getText().toString(), A_USEFOR, edt_yusuan_no.getText().toString(), edt_desc.getText().toString(), WONUM);

        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");

        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                int start = response.indexOf("<return>");
                int end = response.indexOf("</return>");
                String substring = response.substring(start + 8, end);
                LogUtils.d("substring==" + substring);
                StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                });
                if (startWorkProcessBean.getErrorNo() == 0 && startWorkProcessBean.getSuccess().equals("成功")) {

                }
                ToastUtils.showShort(startWorkProcessBean.getSuccess());
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_FOR_YUSUAN) {//预算编号
                YuSuanListBean.ResultBean.ResultlistBean resultlistBean = (YuSuanListBean.ResultBean.ResultlistBean) data.getExtras().get("data");
                edt_yusuan_no.setText(resultlistBean.getPROJECTID());
                edt_yusuanno_desc.setText(resultlistBean.getDESCRIPTION());
            } else if (requestCode == REQUEST_FOR_DEPT) {//职能部门
                CommmonForMaterialDetailBean.ResultBean.ResultlistBean resultlistBean = (CommmonForMaterialDetailBean.ResultBean.ResultlistBean) data.getExtras().get("data");
                edt_zhineng_dep.setText(resultlistBean.getDESCRIPTION());
            } else if (requestCode == REQUEST_FOR_USED) {//使用方向
                CommmonForMaterialDetailBean.ResultBean.ResultlistBean resultlistBean = (CommmonForMaterialDetailBean.ResultBean.ResultlistBean) data.getExtras().get("data");
                edt_shiyong_fangiang.setText(resultlistBean.getDESCRIPTION());
                A_USEFOR = resultlistBean.getVALUE();
            } else if (requestCode == REQUEST_FOR_TYPE) {//工单类型
                CommmonForMaterialDetailBean.ResultBean.ResultlistBean resultlistBean = (CommmonForMaterialDetailBean.ResultBean.ResultlistBean) data.getExtras().get("data");
                tv_order_type.setText(resultlistBean.getDESCRIPTION());
                A_WOTYPE = resultlistBean.getVALUE();
            }
        }
    }

    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow1() {
        View rootView = LayoutInflater.from(this).inflate(R.layout.project_month_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.dialog_for_material, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(true);// 点击空白处时，隐藏掉pop窗口
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
        TextView finish_tv = (TextView) remarkView.findViewById(R.id.finish_tv);
        TextView cancel_tv = (TextView) remarkView.findViewById(R.id.cancel_tv);
        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
        ImageView iv_close = (ImageView) remarkView.findViewById(R.id.iv_close);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });
        ImageView iv_agree = (ImageView) remarkView.findViewById(R.id.iv_agree);
        iv_agree.setBackgroundResource(R.drawable.selected);
        ImageView iv_disagree = (ImageView) remarkView.findViewById(R.id.iv_disagree);
        iv_disagree.setBackgroundResource(R.drawable.unselected);
        iv_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_agree.setBackgroundResource(R.drawable.selected);
                iv_disagree.setBackgroundResource(R.drawable.unselected);
                selected = 1;
                LogUtils.d("常规==");
            }
        });
        iv_disagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_disagree.setBackgroundResource(R.drawable.selected);
                iv_agree.setBackgroundResource(R.drawable.unselected);
                selected = 2;
                LogUtils.d("特殊==");
            }
        });
        finish_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWork(selected);
                pop.dismiss(); //不管有否字符串都应该去dismiss
            }
        });

        cancel_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
    }

    private void startWork(int selected) {
        ld.show();
/**
 * <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
 * 	<soap:Header />
 * 	<soap:Body>
 * 		<wfservicestartWF2 xmlns="http://www.ibm.com/maximo">
 * 			<processname>MATREQ</processname>
 * 			<mbo>WORKORDER</mbo>
 * 			<keyValue>41696</keyValue>
 * 			<key>WONUM</key>
 * 			<nodenum>1</nodenum>
 * 			<loginid>SHENKK</loginid>
 * 		</wfservicestartWF2>
 * 	</soap:Body>
 * </soap:Envelope>
 */
        String request = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "\t<soap:Header />\n" +
                "\t<soap:Body>\n" +
                "\t\t<wfservicestartWF2 xmlns=\"http://www.ibm.com/maximo\">\n" +
                "\t\t\t<processname>MATREQ</processname>\n" +
                "\t\t\t<mbo>WORKORDER</mbo>\n" +
                "\t\t\t<keyValue>%s</keyValue>\n" +
                "\t\t\t<key>WONUM</key>\n" +
                "\t\t\t<nodenum>%s</nodenum>\n" +
                "\t\t\t<loginid>%s</loginid>\n" +
                "\t\t</wfservicestartWF2>\n" +
                "\t</soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, WONUM, selected, SharedPreferencesUtil.getString(this, "personId"));
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");

        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                int start = response.indexOf("<return>");
                int end = response.indexOf("</return>");
                String substring = response.substring(start + 8, end);
                LogUtils.d("substring==" + substring);
                StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                });
                if (startWorkProcessBean.getMsg().equals("流程启动成功！")) {
                    tv_start.setText("工作流审批");
                    statues = startWorkProcessBean.getNextStatus();
                    tv_material_statue.setText(startWorkProcessBean.getNextStatus());
                    startWorkProcessBean.setTag("领料单");//领料单列表刷新
                    EventBus.getDefault().post(startWorkProcessBean);
                }
                ToastUtils.showShort(startWorkProcessBean.getMsg());
            }
        });
    }

    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) this).getWindow().setAttributes(lp);
    }
    @Subscribe (threadMode = ThreadMode.MAIN)
    public void getNotiFication(PostData postData){
        LogUtils.d("222222 getNotiFication");
        if (postData!=null&&postData.getTag().equals("new  line  scuess")){
            getMaterialLine();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
