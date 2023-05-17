package org.example.my.java.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PrintTransformer
 *
 * @author gongmin
 * @date 2023/5/4 15:26
 */
public class PrintTransformer implements ClassFileTransformer {
    final static String startTime = "\nlong startTime = System.nanoTime();\n";
    final static String endTime = "\nlong endTime = System.nanoTime();\n";

    final static Map<String, List<String>> methodMap = new HashMap<>();

    public PrintTransformer() {
        addMethod("org.example.java.agent.test.HelloService", "sayHello");
    }

    private PrintTransformer addMethod(String className, String methodName) {
        List<String> list = methodMap.computeIfAbsent(className, cn -> new ArrayList<>());
        list.add(methodName);
        return this;
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        className = className.replace("/", ".");
        if (methodMap.containsKey(className)) {
            try {
                CtClass ctClass = ClassPool.getDefault().get(className);
                for (String methodName : methodMap.get(className)) {
                    String cost = "\nSystem.out.println(\"   Method:"
                            + methodName
                            + " Cost:\"+(endTime-startTime)+"
                            + "\"ns\");\n";
                    CtMethod ctMethod = ctClass.getDeclaredMethod(methodName);
                    String wrappedMethodName = methodName + "$wrapped";
                    ctMethod.setName(wrappedMethodName);

                    CtMethod newMethod = CtNewMethod.copy(ctMethod, methodName, ctClass, null);

                    StringBuilder newMethodBody = new StringBuilder();
                    newMethodBody.append("{");
                    newMethodBody.append(startTime);
                    newMethodBody.append(wrappedMethodName + "($$);\n");
                    newMethodBody.append(endTime);
                    newMethodBody.append(cost);
                    newMethodBody.append("}");

                    newMethod.setBody(newMethodBody.toString());
                    ctClass.addMethod(newMethod);
                }
                return ctClass.toBytecode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
