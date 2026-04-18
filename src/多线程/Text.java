package 多线程;

public class Text {
    static void main(String[] args) throws InterruptedException {
        Thread is = new MyThread();
        Thread js = new MyThread();
        is.setName("线程1");
        js.setName("线程2");
        Thread thread=Thread.currentThread() ;
        System.out.println(thread.getName());

        js.start();
        is.start();

        for (int i = 0; i < 5; i++) {

            System.out.println("主线程" + i);

        }




    }
}

class MyThread extends Thread{

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {

            System.out.println("子线程"+this.getName() + "  " + i);

        }

    }
}

