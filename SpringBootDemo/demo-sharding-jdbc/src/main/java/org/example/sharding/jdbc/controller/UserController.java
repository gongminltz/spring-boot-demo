package org.example.sharding.jdbc.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.sharding.jdbc.entity.User;
import org.example.sharding.jdbc.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户接口
 *
 * @author gongmin
 * @date 2022/10/17 15:51
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 通过id获取用户信息
     *
     * @param id id
     * @return 用户信息
     */
    @GetMapping("/selectById")
    public User selectById(@RequestParam("id") Integer id) {
        User user = userService.selectById(id);
        if (user == null) {
            log.warn("<getById> 没有找到id为{}的用户", id);
            return null;
        }

        log.info("<getById> name = " + user.getName());
        return user;
    }

    /**
     * 插入一条新记录
     *
     * @param id      用户id
     * @param name    名称
     * @param phone   电话号码
     * @param address 地址
     * @return 返回ok
     */
    @GetMapping("/insert")
    public String insert(@RequestParam("id") Integer id, @RequestParam("name") String name,
                         @RequestParam("phone") String phone, @RequestParam("address") String address) {
        User user = User.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .address(address)
                .build();

        userService.insert(user);

        return "ok";
    }
}
