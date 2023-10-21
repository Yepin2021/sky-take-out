package com.sky.handler;

import com.alibaba.druid.util.StringUtils;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;

import static com.sky.constant.MessageConstant.ALREADY_EXISTS;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    @ExceptionHandler
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        String errMessage = ex.getMessage();
        String username = null;
        log.error("SQL异常信息：{}",errMessage);
        if(errMessage.contains("Duplicate entry")){
            username = StringUtils.subString(ex.getMessage(), "entry '", "' for");
        }
        return Result.error(username + ALREADY_EXISTS);
    }
}
