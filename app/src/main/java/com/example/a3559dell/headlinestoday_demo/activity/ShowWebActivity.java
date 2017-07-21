package com.example.a3559dell.headlinestoday_demo.activity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.a3559dell.headlinestoday_demo.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_show_web)
public class ShowWebActivity extends BaseActivity {
    @ViewInject(R.id.webView)
    private WebView webView;

    private String url;
    @Override
    public void onClick() {

    }
    @Override
    public void initData() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候是控制网页在WebView中去打开，如果为false调用系统浏览器或第三方浏览器打开
                view.loadUrl(url);
                return true;
            }
            //WebViewClient帮助WebView去处理一些页面控制和请求通知
        });
        webView.loadUrl(url);
    }
    @Override
    public void logic() {

    }
    @Override
    public void initView() {
        webView = (WebView) findViewById(R.id.web_webView);
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case 1:

                break;
            case 2:
                Toast.makeText(ShowWebActivity.this, "瞎点这是帮你关闭的", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"帮助");
        menu.add(0,2,0,"关于");
        return super.onCreateOptionsMenu(menu);
    }

}
