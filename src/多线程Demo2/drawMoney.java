package 多线程Demo2;

public class drawMoney extends Thread{
    private Account account;
    private int money;
    public drawMoney(String name , Account account, int money) {
        super(name);
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {

        try {
            if (account.reduce(money)) {
                System.out.println(getName() + "取钱成功取款金额为"+money+  "     账户余额为"+account.getMoney());
            }
            else {
                System.out.println(getName() + "取钱失败  取款金额为"+money+ "     账户余额为"+account.getMoney());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
