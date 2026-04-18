package 多线程Demo2同步方法;

public class Account{
    private int money;
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
    public synchronized boolean reduce(int money) throws InterruptedException {

            if (this.money<money) {
                System.out.println("余额不足");
                return false;
            }
            Thread.sleep(500);
            this.money-=money;
            return true;
        }
    }


