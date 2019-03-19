package com.study.longl.main.feeds.ui;

import com.study.longl.core.model.WorldFeed;
import com.study.longl.main.common.callback.LoadDataListener;
import com.study.longl.network.model.Response;

import java.util.ArrayList;

public class WorldFeedsFragment extends WaterFallFeedsFragment implements LoadDataListener {
    /**
     * RecyclerView的数据源，用于存储所有展示中的Feeds。
     */
    private ArrayList<WorldFeed> feedList = new ArrayList();

    /**
     * 加载feeds。如果数据库有缓存则优先显示缓存内存，如果没有缓存则从网络获取feeds。
     */
    @Override
    protected void loadFeeds(long lastFeed) {
        boolean isRefreshing = lastFeed <= 0;
        //TODO 网络请求
    }

    /**
     * 刷新feeds。
     */
    @Override
    protected void refreshFeeds() {
        loadFeeds(0);
    }

    @Override
    protected void loadFeedsFromDB() {

    }

    @Override
    protected int dataSetSize() {
        return feedList.size();
    }

    @Override
    public void onLoad() {

    }

    /**
     * 处理获取世界频道feeds请求的返回结果。
     *
     * @param response     服务器响应的获取feeds请求的实体类。
     * @param isRefreshing true表示刷新请求，false表示加载更多请求。
     */
    private void handleFetchedFeeds(Response response, boolean isRefreshing) {
        isNoMoreData = false;

    }
}
