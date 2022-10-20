package org.example.mystarter.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求耗时拦截器
 *
 * @author gongmin
 * @date 2022/10/20 14:10
 */
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {
    private static final ThreadLocal<Long> requestStartTimeThreadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long curTime = System.currentTimeMillis();
        requestStartTimeThreadLocal.set(curTime);

        log.debug("<preHandle> uri = {}, 开始时间 = {}",request.getRequestURI(), curTime);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);

        long startTime = requestStartTimeThreadLocal.get();
        long curTime = System.currentTimeMillis();
        log.debug("<afterCompletion> uri = {}, 开始时间 = {}, 结束时间 = {}, 总共耗时 = {}毫秒",
                request.getRequestURI(), startTime, curTime, (curTime - startTime));
    }
}
