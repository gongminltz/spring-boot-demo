package org.example.multiple.data.source.service.impl;

import org.example.multiple.data.source.entity.User;
import org.example.multiple.data.source.mapper.gm2.Gm2UserMapper;
import org.example.multiple.data.source.service.UserService;
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
    private Gm2UserMapper gm2UserMapper;

    @Override
    public User getById(String id) {
        return gm2UserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getByName(String name) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("name", name);

        return gm2UserMapper.selectByExample(example);
    }

    @Override
    public List<User> getByPhone(String phone) {
        return gm2UserMapper.getByPhone(phone);
    }
}
