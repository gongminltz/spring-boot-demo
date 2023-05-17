package org.example.java.agent.test;

/**
 * HelloService
 *
 * @author gongmin
 * @date 2023/5/4 15:37
 */
public class HelloService {
    public void sayHello(String name) {
        System.out.println("      HelloService.sayHello开始");
        System.out.println("         Hello " + name + "!");
        System.out.println("      HelloService.sayHello结束");
    }
}
