package org.example.redis.distributed.lock.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * TestController
 *
 * @author gongmin
 * @date 2022/11/30 15:08
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private RedissonClient redissonClient;

    private int count = 100;

    @GetMapping("/test")
    public String test(Integer threadCount) {
        if (threadCount == null) {
            threadCount = 10;
        }

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                RLock rLock = redissonClient.getLock("count");
                rLock.lock(10, TimeUnit.SECONDS);

                if (count >= 5) {
                    try {
                        Thread.sleep(50);
                        count -= 5;
                        log.info("当前count为" + count);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    log.error("当前count为{}， 数量不足5个，无法售出", count);
                }

                rLock.unlock();
            }).start();
        }

        return "ok";
    }
}
