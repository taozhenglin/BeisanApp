package com.cn.beisanproject.activity;

import android.annotation.SuppressLint;
import android.os.Build;

import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.Utils.SharedPreferencesUtil;
import com.cn.beisanproject.Utils.StatusBarUtils;
import com.cn.beisanproject.fragment.FunCtionFragment;
import com.cn.beisanproject.fragment.PersonalCenterFragment;
import com.cn.beisanproject.fragment.WaitDoFragment;
import com.cn.beisanproject.widget.GSViewPager;
import com.stx.xhb.commontitlebar.CustomTitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GSViewPager viewPager;
    private BottomNavigationBar bottomNavigationBar;//导航栏

    private List<Fragment> mList; //ViewPager的数据源
    private CustomTitleBar mTopBar;
    private TextBadgeItem mWaitDoNumberBadgeItem;

    public String[] mBottonBarTitle = {"功能", "待办事项", "我的"};
    public String[] mTopBarTitle = {"导航中心", "待办任务管理", "个人中心"};
    public String username;
    private TextView tv_common_title;
    private TextView tv_back;
    private ImageView iv_back;
    private long exitTime;
    private int totalresult;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigationBar();
        initViewPager();
        username= SharedPreferencesUtil.getString(this,"username");
        LogUtils.d("username="+username);
        getSupportActionBar().hide();
        mTopBar = (CustomTitleBar) findViewById(R.id.customtitlebar);
        tv_common_title=findViewById(R.id.tv_common_title);
        tv_back=findViewById(R.id.tv_back);
        iv_back=findViewById(R.id.iv_back);
        tv_back.setVisibility(View.GONE);
        iv_back.setVisibility(View.GONE);
//        mTopBar.addRightImageButton(R.mipmap.ic_launcher, R.id.topbar_right_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "右侧图片按钮", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "返回", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mTopBar.addRightTextButton("完成", R.id.topbar_right_about_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "完成", Toast.LENGTH_SHORT).show();
//            }
//        });
        tv_common_title.setText(mTopBarTitle[0]);
        mTopBar.setBackgroundColor(getResources().getColor(R.color.guide_blue));
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.guide_blue);


