package com.example.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.app.service..*(..))")
    public void beforeService(JoinPoint joinPoint) {

        log.info(
                "Service started: {}",
                joinPoint.getSignature().getName()
        );
    }

    @AfterReturning(
            pointcut = "execution(* com.example.app.service..*(..))",
            returning = "result")
    public void afterService(
            JoinPoint joinPoint,
            Object result) {

        log.info(
                "Service completed: {}",
                joinPoint.getSignature().getName()
        );
    }
}