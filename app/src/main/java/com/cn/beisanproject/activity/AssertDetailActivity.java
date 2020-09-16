package com.cn.beisanproject.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.Base.Constants;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.DevicesUtil;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.Utils.Tools;
import com.cn.beisanproject.adapter.AsseertCheckAdapter;
import com.cn.beisanproject.fragment.AssertDetailAllFragment;
import com.cn.beisanproject.fragment.AssertDetailWaitCheckFragment;
import com.cn.beisanproject.fragment.PurchaseContractDetailFragment;
import com.cn.beisanproject.fragment.PurchaseContractLineFragment;
import com.cn.beisanproject.handler.RFIDHandler;
import com.cn.beisanproject.modelbean.AssertCheckListBean;
import com.cn.beisanproject.modelbean.AssertDetailBean;
import com.cn.beisanproject.modelbean.AssertDetailLineBean;
import com.cn.beisanproject.modelbean.MyTagData;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.net.CallBackUtil;
import com.cn.beisanproject.net.OkhttpUtil;
import com.yinglan.keyboard.HideUtil;
import com.zebra.rfid.api3.TagData;

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
/**
 * created by tzl 2020 8 12  固定资产盘点详情
 */
public class AssertDetailActivity extends AppCompatActivity implements View.OnClickListener {
    AssertCheckListBean.ResultBean.ResultlistBean resultlistBean;
    private TextView tv_back;
    private TextView tv_common_title;
    private LinearLayout ll_assert_container;
    private RFIDHandler rfidHandler;
    List<AssertDetailLineBean.ResultBean.ResultlistBean> resultlist;
    private ArrayList<String> titles;
    private MagicIndicator magicIndicator;
    private ViewPager pager;
    private ArrayList<Fragment> fragmentList;
    private Fragment currentFragment;
    private ArrayList<AssertDetailLineBean.ResultBean.ResultlistBean> waitCheckList;
    List<String> list;
    private ImageView in_fun;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assert_detail_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        resultlistBean = (AssertCheckListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
        initView();

//        // RFID Handler
//        rfidHandler = new RFIDHandler();
//        rfidHandler.onCreate(this);

        list=new ArrayList<>();
    }

