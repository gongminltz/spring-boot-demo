package org.example.spring.boot.test.service.impl;

import org.example.spring.boot.test.entity.User;
import org.example.spring.boot.test.mapper.UserMapper;
import org.example.spring.boot.test.service.UserService;
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
