package com.kwin._5mybatis.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import com.kwin._5mybatis.annotation.AutoFill;
import com.kwin._5mybatis.annotation.OperationType;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class AutoFillAndUpdateTimeAspect {
    /**
     * 切入点
     */
    @Pointcut("execution(* com.kwin._5mybatis.mapper.*.*(..)) && @annotation(com.kwin._5mybatis.annotation.AutoFill)")
    public void autoFillPointCut() {}

    /**
     * 前置通知， 在通知中进行通用字段的赋值
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint jp) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.info("开始自动填充");
        MethodSignature signature = (MethodSignature) jp.getSignature();
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        OperationType operationType = autoFill.value();

        Object[] args = jp.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];
        System.out.println(entity);
        LocalDateTime now = LocalDateTime.now();
        // Long currentId = BaseContext.getCurrentId(); // 获取当前操作人的id

        if (operationType == OperationType.INSERT) {
            Method setCreateTime = entity.getClass().getDeclaredMethod("setCreateTime", LocalDateTime.class);
            Method setUpdateTime = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
            setCreateTime.invoke(entity, now);
            setUpdateTime.invoke(entity, now);
        } else if (operationType == OperationType.UPDATE) {
            Method setUpdateTime = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
            setUpdateTime.invoke(entity, now);
        }
    }
}
