package Project.bean;

import java.util.ArrayList;

public class Data {
   public static ArrayList<User> users = new ArrayList<>();

    public boolean add(User user)
    {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername()))
            {
                System.out.println("用户名已存在！");
                return false;
            }
        }

        users.add(user);
        return true;
    }
    public User login(String username, String password)
    {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password))
            {
                return users.get(i);
            }
        }
        return null;
    }
    public static void userShow()
    {
        if (users.isEmpty()) {
            System.out.println("暂无用户");
            return;
        }

        System.out.println("=== 用户列表 ===");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println("【用户 " + (i + 1) + "】");
            System.out.print("  用户名：" + user.getUsername());
            System.out.print("           密码:"+user.getPassword());
        }
    }

    //****************角色***********

    public static ArrayList<MyCharactor> myCharactors = new ArrayList<>();
    public static void  add(MyCharactor myCharactor)
    {
        myCharactors.add(myCharactor);
        System.out.println("创建角色成功");
    }
    public static void charShow()
    {
        if (myCharactors.isEmpty()) {
            System.out.println("暂无角色");
            return;
        }

        System.out.println("=== 我的角色列表 ===");
        for (int i = 0; i < myCharactors.size(); i++) {
            MyCharactor charactor = myCharactors.get(i);
            System.out.println("【角色 " + (i + 1) + "】");
            System.out.println("  名称：" + charactor.getName());
            System.out.println("  生命值：" + charactor.getHp() + "/" + charactor.getMaxhp());
            System.out.println("  攻击力：" + charactor.getAttack());
            System.out.println("  防御力：" + charactor.getDefense());
            System.out.println("  状态：" + (charactor.alive() ? "存活" : "死亡"));
            System.out.println("-------------------");
        }
    }


}
