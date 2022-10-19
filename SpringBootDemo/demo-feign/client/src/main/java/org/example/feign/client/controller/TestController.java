package org.example.feign.client.controller;

import org.example.feign.provider.api.UserApi;
import org.example.feign.provider.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/test")
    public UserDto test() {
        return userApi.getUser("1");
    }
}
