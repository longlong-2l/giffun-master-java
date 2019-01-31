package com.study.longl.main.common.ui;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.study.longl.main.R;
import com.study.longl.main.common.callback.PermissionListener;
import com.study.longl.main.common.callback.RequestLifecycle;

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
     * 当Fragment中的加载内容服务器返回失败，通过此方法显示提示界面给用户。
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
     * 当Fragment中的内容因为网络原因无法显示的时候，通过此方法显示提示界面给用户。
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
     * 将bad network view进行隐藏。
     */
    protected void hideBadNetworkView() {
        badNetworkView.setVisibility(View.GONE);
    }

    /**
     * 将no content view进行隐藏。
     */
    protected void hideNoContentView() {
//        badNetworkView.
    }

    /**
     * 将load error view进行隐藏。
     */
    protected void hideLoadErrorView() {
//        badNetworkView.
    }

    /**
     * 在Fragment基类中获取通用的控件，会将传入的View实例原封不动返回。
     * @param view
     * Fragment中inflate出来的View实例。
     * @return  Fragment中inflate出来的View实例原封不动返回。
     */
    public View onCreateView(View view) {
        rootView = view;
        loading = view.findViewById(R.id.loading);
        return view;
    }

    @Override
    public void startLoading() {
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
