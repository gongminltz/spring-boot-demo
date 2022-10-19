package org.example.global.exception.handler.controller;

import org.example.global.exception.handler.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/exception1")
    public void exception1(@RequestParam("code") String code, @RequestParam("msg") String msg) {
        throw new BusinessException(code, msg);
    }

    @GetMapping("/exception2")
    public void exception2(@RequestParam("msg") String msg) {
        throw new RuntimeException(msg);
    }
}
