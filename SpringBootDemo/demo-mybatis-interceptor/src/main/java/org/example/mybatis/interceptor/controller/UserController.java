package org.example.mybatis.interceptor.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.mybatis.interceptor.entity.User;
import org.example.mybatis.interceptor.service.UserService;
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
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/add")
    public String add(@RequestParam("id") String id, String name, String phone, String address) {
        log.info("<add> id = {}, name = {}, phone = {}, address = {}", id, name, phone, address);

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);

        userService.add(user);
        return "ok";
    }

    @GetMapping("/updatePhone")
    public String updatePhone(@RequestParam("id") String id, @RequestParam("phone") String phone) {
        log.info("<updatePhone> id = {}, phone = {}", id, phone);

        userService.updatePhone(id, phone);
        return "ok";
    }

    @GetMapping("/updatePhoneByPhone")
    public String updatePhoneByPhone(@RequestParam("oldPhone") String oldPhone, @RequestParam("newPhone") String newPhone) {
        log.info("<updatePhoneByPhone> oldPhone = {}, newPhone = {}", oldPhone, newPhone);

        userService.updatePhoneByPhone(oldPhone, newPhone);
        return "ok";
    }

    /**
     * 通过id获取用户信息
     *
     * @param id id
     * @return 用户信息
     */
    @GetMapping("/getById")
    public User getById(@RequestParam("id") String id) {
        User user = userService.getById(id);
        if (user == null) {
            log.warn("<getById> 没有找到id为{}的用户", id);
            return null;
        }

        log.info("<getById> name = " + user.getName());
        return user;
    }

    /**
     * 通过name获取用户信息
     *
     * @param name 名字
     * @return 用户信息
     */
    @GetMapping("/getByName")
    public List<User> getByName(@RequestParam("name") String name) {
        List<User> users = userService.getByName(name);
        if (CollectionUtils.isEmpty(users)) {
            log.warn("<getByName> 没有找到名字为{}的用户", name);
            return null;
        }

        return users;
    }

    /**
     * 通过phone获取用户信息
     *
     * @param phone 电话号码
     * @return 用户信息
     */
    @GetMapping("/getByPhone")
    public List<User> getByPhone(@RequestParam("phone") String phone) {
        List<User> users = userService.getByPhone(phone);
        if (users == null) {
            log.warn("<getByPhone> 没有找到电话号码为{}的用户", phone);
            return null;
        }

        return users;
    }
}
