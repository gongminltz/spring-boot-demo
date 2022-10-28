package org.example.seata.provider.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.example.seata.provider.entity.UserRole;
import org.example.seata.provider.mapper.UserRoleMapper;
import org.example.seata.provider.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserRoleServiceImpl
 *
 * @author gongmin
 * @date 2022/10/26 14:45
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    @GlobalTransactional
    public void insert(UserRole userRole) {
        userRoleMapper.insert(userRole);
    }
}
