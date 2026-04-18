package Project.ui;

import Project.bean.Data;
import Project.bean.MyCharactor;
import Project.bean.User;

import java.util.Scanner;

public class Gamelog {
    public void start() {
        Scanner order = new Scanner(System.in);
        login log = new login();
        while (true) {
            System.out.println("=====欢迎来到box文字游戏主界面=======");
            System.out.println("1.登录   2.注册    3.退出游戏    4.以管理员身份登录");

            switch (order.nextLine()) {
                case "1" -> {
                    User user = log.login();
                    if (user != null)
                        game(user);
                }
                case "2" -> log.adduser();
                case "3" -> {
                    System.out.println("退出游戏");
                    System.exit(0);
                }
                case "4" -> {
                    System.out.println("欢迎来到管理员登录界面！========exit->回到主界面");
                    while (true) {
                        System.out.println("请输入管理用户名:");
                        String nameInput = order.nextLine();
                        if ("exit".equals(nameInput)) break;
                        System.out.println("请输入密码:");
                        String passwordInput = order.nextLine();
                        if ("exit".equals(passwordInput)) break;
                        //实现exit回滚
                        if (nameInput.equals("admin") && passwordInput.equals("1024"))
                        {
                            boolean flag=false;
                           while (true)
                           {
                               System.out.println("管理员登录成功！");

                               System.out.println("1.查看角色列表   2.查看用户列表   3.退出游戏   4.回到主界面");
                               switch (order.nextLine()) {
                                   case "1" -> Data.charShow();
                                   case "2" -> {
                                       Data.userShow();
                                   }
                                   case "3" -> {
                                       System.out.println("退出游戏");
                                       System.exit(0);
                                   }
                                   case "4" -> {
                                    return;
                                   }
                                   default -> System.out.println("请输入正确的选项！");
                               }



                           }

                        }
                        else System.out.println("用户名或密码错误！");


                    }


                }


        default -> System.out.println("请输入正确的选项！");
    }
}

    }


public static void game(User user) {

    Scanner order = new Scanner(System.in);
    System.out.println("游戏开始!");
    System.out.println("1.创建角色并开始战斗   2.查看已创建的角色      3.查看账号信息  exit->回到主界面");
    while (true) {
        String choice = order.next();
        if ("exit".equals(choice)) return;
        switch (choice) {
            case "1" -> {
                fight();
                System.out.println("战斗结束！");
            }
            case "2" -> {
                Data.charShow();
            }
            case "3" -> System.out.println("该账号用户名:" + user.getUsername() + "密码:" + user.getPassword());
        }
    }


}

public static void fight() {
    Scanner order = new Scanner(System.in);
    while (true) {
        System.out.println("请给你的角色起名字");
        String name = order.nextLine();
        System.out.println("目前共有30点属性值可增加:******角色基础");
        System.out.println("输入你的生命属性值:");
        int hp = order.nextInt();
        System.out.println("输入你的攻击属性值:");
        int attack = order.nextInt();
        System.out.println("输入你的防御属性值:");
        int defense = order.nextInt();
        MyCharactor myCharactor = new MyCharactor(name, hp, attack, defense);
        System.out.println("角色创建成功！");
        myCharactor.show();
        Data.add(myCharactor);
    }


}

}
