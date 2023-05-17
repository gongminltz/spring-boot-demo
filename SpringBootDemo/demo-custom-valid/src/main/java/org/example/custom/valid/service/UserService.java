package org.example.custom.valid.service;

import org.example.custom.valid.entity.User;

/**
 * 用户服务
 *
 * @author gongmin
 * @date 2022/10/17 15:49
 */
public interface UserService {
    /**
     * 通过id获取用户信息
     *
     * @param id id
     * @return 用户信息
     */
    User getById(String id);
}
