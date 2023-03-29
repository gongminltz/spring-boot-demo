package org.example.python;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author gongmin
 * @date 2023/1/9 15:29
 */
public class Application {
    public static void main(String[] args) {
//        PythonInterpreter interpreter = new PythonInterpreter();
//
//        interpreter.execfile("E:\\workspace\\spring-boot-demo\\SpringBootDemo\\demo-python\\src\\main\\resources\\sum.py");
//
//        // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
//        PyFunction pyFunction = interpreter.get("start", PyFunction.class);
//        String param = "10,12";
//        //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
//        PyObject pyobj = pyFunction.__call__(new PyString(param));
//        System.out.println("the answer is: " + pyobj);

        test();
    }

    public static void test() {
        try {
            String[] execParam = {"C:\\Users\\00771487\\AppData\\Local\\Programs\\Python\\Python310\\python.exe", "E:\\\\workspace\\\\spring-boot-demo\\\\SpringBootDemo\\\\demo-python\\\\src\\\\main\\\\resources\\\\sum.py",
                    "traceId_123", "http://localhost:9090/algorithm/v1/callback/traceId_123", "1,10"};
            Process pr = Runtime.getRuntime().exec(execParam);
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            InputStream errorStream = pr.getErrorStream();
            BufferedReader error = new BufferedReader(new InputStreamReader(errorStream, "gbk"));

            String lines = null;
            while ((lines = error.readLine()) != null) {
                System.out.println(lines);
            }
            error.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