//        application=(SmartApplication)getApplication();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        requsetWaitDo();
        totalresult=SharedPreferencesUtil.getInt(this,"totalresult");
        setWaitDoNum(totalresult);
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        mList = new ArrayList<>();
        mList.add(new FunCtionFragment(this));
        mList.add(new WaitDoFragment(this));
        mList.add(new PersonalCenterFragment(this));

        viewPager = findViewById(R.id.mainViewPage);
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), mList);
        viewPager.setAdapter(mainAdapter); //视图加载适配器
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LogUtils.d("222222 onPageScrolled","当前位置："+position);
            }

            @Override
            public void onPageSelected(int position) {
                LogUtils.d("222222 onPageSelected","当前位置："+position);
                tv_common_title.setText(mTopBarTitle[position]);



            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * 初始化底部导航条
     */
    private void initBottomNavigationBar()  {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottomBar);
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                viewPager.setCurrentItem(position);
//                mTopBar.setTitle(mTopBarTitle[position]);
                tv_common_title.setText(mTopBarTitle[position]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
        // bottomNavigationBar.setTabSelectedListener(this);
        mWaitDoNumberBadgeItem = new TextBadgeItem();
        //  ShapeBadgeItem shapeBadgeItem = new ShapeBadgeItem();
        /**
         * 设置模式
         * 1、BottomNavigationBar.MODE_DEFAULT 默认
         * 如果Item的个数<=3就会使用MODE_FIXED模式，否则使用MODE_SHIFTING模式
         *
         * 2、BottomNavigationBar.MODE_FIXED 固定大小
         * 填充模式，未选中的Item会显示文字，没有换挡动画。
         *
         * 3、BottomNavigationBar.MODE_SHIFTING 不固定大小
         * 换挡模式，未选中的Item不会显示文字，选中的会显示文字。在切换的时候会有一个像换挡的动画
         */
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_DEFAULT);
        /**
         * 设置背景的样式
         * 1、BottomNavigationBar.BACKGROUND_STYLE_DEFAULT 默认
         * 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC 。
         * 如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
         *
         * 2、BottomNavigationBar.BACKGROUND_STYLE_STATIC 导航条的背景色是白色，
         * 加上setBarBackgroundColor（）可以设置成你所需要的任何背景颜色
         * 点击的时候没有水波纹效果
         *
         * 3、BottomNavigationBar.BACKGROUND_STYLE_RIPPLE 导航条的背景色是你设置的处于选中状态的
         * Item的颜色（ActiveColor），也就是setActiveColorResource这个设置的颜色
         * 点击的时候有水波纹效果
         */
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        //设置导航条背景颜色
        //在BACKGROUND_STYLE_STATIC下，表示整个容器的背景色。
        // 而在BACKGROUND_STYLE_RIPPLE下，表示选中Item的图标和文本颜色。默认 Color.WHITE
        //bottomNavigationBar.setBarBackgroundColor(R.color.main_backgroundColor);
        //选中时的颜色,在BACKGROUND_STYLE_STATIC下，表示选中Item的图标和文本颜色。
        // 而在BACKGROUND_STYLE_RIPPLE下，表示整个容器的背景色。默认Theme's Primary Color
        bottomNavigationBar.setActiveColor(R.color.tab_checked);
        //未选中时的颜色，表示未选中Item中的图标和文本颜色。默认为 Color.LTGRAY
        bottomNavigationBar.setInActiveColor(R.color.tab_unchecked);

        //  mWaitDoNumberBadgeItem.hide();

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home, mBottonBarTitle[0]))
                .addItem(new BottomNavigationItem(R.drawable.ic_waitdo, mBottonBarTitle[1]).setBadgeItem(mWaitDoNumberBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_person, mBottonBarTitle[2]))
                .setFirstSelectedPosition(0)
                .initialise(); //所有的设置需在调用该方法前完成

        mWaitDoNumberBadgeItem.setBackgroundColor(getResources().getColor(R.color.red))
                .setTextColor(R.color.black)
                .setGravity(Gravity.RIGHT | Gravity.TOP);
    }

    /**
     * 显示代办提醒
     *
     * @param num
     */
    private void setWaitDoNum(int num) {
        if (num==0) {
            mWaitDoNumberBadgeItem.hide();
        } else {
            mWaitDoNumberBadgeItem.show();
            mWaitDoNumberBadgeItem.setText(num + "");

        }
    }

    /**
     * 请求代办事项的数目
     */
//    private void requsetWaitDo() {
//        String addr = application.getInterfageAddr(Constants.getWaitWorkMenu);
//        HashMap<String, String> map = new HashMap<>();
//        map.put("username", application.getLoginBean().getData().getUsername());
////        map.put("pageNum", "1");
////        map.put("pageSize", "1");
//
//        OkhttpUtil.okHttpGet(addr, map, new CallBackUtil.CallBackString() {
//            @Override
//            public void onFailure(Call call, Exception e) {
//
//            }
//
//            @Override
//            public void onResponse(String response) {
//
//                if (response.isEmpty()) {
//
//                } else {
//
//                    QueryResultBean<WorkOrderBean> queryParaBean;
//                    try {
//                        queryParaBean = JSONObject.parseObject(response, new TypeReference<QueryResultBean<WorkOrderBean>>() {
//                        });
//                    } catch (Exception e) {
//
//                        return;
//                    }
//                    if (!queryParaBean.getCode().equals("200")) {
//
//                    } else {
//                        setWaitDoNum(queryParaBean.getData().getTotal());
//                    }
//                }
//            }
//        });
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 仿返回键退出界面,但不销毁，程序仍在后台运行
            //  moveTaskToBack(false); // 关键的一行代码
            //  return true;

        }
        return super.onKeyDown(keyCode, event);
    }
    public class MainAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList;

        public MainAdapter(FragmentManager fm, List<Fragment> mFragmentList) {
            super(fm);
            this.mFragmentList = mFragmentList;
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
    /**
     * 重新返回按钮
     */
    @Override
    public void onBackPressed() {
        //点击两次退出应用
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            ToastUtils.showShort("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

}