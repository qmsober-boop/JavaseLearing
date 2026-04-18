package 线程池1;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }
    @Override
    public String call() throws Exception {

        return Thread.currentThread().getName()+"  的结果是"+n*n;

    }
}
