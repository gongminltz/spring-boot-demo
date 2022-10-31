package org.example.dm.service.impl;

import org.example.dm.entity.User;
import org.example.dm.mapper.UserMapper;
import org.example.dm.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
    public User getById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getByName(String name) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("name", name);

        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> getByPhone(String phone) {
        return userMapper.getByPhone(phone);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }
}
