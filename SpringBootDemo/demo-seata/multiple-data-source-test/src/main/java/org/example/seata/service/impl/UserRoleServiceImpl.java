package org.example.seata.service.impl;

import org.example.seata.entity.UserRole;
import org.example.seata.mapper.gm2.UserRoleMapper;
import org.example.seata.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserRoleServiceImpl
 *
 * @author gongmin
 * @date 2022/10/26 8:45
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public void insert(UserRole userRole) {
        userRoleMapper.insert(userRole);
    }
}
