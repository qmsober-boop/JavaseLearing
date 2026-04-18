package 多线程Demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account{
    private int money;
    private Lock lock =new ReentrantLock();
    public Account(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }

    public  void add(int money){
        this.money+=money;
        System.out.println("账户余额为："+this.money);
    }
    public boolean reduce(int money) throws InterruptedException {


        lock.lock();


        try {
            if (this.money<money) {
                System.out.println("余额不足");
                return false;
            }
            Thread.sleep(500);
            this.money-=money;
        }
        finally {
            lock.unlock();
        }
        return true;
        }
    }

