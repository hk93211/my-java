import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 *
 */
public class a34_DynamicProxy {
    public static void main(String[] args) {
        Star star = new Star("kk");
        StarService proxy = MyProxyUtil.createProxy(star);
        proxy.see("龙");
        String walk = proxy.walk();
        System.out.println(walk);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Star implements StarService {
    private String name;

    @Override
    public void see(String thing) {
        System.out.println(this.name + "看" + thing);
    }

    @Override
    public String walk() {
        System.out.println(this.name + "走路");
        return "谢谢";
    }
}

interface StarService {
    void see(String thing);

    String walk();
}

class MyProxyUtil {
    public static <T> T createProxy(T item) {
        T proxy = (T) Proxy.newProxyInstance(
                item.getClass().getClassLoader(),
                item.getClass().getInterfaces(),
                (obj, method, arg) -> {
                    String name = method.getName();
                    Object result = null;
                    if ("see".equals(name)) {
                        System.out.println("see之前");
                        result = method.invoke(item, arg);
                        System.out.println("see之后");
                    } else if ("walk".equals(name)) {
                        System.out.println("walk之前");
                        result = method.invoke(item, arg);
                        System.out.println("walk之后");

                    }
                    return result;
                }
        );
        return proxy;
    }
}