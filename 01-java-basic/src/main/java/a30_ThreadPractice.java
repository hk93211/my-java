import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程练习题：
 * 1. 有一个抽奖池，存放了奖励的金额，金额为{10,5,20,50,100,200,500,800,2,80,300,700}; 创建两个抽奖箱（线程）随机从抽奖池中获取奖项元素并打印在控制台上，格式如下：每次抽出一个奖项就打印一个（随机）
 *     1. 抽奖箱1又产生了一个10元大奖
 *     2. 抽奖箱1又产生了一个100元大奖
 *     3. 抽奖箱1又产生了一个200元大奖
 *     4. 抽奖箱1又产生了一个800元大奖
 *     5. 抽奖箱2又产生了一个700元大奖
 *     6. ……
 * 2. 基于上一题的基础上，完成如下需求：每次抽的过程中，不打印，抽完时一次性打印（随机）
 *     1. 在此次抽奖过程中，抽奖箱1总共产生了6个奖项。分别为：10,20,100,500,2,300最高奖项为300，总计额为932元
 *     2. 在此次抽奖过程中，抽奖箱2总共产生了6个奖项。分别为：5,50,200,800,80,700最高奖项为800，总计额为1835元
 * 3. 基于上一题的基础上，完成如下需求，在此次抽奖过程中，抽奖箱2中产生了最大奖项，该奖项金额为800
 */
public class a30_ThreadPractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10,5,20,50,100,200,500,800,2,80,300,700);

        // 练习1
        // ThreadPractice1 t1 = new ThreadPractice1(list);
        // ThreadPractice1 t2 = new ThreadPractice1(list);
        //
        // t1.setName("抽奖箱1");
        // t2.setName("抽奖箱2");
        //
        // t1.start();
        // t2.start();

        // 练习2
        // ThreadPractice2 t1 = new ThreadPractice2(list);
        // ThreadPractice2 t2 = new ThreadPractice2(list);
        //
        // t1.setName("抽奖箱1");
        // t2.setName("抽奖箱2");
        //
        // t1.start();
        // t2.start();

        // 练习3
        ThreadPractice3 t = new ThreadPractice3(list);

        FutureTask<Integer> ft1 = new FutureTask<>(t);
        FutureTask<Integer> ft2 = new FutureTask<>(t);

        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);

        t1.start();
        t2.start();
        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");

        Integer i1 = ft1.get();
        Integer i2 = ft2.get();

        System.out.println(i1);
        System.out.println(i2);
    }
}

class ThreadPractice1 extends Thread {
    ArrayList<Integer> list;

    public ThreadPractice1(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ThreadPractice1.class) {
                if (list.size() == 0) {
                    break;
                } else {
                    Collections.shuffle(list);
                    Integer i =  list.remove(0);
                    System.out.println(getName() + "又产生了一个" + i + "元大奖");
                }
            }
        }
    }
}

class ThreadPractice2 extends Thread {
    ArrayList<Integer> list;

    public ThreadPractice2(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 局部变量属于线程
        ArrayList<Integer> box = new ArrayList<>();
        while (true) {
            synchronized (ThreadPractice1.class) {
                if (list.size() == 0) {
                    System.out.println(box);
                    Integer max = Collections.max(box);
                    System.out.println(max);
                    int sum = box.stream().mapToInt(Integer::intValue).sum();
                    System.out.println(sum);
                    break;
                } else {
                    Collections.shuffle(list);
                    Integer i =  list.remove(0);
                    box.add(i);
                }
            }
        }
    }
}

class ThreadPractice3 implements Callable<Integer> {
    ArrayList<Integer> list;

    public ThreadPractice3(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        // 局部变量属于线程
        ArrayList<Integer> box = new ArrayList<>();
        while (true) {
            synchronized (ThreadPractice1.class) {
                if (list.size() == 0) {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + box);
                    break;
                } else {
                    Collections.shuffle(list);
                    Integer i =  list.remove(0);
                    box.add(i);
                }
            }
        }
        if (box.size() == 0) {
            return null;
        }
        return Collections.max(box);
    }
}