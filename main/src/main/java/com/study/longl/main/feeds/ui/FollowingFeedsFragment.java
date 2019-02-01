package com.study.longl.main.feeds.ui;

import com.study.longl.core.model.FollowingFeed;
import com.study.longl.main.common.callback.LoadDataListener;

import java.util.ArrayList;

/**
 * @author lilong
 * @since 2019/1/31
 */
public class FollowingFeedsFragment extends BaseFeedsFragment implements LoadDataListener {

    /**
     * RecyclerView 的数据源，用于存储所展示的Feeds
     */

    public ArrayList<FollowingFeed> feedList =  new ArrayList();

    @Override
    public void onLoad() {

    }

    @Override
    protected void setupRecyclerView() {

    }

    @Override
    protected void refreshFeeds() {

    }

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
}
