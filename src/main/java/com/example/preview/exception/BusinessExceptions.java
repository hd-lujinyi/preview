package com.example.preview.exception;/*
@author lujinyi
@creatr 2022-04-2022/4/7-16:30
*/

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BusinessExceptions  extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public BusinessExceptions(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }
    public BusinessExceptions(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessExceptions(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

