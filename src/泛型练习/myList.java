package 泛型练习;

import java.util.ArrayList;

public class myList<E>{
   private ArrayList<E> list = new ArrayList<>();

   public void add(E e){
       list.add(e);
   }
   public E get(int index){
       return list.get(index);
   }
   public void show()
   {
       for(int i = 0; i < list.size(); i++)
       {
           System.out.println(list.get(i));
       }

   }
   public E remove(int index)
   {
       return list.remove(index);
   }



}
