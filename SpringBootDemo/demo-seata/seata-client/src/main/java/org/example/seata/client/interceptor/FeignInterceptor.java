package org.example.seata.client.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import org.springframework.context.annotation.Configuration;

/**
 * feign拦截器
 *
 * @author gongmin
 * @date 2022/10/28 11:50
 */
@Configuration
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String xid = RootContext.getXID();
        requestTemplate.header(RootContext.KEY_XID, xid);
    }
}
