package com.cn.beisanproject.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;


/**
 * ViewPager禁止滑动
 */
public class GSViewPager extends ViewPager {

    public GSViewPager(Context context) {
        super(context);
    }

    public GSViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,false);
    }

}
