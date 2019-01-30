package com.study.longl.core;

/**
 * 项目所有全局通用常量的管理类。
 *
 * @author lilong
 * @since 17/2/23
 */
public interface Const {
    interface Auth {

        public String USER_ID = "u_d";

        public String TOKEN = "t_k";

        public String LOGIN_TYPE = "l_t";
    }

    interface User {

        public String NICKNAME = "nk";

        public String AVATAR = "ar";

        public String BG_IMAGE = "bi";

        public String DESCRIPTION = "de";
    }

    interface Feed {

        public String MAIN_PAGER_POSITION = "mpp";

        public String MAIN_LAST_USE_TIME = "mlut";

        public String MAIN_LAST_IGNORE_TIME = "mlit";
    }
}
