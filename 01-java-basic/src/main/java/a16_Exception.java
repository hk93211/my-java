import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 编译时异常
 *
 * 运行时异常
 *
 *
 * 异常的处理：
 *     抛出：throws
 *     捕获：try ... catch ...
 */
public class a16_Exception {
    public static void main(String[] args) {
        try {
            test();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void test() throws ParseException {
        String str = "2026-01-01 11:11:11";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf.parse(str);
        System.out.println(date);
    }
}
