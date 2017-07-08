package com.example.a3559dell.headlinestoday_demo.application;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by 3559dell on 2017/7/7.
 */
public class MyApplication extends Application {
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
    private UMShareAPI mUMShareAPI;
    private DbManager.DaoConfig config;

    public DbManager.DaoConfig getConfig() {
        return config;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mUMShareAPI= UMShareAPI.get(this);
        x.Ext.init(this);
        config = new DbManager.DaoConfig()
                .setDbName("user.db")
                .setDbVersion(1);
    }

    public UMShareAPI getmUMShareAPI() {
        return mUMShareAPI;
    }
}
