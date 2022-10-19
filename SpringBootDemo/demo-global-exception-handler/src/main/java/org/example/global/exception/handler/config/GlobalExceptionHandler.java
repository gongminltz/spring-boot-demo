package org.example.global.exception.handler.config;

import org.example.global.exception.handler.dto.ResponseData;
import org.example.global.exception.handler.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author gongmin
 * @date 2022/10/19 15:07
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ResponseData businessExceptionHandler(BusinessException e) {
        return ResponseData.builder()
                .code(e.getCode())
                .msg(e.getMsg())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseData exception(Exception e) {
        return ResponseData.builder()
                .code("500")
                .msg(e.getMessage())
                .build();
    }
}
