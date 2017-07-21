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

    public abstract void onClick();
    public abstract void initView();
    public abstract void initData();
    public abstract void logic();


}
