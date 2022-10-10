package com.example.preview.util;/*
@author lujinyi
@creatr 2022-04-2022/4/7-15:57
*/

public class CmfClmTokenException extends RuntimeException{
    private String errorCode;
    private String errorDescription;

    public CmfClmTokenException(String errorCode, String errorDescription) {
        super(errorCode + ":" + errorDescription);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}

