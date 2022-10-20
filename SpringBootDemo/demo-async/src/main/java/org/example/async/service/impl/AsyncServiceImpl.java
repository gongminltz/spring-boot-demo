package org.example.async.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.async.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步服务
 *
 * @author gongmin
 * @date 2022/10/20 15:07
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {
    @Async
    @Override
    public void asyncTest() {
        log.info("<asyncTest> start");
    }

    @Override
    public void asyncTest2() {
        asyncTest3();
        log.info("<asyncTest2> start");
    }

    @Override
    @Async
    public void asyncTest3() {
        log.info("<asyncTest3> start");
    }
}
