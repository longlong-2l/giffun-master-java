package com.study.longl.main.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.study.longl.main.R;

import java.util.List;

import static com.study.longl.core.extension.Density.dp2px;

/**
 * 用于构建PopupWindow类型的弹出式菜单。
 *
 * @author lilong
 * @since 2019/3/8
 */
public class PopupUtil {

    @SuppressLint("InflateParams")
    public static Pair<PopupWindow, ListView> showUserFeedExpandMenu(Activity activity, List<String> expandMenuItems, View anchor) {
        View popupWindow = activity.getLayoutInflater().inflate(R.layout.expand_menu, null);
        ListView expandMenuList = popupWindow.findViewById(R.id.expandMenuList);
        expandMenuList.setAdapter(new ArrayAdapter<>(activity, R.layout.user_feed_more_item, expandMenuItems));
        int windowWidth = dp2px(100f);
        int windowHeight = dp2px(46f) * expandMenuItems.size();
        PopupWindow window = new PopupWindow(popupWindow, windowWidth, windowHeight);
        window.setFocusable(true);
        window.setOutsideTouchable(true);
        window.setBackgroundDrawable(ContextCompat.getDrawable(activity, R.drawable.expand_menu_bg));
        window.update();
        window.showAsDropDown(anchor, -(windowWidth - dp2px(30f)), -dp2px(8f));
        return new Pair<>(window, expandMenuList);
    }

    @SuppressLint("InflateParams")
    public static Pair<PopupWindow, ListView> showCommentExpandMenu(Activity activity, List<String> expandMenuItems, View anchor) {
        View popupView = activity.getLayoutInflater().inflate(R.layout.expand_menu, null);
        ListView expandMenuList = popupView.findViewById(R.id.expandMenuList);
        expandMenuList.setAdapter(new ArrayAdapter<>(activity, R.layout.comment_more_item, expandMenuItems));
        int windowWidth = dp2px(90f);
        int windowHeight = dp2px(41f)* expandMenuItems.size();
        PopupWindow window = new PopupWindow(popupView,windowWidth,windowHeight);
        window.setFocusable(true);
        window.setOutsideTouchable(true);
        window.setBackgroundDrawable(ContextCompat.getDrawable(activity,R.drawable.expand_menu_bg));
        window.update();
        window.showAsDropDown(anchor, -(windowWidth - dp2px(5f)), dp2px(-25f));
        return new Pair<>(window, expandMenuList);
    }
}
