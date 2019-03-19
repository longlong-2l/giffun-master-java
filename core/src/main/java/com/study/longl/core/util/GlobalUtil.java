package com.study.longl.core.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;

import com.study.longl.core.GifFun;
import com.study.longl.core.Log;


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
     */
    private static String appPackage = GifFun.getContext().getPackageName();

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
     * @param mills 睡眠的时长，单位毫秒。
     */
    public static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取AndroidManifest.xml文件中，<application>标签下的meta-data值。
     *
     * @param key
     *  <application>标签下的meta-data健
     */
    public static String getApplicationMetaData(String key) {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = GifFun.getContext().getPackageManager().getApplicationInfo(appPackage, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            Log.logWarn(TAG, e.getMessage(), e);
        }
        if (applicationInfo == null) {
            return "";
        }
        return applicationInfo.metaData.getString(key);
    }
}
