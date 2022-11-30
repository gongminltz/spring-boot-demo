package org.example.mybatis.interceptor.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.Properties;

/**
 * mybatis Prepare拦截器
 *
 * @author gongmin
 * @date 2022/11/25 15:09
 */
@Component
@Slf4j
@Intercepts({
        @Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class}),
})
public class SetParametersInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("拦截器ParamInterceptor");

        //拦截 ParameterHandler 的 setParameters 方法 动态设置参数
        if (invocation.getTarget() instanceof ParameterHandler) {
            ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();

            // 反射获取 参数对像
            Field parameterField =
                    parameterHandler.getClass().getDeclaredField("parameterObject");
            parameterField.setAccessible(true);
            Object parameterObject = parameterField.get(parameterHandler);
            if (Objects.nonNull(parameterObject)) {
                Class<?> parameterObjectClass = parameterObject.getClass();
                Field[] declaredFields = parameterObjectClass.getDeclaredFields();
                // 遍历参数对象的属性
                for (Field f : declaredFields) {
                    // 如果sql是INSERT,且存在createdAt属性
                    if ("phone".equals(f.getName())) {
                        // 设置允许访问反射属性
                        f.setAccessible(true);
                        // 如果没有设置createdAt属性，则自动为createdAt属性添加当前的时间
                        String phone = (String) f.get(parameterObject);

                        if (null == phone) {
                            // 设置createdAt属性为当前时间
                            f.set(parameterObject, "_1");
                        } else {
                            f.set(parameterObject, phone + "_1");
                        }
                    }
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    /**
     * 自动添加创建时间
     *
     * @param invocation 代理对象
     * @throws Throwable 异常
     */
    private void autoAddCreatedAt(Invocation invocation) throws Throwable {
        // 获取代理的参数对象ParameterHandler
        ParameterHandler ph = (ParameterHandler) invocation.getTarget();

        // 通过MetaObject获取ParameterHandler的反射内容
        MetaObject metaObject = MetaObject.forObject(ph,
                SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                new DefaultReflectorFactory());

        // 通过MetaObject反射的内容获取MappedStatement
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("mappedStatement");

        String phone;

        // 当sql类型为INSERT或UPDATE时，自动插入操作员信息
        if (mappedStatement.getSqlCommandType() == SqlCommandType.INSERT ||
                mappedStatement.getSqlCommandType() == SqlCommandType.UPDATE) {
            // 获取参数对象
            Object obj = ph.getParameterObject();
            if (null != obj) {
                // 通过反射获取参数对象的属性
                Field[] fields = obj.getClass().getDeclaredFields();

                // 遍历参数对象的属性
                for (Field f : fields) {
                    // 如果sql是INSERT,且存在createdAt属性
                    if ("phone".equals(f.getName())) {
                        // 设置允许访问反射属性
                        f.setAccessible(true);
                        // 如果没有设置createdAt属性，则自动为createdAt属性添加当前的时间
                        phone = (String) f.get(obj);

                        if (null == phone) {
                            // 设置createdAt属性为当前时间
                            f.set(obj, "_1");
                        } else {
                            f.set(obj, phone + "_1");
                        }
                    }
                }

                // 通过反射获取ParameterHandler的parameterObject属性
                Field parameterObject = ph.getClass().getDeclaredField("parameterObject");

                // 设置允许访问parameterObject属性
                parameterObject.setAccessible(true);

                // 将上面设置的新参数对象设置到ParameterHandler的parameterObject属性
                parameterObject.set(ph, obj);
            }
        }
    }
}
