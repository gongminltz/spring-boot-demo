package org.example.dm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户表
 *
 * @author gongmin
 * @date 2022/10/17 15:41
 */
@Data
@TableName(value = "user_0")
public class User {
    @TableId
    private String id;
    private String name;
    private String phone;
    private String address;
}
