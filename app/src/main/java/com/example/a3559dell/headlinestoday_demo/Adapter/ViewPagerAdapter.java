package com.example.a3559dell.headlinestoday_demo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 3559dell on 2017/7/7.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public ViewPagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}