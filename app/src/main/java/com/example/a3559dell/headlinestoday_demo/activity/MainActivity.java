package com.example.a3559dell.headlinestoday_demo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.andy.library.ChannelActivity;
import com.andy.library.ChannelBean;
import com.bumptech.glide.Glide;
import com.example.a3559dell.headlinestoday_demo.Adapter.ViewPagerAdapter;
import com.example.a3559dell.headlinestoday_demo.R;
import com.example.a3559dell.headlinestoday_demo.fragment.ContentFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @ViewInject(R.id.title_leftdrawer)
    private ImageView imageleftDrawer;
    @ViewInject(R.id.drawerLayout)
    private DrawerLayout drawerLyout;
    @ViewInject(R.id.pindaoBtn)
    private ImageView pindaoBtn;
    @ViewInject(R.id.tabLayout)
    private TabLayout tabLayout;
    private final  String TAB_DATA_KEY = "TabJson";
    @ViewInject(R.id.title_vp)
    private ViewPager vp;
    private Button loginButton;
    @ViewInject(R.id.navigation)
    private NavigationView navigationView;
    private List<ChannelBean> tabList;
    private SharedPreferences sp;
    private List<String> urlList;


    @Override
    public void initData() {
        tabList = new ArrayList<>();
        tabList.add(new ChannelBean("推荐",true));
        tabList.add(new ChannelBean("热点",true));
        tabList.add(new ChannelBean("北京",true));
        tabList.add(new ChannelBean("社会",true));
        tabList.add(new ChannelBean("头条",true));
        tabList.add(new ChannelBean("看点",true));
        tabList.add(new ChannelBean("关注",false));
        tabList.add(new ChannelBean("育儿",false));
        tabList.add(new ChannelBean("体育",true));
        tabList.add(new ChannelBean("购物",false));
        tabList.add(new ChannelBean("育儿",false));
        tabList.add(new ChannelBean("体育",false));
        tabList.add(new ChannelBean("购物",false));
        urlList = new ArrayList<>();
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=war&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=sport&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=tech&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=edu&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=ent&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=money&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=gupiao&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=trave&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=lady&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=war&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=sport&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=tech&limit=30&page=");
        urlList.add("http://wangyi.butterfly.mopaasapp.com/news/api?type=edu&limit=30&page=");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if(resultCode==LoginActivity.RESULT_CODE){
                String url = data.getStringExtra("url");
                Glide.with(MainActivity.this).load(url).into(imageleftDrawer);

            }else if(requestCode==ChannelActivity.REQUEST_CODE){
                String da =data.getStringExtra(ChannelActivity.RESULT_JSON_KEY);
                sp.edit().putString(TAB_DATA_KEY,da).commit();
                logic();
            }
        }
    }

    @Override
    public void onClick() {
        imageleftDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLyout.openDrawer(Gravity.LEFT);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLyout.closeDrawers();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent, 0);
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
        pindaoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = sp.getString(TAB_DATA_KEY, null);
                if(string==null){
                    ChannelActivity.startChannelActivity(MainActivity.this,tabList);
                }else{
                    ChannelActivity.startChannelActivity(MainActivity.this,string);
                }

            }
        });
    }

    @Override
    public void initView() {
        sp = getSharedPreferences("isJson",MODE_PRIVATE);
        View headerView = navigationView.getHeaderView(0);
        loginButton = (Button) headerView.findViewById(R.id.loginButton);
    }

    @Override
    public void logic() {
        List<Fragment> list = new ArrayList<>();

        String str = sp.getString(TAB_DATA_KEY, null);
        if(str==null){
            for(int i = 0;i<tabList.size();i++){
                list.add(new ContentFragment(urlList.get(i)));
            }
        }else{
            List<ChannelBean> listAll= new Gson().fromJson(str, new TypeToken<List<ChannelBean>>() {
            }.getType());
            for(int i = 0;i<listAll.size();i++){
                if (listAll.get(i).isSelect())
                    list.add(new ContentFragment(urlList.get(i)));
            }
        }
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);
        if(str==null){
            for(int i = 0;i<tabList.size();i++){
                tabLayout.getTabAt(i).setText(tabList.get(i).getName());
            }
        }else{
            List<ChannelBean> listAll= new Gson().fromJson(str, new TypeToken<List<ChannelBean>>() {
            }.getType());
            for(int i = 0;i<listAll.size();i++){
                if(listAll.get(i).isSelect()){
                    tabLayout.getTabAt(i).setText(listAll.get(i).getName());
                }

            }
        }
    }

}