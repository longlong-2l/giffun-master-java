package com.study.longl.main.common.callback;

import java.util.List;

/**
 * @author lilong
 * @since 18/4/2
 */

public interface PermissionListener {
    void onGranted();

    void onDenied(List<String> deniedPermissions);
}
