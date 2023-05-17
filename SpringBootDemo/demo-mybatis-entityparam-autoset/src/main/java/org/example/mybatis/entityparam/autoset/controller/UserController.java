package org.example.mybatis.entityparam.autoset.controller;

import org.example.mybatis.entityparam.autoset.entity.User;
import org.example.mybatis.entityparam.autoset.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/insert")
    public User insert(@RequestBody User user) {
        userService.insert(user);
        return user;
    }

    @PostMapping("/update")
    public User update(@RequestBody User user) {
        userService.updateById(user);
        return user;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        userService.deleteById(id);
        return "ok";
    }

    @GetMapping("/get")
    public User get(@RequestParam("id") String id) {
        return userService.getById(id);
    }

    @GetMapping("/getByPhone")
    public List<User> getByPhone(@RequestParam("phone") String phone) {
        return userService.getByPhone(phone);
    }
}
