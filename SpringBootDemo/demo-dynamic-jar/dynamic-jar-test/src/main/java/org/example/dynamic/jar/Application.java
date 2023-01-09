package org.example.dynamic.jar;

import sun.misc.ClassLoaderUtil;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

/**
 * TODO
 *
 * @author gongmin
 * @date 2023/1/6 11:04
 */
public class Application {
    private static Class clazz = null;
    private static Method method = null;
    private static URLClassLoader classloader = null;

    public static void main(String[] args) {
        System.out.println("<main> start");

        Scanner userInput = new Scanner(System.in);

        do {
            String cmd = userInput.next();
            if ("reload".equals(cmd)) {
                try {

                    URL url = new File("E:\\workspace\\spring-boot-demo\\SpringBootDemo\\demo-dynamic-jar\\dynamic-jar\\target\\dynamic-jar-1.0-SNAPSHOT.jar").toURI().toURL();

                    classloader = new URLClassLoader(new URL[]{url});

                    System.out.println(classloader);

                    clazz = classloader.loadClass("org.example.gm.dynamic.jar.Sum");

                    method = clazz.getDeclaredMethod("sum", Integer.class, Integer.class);

                    System.out.println("jar包加载完成");
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else if ("removeJar".equals(cmd)) {
                clazz = null;
                method = null;
                ClassLoaderUtil.releaseLoader(classloader);
                System.out.println("卸载jar包");
            } else if ("invoke".equals(cmd)) {
                Object obj = null;
                try {
                    obj = method.invoke(clazz.newInstance(), 10, 11);
                    System.out.println((int) obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if ("quit".equals(cmd)) {
                break;
            }

        } while (true);
    }
}
