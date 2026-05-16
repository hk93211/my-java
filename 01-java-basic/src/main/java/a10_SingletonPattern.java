/**
 * 单例设计模式
 *   a. 懒汉式单例 -> 拿对象时, 对象才开始创建
 *   b. 饿汉式单例 -> 拿对象时, 对象早就创建好了
 *
 * 确保某个类只能创建一个对象
 *
 *   把类的构造器私有。
 *
 *   定义一个类变量记住类的一个对象。
 *
 *   定义一个类方法，返回对象。
 */
public class a10_SingletonPattern {
    public static void main(String[] args) {
        Single1 instance1 = Single1.getInstance();
        Single1 instance2 = Single1.getInstance();
        System.out.println(instance1 == instance2);

        Single2 instance3 = Single2.getInstance();
        Single2 instance4 = Single2.getInstance();
        System.out.println(instance3 == instance4);
    }
}

// 饿汉式单例
class Single1 {
    private static Single1 s = new Single1();

    private Single1() {}

    public static Single1 getInstance() {
        return s;
    }
}

// 懒汉式单例
class Single2 {
    private static Single2 s;

    private Single2() {}

    public static Single2 getInstance() {
        if (s == null) {
            s = new Single2();
        }
        return s;
    }
}