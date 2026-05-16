import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 反射：
 *     加载类，并允许以编程的方式解剖类中的各种成分(成员变量，方法，构造器等)
 *
 * 获取Class对象的三种形式：
 * 1. Class c = 类名.class
 * 2. Class.forName(String package);
 * 3. Class c = 对象.getClass()
 *
 * 反射的作用：
 *     对于任意一个对象，该框架都可以把对象的字段名和对应的值，保存到文件中去
 */
public class a32_Reflection {
    public static void main(String[] args) throws Exception {
        Class c1 = TestRef.class;
        System.out.println(c1);

        String name = c1.getName();
        String simpleName = c1.getSimpleName();
        System.out.println(name); // com.kwin.TestRef
        System.out.println(simpleName); // TestRef

        // 获取构造器
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructor); // public com.kwin.TestRef(java.lang.String,int)

        // 拿构造器的作用：创建对象
        declaredConstructor.setAccessible(true);
        Object kwin = declaredConstructor.newInstance("kwin", 1);

        // 获取属性
        Field declaredField1 = c1.getDeclaredField("name");
        Field declaredField2 = c1.getDeclaredField("age");
        Field declaredField3 = c1.getDeclaredField("s");
        System.out.println(declaredField1);
        System.out.println(declaredField2);
        System.out.println(declaredField3);

        declaredField1.setAccessible(true);
        declaredField2.setAccessible(true);
        declaredField3.setAccessible(true);
        declaredField1.set(kwin, "h");
        declaredField2.set(kwin, 12);
        declaredField3.set(kwin, "xxx");
        String o1 = (String) declaredField1.get(kwin);
        Object o2 = declaredField2.get(kwin);
        String o3 = (String) declaredField3.get(kwin);
        // String o3 = (String) declaredField3.get(c1);
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);



    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class TestRef {
    private static String s;
    private String name;
    private int age;
}
