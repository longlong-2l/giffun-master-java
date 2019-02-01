package com.study.longl.main.feeds.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.study.longl.main.R;
import com.study.longl.main.common.callback.LoadDataListener;

import static com.study.longl.core.extension.Density.dp2px;

/**
 * 展示瀑布流的Feeds内容。
 *
 * @author lilong
 * @since 2019/2/1
 */
public abstract class WaterFallFeedsFragment extends BaseFeedsFragment implements LoadDataListener {

    public int imageWidth = get();

    private int get() {
        WindowManager windowManager = (WindowManager) mainActivity.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        int columnWidth = metrics.widthPixels / 2;
        return columnWidth - dp2px(18f);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_water_fall_feeds, container, false);
        initViews(view);
//        EventBus.getDefault().register(this)
        return super.onCreateView(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        EventBus.getDefault().unregister(this)
    }

    @Override
    protected void setupRecyclerView() {
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        ((StaggeredGridLayoutManager) layoutManager).setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }
}
