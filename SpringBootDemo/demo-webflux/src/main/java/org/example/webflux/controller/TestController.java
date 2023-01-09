package org.example.webflux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * TestController
 *
 * @author gongmin
 * @date 2022/12/29 15:21
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> test() {
        return Flux.just("test").delayElements(Duration.ofSeconds(5));
    }
}
