/**
 * 创建线程方式1：
 * 继承Thread类
 *
 * 1. 定义一个类MyThread继承java.lang.Thread, 然后重写run()方法
 * 2. 创建MyThread对象
 * 3. 调用MyThread对象的start()方法启动线程，会执行run方法
 *
 * 优点：编码简单
 * 缺点：已经继承Thread类了，无法继承其他类，不利于功能的扩展
 */
public class a24_Thread1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出：" + i);
        }
        // 以上会出现主线程和子线程交替打印输出的情况
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}