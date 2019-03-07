package com.study.longl.main.common.callback;

import java.util.List;

/**
 * @author lilong
 * @since 18/4/2
 */

public interface PermissionListener {
    //同意
    void onGranted();

    //拒绝的权限
    void onDenied(List<String> deniedPermissions);
}
