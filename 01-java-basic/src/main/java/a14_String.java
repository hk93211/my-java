import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 只要是以".."方式创建的字符串对象，会存储到字符串常量池，且相同的内容的字符串只存一份
 *
 * 通过new 方式创建的字符串对象，每new一次都会产生一个新的对象放到堆内存中
 *
 * 常用方法：
 *     length()
 *     charAt()
 *     toCharArray()
 *     equals()
 *     equalsIgnoreCase()
 *     substring() 包前不包后
 *     replace()
 *     contains()
 *     startWith()
 *     split()
 *
 */
public class a14_String {
    public static void main(String[] args) {
        String s0 = "hello";
        String s1 = "hello";
        String s2 = new String();
        String s3 = new String("hello");
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String s4 = new String(chars);

        byte[] bytes = {97, 98, 99, 65, 66, 67};
        String s5 = new String(bytes);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        System.out.println(s1 == s0);
    }
}

class MyStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i); // 高效，不会产生1000个临时String对象
        }
        String result = sb.toString();
        System.out.println(result);

        // 场景：动态构建
        StringBuilder sql = new StringBuilder("SELECT * FROM users WHERE 1=1");
        String name = "kwin";
        if (name != null) {
            sql.append(" AND name = '").append(name).append("'");
        }
        System.out.println(sql.toString());
    }
}

class MyStringJoiner {
    public static void main(String[] args) {
        // 场景：用逗号分隔，并加上中括号前后缀
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        sj.add("Java").add("Python").add("Go");
        System.out.println(sj.toString()); // 输出：[Java, Python, Go]

        // 场景：结合 Stream API（最常用）
        // Collectors.joining() 的底层就是 StringJoiner
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        String result = list.stream()
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println(result); // 输出：{Apple, Banana, Cherry}
    }
}