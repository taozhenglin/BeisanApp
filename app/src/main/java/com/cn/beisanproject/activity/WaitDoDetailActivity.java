package com.cn.beisanproject.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cn.beisanproject.modelbean.WaitDoListBean;

import java.util.List;

/**
 * created by tzl 2020 07 10 代办事项详情
 */
public class WaitDoDetailActivity extends AppCompatActivity {
    private List<WaitDoListBean.ResultBean.ResultlistBean> mResultlistBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mResultlistBean= (List<WaitDoListBean.ResultBean.ResultlistBean>) getIntent().getExtras().get("ResultlistBean");

    }
}
