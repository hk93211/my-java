package com.kwin._5mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * aop:
 *     Controller打印日志的aop
 *     Controller自动填充createTime和updateTime的aop
 *     Service记录操作耗时的aop
 *
 * PageHelper
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
