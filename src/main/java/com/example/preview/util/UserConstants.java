package com.example.preview.util;/*
@author lujinyi
@creatr 2022-04-2022/4/7-15:59
*/

public class UserConstants {
    /**
     * 用户管理 - 用户状态(有效).
     */
    public static final String USER_STATUS_ACTIVE = "0";

    /**
     * 调用userService的selectUsers时. 必须传入分页信息page
     */
    public static final Integer DEFAULT_PAGE = 1;

    /**
     * 调用userService的selectUsers时. 必须传入分页信息pageSize
     */
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    /**
     * 发送限制 - 超过两次.
     */
    public static final String SENT_LIMIT_ERROR = "当天发送超过2次限制";

    /**
     * 用户类型 - INNER: 内部用户.
     */
    public static final String USER_TYPE_INNER = "INNER";

    /**
     * 消息模板-临时口令.
     */
    public static final String TEMP_PWD_MESSAGE_TEMPLATE = "EMAIL_USER_TEMP_PWD";

    public static final int NUMBER_2 = 2;

    public static final int NUMBER_9 = 9;

    public static final String SERVER_VARIABLE = "服务端变量";
}

