package org.example.mongodb.service;

import org.example.mongodb.entity.User;

import java.util.List;

/**
 * UserService
 *
 * @author gongmin
 * @date 2022/11/4 15:03
 */
public interface UserService {
    void insert(User user);

    /**
     * 通过名字查询用户
     *
     * @param name 名字
     * @return 用户列表
     */
    List<User> findByName(String name);
}
