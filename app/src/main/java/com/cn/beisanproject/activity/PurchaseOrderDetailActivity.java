package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.Utils.Tools;
import com.cn.beisanproject.fragment.PurchaseContractDetailFragment;
import com.cn.beisanproject.fragment.PurchaseContractLineFragment;
import com.cn.beisanproject.fragment.PurchaseOrderDetailFragment;
import com.cn.beisanproject.fragment.PurchaseOrdertLineFragment;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.PurchaseOrderListBean;
import com.cn.beisanproject.modelbean.PurchseContractDetailBean;
import com.cn.beisanproject.modelbean.PurchseContractListBean;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.WaitDoListBean;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.yinglan.keyboard.HideUtil;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

public class PurchaseOrderDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout ll_back;
    private TextView tv_common_title;
    TextView tv_start;
    private String contractId;
    String contractNum;
    private MagicIndicator magicIndicator;
    private ViewPager pager;
    private ArrayList<Fragment> fragmentList;
    //    private ArrayList<String> titleList;
    private Fragment currentFragment;
    private ArrayList<String> titles;
    private String statue;
    String url;
    private PurchaseOrderListBean.ResultBean.ResultlistBean mResultlistBean;
    private PopupWindow pop;
    private int isAgree = 1;
    StartWorkProcessBean startWorkProcessBean;
    PurchaseOrderDetailFragment detailFragment;
    String CONTRACTID;
    private WaitDoListBean.ResultBean.ResultlistBean waitdolistbean;
    private boolean needGet;
    private String ownerid;
    PurchseContractDetailBean purchseContractDetailBean;
    private String[] stringItems1 = new String[]{"启动工作流"};
    private String[] stringItems2 = new String[]{"工作流审批"};

    private String CONTRACTNUM;
    private LoadingDialog ld;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contract_detail_activity);
        ll_back = findViewById(R.id.ll_back);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("采购订单");
        tv_start = findViewById(R.id.tv_start);
        pager = findViewById(R.id.pager);
        magicIndicator = findViewById(R.id.magicIndicator);
        ld=new LoadingDialog(this);
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            waitdolistbean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            ownerid = waitdolistbean.getOWNERID() + "";
            getContractDetail();
            LogUtils.d("CONTRACTID=" + CONTRACTID);
        } else {
            mResultlistBean = (PurchaseOrderListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            statue = mResultlistBean.getSTATUS();
            contractNum = mResultlistBean.getCONTRACTNUM();
            CONTRACTID = mResultlistBean.getCONTRACTID() + "";
            if ( statue.equals("已完成") || statue.equals("已取消")||statue.equals("完成") || statue.equals("取消")) {
                tv_start.setVisibility(View.GONE);
            }{
                if (statue.equals("草稿")) {
                    tv_start.setText("启动工作流");
                } else {
                    tv_start.setText("工作流审批");
                }
            }

            initView();
        }

        //键盘自动隐藏
        HideUtil.init(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);

        initListener();
    }
    private void getContractDetail() {
        ld.show();
/**
 * {"appid":"PURCHVIEW",
 * "objectname":"PURCHVIEW",
 * "curpage":1,"showcount":20,
 * "option":"read",
 * "orderby":"STARTDATE DESC",
 * "sqlSearch":" LB='采购合同' and CONTRACTNUM='WZ2145' "}
 */
        LogUtils.d("getContractDetail==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PURCHVIEW");
        object.put("objectname", "PURCHVIEW");
        object.put("curpage", 0);
        object.put("showcount", 1);
        object.put("option", "read");
        object.put("orderby", "STARTDATE DESC");
        LogUtils.d("222222  "+ownerid);
        object.put("sqlSearch", " LB='采购合同' and CONTRACTID= "+"'"+ownerid+"'");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (!response.isEmpty()) {
                    purchseContractDetailBean = JSONObject.parseObject(response, new TypeReference<PurchseContractDetailBean>() {
                    });
                    if (purchseContractDetailBean.getErrcode().equals("GLOBAL-S-0")) {
                        List<PurchseContractDetailBean.ResultBean.ResultlistBean> resultlist = purchseContractDetailBean.getResult().getResultlist();
                        if (resultlist.size() > 0) {
                            CONTRACTID = resultlist.get(0).getCONTRACTID() + "";
                            contractNum = resultlist.get(0).getCONTRACTID() + "";
                            statue = resultlist.get(0).getSTATUS();
                            if ( statue.equals("已完成") || statue.equals("已取消")||statue.equals("完成") || statue.equals("取消")) {
                                tv_start.setVisibility(View.GONE);
                            }{
                                if (statue.equals("草稿")) {
                                    tv_start.setText("启动工作流");
                                } else {
                                    tv_start.setText("工作流审批");
                                }
                            }
                            initView();
                        }


                    }

                }

            }

        });
    }

    private void initView() {

        titles = new ArrayList<String>();
        pager.removeAllViews();
        titles.clear();
        titles.add("采购订单详细信息");
        titles.add("采购订单明细行");

        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.clear();
        detailFragment = new PurchaseOrderDetailFragment(this, mResultlistBean, needGet, purchseContractDetailBean);
        PurchaseOrdertLineFragment purchaseOrdertLineFragment = new PurchaseOrdertLineFragment(this, mResultlistBean, needGet, purchseContractDetailBean);
        fragmentList.add(detailFragment);
        fragmentList.add(purchaseOrdertLineFragment);

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        pager.setAdapter(myFragmentPagerAdapter);
        final CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(titles.get(index));
                simplePagerTitleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.sp13));
                simplePagerTitleView.setPadding(Tools.dip2px(context, 14), Tools.dip2px(context, 1), Tools.dip2px(context, 14), Tools.dip2px(context, 1));
                simplePagerTitleView.setNormalColor(Color.parseColor("#000000"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#008FD7"));
                simplePagerTitleView.setNormalFontSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.sp15));
                simplePagerTitleView.setSelectedFontSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.sp16));
