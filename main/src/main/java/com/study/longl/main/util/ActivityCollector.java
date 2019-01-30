package com.study.longl.main.util;

import android.app.Activity;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * 应用中所有Activity的管理器，可用于一键杀死所有Activity。
 *
 * @author lilong
 * @since 18/2/8
 */
public class ActivityCollector {
    private static String TAG = "ActivityCollector";

    private static ArrayList<WeakReference<Activity>> activityList = new ArrayList<>();

    public int size() {
        return activityList.size();
    }

    public static void add(WeakReference<Activity> weakRefActivity) {
        activityList.add(weakRefActivity);
    }

    public static void remove(WeakReference<Activity> weakRefActivity) {
        boolean result = activityList.remove(weakRefActivity);
        Log.d(TAG, "remove activity reference: " + result);
    }

    public static void finishAll() {
        if (!activityList.isEmpty()) {
            for (WeakReference<Activity> activityWeakReference : activityList) {
                Activity activity = activityWeakReference.get();
                if (activity != null && !activity.isFinishing()) {
                    activity.finish();
                }
            }
            activityList.clear();
        }
    }
}
