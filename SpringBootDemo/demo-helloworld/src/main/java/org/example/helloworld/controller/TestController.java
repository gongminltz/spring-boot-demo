package org.example.helloworld.controller;

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
public class TestController {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world!";
    }
}
