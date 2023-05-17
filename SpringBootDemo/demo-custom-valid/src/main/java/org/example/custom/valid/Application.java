package org.example.custom.valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 *
 * @author gongmin
 * @date 2022/10/14 11:21
 */
@SpringBootApplication
@MapperScan("org.example.custom.valid.mapper")
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("<main> start");
    }
}
