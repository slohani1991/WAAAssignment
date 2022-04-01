package com.assignment.two.assignmenttwo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Pointcut("@annotation(com.assignment.two.assignmenttwo.aspect.LogMe)")
    public void annotationLogMe(){

    }

    @Pointcut("execution(* com.assignment.two.assignmenttwo.controller.PostController.*(..))")
    public void logMe(){

    }

    @Before("logMe() || annotationLogMe()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Log before the method: " + joinPoint.getSignature().getName());
    }
    @After("logMe()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("Log after the method : "+joinPoint.getSignature().getName());
    }

}
