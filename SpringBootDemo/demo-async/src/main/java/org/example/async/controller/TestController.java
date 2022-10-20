package org.example.async.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.async.service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @Resource
    private AsyncService asyncService;

    @GetMapping("/test")
    public String test() {
        log.info("<test> start");
        asyncService.asyncTest();
        asyncService.asyncTest2();
        return "ok";
    }
}
