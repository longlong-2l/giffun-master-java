package com.study.longl.network.util;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

import com.study.longl.core.GifFun;
import com.study.longl.core.Log;
import com.study.longl.core.util.GlobalUtil;

/**
 * @author lilong
 * @since 2019/3/19
 */
public class Utility {
    private static final String TAG = "Utility";

    public static String deviceSerial;

    public static String deviceName;

    public static String appSign;

    static {
        deviceName = getDeviceName();
        deviceSerial = getAppVersion();
        appSign = getAppSign();
    }

    /**
     * 获取设备的品牌和型号，如果无法获取到，则返回Unknown。
     *
     * @return 会以此格式返回数据：品牌 型号。
     */
    private static String getDeviceName() {
        String deviceName = Build.BRAND + " " + Build.MODEL;
        if (TextUtils.isEmpty(deviceName)) {
            deviceName = "unknown";
        }
        return deviceName;
    }

    /**
     * 获取当前App的版本号。
     *
     * @return 当前App的版本号。
     */
    private static String getAppVersion() {
        String version = "";
        try {
            PackageManager packageManager = GifFun.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(GifFun.getPackageName(), 0);
            version = packageInfo.versionName;
        } catch (Exception e) {
            Log.logWarn("getAppVersion", e.getMessage(), e);
        }

        if (TextUtils.isEmpty(version)) {
            version = "unknown";
        }
        return version;
    }

    /**
     * 获取App网络请求验证参数，用于辨识是不是官方渠道的App。
     */
    private static String getAppSign() {
        return "";
    }

    /**
     * 获取设备的序列号。如果无法获取到设备的序列号，则会生成一个随机的UUID来作为设备的序列号，UUID生成之后会存入缓存，
     * 下次获取设备序列号的时候会优先从缓存中读取。
     *
     * @return 设备的序列号。
     */
    @SuppressLint("HardwareIds")
    public String getDeviceSerial() {
        if (deviceSerial == null) {
            String deviceId = null;
            String appChannel = GlobalUtil.getApplicationMetaData("APP_CHANNEL");
            if ("google" != appChannel || "samsung" != appChannel) {
                try {
                    deviceId = Settings.Secure.getString(GifFun.getContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                } catch (Exception e) {
                    Log.logWarn(TAG, "get android_id with error", e);
                }
                if (!TextUtils.isEmpty(deviceId) && deviceId.length() < 255) {
                    deviceSerial = deviceId;
                    return deviceSerial;
                }
            }
        }
        return "";
    }
}
