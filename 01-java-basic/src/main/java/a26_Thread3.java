import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 前两种多线程创建方式都有一个问题：如果线程执行完毕后要返回一些数据，他们重写的run()方法均不能直接返回结果
 *
 * 创建线程方式3：
 * 实现Callable接口
 *
 * 1. 定义一个类MyCallable，实现Callable接口, 然后重写call()方法，这个call方法是有返回值的
 * 2. 创建一个MyCallable对象
 * 3. 把MyCallable对象封装成FutureTask(线程任务对象)
 * 4. 把FutureTask对象交给Thread对象
 * 5. 调用Thread对象的start()方法启动线程
 * 6. 线程执行完毕后，通过FutureTask对象的get方法获取线程任务的执行结果
 *
 * 注意：
 *     还有异步回调的写法
 */
public class a26_Thread3 {
    public static void main(String[] args) {
        MyCallable c1 = new MyCallable(100);
        FutureTask<Integer> f1 = new FutureTask<>(c1);
        new Thread(f1).start();

        MyCallable c2 = new MyCallable(50);
        FutureTask<Integer> f2 = new FutureTask<>(c2);
        new Thread(f2).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出：" + i);
        }

        try {
            // 当主线程执行到这里的时候，发现第一个线程还没有执行完毕，会让出CPU，等第一个线程执行完毕后，才会往下执行
            Integer i = f1.get();
            System.out.println(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            // 当主线程执行到这里的时候，发现第二个线程还没有执行完毕，会让出CPU，等第二个线程执行完毕后，才会往下执行
            Integer i = f2.get();
            System.out.println(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyCallable implements Callable<Integer> {
    private Integer n;

    public MyCallable(Integer n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        int sum = n;

        for (int i = 1; i <= n; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            sum += i;
        }

        return sum;
    }
}