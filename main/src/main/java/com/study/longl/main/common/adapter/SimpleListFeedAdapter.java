package com.study.longl.main.common.adapter;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.study.longl.core.model.BaseFeed;
import com.study.longl.core.model.SimpleListFeed;
import com.study.longl.main.R;
import com.study.longl.main.util.PopupUtil;

import java.util.ArrayList;

import static com.study.longl.core.extension.Density.dp2px;

/**
 * @author lilong
 * @since 2019/3/7
 */
public abstract class SimpleListFeedAdapter<T extends SimpleListFeed, A extends Activity> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int TYPE_FEEDS = 0;

    private final int TYPE_REFEEDS = 2;

    private final int TYPE_LOADING_MORE = 1;

    private int maxImageHeight = dp2px(250f);

    private int imageWidth = 0;

    private int imageHeight = 0;

    private int dataItemCount;

    public boolean isNoMoreData = false;

    public boolean isLoadFailed = false;

    private A activity;

    private ArrayList<T> feedList;

    private int maxImageWidth;

    private RecyclerView.LayoutManager layoutManager;

    public SimpleListFeedAdapter(A activity, ArrayList<T> feedList, int maxImageWidth, RecyclerView.LayoutManager layoutManager) {
        this.activity = activity;
        this.feedList = feedList;
        this.maxImageWidth = maxImageWidth;
        this.layoutManager = layoutManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) throws IllegalArgumentException {
        switch (i) {
            case TYPE_FEEDS:
                return createFeedHolder(viewGroup);
            case TYPE_REFEEDS:
                return createRefeedHolder(viewGroup);
//            case TYPE_LOADING_MORE:
//                return
        }
        return null;
    }

    //给所有控件添加点击事件
    protected void initBaseFeedHolder(final SimpleListFeedViewHolder holder) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
//                    setFabTransition();
                }
                BaseFeed feed;
                T simpleListFeed = feedList.get(position);
                if (simpleListFeed.feedType == 1) {
                    feed = simpleListFeed.refFeed();
                } else {
                    feed = simpleListFeed;
                }
                if (feed == null) {
                    Toast.makeText(activity, "原分享已被删除", Toast.LENGTH_SHORT).show();
                } else if (feed.coverLoadFailed) {
                    loadFeedCover(feed, holder);
                } else if (!feed.coverLoaded) {

                }
                ImageView imageView = view.findViewById(R.id.feedCover);
//                FeedDetailActivity.ac
            }
        });

        holder.expandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int feedPosition = holder.getAdapterPosition();
                T simpleListFeed = feedList.get(feedPosition);

//                Pair pair = PopupUtil.showUserFeedExpandMenu(activity,);
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FeedViewHolder extends SimpleListFeedViewHolder {

        public FeedViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class RefeedViewHolder extends SimpleListFeedViewHolder {

        public RefeedViewHolder(View itemView) {
            super(itemView);
        }

        private TextView refFeedContent = itemView.findViewById(R.id.refFeedContent);
        private TextView refFeedDeleted = itemView.findViewById(R.id.refFeedDeleted);
    }

    public abstract FeedViewHolder createFeedHolder(ViewGroup parent);

    public abstract RefeedViewHolder createRefeedHolder(ViewGroup parent);

    private void loadFeedCover(BaseFeed feed, SimpleListFeedViewHolder holder) {
        //TODO Glide框架没有引入
    }

//    private RecyclerView.ViewHolder createLoadingMoreHolder(ViewGroup parent){
//        RecyclerView.ViewHolder holder =
//    }

    class SimpleListFeedViewHolder extends RecyclerView.ViewHolder {
        public SimpleListFeedViewHolder(View itemView) {
            super(itemView);
        }

        CardView cardView = (CardView) itemView;

        ImageView avatar = itemView.findViewById(R.id.avatar);

        TextView nickname = itemView.findViewById(R.id.nickname);

        TextView postDate = itemView.findViewById(R.id.postDate);

        ImageView expandButton = itemView.findViewById(R.id.expandButton);

        ImageView feedCover = itemView.findViewById(R.id.feedCover);

        TextView feedContent = itemView.findViewById(R.id.feedContent);

        TextView likesCount = itemView.findViewById(R.id.likesCount);

        ImageView likes = itemView.findViewById(R.id.likes);

        FrameLayout likesLayout = itemView.findViewById(R.id.likesLayout);

//        FrameLayout respostLayout = itemView.findViewById(R.id.respostLayout);

        FrameLayout commentLayout = itemView.findViewById(R.id.commentLayout);

    }
}
