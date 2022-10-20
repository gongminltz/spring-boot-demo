package org.example.feign.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 *
 * @author gongmin
 * @date 2022/10/14 11:21
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(value = {"org.example.feign.provider.api", "org.example.feign.client.third"})
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("<main> start");
    }
}
