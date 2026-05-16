import java.util.ArrayList;

/**
 * 泛型定义建议用 E T K V
 *
 * 泛型不支持基本数据类型
 * 泛型的擦除: 泛型只存在于编译阶段，一旦代码编译完成进入字节码阶段，所有的泛型信息都会被“擦除”掉。
 *
 * ArrayList里面只能存对象
 *     add(10) 自动装箱
 *     get(0) 自动拆箱
 */
public class a17_Generics {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("11");
        list.add("111");

        list.remove("11");

        System.out.println(list);
    }
}

// 泛型类
class MyArrayList<E> {
    private ArrayList list = new ArrayList();

    public boolean add(E e) {
        list.add(e);
        return true;
    }

    public boolean remove(E e) {
        return list.remove(e);
    }

    public Object remove(int index) {
        return list.remove(index);
    }

    public String toString() {
        return list.toString();
    }
}

// 泛型接口
interface MyData<E> {
    void add(E e);

    void remove(E e);

    E query(int id);
}


class MyDataImpl implements MyData<MyArrayList> {

    @Override
    public void add(MyArrayList myArrayList) {

    }

    @Override
    public void remove(MyArrayList myArrayList) {

    }

    @Override
    public MyArrayList query(int id) {
        return null;
    }
}