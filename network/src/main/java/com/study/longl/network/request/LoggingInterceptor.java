package com.study.longl.network.request;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author lilong
 * @since 2019/3/19
 */
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
       Request request = chain.request();
       long t1 = System.nanoTime();
        return null;
    }
}
