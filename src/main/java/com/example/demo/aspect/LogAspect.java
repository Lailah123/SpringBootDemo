package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LogAspect {

    @Pointcut("@annotation(com.example.demo.annotation.Log)")
    public void annotationPointCut() {
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("调用前拦截");
    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("调用后拦截");
    }

    @AfterReturning(value = "@annotation(com.example.demo.annotation.Log)",returning = "ret")
    public void LogAfterReturning(JoinPoint joinPoint, Object ret){
        Object[] args = joinPoint.getArgs();
        System.out.println("方法返回前");
        System.out.println("返回值："+ret);
    }

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        System.out.println("环绕通知");
        result = pjp.proceed();
        System.out.println("环绕通知");
        return result;
    }
}

