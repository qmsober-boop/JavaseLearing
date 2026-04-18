package 多线程;

public class ThreadDemo {
    static void main(String[] args) {



        new Thread(() -> {
           for (int i = 0; i < 5; i++) {

               System.out.println("子线程1  " + i);

           }

       }).start();//lambda表达式,创建线程,无返回值
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {

                System.out.println("子线程2  " + i);

            }

        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {

                System.out.println("子线程3  " + i);

            }

        }).start();


        for (int i = 0; i < 5; i++) {

            System.out.println("主线程" + i);

        }

    }

}

class Myrunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            System.out.println("子线程" + i);

        }

    }
}