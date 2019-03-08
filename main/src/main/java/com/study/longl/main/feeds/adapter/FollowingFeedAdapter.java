package com.study.longl.main.feeds.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.study.longl.core.model.FollowingFeed;
import com.study.longl.main.common.adapter.SimpleListFeedAdapter;
import com.study.longl.main.feeds.ui.FollowingFeedsFragment;

import java.util.ArrayList;

/**
 * 关注模块的RecyclerView适配器，用于在界面上展示关注的数据。
 *
 * @author lilong
 * @since 2019/3/7
 */
public class FollowingFeedAdapter extends SimpleListFeedAdapter<FollowingFeed, Activity> {
    boolean isLoadFailed = false;
    boolean isMoreData = false;

    private FollowingFeedsFragment fragment;

    private int maxImageWidth;

    private ArrayList<FollowingFeed> feedList;

    private RecyclerView.LayoutManager layoutManager;

    public FollowingFeedAdapter(Fragment fragment,ArrayList<FollowingFeed> feedList,int maxImageWidth,RecyclerView.LayoutManager layoutManager) {
        super(fragment.getActivity(),feedList,maxImageWidth,layoutManager);

    }

    @Override
    public FeedViewHolder createFeedHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public RefeedViewHolder createRefeedHolder(ViewGroup parent) {
        return null;
    }
}
