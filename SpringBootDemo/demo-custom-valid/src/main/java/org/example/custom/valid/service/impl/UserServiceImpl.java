package org.example.custom.valid.service.impl;

import org.example.custom.valid.entity.User;
import org.example.custom.valid.mapper.UserMapper;
import org.example.custom.valid.service.UserService;
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
    public User getById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
