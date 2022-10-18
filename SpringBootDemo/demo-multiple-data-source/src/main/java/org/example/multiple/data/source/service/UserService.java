package org.example.multiple.data.source.service;

import org.apache.ibatis.annotations.Param;
import org.example.multiple.data.source.entity.User;

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

    /**
     * 新增用户并且配置用户角色
     *
     * @param userName 用户名字
     * @param phone    手机号码
     * @param address  地址
     * @param roleId   角色id
     */
    void addUserAndSetRole(String userName, String phone, String address, String roleId);
}
