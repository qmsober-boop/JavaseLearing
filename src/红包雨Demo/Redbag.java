package 红包雨Demo;

import java.util.Random;

public class Redbag {
    public static int min=20;
    public static int max =100;
    private String name;
    private static int money;
    static Random  r=new Random();
    private static void setMoney()
    {
        money=r.nextInt(29)+1;
    }
    public static void  setMoney2()
    {
        money=r.nextInt(30,100);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        Redbag.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
