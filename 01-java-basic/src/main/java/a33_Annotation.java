import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解可以用在类上、构造器上、方法上、成员变量上、参数上等位置
 *
 * 特殊属性名
 *     如果注解中只有一个value属性，使用注解时，value的名称可以不写
 *
 * 元注解
 *     注解注解的注解
 * @Retention(RetentionPolicy.RUNTIME)
 * // 声明注解的保留周期
 *     1. SOURCE: 只作用在源码阶段，字节码文件中不存在
 *     2. CLASS: (默认值) 保留到字节码文件阶段，运行阶段不存在
 *     3. RUNTIME: (开发常用) 一直保留到运行阶段
 *
 * @Target({ElementType.METHOD})
 * // 声明被修饰的注解只能在那些位置使用
 *     1. TYPE: 类，接口
 *     2. FIELD: 成员变量
 *     3. METHOD: 成员方法
 *     4. PARAMETER: 方法参数
 *     5. CONSTRUCTOR: 构造器
 *     6. LOCAL_VARIABLE: 局部变量
 *
 *
 *  注解的解析
 *      就是判断类上、方法上、成员变量上是否存在注解
 *      指导思想：要解析谁上面的注解，就应该先拿到谁
 *
 *  注解的应用场景
 *      实现一个@Test注解方法，类似junit
 */
@TestAnnotation1(name = "java", address = {"北极"})
public class a33_Annotation {
    @TestAnnotation1(name = "javaScript", address = {"上海"})
    @TestAnnotation2("xxx")
    @TestAnnotation3("xxx")
    @TestAnnotation4(value = "xxx", age = 18)
    public static void main(String[] args) {

    }
}

@interface TestAnnotation1 {
    String name();
    int age() default 18;
    String[] address();
}

@interface TestAnnotation2 {
    String value();
}

@interface TestAnnotation3 {
    String value();
    int age() default 18;
}

@interface TestAnnotation4 {
    String value();
    int age();
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@interface TestAnn {}