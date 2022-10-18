package org.example.multiple.data.source.entity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色关联表
 *
 * @author gongmin
 * @date 2022/10/18 13:40
 */
@Table(name = "user_role")
public class UserRole {
    @Id
    private String id;
    private String userId;
    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
