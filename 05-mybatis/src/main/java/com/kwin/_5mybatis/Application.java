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
 *     搜索条件:
 *         a. 模糊搜索
 *         b. 精确匹配
 *         c. 下拉多选
 *         d. 时间范围
 * 配置类
 *      全局createTime/updateTime序列号和反序列化
 *      全局捕获BusinessException业务异常类, 在任何地方(主要是Service层)能直接抛出 Result.error(xxx)
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
