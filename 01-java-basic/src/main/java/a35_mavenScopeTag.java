/**
 * <dependency>
 *     <groupId>org.springframework.boot</groupId>
 *     <artifactId>spring-boot-starter-test</artifactId>
 *     <scope>test</scope>
 * </dependency>
 *
 * 其中scope -> test 表示依赖的jar包的作用范围
 *
 * |scope值      |主程序|测试程序|打包(运行)|例子  |
 * |compile(默认)|Y    |Y      |Y       |log4j|
 * |test        |-    |Y      |-       |junit|
 * |provided    |Y    |Y      |-       |servlet-api|
 * |runtime     |-    |Y      |Y       |jdbc驱动|
 */
public class a35_mavenScopeTag {
}
