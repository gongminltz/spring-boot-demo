package org.example.mybatis.entityparam.autoset.service.impl;

import org.example.mybatis.entityparam.autoset.entity.User;
import org.example.mybatis.entityparam.autoset.mapper.UserMapper;
import org.example.mybatis.entityparam.autoset.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteById(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getByPhone(String phone) {
        return userMapper.getByPhone(phone);
    }
}
