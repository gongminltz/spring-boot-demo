package org.example.dm.service.impl;

import org.example.dm.entity.User;
import org.example.dm.mapper.UserMapper;
import org.example.dm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return userMapper.selectById(id);
    }

    @Override
    public List<User> getByName(String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);

        return userMapper.selectByMap(map);
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
