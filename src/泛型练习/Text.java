package 泛型练习;

public class Text {
    public static void main(String[] args) {
        myList<Integer> list=new myList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.show();
         System.out.println(list);
         show(list);
         String str="88";
         int a= 99;
         String i=Integer.toString( a);

        System.out.println( i+12);


    }
    public static <E> E show(E e) {
        System.out.println(e);
        return e;
    }


}
