package Project.bean;

public class LoginTuil {
    public boolean identifyName(String name)
    {
        if ((name.length()>16||name.length()<2))
        {
            System.out.println("要求用户名 2~16个字符");
            return false;
        }
        return true;

    }
    public boolean identifyPassword(String password)
    {
        if ((password.length()>16||password.length()<2))
        {
            System.out.println("要求密码 2~16个字符      ->请重新输入用户名和密码");
            return false;
        }

        return true;
    }


}
