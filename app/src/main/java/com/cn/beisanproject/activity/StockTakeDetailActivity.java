package com.cn.beisanproject.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.Utils.Tools;
import com.cn.beisanproject.fragment.ProjectContractDetailFragment;
import com.cn.beisanproject.fragment.ProjectInvoiceFragment;
import com.cn.beisanproject.fragment.StockTakeDetailDiffFragment;
import com.cn.beisanproject.fragment.StockTakeDetailFragment;
import com.cn.beisanproject.handler.RFIDHandler;
import com.cn.beisanproject.modelbean.PostData;
import com.cn.beisanproject.modelbean.StartWorkProcessBean;
import com.cn.beisanproject.modelbean.StockingLineListBean;
import com.cn.beisanproject.modelbean.StockingTakeListBean;
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
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * created by tzl 2020 07 11 库存盘点
 */

public class StockTakeDetailActivity extends AppCompatActivity implements View.OnClickListener, EasyPermissions.PermissionCallbacks {
    StockingTakeListBean.ResultBean.ResultlistBean mResultlistBean;
    private TextView tv_pandian_no;
    private TextView tv_pandian_desc;
    private TextView tv_pandian_date;
    private TextView tv_location;
    private TextView tv_created_by;
    private TextView tv_created_time;
    private TextView tv_big_type;
    private TextView tv_middle_type;
    private TextView tv_small_type;
    private TextView tv_back;
    private TextView tv_common_title;
    private LinearLayout ll_stock_line;
    ImageView iv_fun;
    List<StockingLineListBean.ResultBean.ResultlistBean> resultlist;
    private static final int REQUEST_CODE_QRCODE_PERMISSIONS = 1;
    private MagicIndicator magicIndicator;
    private ViewPager pager;
    private ArrayList<Fragment> fragmentList;
    private Fragment currentFragment;
    private ArrayList<String> titles;
    private String model;
    private String carrier;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_detail_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);
        model = android.os.Build.MODEL;//手机型号
        carrier = Build.MANUFACTURER;//手机厂商
        LogUtils.d("model== " + model + "       carrie=r=" + carrier);

        tv_back = findViewById(R.id.tv_back);
        tv_back.setOnClickListener(this);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("盘点详情");
        iv_fun = findViewById(R.id.iv_fun);
        iv_fun.setBackground(getResources().getDrawable(R.drawable.scan));

        iv_fun.setOnClickListener(this);
        pager = findViewById(R.id.pager);
        magicIndicator = findViewById(R.id.magicIndicator);
        findViewById(R.id.tv_start).setVisibility(View.GONE);

        mResultlistBean = (StockingTakeListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("ResultlistBean");
        initView();


    }

    private void initView() {
        titles = new ArrayList<String>();
        pager.removeAllViews();
        titles.clear();
        titles.add("库存盘点详情");
        titles.add("库存差异");

        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.clear();
        StockTakeDetailFragment detailFragment = new StockTakeDetailFragment(this, mResultlistBean);
        StockTakeDetailDiffFragment detailLineFragment = new StockTakeDetailDiffFragment(this, mResultlistBean);
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
                linePagerIndicator.setColors(ContextCompat.getColor(StockTakeDetailActivity.this, R.color.guide_blue));
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
                if (position == 0) {
                    detailFragment.getData();
                } else {
                    detailLineFragment.getData();
                }


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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.iv_fun:
                if (carrier.equals("Zebra Technologies")) {
                    startActivity(new Intent(this, StockCheckScanZebraActivity.class).putExtra("mResultlistBean", mResultlistBean));

                }else {
                    requestCodeQRCodePermissions();

                }
                break;
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_QRCODE_PERMISSIONS) {
            LogUtils.d("222222", permissions.length + "");
            switch (permissions[0]) {
                case Manifest.permission.CAMERA:
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        startActivity(new Intent(this, StockCheckScanActivity.class).putExtra("mResultlistBean", mResultlistBean));
                    }
                    break;

            }
        }
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);

    }

    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private void requestCodeQRCodePermissions() {
        LogUtils.d("222222", "requestCodeQRCodePermissions()");

        String[] perms = {Manifest.permission.CAMERA};
        if (!EasyPermissions.hasPermissions(this, perms)) {
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_QRCODE_PERMISSIONS, perms);
        } else {
            startActivity(new Intent(this, StockCheckScanActivity.class).putExtra("mResultlistBean", mResultlistBean));

        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
