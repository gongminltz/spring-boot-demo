package org.example.spring.boot.test.service;

import org.apache.ibatis.annotations.Param;
import org.example.spring.boot.test.entity.User;

import java.util.List;

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
