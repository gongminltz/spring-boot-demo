package org.example.mybatis.interceptor.service;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.interceptor.entity.User;

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

    /**
     * 通过名称查找
     *
     * @param name 名字
     * @return 用户列表
     */
    List<User> getByName(String name);

    /**
     * 通过电话号码获取
     *
     * @param phone 电话号码
     * @return 用户信息
     */
    List<User> getByPhone(@Param("phone") String phone);

    void add(User user);

    void updatePhone(String id, String phone);

    void updatePhoneByPhone(String oldPhone, String newPhone);
}
