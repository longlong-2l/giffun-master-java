package com.study.longl.core.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.litepal.annotation.Column;

/**
 * Feed实体类，用于存储服务器返回的Feed数据。
 *
 * @author lilong
 * @since 2019/1/31
 */
public class BaseFeed extends Model implements Parcelable, SearchItem {

    protected BaseFeed(Parcel in) {

    }

    public static final Creator<BaseFeed> CREATOR = new Creator<BaseFeed>() {
        @Override
        public BaseFeed createFromParcel(Parcel in) {
            return new BaseFeed(in);
        }

        @Override
        public BaseFeed[] newArray(int size) {
            return new BaseFeed[size];
        }
    };

    public long modeId = 0L;

    /**
     * 本地数据库中使用的id。
     */
    private int id = 0;

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Feed封面的地址。
     */
    public String cover = "";

    /**
     * Feed图片的地址。
     */
    public String gif = "";

    /**
     * Feed的具体内容。
     */
    public String content = "";

    /**
     * Feed图片的宽度。
     */
    @SerializedName("img_width")
    public int imgWidth = 0;

    /**
     * Feed图片的高度。
     */
    @SerializedName("img_height")
    public int imgHeight = 0;

    /**
     * Feed所属用户的昵称。
     */
    public String nickname = "";

    /**
     * Feed所属用户头像的地址。
     */
    public String avatar = "";

    /**
     * Feed所属用户个人主页的背景图。
     */
    @SerializedName("bg_image")
    public String bgImage = "";

    /**
     * 该条Feed对应的的User id。
     */
    @SerializedName("user_id")
    public long userId = 0L;

    /**
     * Feed发布的时间。
     */
    @SerializedName("post_date")
    public long postDate = 0L;

    /**
     * 服务器端返回的Feed id。
     */
    @SerializedName("feed_id")
    public long feedId = 0L;

    /**
     * Feed图片的大小，单位是字节。
     */
    public long fsize = 0L;

    /**
     * 该条feed的点赞数。
     */
    @SerializedName("likes_count")
    public int likesCount = 0;

    /**
     * 是否已对该feed点赞。
     */
    @SerializedName("liked_already")
    public boolean isLikedAlready = false;

    /**
     * 封面图是否已加载成功。（未成功加载封面图的feed不可以进入Feed详情界面）
     */
    @Column(ignore = true)
    public boolean coverLoaded = false;

    /**
     * 封面图片是否加载失败。
     */
    @Column(ignore = true)
    public boolean coverLoadFailed = false;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cover);
        parcel.writeString(gif);
        parcel.writeString(content);
        parcel.writeInt(imgWidth);
        parcel.writeInt(imgHeight);
        parcel.writeString(nickname);
        parcel.writeString(avatar);
        parcel.writeString(bgImage);
        parcel.writeLong(postDate);
        parcel.writeLong(feedId);
        parcel.writeLong(userId);
        parcel.writeLong(fsize);
        parcel.writeLong(likesCount);
        parcel.writeInt(isLikedAlready ? 1 : 0);
    }
}
