// 进制
public class a1_NumeralSystem {
    public static void main(String[] args) {
        // 十进制(Decimal)
        int decimal = 100;

        // 二进制 0b开头
        int binary = 0b1100100;

        // 八进制 0开头
        int octal = 0144;

        // 十六进制 0x开头
        int hex = 0x64;

        // 打印结果（输出时默认都会转为十进制显示）
        System.out.println("十进制: " + decimal);
        System.out.println("二进制 0b1100100: " + binary);
        System.out.println("八进制 0144: " + octal);
        System.out.println("十六进制 0x64: " + hex);

        // 进阶：如何将十进制转换为其他进制的字符串？
        System.out.println("--- 转换演示 ---");
        System.out.println("100 的二进制字符串: " + Integer.toBinaryString(100));
        System.out.println("100 的八进制字符串: " + Integer.toOctalString(100));
        System.out.println("100 的十六进制字符串: " + Integer.toHexString(100));
    }
}
