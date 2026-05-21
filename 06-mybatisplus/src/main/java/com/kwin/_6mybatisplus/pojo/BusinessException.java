package com.kwin._6mybatisplus.pojo;

// 自定义业务异常，用来传递有用的错误提示
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}