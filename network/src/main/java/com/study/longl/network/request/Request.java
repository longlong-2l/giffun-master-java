package com.study.longl.network.request;

import com.study.longl.network.model.CallBack;
import com.study.longl.network.util.Utility;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 网络请求模式的基类，所有的请求封装都应该要继承此类。这里会提供网络模块的配置，以及请求的具体逻辑处理等。
 *
 * @author lilong
 * @since 2019/3/19
 */
public abstract class Request {

    private OkHttpClient okHttpClient;  //原文是有lateinit关键字的，可以晚些初始化

    private OkHttpClient.Builder okHttpBuilder;

    private CallBack callBack;

    private Map<String, String> params;

    private boolean getParamsAlready = false;

    private String deviceName;

    private String deviceSerial;

    private void build() {
        okHttpBuilder = new OkHttpClient.Builder().addNetworkInterceptor(new LoggingInterceptor());
        okHttpClient = okHttpBuilder.build();
        connectTimeout(10);
        writeTimeout(10);
        readTimeout(10);
        deviceName = Utility.deviceName;
    }

    private void connectTimeout(int seconds) {
        okHttpBuilder.connectTimeout((long) seconds, TimeUnit.SECONDS);
    }

    private void writeTimeout(int seconds) {
        okHttpBuilder.writeTimeout((long) seconds, TimeUnit.SECONDS);
    }

    private void readTimeout(int seconds) {
        okHttpBuilder.readTimeout((long) seconds, TimeUnit.SECONDS);
    }
}
