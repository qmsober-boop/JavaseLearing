package 多线程;

import java.util.concurrent.*;

public class callable {
    static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallable task = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(task);
        Thread t = new Thread(futureTask);
        t.start();
        System.out.println(t.getName());
        t.setName("实验线程1");
        System.out.println(t.getName());


        for (int i = 0; i < 5; i++) {

            System.out.println("主线程" + i);
            t.join();
        }

        System.out.println("主线程执行完毕");




    }
}
class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {

            System.out.println("子线程" + i);
        }
        return "子线程执行完毕";
    }
}
