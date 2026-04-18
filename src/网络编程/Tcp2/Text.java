package 网络编程.Tcp2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Text {
    static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8001);
        while (true) {
            try {
                Socket socket = ss.accept();
                new Servicer( socket).start();
                System.out.println("客户端"+socket.getInetAddress()+"已连接");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
