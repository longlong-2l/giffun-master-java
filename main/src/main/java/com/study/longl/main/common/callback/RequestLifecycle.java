package com.study.longl.main.common.callback;

/**
 * 在Activity或Fragment中进行网络访问所需要经历的生命周期函数
 * @author lilong
 * @since 18/4/2
 */
public interface RequestLifecycle {

    void startLoading();

    void loadFinished();

    void loadFailed(String msg);

}
