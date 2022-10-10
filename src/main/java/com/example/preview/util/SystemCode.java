package com.example.preview.util;/*
@author lujinyi
@creatr 2022-04-2022/4/7-15:59
*/

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
@ApiModel(description = "code")
public enum SystemCode  implements IResultCode {



    //操作成功
    SUCCESS(SystemCode.SUCCESS_CODE, "操作成功"),

    //系统未知异常
    FAILURE(SystemCode.FAILURE_CODE, "操作失败,请稍后再试"),

    //数据不存在
    DATA_NOT_EXIST(SystemCode.DATA_NOT_EXIST_CODE, "数据不存在"),

    //数据已存在
    DATA_EXISTED(SystemCode.DATA_EXISTED_CODE, "数据已存在"),
    ;

    /**
     * 通用 code
     */
    public static final int FAILURE_CODE = 400;
    public static final int SUCCESS_CODE = 200;


    /**
     * 数据层 code
     */
    public static final int DATA_NOT_EXIST_CODE = 900910;
    public static final int DATA_EXISTED_CODE = 900909;

    /**
     * code编码值
     */
    final int code;
    /**
     * 信息描述
     */
    final String msg;
}


