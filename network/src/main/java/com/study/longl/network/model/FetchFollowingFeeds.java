package com.study.longl.network.model;

import com.google.gson.annotations.SerializedName;
import com.study.longl.core.model.FollowingFeed;

import java.util.ArrayList;

/**
 * @author lilong
 * @since 2019/3/19
 */
public class FetchFollowingFeeds extends Response{
    @SerializedName("data")
    public ArrayList<FollowingFeed> feeds = new ArrayList<>();

    public static void getResponse(Callback callBack){

    }

    public static void getResponse(long lastFeed, Callback callBack){

    }
}
