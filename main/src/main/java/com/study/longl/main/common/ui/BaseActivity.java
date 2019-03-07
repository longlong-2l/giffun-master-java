package com.study.longl.main.common.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.study.longl.main.R;
import com.study.longl.main.common.callback.PermissionListener;
import com.study.longl.main.common.callback.RequestLifecycle;
import com.study.longl.main.util.ActivityCollector;
import com.umeng.analytics.MobclickAgent;

//import org.greenrobot.eventbus.EventBus;

import java.lang.ref.WeakReference;
import java.util.Objects;

/**
 * 应用程序中所有Activity的基类。
 *
 * @author lilong
 * @since 17/2/16
 */
public class BaseActivity extends AppCompatActivity implements RequestLifecycle {

    /**
     * 判断当前Activity是否在前台。
     */
    protected boolean isActive = false;

    /**
     * 当前Activity的实例。
     */
    protected Activity activity = null;

    /**
     * Activity中显示加载等待的控件。
     */
    protected ProgressBar loading = null;

    /**
     * Activity中由于服务器异常导致加载失败显示的布局。
     */
    private View loadErrorView = null;

    /**
     * Activity中由于网络异常导致加载失败显示的布局。
     */
    private View badNetworkView = null;

    /**
     * Activity中当界面上没有任何内容时展示的布局。
     */
    private View noContentView = null;

    private WeakReference<Activity> weakReference = null;

    protected Toolbar toolbar = null;

    private ProgressDialog progressDialog = null;

    private PermissionListener mListener = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        weakReference = new WeakReference<Activity>(this);
        ActivityCollector.add(weakReference);
//        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isActive = true;
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        isActive = false;
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activity = null;
        ActivityCollector.remove(weakReference);
//        EventBus.getDefault().unregister(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setupViews();
    }

    public void setupViews() {
        Log.d("extends", "father_setupViews: ");
//        loading = findViewById(R.id.loading);
    }

    public void setupToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    //设置状态栏透明，只设置Android5.0以上的接口
    protected void transparentStatusBar() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void startLoading() {
//        loading.setVisibility(View.VISIBLE);
        hideBadNetWorkView();
        hideLoadErrorView();
        hideNoContentView();
    }

    @Override
    public void loadFinished() {
//        loading.setVisibility(View.GONE);
    }

    @Override
    public void loadFailed(String msg) {
//        loading.setVisibility(View.GONE);
    }

    //将加载失败的控件隐藏
    protected void hideLoadErrorView() {

    }

    //隐藏无数据内容
    protected void hideNoContentView() {

    }

    //将网络有问题的隐藏
    protected void hideBadNetWorkView() {

    }

    protected void showProgreeDialog(String title, String message) {

    }

    protected void clossProgressDialog() {
//        if (progressDialog.isShowing()) {
//            progressDialog.dismiss();
//        }
    }
}
