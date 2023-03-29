package org.example.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * TestController
 *
 * @author gongmin
 * @date 2022/12/29 15:21
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> test() {
        return Flux.just("test").delayElements(Duration.ofSeconds(5));
    }

    @GetMapping("/hello")
    public Mono<String> hello() {
        log.info("<hello> 线程" + Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        Mono<String> hello = Mono.fromSupplier(() -> getHelloStr());
        System.out.println("接口耗时：" + (System.currentTimeMillis() - start));
        log.info("<hello> 线程" + Thread.currentThread().getName());
        return hello;
    }

    private String getHelloStr() {
        try {
            log.info("<getHelloStr> 线程" + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    @GetMapping(value = "/flux",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {
        Flux<String> flux = Flux.fromArray(new String[]{"小黑","小胖","小六","一鑫"}).map(s -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "二班：" + s;
        });
        return flux;
    }
}
