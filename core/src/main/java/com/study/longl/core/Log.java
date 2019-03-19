package com.study.longl.core;


/**
 * @author lilong
 * @since 2019/3/19
 * 日志扩展类工具
 */
public class Log {
    private static final String TAG = "Log";
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NOTHING = 6;

    private static int level;

    {
        if (GifFun.isDebug) {
            level = GifFun.isDebug ? VERBOSE : WARN;
        }
    }

    public static void logDebug(String msg) {
        if (level < DEBUG) {
            android.util.Log.d(TAG, msg);
        }
    }

    public static void logInfo(String msg) {
        if (level < INFO) {
            android.util.Log.i(TAG, msg);
        }
    }

    public static void logInfo(String tag, String msg) {
        if (level < INFO) {
            android.util.Log.i(tag, msg);
        }
    }

    public static void logWarn(String msg, Throwable tr) {
        if (level < WARN) {
            if (tr == null) {
                android.util.Log.w(TAG, msg);
            } else {
                android.util.Log.w(TAG, msg, tr);
            }
        }
    }

    public static void logDebug(String tag, String msg) {
        if (level < DEBUG) {
            android.util.Log.d(tag, msg);
        }
    }

    public static void logWarn(String tag, String msg, Throwable tr) {
        if (level < WARN) {
            if (tr == null) {
                android.util.Log.w(tag, msg);
            } else {
                android.util.Log.w(tag, msg, tr);
            }
        }
    }

    public static void logError(String tag, String msg, Throwable tr) {
        if (level < ERROR) {
            android.util.Log.e(tag, msg, tr);
        }
    }
}
