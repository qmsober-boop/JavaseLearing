package 网络编程2.聊天软件;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(Consent.PORT);
        while (true) {
            Socket socket=ss.accept();
            new ServivceThread(socket).start();
            System.out.println("用户:" + socket.getInetAddress() + "已连接");
            System.out.println("目前有"+ Consent.OnlineUsers.size()+"人在线");
        }

    }

}
