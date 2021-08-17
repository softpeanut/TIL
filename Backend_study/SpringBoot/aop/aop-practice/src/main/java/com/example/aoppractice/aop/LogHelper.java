package com.example.aoppractice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
class LogHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogHelper.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMapping(){ }

    @Before("getMapping()")
    public void before(JoinPoint joinPoint) {
        LOGGER.info("Before Logging");
    }

    @AfterReturning(pointcut = "getMapping()", returning = "result")
    public void AfterReturning(JoinPoint joinPoint, Object result) {
        LOGGER.info("AfterReturning Logging");
    }

    @Around("getMapping()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Around Logging Start");
        try {
            Object result = joinPoint.proceed();
            LOGGER.info("Around Logging End");
            return result;
        }catch (Exception e) {
            LOGGER.error("Around Logging Exception");
            LOGGER.error(e.toString());
            return null;
        }
    }

}

