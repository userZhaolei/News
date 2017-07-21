package com.example.a3559dell.headlinestoday_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a3559dell.headlinestoday_demo.R;
import com.example.a3559dell.headlinestoday_demo.utils.UmengUtils;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.Map;

@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity{
    public  static final int RESULT_CODE = 105;

    @ViewInject(R.id.qqBtn)
    private Button qqBtn;
    @ViewInject(R.id.tenxunButton)
    private Button tenxunButton;
    @ViewInject(R.id.weiboButton)
    private Button weiboButton;
    private UmengUtils umengUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
         umengUtils =  new UmengUtils(this);
        onClick();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        umengUtils.onActivityResult(requestCode, resultCode, data);
    }

    public void onClick( ) {
         qqBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 umengUtils.doUMShareAPI(SHARE_MEDIA.QQ, new UMAuthListener() {
                     @Override
                     public void onStart(SHARE_MEDIA share_media) {

                     }

                     @Override
                     public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        Intent intent = new Intent();
                         intent.putExtra("url",map.get("iconurl"));
                         setResult(RESULT_CODE,intent);
                         finish();
                     }

                     @Override
                     public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                     }

                     @Override
                     public void onCancel(SHARE_MEDIA share_media, int i) {

                     }
                 });
             }
         });
         weiboButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 umengUtils.doUMShareAPI(SHARE_MEDIA.SINA, new UMAuthListener() {
                     @Override
                     public void onStart(SHARE_MEDIA share_media) {

                     }

                     @Override
                     public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                     }

                     @Override
                     public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                     }

                     @Override
                     public void onCancel(SHARE_MEDIA share_media, int i) {

                     }
                 });
             }
         });

        }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void logic() {

    }

}
