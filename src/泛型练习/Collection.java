package 泛型练习;
import java.util.*;

public class Collection {
    static void main(String[] args) {
        int [][] arr=new int[][]{{1,2,3,34},{4,5,6},{4,5,6}};
        System.out.println( arr[0].length);
        for (int[] ints : arr) {
            String s = Arrays.toString(ints);
            System.out.println(s.hashCode());
        }
        System.out.println("------------");
        Student s1 = new Student("王志华", 24, "西昌市");
        Student s2 = new Student("王志华", 23, "西昌市");
        Student s3 = new Student("李华", 19, "南充");
        Student s5 = new Student("成龙", 27, "美国");
        Student s4 = new Student("李华", 18, "南充");
        Student s6 = new Student("成龙", 18, "美国");
        Set<Student> list = new TreeSet<>((o1, o2)->o2.getAge()-o1.getAge());
        list.add(s1);
        list.add(s5);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s6);
        for (Student student : list) {

            int  s = student.getAge();
            System.out.println(s);
            System.out.println(student.getName());


        }




    }
}
