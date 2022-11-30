package org.example.mybatis.interceptor.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户表
 *
 * @author gongmin
 * @date 2022/10/17 15:41
 */
@Table(name = "user_0")
@Data
public class User {
    @Id
    private String id;
    private String name;
    private String phone;
    private String address;
    public Date createdAt;
}
