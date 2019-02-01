package com.study.longl.network.model;


/**
 * 网络请求响应的回调接口。
 * @author lilong
 * @since 2019/2/1
 */
public interface CallBack {

    void onResponse(Response response);

    void onFailure(Exception e);
}
