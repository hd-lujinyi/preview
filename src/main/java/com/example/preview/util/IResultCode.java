package com.example.preview.util;/*
@author lujinyi
@creatr 2022-04-2022/4/7-15:58
*/

import java.io.Serializable;

/**
 * @Description: 状态码接口
 * @Author: x
 * @Date :
 */
public interface IResultCode extends Serializable {

    /**
     * 返回的code码
     *
     * @return code
     */
    int getCode();

    /**
     * 返回的消息
     *
     * @return 消息
     */
    String getMsg();
}
