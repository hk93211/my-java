/**
 * 创建线程方式2：
 * 实现Runnable接口
 *
 * 1. 定义一个线程任务类MyRunnable，实现Runnable接口, 然后重写run()方法
 * 2. 创建MyRunnable对象
 * 3. 把该MyRunnable交给Thread对象
 * 4. 调用Thread对象的start()方法启动线程，会执行run方法
 *
 * 优点：任务类只是实现接口，可以继续继承其他类，实现其他接口，扩展性强
 * 缺点：需要多一个Runnable对象
 */
public class a25_Thread2 {
    public static void main(String[] args) {
        Runnable r = new MyRunnable();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("子线程1:" + i);
            }
        }).start();

        new Thread(r).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出：" + i);
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程2:" + i);
        }
    }
}