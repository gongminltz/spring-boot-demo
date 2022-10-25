package org.example.sharding.jdbc.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 用户表
 *
 * @author gongmin
 * @date 2022/10/17 15:41
 */
@Data
@Builder
public class User {
    private Integer id;
    private String name;
    private String phone;
    private String address;
}
