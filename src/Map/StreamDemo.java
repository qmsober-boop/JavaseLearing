package Map;


import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
       List<String>list = new ArrayList<>();
       list.add("张三");
       list.add("王五");
       list.add("赵六");
       list.add("张三");
       System.out.println( list);
       list.stream().map(s->1).forEach(System.out::println);
       System.out.println(list);
       Stream<String>l1=Stream.of("张三","王五","赵六","张三");
       Stream<Integer>nums=Stream.of(1,2,3,4,5,6,11111,8,9);
       Optional<Integer>max = nums.max((a,b)->a-b);
       Integer max1 = max.get();
       System.out.println(max1);


    }
}
