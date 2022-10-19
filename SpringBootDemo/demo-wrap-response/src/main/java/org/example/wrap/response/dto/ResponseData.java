package org.example.wrap.response.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 统一返回数据格式
 *
 * @author gongmin
 * @date 2022/10/19 11:55
 */
@Data
@Builder
public class ResponseData {
    private String code;
    private String msg;
    private Object data;
}
