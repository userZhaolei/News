package com.example.a3559dell.headlinestoday_demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.xutils.x;

/**
 * Created by 3559dell on 2017/7/21.
 */
public abstract class BaseActivity extends AppCompatActivity  {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initView();
        initData();
        onClick();
        logic();
    }

    /**
     * 点击事件
     */
    public abstract void onClick();

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 逻辑处理
     */
    public abstract void logic();


}
