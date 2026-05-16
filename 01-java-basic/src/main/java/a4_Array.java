import java.util.Arrays;

// 数组
public class a4_Array {
    public static void main(String[] args) {
        // 已经知道数组中要存哪些具体数据时，使用静态初始化
        // 简写形式（最常用）
        int[] scores = {88, 92, 100, 75};

        // 标准形式
        String[] names = new String[]{"张三", "李四", "王五"};


        // 只知道数组需要存多少个数据，但还不确定具体数值时
        // 创建一个可以存放 5 个整数的数组
        int[] numbers = new int[5];

        // 此时 numbers 里的值全是默认值 0
        System.out.println(numbers[0]); // 输出 0

        // 后续根据需要赋值
        numbers[0] = 10;
        numbers[1] = 11;
        numbers[2] = 12;
        numbers[3] = 13;
        numbers[4] = 14;

        /**
         * 在动态初始化后，数组会自动填充“零值”。具体的默认值取决于数据类型：
         *
         * 数据类型 (byte, short, int, long)    0
         * 浮点类型 (float, double)    0.0
         * 字符类型 (char)    '\u0000' (表现为空格)
         * 布尔类型 (boolean)    false
         * 引用类型 (String, 自定义类等)    null
         */

        // 数组的长度 arr.length
        System.out.println(numbers.length);
    }
}

class MyArrays {
    public static void main(String[] args) {
        int[] arr1 = {3, 1, 2};
        int[][] arr2 = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(arr2);
        System.out.println(Arrays.deepToString(arr2));

        System.out.println(Arrays.asList(arr1));

        // 2. 排序
        Arrays.sort(arr1);
        System.out.println("排序后: " + Arrays.toString(arr1)); // [1, 2, 5, 8]

        // 3. 二分查找
        int index = Arrays.binarySearch(arr1, 2);
        System.out.println("数字2的索引: " + index); // 1

        // 4. 扩容/复制
        int[] newNums = Arrays.copyOf(arr1, 6);
        System.out.println("扩容后: " + Arrays.toString(newNums)); // [1, 2, 3, 0, 0, 0]

        // 5. 快速填充
        Arrays.fill(newNums, 4, 6, 9); // 将索引4到5填为9
        System.out.println("填充后: " + Arrays.toString(newNums)); // [1, 2, 3, 0, 9, 9]

        System.out.println(Arrays.stream(newNums).sum());

        System.out.println(Arrays.stream(newNums).max());

        System.out.println(Arrays.stream(newNums).distinct());
        int[] array = Arrays.stream(newNums).distinct().toArray();
        System.out.println(Arrays.toString(array));
    }
}