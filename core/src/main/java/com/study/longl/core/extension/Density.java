package com.study.longl.core.extension;

import com.study.longl.core.GifFun;

/**
 * 单位转换工具类，会根据手机的分辨率来进行单位转换。
 *
 * @author lilong
 * @since 2019/2/1
 */
public class Density {

    /**
     * 根据手机的分辨率将dp转成为px
     */
    public static int dp2px(Float dp) {
        float scale = GifFun.getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率将px转成dp
     */
    public static int px2dp(float px) {
        float scale = GifFun.getContext().getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }
}
