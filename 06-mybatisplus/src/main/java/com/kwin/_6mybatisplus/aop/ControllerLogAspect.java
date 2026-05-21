package com.kwin._5mybatis.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest; // 注意这里换成了 jakarta

/**
 * 自动增加所有controller接口入参/出参/请求耗时 切面
 */
@Aspect
@Component
@Slf4j
public class ControllerLogAspect {

    @Autowired
    private ObjectMapper objectMapper;

    @Around("execution(public * com.kwin._5mybatis..controller..*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String requestUrl = "";
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            requestUrl = request.getRequestURL().toString();
        }

        String argsJson = "";
        try {
            argsJson = objectMapper.writeValueAsString(joinPoint.getArgs());
        } catch (JsonProcessingException e) {
            argsJson = "参数转换失败";
        }
        log.info(">>> 开始请求 URL: {}, 方法: {}, 入参: {}", requestUrl, joinPoint.getSignature().getName(), argsJson);

        Object result;
        try {
            result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();

            String resultJson = "";
            try {
                resultJson = objectMapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                resultJson = "返回值转换失败";
            }
            log.info("<<< 结束请求 URL: {}, 耗时: {}ms, 出参: {}", requestUrl, (endTime - startTime), resultJson);

            return result;
        } catch (Throwable e) {
            log.error("!!! 请求异常 URL: {}, 方法: {}, 异常信息: {}", requestUrl, joinPoint.getSignature().getName(), e.getMessage(), e);
            throw e;
        }
    }
}