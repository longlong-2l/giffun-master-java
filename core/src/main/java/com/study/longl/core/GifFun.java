package com.study.longl.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.study.longl.core.util.SharedUtil;

public class GifFun {

    public static boolean isDebug = false;

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    private static Handler handler;

    private static boolean isLogin;

    private static long userId;

    private static String token;

    private static int loginType = -1;

    public static String BASE_URL = isDebug ? "http://192.168.31.177:3000" : "http://api.quxianggif.com";

    public static final int GIF_MAX_SIZE = 20 * 1024 * 1024;

    /**
     * 初始化接口。这里会进行应用程序的初始化操作，一定要在代码执行的最开始调用。
     *
     * @param c
     *          Context参数，注意这里要传入的是Application的Context，千万不能传入Activity或者Service的Context。
     */
    public static void initialize(Context c) {
        context = c;
        handler = new Handler(Looper.getMainLooper());
        refreshLoginState();
    }

    /**
     * 获取全局Context，在代码的任意位置都可以调用，随时都能获取到全局Context对象。
     *
     * @return 全局Context对象。
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 获取创建在主线程上的Handler对象。
     *
     * @return 创建在主线程上的Handler对象。
     */
    public static Handler getHandler() {
        return handler;
    }

    /**
     * 判断用户是否已登录。
     *
     * @return 已登录返回true，未登录返回false。
     */
    public static boolean isLogin() {
        return isLogin;
    }

    /**
     * 返回当前应用的包名。
     */
    public static String getPackageName() {
        return context.getPackageName();
    }

    /**
     * 注销用户登录。
     */
    public static void logout() {
        SharedUtil.clear(Const.Auth.USER_ID);
        SharedUtil.clear(Const.Auth.TOKEN);
        SharedUtil.clear(Const.Auth.LOGIN_TYPE);
        SharedUtil.clear(Const.User.AVATAR);
        SharedUtil.clear(Const.User.BG_IMAGE);
        SharedUtil.clear(Const.User.DESCRIPTION);
        SharedUtil.clear(Const.User.NICKNAME);
        SharedUtil.clear(Const.Feed.MAIN_PAGER_POSITION);
        GifFun.refreshLoginState();
    }

    /**
     * 获取当前登录用户的id。
     * @return 当前登录用户的id。
     */
    public static long getUserId() {
        return userId;
    }

    /**
     * 获取当前登录用户的token。
     * @return 当前登录用户的token。
     */
    public static String getToken() {
        return token;
    }

    /**
     * 获取当前登录用户的登录类型。
     * @return 当前登录用户登录类型。
     */
    public static int getLoginType() {
        return loginType;
    }

    /**
     * 刷新用户的登录状态。
     */
    public static void refreshLoginState() {
        long u = SharedUtil.read(Const.Auth.USER_ID, 0L);
        String t = SharedUtil.read(Const.Auth.TOKEN, "");
        int lt = SharedUtil.read(Const.Auth.LOGIN_TYPE, -1);
        isLogin = u > 0 && !TextUtils.isEmpty(t) && lt >= 0;
        if (isLogin) {
            userId = u;
            token = t;
            loginType = lt;
        }
    }

}
