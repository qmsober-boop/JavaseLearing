package 网络编程.Tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Text {
    static void main(String[] args) throws IOException {
        System.out.println("客户端启动");
        Socket socket = new Socket("127.0.0.1", 8001);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(outputStream);
        Scanner sr=new Scanner(System.in);
        while (true){
           String string= sr.nextLine();
            if("exit".equals( string)) {
                dos.close();
                socket.close();
                break;
            }
            dos.writeUTF( string);
           dos.flush();

        }



    }
}
