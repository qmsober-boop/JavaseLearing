package 线程池2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Text {
    static void main(String[] args) {
        ExecutorService pool = Executors.newScheduledThreadPool(3);

        Thread thread = new Thread(() -> {
            System.out.println("线程" + Thread.currentThread().getName() + "  " + "开始" +  "      执行");
            System.out.println("线程" + Thread.currentThread().getName() + "  " + "结束");
        });
        pool.execute(thread);
        pool.execute(thread);
        pool.execute(thread);
        pool.execute(thread);
        pool.execute(thread);
        pool.execute(thread);



    }
}
