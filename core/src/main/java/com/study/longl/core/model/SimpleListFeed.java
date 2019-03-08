package com.study.longl.core.model;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

/**
 * SimpleListFeed的实体类，用于存储单列列表展示的Feed数据。
 *
 * @author lilong
 * @since 2019/1/31
 */
public abstract class SimpleListFeed extends BaseFeed{
    @SerializedName("feed_type")
    public int feedType = 0;

    protected SimpleListFeed(Parcel in) {
        super(in);
    }

    public abstract BaseFeed refFeed();
}
