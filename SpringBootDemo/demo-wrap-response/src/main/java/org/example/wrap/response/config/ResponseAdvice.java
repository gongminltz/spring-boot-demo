package org.example.wrap.response.config;

import org.example.wrap.response.dto.ResponseData;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 包装返回值
 *
 * @author gongmin
 * @date 2022/10/19 11:09
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    /**
     * 内容是否需要重写（通过此⽅法可以选择性部分控制器和⽅法进⾏重写）
     * 返回 true 表示重写
     *
     * @param methodParameter 返回数据类型
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        /**
         * 这里有一点要注意，这个advice中supports方法中判断返回结果类型必须为非String类型。
         * 如果返回结果为String类型，那么result要转为json字符串后再返回，需要再写一个advice。
         */
        if (methodParameter.getGenericParameterType().equals(ResponseData.class) ||
                methodParameter.getGenericParameterType().equals(String.class)) {
            return false;
        }

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return ResponseData.builder().code("0")
                .msg("ok")
                .data(o)
                .build();
    }
}
