package com.example.a3559dell.headlinestoday_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a3559dell.headlinestoday_demo.Adapter.ViewPagerAdapter;
import com.example.a3559dell.headlinestoday_demo.R;
import com.example.a3559dell.headlinestoday_demo.fragment.ContentFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity{
    @ViewInject(R.id.title_leftdrawer)
    private ImageView imageleftDrawer;
    @ViewInject(R.id.drawerLayout)
    private DrawerLayout drawerLyout;

    @ViewInject(R.id.tabLayout)
    private TabLayout tabLayout;

    @ViewInject(R.id.title_vp)
    private ViewPager vp;
    private Button loginButton;
    @ViewInject(R.id.navigation)
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        View headerView = navigationView.getHeaderView(0);
        loginButton = (Button) headerView.findViewById(R.id.loginButton);

        OnClik();
        setTabBar();
    }

    private void setTabBar() {
        List<Fragment> list = new ArrayList<>();
        for(int i= 0 ; i <7;i++){
            list.add(new ContentFragment());
        }
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),list);
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);
        tabLayout.getTabAt(0).setText("推荐");
        tabLayout.getTabAt(1).setText("热点");
        tabLayout.getTabAt(2).setText("北京");
        tabLayout.getTabAt(3).setText("社会");
        tabLayout.getTabAt(4).setText("头条");
        tabLayout.getTabAt(5).setText("看点");
        tabLayout.getTabAt(6).setText("关注");
    }
    private void OnClik() {
        imageleftDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLyout.openDrawer(Gravity.LEFT);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new  Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setCheckable(true);
                drawerLyout.closeDrawers();
                return true;
            }
        });
    }

}