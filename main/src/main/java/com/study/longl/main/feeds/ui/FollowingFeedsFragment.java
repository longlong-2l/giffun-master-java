package com.study.longl.main.feeds.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.longl.core.Log;
import com.study.longl.core.model.FollowingFeed;
import com.study.longl.main.R;
import com.study.longl.main.common.callback.LoadDataListener;
import com.study.longl.network.model.FetchFollowingFeeds;
import com.study.longl.network.model.OriginThreadCallback;
import com.study.longl.network.model.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lilong
 * @since 2019/1/31
 */
public class FollowingFeedsFragment extends BaseFeedsFragment implements LoadDataListener {

    private static final String TAG = "FollowingFeedsFragment";

    /**
     * RecyclerView 的数据源，用于存储所展示的Feeds
     */
    public ArrayList<FollowingFeed> feedList = new ArrayList<>();

    /**
     * 通过获取屏幕宽度来计算出每张图片最大的宽度。
     *
     * @return 计算后得出的每张图片最大的宽度。
     */
    private int maxImageWidth;

//    private int get() {
//        WindowManager windowManager = (WindowManager) mainActivity.getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics metrics = new DisplayMetrics();
//        windowManager.getDefaultDisplay().getMetrics(metrics);
//        int columnWidth = metrics.widthPixels;
//        return columnWidth - dp2px((float) (24 + 20));
//    }

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
        if (!isLoadingMore) {
            if (!feedList.isEmpty()) {
                isLoadingMore = true;
                isLoadFailed = false;
                isNoMoreData = false;
                long lastFeed = feedList.get(feedList.size() - 1).feedId;
                loadFeeds(lastFeed);
            }
        }
    }

    @Override
    protected void setupRecyclerView() {
//        layoutManager = new LinearLayoutManager(mainActivity);
//        adapter = new FollowingFeedAdapter(this, feedList, maxImageWidth, layoutManager);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
//        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    @Override
    protected void loadFeeds(long lastFeed) {
        //TODO 网络访问
        final boolean isRefreshing = lastFeed <= 0;
//        FetchFollowingFeeds.getResponse(lastFeed, new OriginThreadCallback() {
//            @Override
//            public void onResponse(Response response) {
//                handleFetchedFeeds(response, isRefreshing);
//                isLoadingMore = false;
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                Log.logWarn(TAG, e.getMessage(), e);
//                if (isRefreshing) {
//
//                }
//                mainActivity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        loadFailed(null);
//                        isLoadingMore = false;
//                    }
//                });
//            }
//        });
    }

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

    /**
     * 处理获取关注列表feeds请求的返回结果。
     *
     * @param response     服务器响应的获取feeds请求的实体类。
     * @param isRefreshing true表示刷新请求，false表示加载更多请求。
     */
    private void handleFetchedFeeds(Response response, Boolean isRefreshing) {
        isNoMoreData = false;
    }

    @Override
    public void loadFinished() {
        super.loadFinished();
        if (feedList.isEmpty()) {
//            swipeRefreshLayout.setVisibility(View.GONE);
//            recyclerView.setVisibility(View.GONE);
            showNoContentViewWithButton("你关注的内容空空如也", "去关注", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        } else {
            hideNoContentView();
        }
    }

    private void saveCachedFeeds(List<FollowingFeed> feeds) {
        //TODO 保存缓存内容
    }
}
