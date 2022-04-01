package com.assignment.two.assignmenttwo.aspect;

import com.assignment.two.assignmenttwo.entity.ExceptionData;
import com.assignment.two.assignmenttwo.service.ExceptionService;
import com.assignment.two.assignmenttwo.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    LoggerService loggerService;

    @Autowired
    ExceptionService exceptionService;


    @Pointcut("execution(* com.assignment.two.assignmenttwo.controller.*.*(..))")
    public void logData(){
    }

    @Pointcut("@annotation(com.assignment.two.assignmenttwo.aspect.annotation.ExecutionTime)")
    public void getExecutionTime(){

    }

    @Around("getExecutionTime()")
    public Object aroundData(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
            LocalDateTime startTime = LocalDateTime.now();
            Object obj = proceedingJoinPoint.proceed();
            LocalDateTime endTime = LocalDateTime.now();
            long diff = ChronoUnit.MILLIS.between(startTime, endTime);
            System.out.println("Execution End Time : " + diff + " Milli Seconds");
            return obj;
    }

    @After("logData()")
    public void logBefore(JoinPoint joinPoint){

        String operation = joinPoint.getSignature().getName();
        long userId = 2;
        loggerService.addLogData(userId,operation);
    }

    @AfterThrowing(value = "execution(* com.assignment.two.assignmenttwo.controller.*.*(..)))",throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Exception error){

        String operation = joinPoint.getSignature().getName();
        long userId =2;
        exceptionService.addException(userId,operation,error);

    }



}
