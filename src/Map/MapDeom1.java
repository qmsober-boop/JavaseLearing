package Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MapDeom1 {
 public static void main(String[] args) {
  List<String> list = new ArrayList<>();
  char[] charArray = "3234".toCharArray();
  for (char c : charArray) {
   System.out.println(c);
  }
  list.add("张三");
  list.add("王五");
  list.add("赵六");
  list.add("张三");
  System.out.println( list);
  Collections.shuffle( list);
  System.out.println( list);
  Collections.addAll(list,"张三","王五","赵六","张三");
  System.out.println(list);
  Collections.sort(list);
  System.out.println(list);
  System.out.println(Collections.binarySearch(list,"张三"));

 }

}
