package com.study.longl.core.model;

import android.os.Parcel;

/**
 * 转发引用Feed的实体类，用于存储转发Feed中引用的Feed对象。
 * @author lilong
 * @since 2019/1/31
 */
public class RefFeed extends BaseFeed{
    protected RefFeed(Parcel in) {
        super(in);
    }
}
