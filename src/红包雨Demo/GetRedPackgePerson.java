package 红包雨Demo;

import java.security.Key;
import java.util.HashMap;
import java.util.List;

public class GetRedPackgePerson extends Thread{
   public static HashMap<String,Integer> map = new HashMap<>();
    List<Integer> redPackges;
    public GetRedPackgePerson(String name, int i, List<Integer> redPackges) {
        this.redPackges = redPackges;
        super(name+i);
    }

    @Override
    public void run() {
        //得到红包的随机索引
        while (true) {
            synchronized (redPackges) {
                if (redPackges.size()==0)
                {
                    break;
                }
                int index = (int)(Math.random()*(redPackges.size()));
                System.out.println(getName()+"抢到红包"+redPackges.get(index));
                if (map.containsKey(getName())) {
                    map.put(getName(), map.get(getName()).intValue()+redPackges.get(index));
                }
                else {
                    map.put(getName(), redPackges.get(index));
                }
                redPackges.remove(index);
                System.out.println("---------------剩余红包"+redPackges.size());
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                   e.printStackTrace();
                }
                if (redPackges.size()==0)
                {
                    System.out.println("红包雨结束啦");
                    map.forEach((k,v)-> System.out.println(k+"抢啊到的红包总数为  "+v));
                    break;
                }
            }
        }

    }
}
