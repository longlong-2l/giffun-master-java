package com.study.longl.main.feeds.ui;

import com.study.longl.core.model.HotFeed;
import com.study.longl.main.common.callback.LoadDataListener;
import com.study.longl.network.model.OriginThreadCallback;
import com.study.longl.network.model.Response;

import java.util.ArrayList;

/**
 * @author lilong
 * @since 2019/1/31
 */
public class HotFeedsFragment extends WaterFallFeedsFragment implements LoadDataListener {

    /**
     * RecyclerView 的数据源，用于存储所有展示的Feeds
     * 原文为MutableList，JAVA里面没有这个List，感觉ArrayList也可以
     */
    public ArrayList<HotFeed> feedArrayList = new ArrayList<>();

    @Override
    protected void setupRecyclerView() {
        super.setupRecyclerView();
//        adapter = Hot

    }

    @Override
    public void onLoad() {

    }

    /**
     * 刷新feeds。
     */
    @Override
    protected void refreshFeeds() {
        loadFeeds(0);
    }

    /**
     * 加载feeds。如果数据库有缓存则优先显示缓存内存，如果没有缓存则从网络获取feeds。
     */
    @Override
    protected void loadFeeds(long lastFeed) {
        boolean isRefreshing = lastFeed == 0L;       /* lastFeed等于0表示刷新 */
//        OriginThreadCallback originThreadCallback = new OriginThreadCallback() {
//            @Override
//            public void onResponse(Response response) {
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//
//            }
//        };
    }

    @Override
    protected void loadFeedsFromDB() {
        // 由于服务器接口设计原因，热门feed不能缓存到数据库中，因此这里直接刷新feeds列表
        refreshFeeds();
    }

    @Override
    protected int dataSetSize() {
        return feedArrayList.size();
    }

    /**
     * 处理获取世界频道feeds请求的返回结果。
     *
     * @param response     服务器响应的获取feeds请求的实体类。
     * @param isRefreshing true表示刷新请求，false表示加载更多请求。
     */
    private void handleFetchFeeds(Response response, boolean isRefreshing) {
        isNoMoreData = false;
    }
}
