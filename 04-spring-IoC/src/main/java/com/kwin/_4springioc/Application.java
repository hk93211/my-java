package com.kwin._4springioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring-IoC (Inversion of Control) 控制反转， 是 Spring 框架最核心的设计思想
 * 核心含义是：将对象的创建权、管理权和生命周期，从程序员自己手里“反转”交给 Spring 容器来统一管理。
 *
 * 和 DI (Dependency Injection) 依赖注入的关系
 *
 * IoC 是设计思想（目标）：把控制权交给容器。
 * DI 是实现方式（手段）：容器通过“依赖注入”的方式，在运行期间动态地将某个对象所依赖的其他对象（比如数据库连接、工具类等）自动装配给它。
 *
 * 1. 将 Dao 及 Service 层的实现类，交给 IoC 容器管理 -> @Component注解
 * 2. 为 Controller 及 Service 注入运行时所依赖的对象 -> @Autowired
 *
 * @Component  声明Bean的基础注解
 * @Controller  @Component的衍生注解  标注在控制层类上
 * @Service  @Component的衍生注解  标注在业务层类上
 * @Repository  @Component的衍生注解  标注在数据访问层类上(由于与mybatis整合，用得少，用@Mapper)
 *
 *
 * 声明bean的四大注解，要想生效，还需要被组件扫描注解@ComponentScan扫描
 * 该注解虽然没有显示配置，但是实际上已经包含在了启动类声明注解@SpringBootApplication中，默认范围是启动类所在包及其子包
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
