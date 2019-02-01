package com.study.longl.core.model;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

/**
 * HotFeed的实体类，用于存储服务器返回的热门Feed数据。
 *
 * @author lilong
 * @since 2019/2/1
 */
public class HotFeed extends WaterFallFeed {
    protected HotFeed(Parcel in) {
        super(in);
    }

    @SerializedName("comments_count")
    public int commentsCount = 0;
}
