package com.study.longl.core.model;

import com.google.gson.annotations.SerializedName;

/**
 * SimpleListFeed的实体类，用于存储单列列表展示的Feed数据。
 *
 * @author lilong
 * @since 2019/1/31
 */
public abstract class SimpleListFeed {
    @SerializedName("feed_type")
    int feedType = 0;

    abstract BaseFeed refFeed();
}
