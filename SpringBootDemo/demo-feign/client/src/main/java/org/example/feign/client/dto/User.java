package org.example.feign.client.dto;

import lombok.Data;

/**
 * 用户表
 *
 * @author gongmin
 * @date 2022/10/17 15:41
 */
@Data
public class User {
    private String id;
    private String name;
    private String phone;
    private String address;
}
