// 静态变量和静态方法
public class a5_Static {
    public static void main(String[] args) {
        // 属于类，而不属于某个具体的对象（实例）
        // 静态资源在内存中只有一份，被所有对象共享
    }
}

// 1. 静态变量 (Static Variables) 的使用场景
// A. 共享数据
class User {
    // 记录某个类被实例化的次数，或者在一个网游中记录当前在线的总人数。
    public static int onlineCount = 0; // 所有用户共享这个计数器

    public User() {
        onlineCount++; // 每创建一个新用户，计数器加1
    }
}

// B. 定义常量
// 配合 final 关键字使用，定义全局不变量。这样可以节省内存，因为不需要每个对象都存一份。
//
// 例子：数学常数、状态码、配置信息。
class Config {
    public static final double PI = 3.1415926;
    public static final String APP_VERSION = "v2.0.1";
}

// 2. 静态方法 (Static Methods) 的使用场景
// A. 工具类方法 (Utility Methods)
// 例子：Math.sqrt(), Arrays.sort(), Integer.parseInt()。
// B. 工厂方法 (Factory Methods)
// C. 单例模式 (Singleton Pattern)

// 注意事项: 静态方法不能被重写 (Override), this 关键字禁区