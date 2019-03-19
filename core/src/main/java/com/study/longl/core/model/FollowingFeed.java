package com.study.longl.core.model;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

/**
 * FollowingFeed的实体类，用于存储服务器返回的用户关注列表的Feed数据。
 *
 * @author lilong
 * @since 2019/1/31
 */
public class FollowingFeed extends SimpleListFeed {

    @SerializedName("ref_feed")
    public RefFeed refFeed = null;

    protected FollowingFeed(Parcel in) {
        super(in);
    }

    @Override
    public BaseFeed refFeed() {
        return refFeed;
    }
}
