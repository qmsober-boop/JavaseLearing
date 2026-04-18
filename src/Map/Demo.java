package Map;
import java.util.*;


public class Demo {

    public static void main(String[] args) {
        Map<Teacher,Integer> map=new TreeMap<>((o1, o2)->o2.getAge()-o1.getAge());
        map.put(new Teacher("王志华",37),1);
        map.put(new Teacher("韩国人",20),1);
        map.put(new Teacher("美国人",18),1);
        map.put(new Teacher("张志明",32),1);
        map.put(new Teacher("刘耀文",22),1);
        map.put(new Teacher("增明星",11),1);
        Optional<Map.Entry<Teacher, Integer>> max = map.entrySet().stream().max((o1, o2)->o1.getKey().getAge()-o2.getKey().getAge());
        System.out.println(max.get().getKey().getAge());
        System.out.println(max.get().getKey().getName());


           }

    Map<String,Integer> map=new HashMap<>();
    ArrayList<String>  list = new ArrayList<>();
    public void put() {
        Random r=new Random();
        String [] arr={"日本","美国","中国","英国"};
        for (int i = 0; i < 80; i++)
        {
            list.add(arr[r.nextInt(arr.length)]);
        }
        System.out.println(list);
    }

    public void cale()
    {

        for (String string : list) {

            if(map.containsKey( string))
            {
                map.put(string, map.get(string)+1);
            }
            else {

                map.put(string, 1);
            }

        }

    }
    public  void show()
    {
        map.forEach((k,v)-> System.out.println(k+"="+v));
        System.out.println(map);
    }

}
