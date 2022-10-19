package org.example.global.exception.handler.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义异常类
 *
 * @author gongmin
 * @date 2022/10/19 15:06
 */
@AllArgsConstructor
@Data
public class BusinessException extends RuntimeException {
    private String code;
    private String msg;
}
