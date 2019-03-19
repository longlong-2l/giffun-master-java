package com.study.longl.network.request;

import com.study.longl.core.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttp网络请求日志拦截器，通过日志记录OkHttp所有请求以及响应的细节。
 * okHttp里面是有很多拦截器的
 *
 * @author lilong
 * @since 2019/3/19
 */
public class LoggingInterceptor implements Interceptor {

    private static final String TAG = "LoggingInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        Log.logInfo(TAG, "Sending request" + request.url() + "\n" + request.headers());
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        Log.logInfo(TAG, "Received response for " + response.request().url() + " in " + (t2 - t1) / 1e6 + "ms\n" + response.headers());
        return response;
    }
}
