package org.example.seata.service;

/**
 * 用户服务
 *
 * @author gongmin
 * @date 2022/10/17 15:49
 */
public interface UserService {
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
