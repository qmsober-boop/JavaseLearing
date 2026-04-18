package Map;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Text {
    static void main(String[] args) {
        List<Teacher>list = new ArrayList<>();
        list.add(new Teacher("李四", 18));
        list.add(new Teacher("王五", 20));
        list.add(new Teacher("赵六", 22));
        list.add(new Teacher("掌天下", 18));
        list.add(new Teacher("付一凡", 18));
        System.out.println(list);
       Stream<Teacher> s1=list.stream();
       //将这个流转换为map
        Map<String,Integer> map=s1.collect(Collectors.toMap(Teacher::getName,Teacher::getAge));
        System.out.println(map);

    }
}
