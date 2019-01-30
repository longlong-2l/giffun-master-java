package com.study.longl.core.util;

import android.widget.Toast;

import com.study.longl.core.GifFun;


/**
 * 应用程序全局的通用工具类，功能比较单一，经常被复用的功能，应该封装到此工具类当中，从而给全局代码提供方面的操作。
 *
 * @author lilong
 * @since 17/2/18
 */
public class GlobalUtil {
    private static final String TAG = "GlobalUtil";

    private Toast toast = null;

    /**
     * 获取当前应用程序的包名。
     *
     * @return 当前应用程序的包名。
     */
    public String get() {
        return GifFun.getPackageName();
    }

    /**
     * 将当前线程睡眠指定毫秒数。
     *
     * @param mills
     * 睡眠的时长，单位毫秒。
     */
    public static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
