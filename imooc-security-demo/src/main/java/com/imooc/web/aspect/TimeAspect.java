package com.imooc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @program: imooc-security
 * @description: 时间切片
 * @author: linxinting
 * @create: 2020-11-17 14:13
 **/
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.imooc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("time aspect start");

        Object[] args = pjp.getArgs();
        for(Object arg : args){
            System.out.println("arg is "+arg);
        }

        long start = System.currentTimeMillis();
        Object object = pjp.proceed();
        System.out.println("time aspect 耗时："+(System.currentTimeMillis() - start));

        System.out.println("time aspect end");
        return object;
    }
}
