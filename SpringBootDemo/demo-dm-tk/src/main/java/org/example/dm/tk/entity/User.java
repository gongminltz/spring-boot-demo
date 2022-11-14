package org.example.dm.tk.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表
 *
 * @author gongmin
 * @date 2022/10/17 15:41
 */
@Data
@Table(name = "user_0")
public class User {
    @Id
    private String id;
    private String name;
    private String phone;
    private String address;
}
