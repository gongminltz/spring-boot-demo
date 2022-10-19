package org.example.aop.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.example.aop.dto.LogInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ControllerAop
 *
 * @author gongmin
 * @date 2022/10/19 9:03
 */
@Aspect
@Component
@Slf4j
public class GlobalLogAspect extends BaseAspectSupport {
    private static final JsonMapper jsonMapper = new JsonMapper();

    /**
     * 定义切面Pointcut
     * <p>
     * 第一个*表示任意返回值
     * 第二个*表示controller包中的任意类
     * 第三个*表示任意方法
     * 括号中中的..表示任意参数
     */
    @Pointcut("execution (* org.example.aop.controller.*.*(..))")
    public void log() {

    }

    @AfterReturning(pointcut = "log()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) throws JsonProcessingException {
        log.info("<afterReturning> " + jsonMapper.writeValueAsString(result));
    }


    /**
     * 环绕通知
     *
     * @param joinPoint joinPoint
     * @return 目标方法返回值
     */
    @Around("log()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LogInfo logInfo = new LogInfo();

        // 记录时间定时器
        long startTime = System.currentTimeMillis();

        // 接口请求时间
        logInfo.setStartTime(startTime);

        // 执行结果
        Object result = joinPoint.proceed();
        logInfo.setResult(result);

        // 执行消耗时间
        long timeEnd = System.currentTimeMillis();
        logInfo.setSpendTime(timeEnd - startTime);

        // 执行参数
        Method method = resolveMethod(joinPoint);
        logInfo.setParameter(getParameter(method, joinPoint.getArgs()));

        // 获取HttpServletRequest
        HttpServletRequest request;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            log.error("<doAround> requestAttributes is null");
            throw new RuntimeException("requestAttributes is null");
        }
        request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        // 请求链接
        logInfo.setUrl(request.getRequestURL().toString());

        // 请求方法
        logInfo.setMethod(request.getMethod());

        // 请求地址
        logInfo.setIp(getRemoteHost(request));

        log.info("<doAround> " + jsonMapper.writeValueAsString(logInfo));

        return result;
    }

    /**
     * 获取ip地址
     *
     * @param request 请求
     * @return 返回ip地址
     */
    public String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    /**
     * 根据方法和传入的参数获取请求参数
     */
    private Object getParameter(Method method, Object[] args) {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < parameters.length; i++) {
            //将RequestBody注解修饰的参数作为请求参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            //将RequestParam注解修饰的参数作为请求参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            String key = parameters[i].getName();
            if (requestBody != null) {
                argList.add(args[i]);
            } else if (requestParam != null) {
                map.put(key, args[i]);
            } else {
                map.put(key, args[i]);
            }
        }
        if (map.size() > 0) {
            argList.add(map);
        }
        if (argList.size() == 0) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }
}
