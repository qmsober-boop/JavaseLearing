package 网络编程.Tcp3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Server {
    static void main(String[] args) throws IOException {
        ExecutorService executorService = new ThreadPoolExecutor(3,5,10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());


        ServerSocket ss = new ServerSocket(8001);
        int num=1;
        while (true) {

            Socket socket = ss.accept();
            executorService.execute(new NewService(socket));
            System.out.println(socket.getInetAddress()+"      "+num+"客户端已连接");
            System.out.println("--------------------------------");
            num++;

        }

    }
}
