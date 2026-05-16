import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. 同步代码块(synchronized包裹代码块) 自己加锁
 *
 * 2. 同步方法(synchronized修饰方法)
 *     有锁：如果方法是实例方法，默认用this作为锁对象
 *          如果方法是静态方法，默认用类名.class作为锁对象
 *
 * 哪个方法好一点：同步代码块，锁的范围小点
 *
 * lock锁
 */
public class a28_ThreadSafe {
    public static void main(String[] args) {
        Account a = new Account("110", 1000);

        new MoneyThread("小明", a).start();
        new MoneyThread("小红", a).start();


    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Account {
    private String id;
    private double money;

    public void dMondy(int money) {
        String tname = Thread.currentThread().getName();

        synchronized (Account.class) {
            if (this.money >= money) {
                System.out.println(tname + "取钱" + money);
                this.money -= money;

                System.out.println(tname + "余额为：" + this.money);
            } else {
                System.out.println(tname + "余额不足");
            }
        }
    }
}

class MoneyThread extends Thread {
    private Account account;
    public MoneyThread(String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        account.dMondy(1000);
    }
}
