package Project.ui;

import Project.bean.Data;
import Project.bean.LoginTuil;
import Project.bean.User;
import Project.bean.Vcode;

import java.util.Scanner;

public class login extends LoginTuil {
    Scanner sc = new Scanner(System.in);

    Vcode code = new Vcode();
    Data data = new Data();

    public void adduser() {

        User newuser = new User();
        String nameInput;
        String passwordInput;

        while (true) {
            System.out.println("欢迎来到注册界面！==========exit->回到主界面");
            System.out.println("请输入用户名:");
            nameInput = sc.nextLine();
            if ("exit".equals(nameInput)) return;
            if (!identifyName(nameInput)) continue;
            System.out.println("请输入密码:");
            passwordInput = sc.nextLine();
            if ("exit".equals(passwordInput)) return;
            if (!identifyPassword(passwordInput)) continue;
            while (true) {
                System.out.println("请再次输入密码:");
                String passwordInput2 = sc.nextLine();
                if ("exit".equals(passwordInput2)) return;
                if (!passwordInput.equals(passwordInput2)) {
                    System.out.println("两次密码不一致！");
                    System.out.println("请重新输入密码:");
                    continue;
                }
                break;
            }
            while (true) {
                System.out.println("验证码为" + code.getVcode());
                if (!Vcode.check(sc.nextLine())) {
                    System.out.println("验证码错误！");
                    System.out.println("请重新输入验证码:");
                    continue;
                }
                break;
            }
            newuser.setUsername(nameInput);
            newuser.setPassword(passwordInput);

            if (data.add(newuser)) {
                System.out.println("注册成功！");
                System.out.println("用户名:" + newuser.getUsername() + "密码:" + newuser.getPassword() + "的用户已经创建");
            } else {
                System.out.println("注册失败！!!系统故障请联系客服处理!")
                ;
            }
            return;
        }
    }

    public User login() {
        while (true) {

            System.out.println("欢迎来到登录界面！========exit->回到主界面");
            System.out.println("请输入用户名:");
            String nameInput = sc.nextLine();
            if ("exit".equals(nameInput)) return null;
            System.out.println("请输入密码:");
            String passwordInput = sc.nextLine();
            if ("exit".equals(passwordInput)) return null;
            //实现exit回滚
            User flag = data.login(nameInput,passwordInput);
            if (flag!=null) {
                System.out.println("登录成功！");
                System.out.println("用户名:" + nameInput + "密码:" + passwordInput + "的用户已经登录");
                return flag;
            } else {
                System.out.println("用户名或密码错误！");
                break;
            }
        }
    return null;
    }

}
