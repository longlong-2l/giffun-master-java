package com.study.longl.core.model;

import org.litepal.crud.LitePalSupport;

/**
 * 所有网络通讯数据模型实体类的基类。
 *
 * @author lilong
 * @since 2019/1/31
 */
public abstract class Model extends LitePalSupport {

    /**
     * 获取当前实体类的实体数据id。比如User类就获取userId，Comment类就获取commentId。
     * @return 当前实体类的实体数据id。
     */
    long modelId;
}
