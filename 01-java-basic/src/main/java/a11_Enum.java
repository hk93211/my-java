import java.util.Arrays;

public class a11_Enum {
    public static void main(String[] args) {
        System.out.println(Status.ERROR);
        System.out.println(Arrays.toString(Status.values()));
        System.out.println(Status.valueOf("SUCCESS"));
        System.out.println(Status.SUCCESS.getCode());
        System.out.println(Status.ERROR.getCode());
        System.out.println(Status.ERROR.getMsg());
    }
}

enum Status {
    // 每一个枚举项其实都是这个类的一个实例
    SUCCESS(200, "操作成功"),
    ERROR(500, "服务器开小差了");

    private final int code;
    private final String msg;

    // 构造器（必须是私有的）
    Status(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() { return code; }
    public String getMsg() { return msg; }
}


enum A {
    X, Y, Z
}

// 编译后
// final class A extends java.lang.Enum<A> {
//     public static final A X = new A();
//     public static final A Y = new A();
//     public static final A Z = new A();
//
//     public static A[] values();
//     public static A valueOf(java.lang.String);
//     private A() {}
//     static {}
// }