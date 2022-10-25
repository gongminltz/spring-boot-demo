package org.example.sentinel.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import org.springframework.context.annotation.Configuration;

import java.io.PrintWriter;

/**
 * SentinelExceptionConfig
 *
 * @author gongmin
 * @date 2022/10/25 11:35
 */
@Configuration
public class SentinelExceptionConfig {
    //静态块中
    static {
        WebCallbackManager.setUrlBlockHandler((request, response, ex) -> {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            // 简单演示，这里可以自行处理
            PrintWriter out = response.getWriter();
            out.print("当前访问用户过多，请稍后重试");
            out.flush();
            out.close();
        });
    }
}
