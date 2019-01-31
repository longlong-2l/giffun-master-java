package com.study.longl.core.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Feed实体类，用于存储服务器返回的Feed数据。
 * @author lilong
 * @since 2019/1/31
 */
public class BaseFeed implements Parcelable,SearchItem{

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
