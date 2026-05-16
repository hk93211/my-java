// 表达式的自动类型提升
public class a3_BinaryNumericPromotion {
    public static void main(String[] args) {
        /**
         * Java 的自动提升遵循以下两个核心逻辑：
         *
         * A. 所有的 byte、short、char 型将被提升到 int
         *
         * B. 如果有一个操作数等级更高，整个表达式提升至该等级
         *
         * int → long → float → double
         */

        short s = 1;
        // 注意看下一行代码, 编译直接报错了
//        s = s + 1;

        // 注意看下一行代码, 没有报错, 因为 += 运算符内部隐式包含了强制类型转换
        s += 1;
    }
}
