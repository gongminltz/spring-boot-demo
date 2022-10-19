package org.example.filter.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义过滤器
 *
 * @author gongmin
 * @date 2022/10/19 8:48
 */
@Component
@WebFilter(urlPatterns = "/*")
@Order(1)
public class MyFilter2 implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(MyFilter2.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        logger.info("<doFilter> " + httpServletRequest.getRequestURI());

        if (httpServletRequest.getRequestURI().equals("/test/helloWorld")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("<init> start");
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        logger.info("<destroy> start");
        Filter.super.destroy();
    }
}
