package com.study.longl.main;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.study.longl.core.GifFun;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import org.litepal.LitePal;

/**
 * GifFun自定义Application，在这里进行全局的初始化操作。
 *
 * @author lilong
 * @since 2019/2/1
 */
public class GifFunApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GifFun.initialize(this);
//        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, null);
//        MobclickAgent.setCatchUncaughtExceptions(false);
//        LitePal.initialize(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
