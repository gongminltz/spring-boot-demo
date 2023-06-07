package org.example.log4j2.sensitive.controller;

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
    @GetMapping("/test")
    public String test(String phone, String name, String email, String bankCard) {
        log.info("<test> phone:={}, name:={}, email:={}, bankCard:={}", phone, name, email, bankCard);
        return "Hello world!";
    }
}
