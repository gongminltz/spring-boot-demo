package org.example.aop.controller;

import lombok.extern.slf4j.Slf4j;
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
    @GetMapping("/test")
    public String test(String name) {
        log.info("<test> name = " + name);
        return "你好 " + name;
    }

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world!";
    }
}
