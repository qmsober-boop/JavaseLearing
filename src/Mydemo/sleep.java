package Mydemo;

public class sleep {
    static void main(String[] args) {
        while ( true)
        {
            System.out.println("hello world");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
