package org.example.wrap.response.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.wrap.response.dto.ResponseData;
import org.example.wrap.response.dto.User;
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
@Slf4j
public class TestController {
    @GetMapping("/test1")
    public String test1(String name) {
        log.info("<test1> name = " + name);
        return "ok: " + name;
    }

    @GetMapping("/test")
    public User test(String name) {
        log.info("<test> name = " + name);

        return User.builder().id("1")
                .name("gongmin")
                .phone("12344")
                .build();
    }

    @GetMapping("/helloWorld")
    public ResponseData helloWorld() {
        return ResponseData.builder().code("0")
                .msg("ok")
                .data("hello world")
                .build();
    }
}
