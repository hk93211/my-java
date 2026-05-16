import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 核心特征
 * 动态扩容：普通数组长度固定，而 ArrayList 会在容量不足时自动创建一个更大的新数组（通常是原容量的 1.5 倍），并将旧数据拷贝过去。
 * 有序且重复：它维护了元素的插入顺序，并允许存储重复的元素（包括 null）。
 * 随机访问快：由于底层是数组，通过索引访问元素的时间复杂度为 $O(1)。
 * 增删相对慢：在中间插入或删除元素需要移动后续的所有元素，时间复杂度为 $O(n)。
 * 非线程安全：在多线程环境下，如果多个线程同时修改它，可能会出现问题。
 */
public class a6_ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        // 1. 增
        list.add("Java");
        list.add("Java2");
        list.add(0, "Python"); // 在指定位置插入
        System.out.println(list);

        // 2. 删
        list.remove("Python"); // 按内容删
        list.remove(0);        // 按索引删
        System.out.println(list);

        // 3. 改
        list.set(0, "Go");     // 将索引0改为"Go"
        System.out.println(list);

        // 4. 查
        String lang = list.get(0);
        int size = list.size();
        boolean hasJava = list.contains("Java");
        boolean isEmpty = list.isEmpty();


        // 5. 清空
        list.clear();

        /**
         * 谨慎使用 remove(Object)：在循环中删除元素建议使用 Iterator 或 removeIf，
         * 否则容易抛出 ConcurrentModificationException。
         */
    }
}

class ArrayListToArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        // 方式一：使用 toArray()，返回 Object[] (不推荐)
        Object[] objArr = list.toArray();

        // 方式二：传入指定类型的数组 (推荐)
        String[] strArr = list.toArray(new String[0]);
    }
}

class ArrayToArrayList {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C"};

        // 方式一：Arrays.asList() (生成的 List 长度固定，不可增删)
        List<String> list1 = Arrays.asList(arr);

        // 方式二：构造函数包装 (推荐，可自由增删)
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(arr));

        // 方式三：Java 9+ 的 List.of() (生成的 List 不可变)
        // List<String> list3 = List.of(arr);
    }
}

class ArrayListToString {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana"));
        // 方式一：默认打印格式 [Apple, Banana]
        String str1 = list.toString();
        System.out.println(str1);

        // 方式二：使用 join 拼接成 "Apple, Banana"
        String str2 = String.join(", ", list);
        System.out.println(str2);
    }
}

class ArrayListToSet {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        HashSet<Integer> set = new HashSet<>(numbers); // 此时 set 中只有 1, 2, 3
        System.out.println(set);
    }
}