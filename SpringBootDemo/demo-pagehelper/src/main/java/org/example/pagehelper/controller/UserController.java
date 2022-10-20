package org.example.pagehelper.controller;

import com.github.pagehelper.PageInfo;
import org.example.pagehelper.entity.User;
import org.example.pagehelper.service.UserService;
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
     * 分页获取获取用户信息
     *
     * @param pageNum 页码 从1开始
     * @param pageSize 每页个数
     * @return 用户信息
     */
    @GetMapping("/getList")
    public PageInfo<User> getList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        return userService.getList(pageNum, pageSize);
    }
}
