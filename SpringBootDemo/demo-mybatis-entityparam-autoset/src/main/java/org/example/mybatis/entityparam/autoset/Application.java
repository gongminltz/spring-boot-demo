package org.example.mybatis.entityparam.autoset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 *
 * @author gongmin
 * @date 2022/10/14 11:21
 */
@SpringBootApplication
@MapperScan("org.example.mybatis.entityparam.autoset.mapper")
@EnableTransactionManagement
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("<main> start");
    }
}
