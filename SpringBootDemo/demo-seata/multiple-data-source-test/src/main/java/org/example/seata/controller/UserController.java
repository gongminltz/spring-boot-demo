package org.example.seata.controller;

import org.example.seata.entity.User;
import org.example.seata.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户接口
 *
 * @author gongmin
 * @date 2022/10/17 15:51
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 新增用户并且配置用户角色
     *
     * @param userName 用户名字
     * @param phone    手机号码
     * @param address  地址
     * @param roleId   角色id
     * @return ok
     */
    @GetMapping("/addUserAndSetRole")
    public String addUserAndSetRole(String userName, String phone, String address, String roleId) {
        userService.addUserAndSetRole(userName, phone, address, roleId);
        return "ok";
    }
}
