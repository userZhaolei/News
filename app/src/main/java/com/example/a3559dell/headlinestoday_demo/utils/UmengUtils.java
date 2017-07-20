package com.example.a3559dell.headlinestoday_demo.utils;

import android.app.Activity;
import android.content.Intent;

import com.example.a3559dell.headlinestoday_demo.application.MyApplication;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

/**
 * Created by 3559dell on 2017/7/8.
 */
public class UmengUtils {
    private Activity activity;

    public UmengUtils(Activity activity) {
        this.activity = activity;
    }

    public void doUMShareAPI(SHARE_MEDIA share_media, UMAuthListener umAuthListener) {
        MyApplication application = (MyApplication) activity.getApplication();
        UMShareAPI umShareAPI = application.getmUMShareAPI();
        umShareAPI.getPlatformInfo(activity, share_media, umAuthListener);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        MyApplication application = (MyApplication) activity.getApplication();
        UMShareAPI umShareAPI = application.getmUMShareAPI();
        umShareAPI.onActivityResult(requestCode, resultCode, data);
    }
}
