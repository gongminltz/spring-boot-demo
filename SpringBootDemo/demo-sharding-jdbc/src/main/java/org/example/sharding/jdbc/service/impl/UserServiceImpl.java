package org.example.sharding.jdbc.service.impl;

import org.example.sharding.jdbc.entity.User;
import org.example.sharding.jdbc.mapper.UserMapper;
import org.example.sharding.jdbc.service.UserService;
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
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
