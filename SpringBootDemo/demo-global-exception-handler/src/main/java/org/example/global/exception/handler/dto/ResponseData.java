package org.example.global.exception.handler.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 统一返回数据格式
 *
 * @author gongmin
 * @date 2022/10/19 15:09
 */
@Data
@Builder
public class ResponseData {
    private String code;
    private String msg;
    private Object data;
}
