package com.study.longl.main.common.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.longl.core.model.SimpleListFeed;
import com.study.longl.main.R;

import org.w3c.dom.Text;

import static com.study.longl.core.extension.Density.dp2px;

/**
 * @author lilong
 * @since 2019/3/7
 */
public class SimpleListFeedAdapter<T extends SimpleListFeed, A extends Activity> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int maxImageHeight = dp2px(250f);

    private int imageWidth = 0;

    private int imageHeight = 0;

    private int dataItemCount;

    public boolean isNoMoreData = false;

    public boolean isLoadFailed = false;

    public SimpleListFeedAdapter() {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FeedViewHolder extends SimpleListFeedViewHolder {

        public FeedViewHolder(View itemView) {
            super(itemView);
        }
    }

    class RefeedViewHolder extends SimpleListFeedViewHolder {

        public RefeedViewHolder(View itemView) {
            super(itemView);
        }

        private TextView refFeedContent = itemView.findViewById(R.id.refFeedContent);
        private TextView refFeedDeleted = itemView.findViewById(R.id.refFeedDeleted);
    }

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
