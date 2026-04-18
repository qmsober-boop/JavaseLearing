package 线程池1;

import java.util.concurrent.*;

public class ExecutorDemo {
    static void main(String[] args)   {
        ExecutorService ex= new  ThreadPoolExecutor(3,5,1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
                );



    }

}
