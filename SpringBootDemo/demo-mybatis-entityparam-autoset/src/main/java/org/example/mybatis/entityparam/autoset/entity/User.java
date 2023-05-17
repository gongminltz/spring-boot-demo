package org.example.mybatis.entityparam.autoset.entity;

import lombok.Data;

import javax.persistence.Table;

/**
 * 用户表
 *
 * @author gongmin
 * @date 2022/10/17 15:41
 */
@Table(name = "user")
@Data
public class User extends BaseEntity {
    private String sex;
    private String name;
    private String phone;
    private String address;
}
