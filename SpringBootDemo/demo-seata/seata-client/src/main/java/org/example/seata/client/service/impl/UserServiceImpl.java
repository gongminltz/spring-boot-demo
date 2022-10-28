package org.example.seata.client.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.example.seata.client.entity.User;
import org.example.seata.client.mapper.UserMapper;
import org.example.seata.client.service.UserService;
import org.example.seata.provider.api.UserRoleApi;
import org.example.seata.provider.dto.UserRoleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserMapper userMapper;

    @Autowired
    private UserRoleApi userRoleApi;

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

        userMapper.insert(user);

        // 配置用户角色
        UserRoleDto userRole = UserRoleDto.builder()
                .id("1")
                .userId(userId)
                .roleId(roleId)
                .build();

        userRoleApi.insert(userRole);

        throw new RuntimeException();
    }
}
