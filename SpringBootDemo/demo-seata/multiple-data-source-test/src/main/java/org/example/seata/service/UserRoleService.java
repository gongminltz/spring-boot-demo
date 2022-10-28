package org.example.seata.service;

import org.example.seata.entity.UserRole;

/**
 * UserRoleService
 *
 * @author gongmin
 * @date 2022/10/26 8:44
 */
public interface UserRoleService {
    /**
     * 新增一条userRole记录
     *
     * @param userRole userRole
     */
    void insert(UserRole userRole);
}
