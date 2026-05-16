import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流是惰性的
 * 当你调用中间操作时，它并不会立即处理数据，而是先“记在小本本上”；只有当你调用终端操作时，它才会真正开始干活。
 *
 * 中间方法：
 *     filter()（过滤）
 *     map()（转换）
 *     sorted()（排序）
 *     distinct()（去重）
 *
 *     不常用
 *     limit()
 *     skip()
 *     concat()
 *
 * 结束方法
 *     forEach()（遍历）
 *     count()（计数）
 *     findFirst()（查找第一个）
 *     collect()（收集）
 *
 *  收集
 *  Collectors.toList()
 *  Collectors.toSet()
 *  Collectors.toMap(Function keyMapper, Function valueMapper)
 *
 */
public class a23_Stream {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("张无忌");
        list.add("张三丰");
        list.add("赵敏");
        list.add("张翠山");
        list.add("张三");

        // 需求：找出姓张的人，且名字为3个字的人，存到另一个list
        ArrayList<String> list1 = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张") && name.length() == 3) {
                list1.add(name);
            }
        }
        System.out.println(list1);

        // 使用Stream实现
        List<String> list2 = list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .collect(Collectors.toList());
        System.out.println(list2);

        // 获取数组的Stream流
        Integer[] arr = {1, 2, 3};
        Stream<Integer> stream1 = Arrays.stream(arr);
        Stream<Integer> stream2 = Stream.of(arr);
        System.out.println(stream1.count());
        System.out.println(stream2.count());

        Map<String, String> map = list.stream()
                .collect(Collectors.toMap(
                        k -> "key" + k,
                        v -> "value" + v)
                );
        System.out.println(map);
    }
}
