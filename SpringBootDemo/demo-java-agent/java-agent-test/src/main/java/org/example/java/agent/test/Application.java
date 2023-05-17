package org.example.java.agent.test;

/**
 * Application
 *
 * @author gongmin
 * @date 2023/5/4 15:36
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Application.main开始");

        HelloService helloService = new HelloService();
        helloService.sayHello("一拳超人");

        System.out.println("Application.main结束");
    }
}
