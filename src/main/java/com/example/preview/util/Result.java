package com.example.preview.util;/*
@author lujinyi
@creatr 2022-04-2022/4/7-15:58
*/


import com.example.preview.constant.enums.CommonEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import static com.example.preview.constant.enums.CommonEnum.SUCCESS_RESPONSE;

import java.io.Serializable;

/**
 * @Description:响应结果集
 * @Author: x
 * @Date :
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(description = "响应信息主体")
@Data
public class Result <T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回标记：成功标记=200，失败标记=400")
    private int code;

    @ApiModelProperty(value = "返回信息")
    private String msg;

    @ApiModelProperty(value = "数据")
    private T data;

    @ApiModelProperty(value = "查询信息是否错误")
    private String flag;

    /**
     * 成功
     */
    public static <T> Result<T> succeed() {
        return restResult(null, SUCCESS_RESPONSE.getCode(), null,"true");
    }

    public static <T> Result<T> succeed(T data) {
        return restResult(data, SUCCESS_RESPONSE.getCode(), null,"true");
    }

    public static <T> Result<T> succeed(T data, String msg,String flag) {
        return restResult(data, SUCCESS_RESPONSE.getCode(), msg,flag);
    }

    /**
     * 失败
     */

    public static <T> Result<T> fail(int code, String msg) {
        return restResult(null, code, msg,"false");
    }



    private static <T> Result<T> restResult(T data, int code, String msg,String flag) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        apiResult.setFlag(flag);
        return apiResult;
    }

    public Result(CommonEnum commonEnum, T data) {
        this.code = commonEnum.getCode();
        this.msg = commonEnum.getMsg();
        this.data = data;
    }

    public Result(CommonEnum commonEnum) {
        this.code = commonEnum.getCode();
        this.msg = commonEnum.getMsg();
    }


    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
