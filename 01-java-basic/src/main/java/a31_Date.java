import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * SimpleDateFormat
 *
 * LocalDate
 * LocalTime
 * LocalDateTime
 */
public class a31_Date {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE a");

        String format = simpleDateFormat.format(date);
        System.out.println(format); // 2026-05-11 23:13:56 周一 下午

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();

        System.out.println(year);
        System.out.println(monthValue);
        System.out.println(dayOfMonth);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EEE a");
        String format1 = dateTimeFormatter.format(now);
        System.out.println(format1);
    }
}
