import java.util.ArrayList;

/**
 * 泛型通配符
 * <?> -> 无边界统配符 表示任意类型
 * <? extends T> ‌上界通配符‌ 表示 T 或其子类型
 * <? super T> 下界通配符 表示 T 或其父类型
 */
public class a19_GenericsWildcard {
    public static void main(String[] args) {
        ArrayList<Xiaomi> xiaomis = new ArrayList<>();
        xiaomis.add(new Xiaomi());
        xiaomis.add(new Xiaomi());
        xiaomis.add(new Xiaomi());

        ArrayList<Biyadi> biyadis = new ArrayList<>();
        biyadis.add(new Biyadi());
        biyadis.add(new Biyadi());
        biyadis.add(new Biyadi());

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());

        go(xiaomis);
        go(biyadis);
        // go(dogs); dogs不能传进go方法, 因为Dog没有继承Car
    }

    public static void go(ArrayList<? extends Car> cars) {
        for (Car car : cars) {
            System.out.println(car + "开车啦~");
        }
    }
}

class Car {}

class Xiaomi extends Car {}
class Biyadi extends Car {}
