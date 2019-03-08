package com.study.longl.main.feeds.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.study.longl.core.model.FollowingFeed;
import com.study.longl.main.R;
import com.study.longl.main.common.callback.LoadDataListener;
import com.study.longl.main.feeds.adapter.FollowingFeedAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import static com.study.longl.core.extension.Density.dp2px;

/**
 * @author lilong
 * @since 2019/1/31
 */
public class FollowingFeedsFragment extends BaseFeedsFragment implements LoadDataListener {

    /**
     * RecyclerView 的数据源，用于存储所展示的Feeds
     */
    public ArrayList<FollowingFeed> feedList = new ArrayList<>();

    /**
     * 通过获取屏幕宽度来计算出每张图片最大的宽度。
     *
     * @return 计算后得出的每张图片最大的宽度。
     */
    private int maxImageWidth = get();

    private int get() {
        WindowManager windowManager = (WindowManager) mainActivity.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        int columnWidth = metrics.widthPixels;
        return columnWidth - dp2px((float) (24 + 20));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_following_feeds, container, false);
        initViews(view);
//        EventBus.getDefault().register(this);
        return super.onCreateView(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onLoad() {

    }

    @Override
    protected void setupRecyclerView() {
        layoutManager = new LinearLayoutManager(mainActivity);
        adapter = new FollowingFeedAdapter(this, feedList, maxImageWidth, layoutManager);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
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
