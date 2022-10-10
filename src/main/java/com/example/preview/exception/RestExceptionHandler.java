package com.example.preview.exception;/*
@author lujinyi
@creatr 2022-04-2022/4/7-16:31
*/

import com.example.preview.util.Result;
import com.example.preview.util.SystemCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@RestControllerAdvice
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class RestExceptionHandler {
    /**
     * 未能捕获的异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.warn("未知异常:{}", e.getMessage());
        log.error("未知异常:{}", e);
        return Result.fail(SystemCode.FAILURE_CODE, "服务器内部错误");
    }

    /**
     * 捕获自定义抛出的异常
     */
    @ExceptionHandler(BusinessExceptions.class)
    public Result handleServiceException(BusinessExceptions e) {
        log.warn("自定义抛出异常:{}", e.getMessage());
        return Result.fail(e.getCode(), e.getMsg());
    }
}
