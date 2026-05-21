package com.kwin._6mybatisplus.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RecordTimeAspect {
    @Around("execution(* com.kwin._6mybatisplus.service.impl.*.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        long beginTime = System.currentTimeMillis();

        Object obj = pjp.proceed();
        long endTime = System.currentTimeMillis();
        log.info("耗时: {}", endTime - beginTime);

        return obj;
    }
}