    private void initView() {
        tv_back = findViewById(R.id.tv_back);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("固定资产盘点详情");
        tv_back.setOnClickListener(this);
        pager = findViewById(R.id.pager);
        magicIndicator = findViewById(R.id.magicIndicator);
        in_fun=findViewById(R.id.iv_fun);
        in_fun.setBackground(getResources().getDrawable(R.drawable.check));
        in_fun.setOnClickListener(this);
        if (!DevicesUtil.getDevicesType().equals("Zebra Technologies")){//非斑马感应设备
            in_fun.setVisibility(View.GONE);
        }
        titles = new ArrayList<String>();
        pager.removeAllViews();
        titles.clear();
        titles.add("盘点汇总");
        titles.add("盘点差异");

        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.clear();
        AssertDetailAllFragment allFragment = new AssertDetailAllFragment(this, resultlistBean);
        AssertDetailWaitCheckFragment waitCheckFragment = new AssertDetailWaitCheckFragment(this, resultlistBean);
        fragmentList.add(allFragment);
        fragmentList.add(waitCheckFragment);

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
                linePagerIndicator.setColors(ContextCompat.getColor(AssertDetailActivity.this, R.color.guide_blue));
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


//    private void setInfo(List<AssertDetailLineBean.ResultBean.ResultlistBean> resultlist) {
//        ll_assert_container.removeAllViews();
//        if (resultlist.size() > 0) {
//            for (int i = 0; i < resultlist.size(); i++) {
//                View view = LayoutInflater.from(AssertDetailActivity.this).inflate(R.layout.asseert_line_item, ll_assert_container, false);
//                TextView tv_assert_name = view.findViewById(R.id.tv_assert_name);
//                TextView tv_assert_admin = view.findViewById(R.id.tv_assert_admin);
//                TextView tv_department = view.findViewById(R.id.tv_department);
//                TextView tv_shiyong_statue = view.findViewById(R.id.tv_shiyong_statue);
//                TextView tv_shiyong_people = view.findViewById(R.id.tv_shiyong_people);
//                TextView tv_shigong_deparment = view.findViewById(R.id.tv_shigong_deparment);
//                TextView tv_project_deparment = view.findViewById(R.id.tv_project_deparment);
//                TextView tv_owner_companny = view.findViewById(R.id.tv_owner_companny);
//                TextView tv_assert_type = view.findViewById(R.id.tv_assert_type);
//                TextView tv_xinghao = view.findViewById(R.id.tv_xinghao);
//                TextView tv_count_date = view.findViewById(R.id.tv_count_date);
//                TextView tv_buy_time = view.findViewById(R.id.tv_buy_time);
//                TextView tv_start_time = view.findViewById(R.id.tv_start_time);
//                TextView tv_store_address = view.findViewById(R.id.tv_store_address);
//                TextView tv_zhejiu = view.findViewById(R.id.tv_zhejiu);
//                TextView tv_origin_value = view.findViewById(R.id.tv_origin_value);
//                TextView tv_has_checked = view.findViewById(R.id.tv_has_checked);
//                ImageView iv_haschecked = view.findViewById(R.id.iv_haschecked);
//
//                tv_assert_name.setText("固定资产名称：" + resultlist.get(i).getDESCRIPTION());
//                tv_assert_admin.setText("资产管理员：" + resultlist.get(i).getADMINISTRATOR());
//                tv_department.setText("使用部门：" + resultlist.get(i).getDEPARTMENT());
//                tv_shiyong_statue.setText("使用情况：" + resultlist.get(i).getSYQK());
//                tv_shiyong_people.setText("使用人：" + resultlist.get(i).getDISPLAYNAME());
//                tv_shigong_deparment.setText("施工单位：" + resultlist.get(i).getSGCOM());
//                tv_project_deparment.setText("项目主办方：" + resultlist.get(i).getMANAGEMENT());
//                tv_owner_companny.setText("所属公司：" + resultlist.get(i).getOWNERSITE());
//                tv_assert_type.setText("固定资产类别：" + resultlist.get(i).getASSETTYPE());
//                tv_xinghao.setText("固定资产型号：" + resultlist.get(i).getPRODUCTMODEL());
//                tv_count_date.setText("财务入账时间：" + resultlist.get(i).getFIXASSETDATE());
//                tv_buy_time.setText("购买时间：" + resultlist.get(i).getDATEOFPURCHASE());
//                tv_start_time.setText("启用时间：" + resultlist.get(i).getDATEPLACEDINSERVICE());
//                tv_store_address.setText("存放地点：" + resultlist.get(i).getCFDD());
//                tv_zhejiu.setText("折旧年限：" + resultlist.get(i).getDEPRECIATIONPERIOD());
//                tv_origin_value.setText("资产原值：" + resultlist.get(i).getCOST());
//                tv_has_checked.setText("是否已盘点：" + resultlist.get(i).getYPD());
//                ll_assert_container.addView(view);
//            }
//        }
//    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_back:
                finish();
                break;
            case R.id.iv_fun:

                startActivity(new Intent(this,AssertCheckActivity.class).putExtra("resultlistBean",resultlistBean));
                break;
        }
    }





//    @Override
//    public void handleTagdata(TagData[] tagData) {
//        Log.d("222222", "handleTagdata");
//        ToastUtils.showShort("handleTagdata");
//        final StringBuilder sb = new StringBuilder();
//        for (int index = 0; index < tagData.length; index++) {
////            sb.append(tagData[index].getTagID() + "\n");
//            if (!list.contains(tagData[index].getTagID())) {
//                list.add(tagData[index].getTagID());
//            }
//        }
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(list.get(i) + "\n");
//        }
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
////                textrfid.append(sb.toString());
//                Log.d("222222", "sb.toString()=" + sb.toString() +"tagData.size"+tagData.length);
//                ToastUtils.showShort(sb.toString() +"list.size="+list.size());
//
//                PostData data=new PostData();
//                data.setTag("固定资产盘点");
//                EventBus.getDefault().post(data);
//            }
//        });
//    }

//    @Override
//    public void handleTriggerPress(boolean pressed) {
//        if (pressed) {
//            Log.d("222222", "handleTriggerPress pressed=true");
//
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
////                    textrfid.setText("");
//                }
//            });
//            rfidHandler.performInventory();
//        } else {
//            Log.d("222222", "handleTriggerPress pressed=false");
//            rfidHandler.stopInventory();
//        }
//    }

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
    @Override
    protected void onPause() {
        super.onPause();
//        rfidHandler.onPause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
//        String onResume = rfidHandler.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        rfidHandler.onDestroy();
    }
}
