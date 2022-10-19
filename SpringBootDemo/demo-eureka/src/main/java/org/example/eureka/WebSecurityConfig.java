package org.example.eureka;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * csrf配置类
 *
 * @author gongmin
 * @date 2022/10/19 17:10
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 关闭csrf认证，否则会报错Root name 'timestamp' does not match expected ('instance')
        http.csrf().disable();
        super.configure(http);
    }
}
