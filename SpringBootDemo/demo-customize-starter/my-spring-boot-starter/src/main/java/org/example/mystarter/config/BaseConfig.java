package org.example.mystarter.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @author gongmin
 * @date 2022/10/20 14:07
 */
@Configuration
@Slf4j
public class BaseConfig {
    @Bean
    public InterceptorConfig interceptorConfig() {
        log.debug("<interceptorConfig> start");
        return new InterceptorConfig();
    }
}
