package com.nishant.ctplbackend.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
@Slf4j
public class LoggerAspect {

    @Around("execution(* com.nishant.ctplbackend..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{

        log.info(joinPoint.getSignature().toString() + "method execution started!");
        Instant start = Instant.now();
        Object result = joinPoint.proceed();
        Instant end = Instant.now();
        long timeTaken = Duration.between(start,end).toMillis();
        log.info("Time taken to execute:: " + timeTaken);
        log.info( joinPoint.getSignature().toString()+"method execution end!");

        return result;
    }








}
