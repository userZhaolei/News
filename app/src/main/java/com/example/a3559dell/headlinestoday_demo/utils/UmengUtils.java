package com.example.a3559dell.headlinestoday_demo.utils;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.a3559dell.headlinestoday_demo.application.MyApplication;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by 3559dell on 2017/7/8.
 */
public class UmengUtils {
    private Activity activity;
    public UmengUtils(Activity activity) {
      this.activity = activity;
    }
    public void doUMShareAPI(SHARE_MEDIA share_media){
        MyApplication application = (MyApplication) activity.getApplication();
        UMShareAPI umShareAPI = application.getmUMShareAPI();
         umShareAPI.doOauthVerify(activity, share_media, new UMAuthListener() {
             @Override
             public void onStart(SHARE_MEDIA share_media) {

             }

             @Override
             public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                 Toast.makeText(activity,"成功",Toast.LENGTH_LONG).show();
             }

             @Override
             public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                 Toast.makeText(activity,"错误",Toast.LENGTH_LONG).show();
             }

             @Override
             public void onCancel(SHARE_MEDIA share_media, int i) {
                 Toast.makeText(activity,"取消",Toast.LENGTH_LONG).show();
             }
         });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        MyApplication application = (MyApplication) activity.getApplication();
        UMShareAPI umShareAPI = application.getmUMShareAPI();
        umShareAPI.onActivityResult( requestCode, resultCode, data);
    }
}
