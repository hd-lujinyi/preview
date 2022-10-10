package com.example.preview.constant.enums;/*
@author lujinyi
@creatr 2022-04-2022/4/7-16:00
*/

import lombok.Getter;
import lombok.Setter;

public enum CommonEnum {

    //成功

    SUCCESS_RESPONSE(200, "成功"),
    //失败

    FAILED_RESPONSE(400, "失败");

    @Setter
    @Getter
    private Integer code;

    @Setter
    @Getter
    private String msg;


    CommonEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
