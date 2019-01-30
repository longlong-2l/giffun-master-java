package com.study.longl.main.init.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.study.longl.core.GifFun;
import com.study.longl.core.util.GlobalUtil;
import com.study.longl.main.common.ui.BaseActivity;

/**
 * 闪屏Activity界面，在这里进行程序初始化操作。
 *
 * @author lilong
 * @since 19/1/30
 */
public abstract class SplashActivity extends BaseActivity {
    /**
     * 记录进入SplashActivity的时间。
     */
    private long enterTime = 0;

    /**
     * 判断是否正在跳转或已经跳转到下一个界面。
     */
    private boolean isForwarding = false;

    private boolean hasNewVersion = false;

    private View logoView = null;

    private long MAX_WAIT_TIME = 5000;

    private long MIN_WAIT_TIME = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enterTime = System.currentTimeMillis();
        delayToForward();
    }

    /**
     * 设置闪屏界面的最大延迟跳转，让用户不至于在闪屏界面等待太久。
     */
    private void delayToForward() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                GlobalUtil.sleep(MAX_WAIT_TIME);
//                forwardToNextActivity(false, null);
            }
        }).start();
    }

    /**
     * 跳转到下一个Activity。如果在闪屏界面停留的时间还不足规定最短停留时间，则会在这里等待一会，保证闪屏界面不至于一闪而过。
     */
    public void forwardToNextActivity() {
        if (!isForwarding) {
            isForwarding = true;
            long currentTime = System.currentTimeMillis();
            long timeSpent = currentTime- enterTime;
            if(timeSpent< MIN_WAIT_TIME){
                GlobalUtil.sleep(MIN_WAIT_TIME - timeSpent);
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(GifFun.isLogin()){
//                        Main
                    }
                }
            });
        }
    }
}
