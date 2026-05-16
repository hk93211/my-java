import java.util.HashSet;
import java.util.Objects;

/**
 * HashSet: 无序，不重复，无索引
 * LinkedHashSet: 有序，不重复，无索引
 * TreeSet: 排序，不重复，无索引
 *
 * 注意：
 *     Set要用到的常用方法，基本上就是Collection提供的，自己基本上没有一些常用功能
 *
 * 要自定义对象去重方法，必须重写对象的hashCode()和equals()方法
 */
public class a22_Set {
    public static void main(String[] args) {
        HashSet<MyStudent> s = new HashSet<>();

        s.add(new MyStudent("kk", 18));
        s.add(new MyStudent("kk", 28));
        s.add(new MyStudent("kk", 28));
        s.add(new MyStudent("ww", 18));

        System.out.println(s);
    }
}

class MyStudent {
    private String name;
    private int age;


    public MyStudent() {
    }

    public MyStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "MyStudent{name = " + name + ", age = " + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyStudent myStudent = (MyStudent) o;
        return age == myStudent.age && Objects.equals(name, myStudent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}