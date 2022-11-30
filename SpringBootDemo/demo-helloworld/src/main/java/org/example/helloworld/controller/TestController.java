package org.example.helloworld.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TestController {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world!";
    }

    @GetMapping("/add")
    public String add(@RequestParam("data1") Integer data1, @RequestParam("data2") Integer data2) {
        return String.valueOf(data1 + data2);
    }

    @GetMapping("/waitTest")
    public String waitTest(long duration) {
        try {
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            return "fail";
        }

        return "ok";
    }
}
