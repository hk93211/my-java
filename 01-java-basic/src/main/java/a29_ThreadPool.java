import java.util.concurrent.*;

/**
 * 线程池
 * 就是一种可以复用线程的技术
 * 因为创建线程的开销是很大的，并且请求过多的时候，肯定会产生大量的线程出来，这样会严重的影响系统的性能
 *
 * 创建线程池有两种方式
 * 1. 使用ExecutorService的实现类ThreadPoolExecutor自创建一个线程池对象
 *     参数1：指定线程池核心线程数量
 *     参数2：指定线程池的最大线程数量
 *     参数3：指定临时线程存活时间
 *     参数4：指定临时线程存活的时间单位
 *     参数5：指定线程池的任务队列
 *     参数6：指定线程池的线程工厂
 *     参数7：指定线程池的任务拒绝策略（线程都在忙，任务队列也满了的时候，新任务来怎么处理）
 *
 * 2. 使用Executors(线程池工具类)调用方法返回不同特点的线程池对象
 */
public class a29_ThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(
                3,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        Runnable target = new MyRunnable();
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        // 关闭线程池（一般不关闭线程池）
        pool.shutdown(); // 关闭不会接受新的任务，会继续执行已经存在的任务，等所有任务都执行完毕后再关闭线程池

        // 立即关闭线程池
        // pool.shutdownNow();

        /**
         * 任务拒绝策略
         * ThreadPoolExecutor.AbortPolicy()    丢弃任务并抛出RejectedExecution异常，默认策略
         * ThreadPoolExecutor.DiscardPolicy()    丢弃任务，但是不抛出异常，这是不推荐的做法
         * ThreadPoolExecutor.DiscardOldestPolicy()    抛弃队列中等待最久的任务，然后把当前任务加入队列中
         * ThreadPoolExecutor.CallerRunsPolicy()    由主线程负责调用任务的run()方法从而绕过线程池直接执行
         */
    }
}

class ThreadPool1 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

    }
}

// 练习：抢红包游戏