package org.example.mybatis.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表
 *
 * @author gongmin
 * @date 2022/10/17 15:41
 */
@Table(name = "user")
@Data
public class User {
    @Id
    private Long id;
    private String sex;
    private String name;
    private String phone;
    private String address;
}
