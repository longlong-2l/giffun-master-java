package com.study.longl.main.feeds.adapter;

import android.support.v7.widget.RecyclerView;

import com.study.longl.core.model.FollowingFeed;
import com.study.longl.main.feeds.ui.FollowingFeedsFragment;

import java.util.ArrayList;

/**
 * 关注模块的RecyclerView适配器，用于在界面上展示关注的数据。
 *
 * @author lilong
 * @since 2019/3/7
 */
public class FollowingFeedAdapter {
    boolean isLoadFailed = false;
    boolean isMoreData = false;

    private FollowingFeedsFragment fragment;

    private int maxImageWidth;

    private ArrayList<FollowingFeed> feedList;

    private RecyclerView.LayoutManager layoutManager;



}
