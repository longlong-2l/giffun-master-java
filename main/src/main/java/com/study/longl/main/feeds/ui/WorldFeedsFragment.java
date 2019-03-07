package com.study.longl.main.feeds.ui;

import com.study.longl.main.common.callback.LoadDataListener;

public class WorldFeedsFragment extends WaterFallFeedsFragment implements LoadDataListener {
    /**
     * RecyclerView的数据源，用于存储所有展示中的Feeds。
     */
//    MutableList<WorldFeed> feedList = new ArrayList();

    @Override
    protected void refreshFeeds() {

    }

    /**
     * 加载feeds。如果数据库有缓存则优先显示缓存内存，如果没有缓存则从网络获取feeds。
     */
    @Override
    protected void loadFeeds(long lastFeed) {

    }

    @Override
    protected void loadFeedsFromDB() {

    }

    @Override
    protected int dataSeetSize() {
        return 0;
    }

    @Override
    public void onLoad() {

    }
}
