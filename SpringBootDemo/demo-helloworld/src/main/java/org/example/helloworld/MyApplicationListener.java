package org.example.helloworld;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * MyApplicationListener
 *
 * @author gongmin
 * @date 2023/3/29 15:08
 */
@Component
public class MyApplicationListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("应用程序关闭了");
    }
}
