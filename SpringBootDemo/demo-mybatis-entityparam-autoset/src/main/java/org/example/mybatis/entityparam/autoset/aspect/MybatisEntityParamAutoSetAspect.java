package org.example.mybatis.entityparam.autoset.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.example.mybatis.entityparam.autoset.entity.BaseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Date;

/**
 * mybatis BaseEntity参数自动填充
 *
 * @author gongmin
 * @date 2023/5/17 10:41
 */
@Aspect
@Component
public class MybatisEntityParamAutoSetAspect {
    private static long id = 0;

    @Pointcut("execution(* org.example.mybatis.entityparam.autoset.mapper.*.batch*(..)) && args(object, ..)")
    public void batchUpdatePointcut(Object object) {
    }

    @Before(value = "batchUpdatePointcut(object)", argNames = "joinPoint,object")
    public void beforeBatch(JoinPoint joinPoint, Object object) throws Throwable {
        if (object instanceof Collection<?>) {
            Collection<?> items = (Collection<?>) object;
            for (Object item : items) {
                if (item instanceof BaseEntity) {
                    setBaseEntity((BaseEntity) item);
                }
            }
        }
    }

    @Before("execution(* org.example.mybatis.entityparam.autoset.mapper.*.insert*(..)) && args(entity, ..)")
    public void beforeInsert(JoinPoint joinPoint, Object entity) throws Exception {
        if (entity instanceof BaseEntity) {
            setBaseEntity((BaseEntity) entity);
        }
    }

    @Before("execution(* org.example.mybatis.entityparam.autoset.mapper.*.update*(..)) && args(entity, ..)")
    public void beforeUpdate(JoinPoint joinPoint, Object entity) throws Exception {
        if (entity instanceof BaseEntity) {
            setBaseEntity((BaseEntity) entity);
        }
    }

    private void setBaseEntity(BaseEntity baseEntity) {
        if (StringUtils.isEmpty(baseEntity.getId())) {
            baseEntity.setId(String.valueOf(id++));
        }

        Date date = new Date();

        if (baseEntity.getCreateDate() == null) {
            baseEntity.setCreateDate(date);
        }
        if (baseEntity.getModifyDate() == null) {
            baseEntity.setModifyDate(date);
        }
    }
}
