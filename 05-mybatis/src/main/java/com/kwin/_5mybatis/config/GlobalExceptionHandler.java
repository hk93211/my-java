package com.kwin._5mybatis.config;

import com.kwin._5mybatis.pojo.BusinessException;
import com.kwin._5mybatis.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 专门捕获我们在 Service 层主动抛出的 BusinessException
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Void> handleBusinessException(BusinessException e) {
        log.warn("业务异常: {}", e.getMessage());
        // 直接把 Service 层传过来的错误信息（msg）喂给统一返回对象
        return Result.error(e.getMessage());
    }

    /**
     * 兜底：捕获系统未知的其他异常（如数据库断开、空指针等）
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e) {
        log.error("系统未知异常: ", e);
        return Result.error("系统开小差了，请稍后再试");
    }
}
