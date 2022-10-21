package org.example.feign.client.third;

import feign.Logger;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

/**
 * feign 表单请求支持配置
 *
 * @author gongmin
 * @date 2022/10/20 17:26
 */
public class FeignFormSupportConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    /**
     * new一个form编码器，实现支持form表单提交
     *
     * @return form编码器
     */
    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

    /**
     * 开启Feign的日志
     *
     * @return 日志级别
     */
    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }
}
