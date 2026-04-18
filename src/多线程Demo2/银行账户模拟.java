package 多线程Demo2;


public class 银行账户模拟 {
    static void main(String[] args) {

        Account account = new Account(2000);

        new drawMoney("李四", account, 400).start();
        new drawMoney("张三", account, 500).start();
        new drawMoney("逆天", account, 11000).start();


    }

}


