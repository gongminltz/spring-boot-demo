package org.example.sentinel.controller;

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
    @GetMapping("/test")
    public String test(Integer duration) {
        if (duration == null) {
            return "Hello world!";
        }

        try {
            Thread.sleep(duration *1000);
            return "Hello world!";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
