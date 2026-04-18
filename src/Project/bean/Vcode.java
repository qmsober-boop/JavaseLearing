package Project.bean;

import java.util.Random;

public class Vcode {
    public static String vcode;
    Random random=new Random();
    public String getVcode() {
        char [] code=new char[5];
        char [] ch=new  char[52];
        for (int i=0;i<26;i++)
        {
            ch[i]=(char)('A'+i);
            ch[i+26]=(char)('a'+i);
        }
        for (int i=0;i<4;i++)
        {
           code[i]=ch[random.nextInt(52)];
        }
        code[4]=(char)(random.nextInt(48,57));
        char temp;
        for (int i = 0; i < code.length; i++) {
            int num=random.nextInt(5);
            temp=code[0];
            code[0]=code[num];
            code[num]=temp;
        }
        String vcode=new String(code);
        Vcode.vcode=vcode;
        return vcode;

    }
    public static boolean check(String code) {
        if (vcode.equalsIgnoreCase(code))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}
