package com.study.longl.main.feeds.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.study.longl.main.R;
import com.study.longl.main.common.callback.LoadDataListener;
import com.study.longl.main.common.ui.BaseFragment;

/**
 * 应用程序中所有Feed相关Fragment的基类。
 *
 * @author lilong
 * @since 19/1/31
 */
public abstract class BaseFeedsFragment extends BaseFragment {

    /**
     * 判断是否加载更多Feeds
     */
    protected boolean isLoadingMore = false;

    protected MainActivity mainActivity;

    protected SwipeRefreshLayout swipeRefreshLayout;

    protected RecyclerView recyclerView;

    protected RecyclerView.Adapter adapter;

    protected RecyclerView.LayoutManager layoutManager;

    public boolean isLoadFailed = false;

    public LoadDataListener loadDataListener;

    /**
     * 判断是否还有更多数据。
     *
     * @return isNoMoreData 当服务器端没有更多Feeds时，此值为true，否则此值为false。
     */
    public boolean isNoMoreData = false;

    protected void initViews(View rootView) {
        recyclerView = rootView.findViewById(R.id.recyclerView);
        swipeRefreshLayout = rootView.findViewById(R.id.swipeRefresh);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    /**
     * 加载feeds完成，将feeds显示出来，将加载等待控件隐藏。
     */
    @Override
    public void loadFinished() {
        super.loadFinished();
        isLoadFailed = false;
        recyclerView.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setVisibility(View.VISIBLE);
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void loadFailed(String msg) {
        super.loadFailed(msg);
        isLoadFailed = true;
        swipeRefreshLayout.setRefreshing(false);
    }

    protected void scrollTop() {
        if (adapter.getItemCount() != 0) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    protected abstract void setupRecyclerView();

    protected abstract void refreshFeeds();

    protected abstract void loadFeeds();

    protected abstract void loadFeedsFromDB();

    protected abstract int dataSeetSize();
}
