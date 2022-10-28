package org.example.seata.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.example.seata.entity.User;
import org.example.seata.entity.UserRole;
import org.example.seata.mapper.gm1.Gm1UserMapper;
import org.example.seata.service.UserRoleService;
import org.example.seata.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务
 *
 * @author gongmin
 * @date 2022/10/17 15:49
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private Gm1UserMapper gm1UserMapper;

    @Resource
    private UserRoleService userRoleService;

    @Override
    @GlobalTransactional
    public void addUserAndSetRole(String userName, String phone, String address, String roleId) {
        logger.info("<addUserAndSetRole> userName = {}, phone = {}, address = {}, roleId = {}",
                userName, phone, address, roleId);

        String userId = "2" + roleId;

        // 新增用户
        User user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setPhone(phone);
        user.setAddress(address);

        gm1UserMapper.insert(user);

        // 配置用户角色
        UserRole userRole = new UserRole();
        userRole.setId("1");
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);

        userRoleService.insert(userRole);

        throw new RuntimeException();
    }
}
