import java.util.Arrays;

/**
 * 泛型方法
   public static <T> void test(T t) {}

 注意:public T get(int index) {} 不是泛型方法, 这个T是从别的地方拿到的, 比如说是类上定义的
 */
public class a18_GenericsMethod {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 333};
        printArray(array1);

        String[] array2 = {"11", "22", "33"};
        printArray(array2);
    }

    // 需求: 打印数组的内容, 而不是地址
    public static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }
}

