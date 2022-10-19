package org.example.feign.provider.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 用户信息
 *
 * @author gongmin
 * @date 2022/10/19 16:15
 */
@Data
@Builder
public class UserDto {
    private String id;
    private String name;
    private String phone;
}
