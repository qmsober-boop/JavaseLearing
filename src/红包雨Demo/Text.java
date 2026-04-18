package 红包雨Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Text {
    static void main(String[] args) {
        List<Integer> redPackges = getRedPack();
        for (int i = 1; i <=200; i++) {

            new GetRedPackgePerson("员工",i,redPackges).start();

        }

    }
    public static List<Integer> getRedPack()
    {
        List<Integer>list = new ArrayList<>();
        Random r =new Random();

        for (int i = 1; i <= 160; i++)
        {
            list.add(r.nextInt(29)+1);
        }
        for (int i = 0; i < 40; i++) {
            
            list.add(r.nextInt(30,100));
        }
        
return list;

    }

}
