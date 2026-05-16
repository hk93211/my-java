/**
 * Lambda表达式只能替换函数式接口的匿名内部类
 *     函数式接口: 有且仅有一个抽象方法的接口, 通常用 @FunctionalInterface 注解修饰
 */
public class a12_Lambda {
    public static void main(String[] args) {
        Swim swim = () -> System.out.println(1);

        swim.swimming();


    }
}

@FunctionalInterface
interface Swim {
    void swimming();
}

