package com.geektime.datasource.aspect;

import com.geektime.datasource.annotation.TargetDataSource;
import com.geektime.datasource.routing.DynamicDatasourceThreadLocal;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author YangMin
 * @date 2020/12/6 20:54
 */
@Aspect
@Component
public class DynamicDatasourceAspect {

    @Pointcut("@annotation(com.geektime.datasource.annotation.TargetDataSource)")
    public void datasource(){}

    @Before("datasource()")
    public void before(JoinPoint joinPoint) {
        Method m = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if(m != null) {
            TargetDataSource targetDataSource = m.getAnnotation(TargetDataSource.class);
            String dataSourceName = targetDataSource.value();
            DynamicDatasourceThreadLocal.setDataSource(dataSourceName);
        }
    }

    @After("datasource()")
    public void after() {
        DynamicDatasourceThreadLocal.removeDataSource();
    }
}
