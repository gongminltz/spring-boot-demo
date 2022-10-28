package org.example.seata.provider.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色关联表
 *
 * @author gongmin
 * @date 2022/10/18 13:40
 */
@Table(name = "user_role")
@Data
public class UserRole {
    @Id
    private String id;
    private String userId;
    private String roleId;
}
