package org.example.my.java.agent;

import java.lang.instrument.Instrumentation;

/**
 * AgentTest
 *
 * @author gongmin
 * @date 2023/5/4 15:26
 */
public class AgentTest {
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("AgentTest.premain开始");

        instrumentation.addTransformer(new PrintTransformer());

        System.out.println("AgentTest.premain结束");
    }

    public static void main(String[] args) {
        //main方法在idea打包时需要，实际上没什么作用，不会被执行。
    }
}