//                simplePagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;


            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                linePagerIndicator.setLineWidth(Tools.dip2px(context, 25));
                linePagerIndicator.setLineHeight(Tools.dip2px(context, 2));
                linePagerIndicator.setRoundRadius(4);
                linePagerIndicator.setColors(ContextCompat.getColor(PurchaseOrderDetailActivity.this, R.color.guide_blue));
                return linePagerIndicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, pager);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                magicIndicator.onPageSelected(position);
            }

            @Override
            public void onPageSelected(int position) {
                LogUtils.d("222222", "position=" + position);
//                magicIndicator.onPageSelected(position);
                currentFragment = fragmentList.get(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                magicIndicator.onPageScrollStateChanged(state);
            }
        });

        pager.setCurrentItem(0);
        currentFragment = fragmentList.get(0);
    }


    private void initListener() {
        tv_start.setOnClickListener(this);
        ll_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_start:
                if (statue.equals("草稿")) {
                   //启动工作流
                    ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems1, tv_start);
                    dialog.isTitleShow(false)
                            .titleTextSize_SP(12)
                            .titleTextColor(Color.parseColor("#33000000"))
                            .cancelText("取消")
                            .cancelText(getResources().getColor(R.color.guide_blue))
                            .itemTextColor(getResources().getColor(R.color.guide_blue))
                            .layoutAnimation(null)
                            .show();
                    dialog.setOnOperItemClickL(new OnOperItemClickL() {
                        @Override
                        public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                            switch (position) {
                                case 0://
                                    start();
                                    dialog.dismiss();
                                    break;
                            }
                        }
                    });
                } else {
                    ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems2, tv_start);
                    dialog.isTitleShow(false)
                            .titleTextSize_SP(12)
                            .titleTextColor(Color.parseColor("#33000000"))
                            .cancelText("取消")
                            .cancelText(getResources().getColor(R.color.guide_blue))
                            .itemTextColor(getResources().getColor(R.color.guide_blue))
                            .layoutAnimation(null)
                            .show();
                    dialog.setOnOperItemClickL(new OnOperItemClickL() {
                        @Override
                        public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                            switch (position) {
                                case 0://
                                    showRemarkPopupwindow();
                                    dialog.dismiss();
                                    break;
                            }
                        }
                    });
                }
                break;

        }
    }

    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow() {
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
                input_et.setHint("驳回");
                LogUtils.d("不同意==");
            }
        });

        //确定后，添加标签页

        finish_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = input_et.getText().toString().trim();
                goApproval(isAgree, txt);
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
    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) this).getWindow().setAttributes(lp);
    }
    private void start() {
        url = Constants.COMMONSOAP;
        String Processname = "CONTPURCH";
        String Mbo = "PURCHVIEW";
        String keyValue = contractNum;
        String key = "CONTRACTNUM";
        String Loginid = SharedPreferencesUtil.getString(this, "personId");
        String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
                "<soap:Header/>" +
                "<soap:Body><wfservicestartWF xmlns=\"http://www.ibm.com/maximo\">" +
                "<processname>%s</processname>" +
                "<mbo>%s</mbo>" +
                "<keyValue>%s</keyValue>" +
                "<key>%s</key>" +
                "<loginid>%s</loginid>" +
                "</wfservicestartWF>" +
                "</soap:Body></soap:Envelope>";
        request = String.format(request, Processname, Mbo, keyValue, key, Loginid);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");

        String s = JSONObject.toJSONString(request);
        OkhttpUtil.okHttpPostJson(url, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());

            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                //xml 解析
                if (!response.isEmpty()) {
                    if (response.contains("<return>")&&response.contains("</return>")){
                        int start = response.indexOf("<return>");
                        int end = response.indexOf("</return>");
                        String substring = response.substring(start + 8, end);
                        LogUtils.d("substring==" + substring);
                        startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {});
                        if (startWorkProcessBean.getMsg().equals("流程启动成功！")) {
                            statue = startWorkProcessBean.getNextStatus();
                            tv_start.setText("工作流审批");
                            PostData postData=new PostData();
                            postData.setTag("采购订单");
                            postData.setNextStatus(statue);
                            EventBus.getDefault().post(postData);
                        } else {

                        }
                        ToastUtils.showShort(startWorkProcessBean.getMsg());
                    }else {
                        ToastUtils.showShort("启动失败");

                    }

                }

            }
        });

    }
    private void goApproval(int ifAgree, String opinion) {
        if (StringUtils.isEmpty(opinion)){
            if (ifAgree==1){
                opinion="同意";
            }else {
                opinion="驳回";
            }
        }
        /**
         * --审批（推送）状态不等于【“草稿”，“已批准”，“已取消”】，调用审批接口
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfmenagementservicwfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:processname>CONTPURCH</max:processname>
         *          <max:mboName>PURCHVIEW</max:mboName>
         *          <max:keyValue>8139</max:keyValue>
         *          <max:key>CONTRACTID</max:key>
         *          <max:ifAgree>1</max:ifAgree>
         *          <max:opinion>审核通过</max:opinion>
         *          <max:loginid>CHENYN</max:loginid>
         *       </max:wfmenagementservicwfGoOn>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\" >" +
                "<max:processname>CONTPURCH</max:processname>" +
                "<max:mboName>PURCHVIEW</max:mboName>" +
                "<max:keyValue>%s</max:keyValue>" +
                "<max:key>CONTRACTID</max:key>" +
                "<max:opinion>%s</max:opinion>" +
                "<max:ifAgree>%s</max:ifAgree>" +
                "<max:loginid>%s</max:loginid>" +
                "</max:wfservicewfGoOn>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
        request = String.format(request, CONTRACTID, opinion, ifAgree, SharedPreferencesUtil.getString(this, "personId"));
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");

        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());

            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                if (response.contains("<return>")&&response.contains("</return>")){
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                    });
                    if (startWorkProcessBean.getMsg().equals("审批成功")) {
                        statue = startWorkProcessBean.getNextStatus();
                        PostData postData=new PostData();
                        postData.setTag("采购订单");
                        postData.setNextStatus(statue);
                        EventBus.getDefault().post(postData);
                    } else {

                    }
                    ToastUtils.showShort(startWorkProcessBean.getMsg());
                }else
                    ToastUtils.showShort("操作失败");


            }
        });
    }

    public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
        private ArrayList<Fragment> fragmentLists;
        private ArrayList<String> titlelists;

        public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList, ArrayList<String> titleList) {
            super(fm);
            this.fragmentLists = fragmentList;
            this.titlelists = titleList;
        }


        @Override
        public Fragment getItem(int position) {
            return fragmentLists.get(position);
        }

        @Override
        public int getCount() {
            return fragmentLists.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titlelists.get(position);
        }
    }
}
