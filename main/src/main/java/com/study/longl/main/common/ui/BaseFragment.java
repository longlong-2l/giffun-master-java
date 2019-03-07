package com.study.longl.main.common.ui;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.study.longl.main.R;
import com.study.longl.main.common.callback.PermissionListener;
import com.study.longl.main.common.callback.RequestLifecycle;

import java.util.ArrayList;

/**
 * 应用程序中所有Fragment的基类。
 *
 * @author lilong
 * @since 17/3/20
 */
public class BaseFragment extends Fragment implements RequestLifecycle {

    private PermissionListener mListener = null;

    /**
     * Fragment中由于服务器异常导致加载失败显示的布局。
     */
    private View loadErrorView = null;

    /**
     * Fragment中由于网络异常导致加载失败显示的布局。
     */
    private View badNetworkView = null;

    /**
     * Fragment中当界面上没有任何内容时展示的布局。
     */
    private View noContentView = null;

    /**
     * Fragment中inflate出来的布局。
     */
    protected View rootView = null;

    /**
     * Fragment中inflate出来的布局。
     */
    protected ProgressBar loading = null;

    /**
     * 当Fragment中的加载内容服务器返回失败，
     * 通过此方法显示提示界面给用户。
     *
     * @param tip 界面中的提示信息
     */
    protected void showLoadErrorView(String tip) {
        if (loadErrorView != null) {
            loadErrorView.setVisibility(View.VISIBLE);
            return;
        }
        if (rootView != null) {
            ViewStub viewStub = rootView.findViewById(R.id.loadErrorView);
            if (viewStub != null) {
                loadErrorView = viewStub.inflate();
                TextView loadErrorText = loadErrorView.findViewById(R.id.loadErrorText);
                loadErrorText.setText(tip);
            }
        }
    }

    /**
     * 当Fragment中的内容因为网络原因无法显示的时候，
     * 通过此方法显示提示界面给用户。
     *
     * @param listener 重新加载点击事件回调
     */
    protected void showBadNetworkView(View.OnClickListener listener) {
        if (badNetworkView != null) {
            badNetworkView.setVisibility(View.VISIBLE);
            return;
        }
        if (rootView != null) {
            ViewStub viewStub = rootView.findViewById(R.id.badNetworkRootView);
            if (viewStub != null) {
                badNetworkView = viewStub.inflate();
                View badNetworkRootView = badNetworkView.findViewById(R.id.badNetworkRootView);
                badNetworkRootView.setOnClickListener(listener);
            }
        }
    }

    /**
     * 当Fragment中没有任何内容的时候，
     * 通过此方法显示提示界面给用户。
     *
     * @param tip 界面中的提示信息
     */
    protected void showNoContentView(String tip) {
        if (noContentView != null) {
            noContentView.setVisibility(View.VISIBLE);
            return;
        }
        if (rootView != null) {
            ViewStub viewStub = rootView.findViewById(R.id.noContentView);
            if (viewStub != null) {
                noContentView = viewStub.inflate();
                TextView noContentText = noContentView.findViewById(R.id.noContentText);
                noContentText.setText(tip);
            }
        }
    }

    /**
     * 当Fragment中没有任何内容的时候，通过此方法显示提示界面给用户。
     *
     * @param tip        界面中的提示信息
     * @param buttonText 界面中的按钮的文字
     * @param listener   按钮的点击事件回调
     */
    protected void showNoContentViewWithButton(String tip, String buttonText, View.OnClickListener listener) {

    }

    /**
     * 将bad network view进行隐藏。
     */
    protected void hideBadNetworkView() {
        badNetworkView.setVisibility(View.GONE);
    }

    /**
     * 将no content view进行隐藏。
     */
    protected void hideNoContentView() {
        noContentView.setVisibility(View.GONE);
    }

    /**
     * 将load error view进行隐藏。
     */
    protected void hideLoadErrorView() {
        loadErrorView.setVisibility(View.GONE);
    }

    /**
     * 检查和处理运行时权限，并将用户授权的结果通过PermissionListener进行回调。
     *
     * @param permissions 要检查和处理的运行时权限数组
     * @param listener    用于接收授权结果的监听器
     */
    protected void handlePermissions(ArrayList<String> permissions, PermissionListener listener) {
        if (permissions == null || getActivity() == null) {
            return;
        }
        mListener = listener;
        ArrayList<String> requestPermissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(getActivity(), permission) != PackageManager.PERMISSION_GRANTED) {
                requestPermissionList.add(permission);
            }
        }
        if (!requestPermissionList.isEmpty()) {
            requestPermissions((String[]) requestPermissionList.toArray(), 1);
        } else {
            listener.onGranted();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    ArrayList<String> deniedPermissions = new ArrayList<>();
                    for (int i : grantResults) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            deniedPermissions.add(permission);
                        }
                    }
                    if (deniedPermissions.isEmpty()) {
                        mListener.onGranted();
                    } else {
                        mListener.onDenied(deniedPermissions);
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * 在Fragment基类中获取通用的控件，会将传入的View实例原封不动返回。
     * 目的是为了能拿到loading
     * @param view Fragment中inflate出来的View实例。
     * @return Fragment中inflate出来的View实例原封不动返回。
     */
    public View onCreateView(View view) {
        rootView = view;
        loading = view.findViewById(R.id.loading);
        return view;
    }

    @Override
    public void startLoading() {
        Log.i("load", "startLoading: ");
        loading.setVisibility(View.VISIBLE);
        hideBadNetworkView();
        hideNoContentView();
        hideLoadErrorView();
    }

    @Override
    public void loadFinished() {
        loading.setVisibility(View.GONE);
    }

    @Override
    public void loadFailed(String msg) {
        loading.setVisibility(View.GONE);
    }
}
