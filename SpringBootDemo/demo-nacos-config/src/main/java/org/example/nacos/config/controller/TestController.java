package org.example.nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author gongmin
 * @date 2022/10/14 11:22
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {
    @Value("${gm.url}")
    private String gmUrl;

    @Value("${gm.password}")
    private String password;

    @GetMapping("/test")
    public String helloWorld() {
        return "gm.url = " + gmUrl + ", password = " + password;
    }
}
