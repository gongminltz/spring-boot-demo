package org.example.mystarter.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 *
 * @author gongmin
 * @date 2022/10/20 14:26
 */
@RestController
@RequestMapping("/test")
public class TestController {
    /**
     * 休息duration毫秒后返回ok
     *
     * @param duration 休息时长，单位毫秒
     * @return ok
     */
    @GetMapping("/test")
    public String test(Integer duration) {
        if (duration == null) {
            return "ok";
        }

        try {
            Thread.sleep(duration);
            return "ok";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
