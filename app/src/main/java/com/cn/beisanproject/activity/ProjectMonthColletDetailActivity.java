package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.cn.beisanproject.fragment.ProjectMonthColletDetailFragment;
import com.cn.beisanproject.fragment.ProjectMonthColletLineFragment;
import com.cn.beisanproject.modelbean.ProjectMonthCollectBean;
import com.cn.beisanproject.modelbean.PurchaseEnquiryListBean;
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
import java.util.EventListener;
import java.util.HashMap;

import okhttp3.Call;

/**
 * created by tzl 2020 0716 项目月度计划汇总详情
 */
public class ProjectMonthColletDetailActivity extends AppCompatActivity implements View.OnClickListener {
    ProjectMonthCollectBean.ResultBean.ResultlistBean mResultlistBean;
    private TextView tv_back;
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
    String request;
    private PopupWindow pop;
    private int isAgree = 1;
    private String[] stringItems = new String[]{"工作流审批"};
    private String PRID;
    private boolean needGet;
    private WaitDoListBean.ResultBean.ResultlistBean mWitdolistBean;
    private String OWNERID;
    private LoadingDialog ld;
    ProjectMonthCollectBean.ResultBean.ResultlistBean resultlistBean;
    private String PRNUM;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contract_detail_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        ld = new LoadingDialog(this);
        if (!StringUtils.isEmpty(getIntent().getStringExtra("from")) && getIntent().getStringExtra("from").equals("waitdolist")) {//来自代办事项列表
            needGet = true;
            mWitdolistBean = (WaitDoListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
            OWNERID = mWitdolistBean.getOWNERID() + "";
            getDetail();
            LogUtils.d("OWNERID=" + OWNERID);
        } else {
            mResultlistBean = (ProjectMonthCollectBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");//来自首页项目月度计划汇总
            PRID = mResultlistBean.getPRID() + "";
            PRNUM = mResultlistBean.getPRNUM() + "";
            statue = mResultlistBean.getSTATUS();

            initView();
        }


        initListener();
    }

    private void getDetail() {
        /**
         * --项目月度计划汇总待办查询
         * http://192.168.1.180:7009/maximo/mobile/common/api?data=
         * {"appid":"PR","objectname":"PR","curpage":1,"showcount":20,"option":"read","sqlSearch":"PRID=:OWNERID "}
         */
        ld.show();
        LogUtils.d("query==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "PR");
        object.put("objectname", "PR");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("sqlSearch", "PRID= " + "'" + OWNERID + "'");
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
                ProjectMonthCollectBean projectMonthCollectBean;

                if (!response.isEmpty()) {
                    projectMonthCollectBean = JSONObject.parseObject(response, new TypeReference<ProjectMonthCollectBean>() {});

                    if (projectMonthCollectBean.getErrcode().equals("GLOBAL-S-0")) {
                        resultlistBean = projectMonthCollectBean.getResult().getResultlist().get(0);
                        statue = resultlistBean.getSTATUS();
                        PRNUM= resultlistBean.getPRNUM();
                        if (statue.equals("已批准") || statue.equals("已取消")) {
                            tv_start.setVisibility(View.GONE);
                        } else {
                            if (statue.equals("等待批准")) {
                                tv_start.setText("启动工作流");
                            } else {
                                tv_start.setText("工作流审批");
                            }
                        }
                        PRID = resultlistBean.getPRID() + "";
                        initView();

                    }

                }

            }


        });


    }

    private void initListener() {
        tv_start.setOnClickListener(this);
        tv_back.setOnClickListener(this);
    }

    private void initView() {
        tv_back = findViewById(R.id.tv_back);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("项目月度计划汇总");
        tv_start = findViewById(R.id.tv_start);
        if ( statue.equals("已完成") || statue.equals("已取消")||statue.equals("完成") || statue.equals("取消")){
            tv_start.setVisibility(View.GONE);
        } else {
            if (statue.equals("等待批准")) {
                tv_start.setText("启动工作流");
            } else {
                tv_start.setText("工作流审批");
            }
        }
        pager = findViewById(R.id.pager);
        magicIndicator = findViewById(R.id.magicIndicator);
        titles = new ArrayList<String>();
        pager.removeAllViews();
        titles.clear();
        titles.add("项目月度计划汇总详情");
        titles.add("汇总明细行");

        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.clear();
        ProjectMonthColletDetailFragment detailFragment = new ProjectMonthColletDetailFragment(this, mResultlistBean, resultlistBean, needGet);
        ProjectMonthColletLineFragment detailLineFragment = new ProjectMonthColletLineFragment(this, mResultlistBean, resultlistBean, needGet);
        fragmentList.add(detailFragment);
        fragmentList.add(detailLineFragment);

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
                simplePagerTitleView.setNormalFontSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.sp13));
                simplePagerTitleView.setSelectedFontSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.sp14));
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
                linePagerIndicator.setColors(ContextCompat.getColor(ProjectMonthColletDetailActivity.this, R.color.guide_blue));
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
            case R.id.tv_start:
                if (statue.equals("等待批准")) {
                    start();
                } else {
                    ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems, tv_start);
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
                                case 1:
                                    break;
                            }
                        }
                    });
                }
                break;

        }
    }

    private void start() {
        /**
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfservicestartWF creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:processname>PROJSUM</max:processname>
         *          <max:mbo>PR</max:mbo>
         *          <max:keyValue>2897</max:keyValue>
         *          <max:key>PRNUM</max:key>
         *          <max:loginid>MAXADMIN</max:loginid>
         *       </max:wfservicestartWF>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>PROJSUM</max:processname>\n" +
                "         <max:mbo>PR</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>PRNUM</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, PRNUM, SharedPreferencesUtil.getString(this, "personId"));
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");
        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
                ToastUtils.showShort("操作失败");
            }

            @Override
            public void onResponse(String response) {
                ld.close();
                LogUtils.d("onResponse==" + response);
                //解析xml 如果审批同意 则底部审批按钮消失
                if (!response.isEmpty()) {
                    if (response.contains("<return>")&&response.contains("</return>")){
                        int start = response.indexOf("<return>");
                        int end = response.indexOf("</return>");
                        String substring = response.substring(start + 8, end);
                        LogUtils.d("substring==" + substring);
                        StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                        });
                        if (startWorkProcessBean.getMsg().equals("流程启动成功！")) {
                            statue = startWorkProcessBean.getNextStatus();
                            tv_start.setText("工作流审批");
                            startWorkProcessBean.setTag("项目月度计划汇总");
                            EventBus.getDefault().post(startWorkProcessBean);
                        } else {

                        }
                        ToastUtils.showShort(startWorkProcessBean.getMsg());
                    }else {
                        ToastUtils.showShort("操作失败");

                    }

                }


            }
        });
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
                input_et.setHint("不同意");
                LogUtils.d("不同意==");
            }
        });
//        final TextView number_tv = (TextView) remarkView.findViewById(R.id.number_tv);
//        title_tv.setText("给TA贴标签");
//        input_et.setHint("请填写10个字以内的标签名称");
//        finish_tv.setText("确定");
//        number_tv.setText("0/10");

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

    private void goApproval(int ifAgree, String opinion) {
        /**
         * --审批（推送）状态不等于【“草稿”，“已批准”，“已取消”】，调用审批接口
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfmenagementservicwfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:processname>XMHT</max:processname>
         *          <max:mboName>PURCHVIEW</max:mboName>
         *          <max:keyValue>8459</max:keyValue>
         *          <max:key>CONTRACTID</max:key>
         *          <max:ifAgree>1</max:ifAgree>
         *          <max:opinion>审核通过</max:opinion>
         *          <max:loginid>YANGZB</max:loginid>
         *       </max:wfmenagementservicwfGoOn>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
                "<soap:Header/>" +
                "<soap:Body><wfservicestartWF xmlns=\"http://www.ibm.com/maximo\">" +
                "<processname>PROJSUM</processname>" +
                "<mbo>PR</mbo>" +
                "<keyValue>%s</keyValue>" +
                "<key>PRID</key>" +
                "<opinion>%s</opinion>" +
                "<ifAgree>%s</ifAgree>" +
                "<loginid>%s</loginid>" +
                "</wfservicestartWF>" +
                "</soap:Body></soap:Envelope>";
        request = String.format(request, PRID, opinion, ifAgree, SharedPreferencesUtil.getString(this, "personId"));
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
                int start = response.indexOf("<return>");
                int end = response.indexOf("</return>");
                String substring = response.substring(start + 8, end);
                LogUtils.d("substring==" + substring);
                StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                });
                if (startWorkProcessBean.getMsg().equals("审批成功")) {
                    statue = startWorkProcessBean.getNextStatus();
                    startWorkProcessBean.setTag("项目月度计划汇总");
                    EventBus.getDefault().post(startWorkProcessBean);
                } else {

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
