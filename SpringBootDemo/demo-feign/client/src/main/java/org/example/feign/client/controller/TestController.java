package org.example.feign.client.controller;

import org.example.feign.client.dto.User;
import org.example.feign.client.service.HkwsService;
import org.example.feign.client.third.MybatisUserApi;
import org.example.feign.provider.api.UserApi;
import org.example.feign.provider.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date 2022/10/19 17:18
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserApi userApi;

    @Autowired
    private MybatisUserApi mybatisUserApi;

    @Resource
    private HkwsService hkwsService;

    @GetMapping("/test")
    public UserDto test(@RequestParam("id") String id) {
        return userApi.getUser(id);
    }

    /**
     * 根据用户名自来获取用户信息
     *
     * @param name 用户名自
     * @return 用户信息列表
     */
    @GetMapping("/getByName")
    List<User> getByName(@RequestParam("name") String name) {
        return mybatisUserApi.getByName(name);
    }

    @GetMapping("/getAccessToken")
    public String getAccessToken() {
        return hkwsService.getAccessToken();
    }
}
