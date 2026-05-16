import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 循环
 * 1. 迭代器 iterator
 * 2. 增强for
 * 3. forEach
 *
 * 认识并发修改异常
 */
public class a20_Collection {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();

        list.add("11");
        list.add("22");
        list.add("333");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String st = iterator.next();
            if (st.equals("22")) {
                // 注意要用迭代器的remove方法删，不能用list.remove来删，否则会抛出并发修改异常
                iterator.remove();
            }
        }

        for (String s : list) {
            System.out.println(s);
        }

        // list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);
    }
}

