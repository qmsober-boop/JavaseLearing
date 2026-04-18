package 网络编程.Tcp2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Servicer extends  Thread{

    private Socket socket;
    public Servicer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            this.setName("线程"+socket.getPort());
            while (true) {
                String msg = dis.readUTF();
                System.out.println(Thread.currentThread().getName()+"给你发送msg:" + msg);
                System.out.println("客户端的端口:" + socket.getPort());
                System.out.println("客户端的ip:  " + socket.getInetAddress());
                System.out.println("--------------------------------");
            }
        } catch (IOException e) {
            System.out.println(Thread.currentThread().getName()+"客户端已断开连接");
        }


    }
}
