// 强制类型转换
public class a2_ExplicitCasting {
    public static void main(String[] args) {
        /**
         * 基本数据类型的强制转换
         *
         * 当把存储范围大的类型（如 double）赋值给存储范围小的类型（如 int）时，
         * 必须使用强转。其语法格式为：(目标类型) 变量名。
         *
         * 浮点型 → 整型	丢弃小数部分（截断）	(int) 3.14 结果为 3
         * 大范围整型 → 小范围整型	数据溢出（二进制截断）	(byte) 128 结果为 -128
         */

        // 1. 浮点数转整数 (精度丢失)
        double pi = 3.99;
        int roundedPi = (int) pi;
        System.out.println("double 3.99 强转 int: " + roundedPi); // 输出 3

        // 2. 大整型转小整型 (数据溢出)
        int num = 130;
        byte b = (byte) num;
        // byte 范围是 -128 ~ 127，130 超过后会产生溢出
        System.out.println("int 130 强转 byte: " + b); // 输出 -126

        /**
         * 引用数据类型的强制转换（向下转型）
         *
         * 引用类型的强转通常发生在继承或实现关系中。
         *
         * 向上转型 (Upcasting)：子类转父类，自动完成。
         * 向下转型 (Downcasting)：父类转子类，必须手动强转。
         */
        Animal myAnimal = new Dog(); // 向上转型 (自动)

        // 如果想调用 Dog 特有的 bark() 方法，必须强转
        if (myAnimal instanceof Dog) { // 推荐：先用 instanceof 检查
            Dog myDog = (Dog) myAnimal; // 向下转型 (强制)
            myDog.bark();
        }

        // 错误的强转示例 (编译通过，运行报错 ClassCastException)
        // Animal realAnimal = new Animal();
        // Dog fakeDog = (Dog) realAnimal;
    }
}

class Animal {
    void makeSound() { System.out.println("动物发出声音"); }
}

class Dog extends Animal {
    void bark() { System.out.println("汪汪汪！"); }
}