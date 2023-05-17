package org.example.mybatis.entityparam.autoset.service;

import org.example.mybatis.entityparam.autoset.entity.User;

import java.util.List;

/**
 * 用户服务
 *
 * @author gongmin
 * @date 2022/10/17 15:49
 */
public interface UserService {
    void insert(User user);

    void updateById(User user);

    void deleteById(String id);

    User getById(String id);

    List<User> getByPhone(String phone);
}
