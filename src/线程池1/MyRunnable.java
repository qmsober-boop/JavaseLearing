package 线程池1;

public class MyRunnable implements Runnable {
    private String name;
    public MyRunnable(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            System.out.println("线程" + Thread.currentThread().getName() + "  " + i);
            System.out.println("这是任务"+  name);

            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程" + Thread.currentThread().getName() + "  " + "结束");
    }
}
