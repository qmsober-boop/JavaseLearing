package 网络编程.Tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动");
        ServerSocket ss = new ServerSocket(8001);
        Socket socket = ss.accept();//阻塞等待客户端建立连接
        InputStream in = socket.getInputStream();
        DataInputStream dis = new DataInputStream(in);
        while (true) {
           String msg = dis.readUTF();
            System.out.println("服务器收到:" + msg);
            System.out.println("客户端的端口:" + socket.getPort());
            System.out.println("客户端的ip:  " + socket.getInetAddress());
            System.out.println("--------------------------------");
        }
    }
}
