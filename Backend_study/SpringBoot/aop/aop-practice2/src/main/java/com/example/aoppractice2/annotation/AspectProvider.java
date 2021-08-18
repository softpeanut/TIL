package com.example.aoppractice2.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AspectProvider {

    @Around("@annotation(com.example.aoppractice2.annotation.PerformanceTimeRecord)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("First Log");

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }


    @Before("@annotation(com.example.aoppractice2.annotation.PersonInfo))")
    public void logBeforePersonInfo() {
        log.info("Before Log");
    }

    @After("@annotation(com.example.aoppractice2.annotation.PersonInfo))")
    public void logAfterPersonInfo() {
        log.info("After Log");
    }

}
