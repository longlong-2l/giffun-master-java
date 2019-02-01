package com.study.longl.network.model;

/**
 * 请求响应的基类，这里封装了所有请求都必须会响应的参数，status和msg。
 *
 * @author lilong
 * @since 2019/2/1
 */
public class Response {

    /**
     * 请求结果的状态码，这里可以查看所有状态码的含义：https://github.com/sharefunworks/giffun-server#2-状态码
     */
    public int status = 0;

    /**
     * 请求结果的简单描述。
     */
    public String msg = "";
}
