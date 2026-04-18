package 网络编程.Tcp2;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sendmsg {
    static void main(String[] args) throws IOException {
       Socket socket=new Socket("127.0.0.1", 8001);

        OutputStream outputStream=socket.getOutputStream();
        DataOutputStream dos=new DataOutputStream(outputStream);
        Scanner sc=new Scanner(System.in);
        String string = null;
        while (true) {

            if ("exit".equals(string))
            {
                dos.close();
                socket.close();
                break;
            }
            string = sc.nextLine();
            dos.writeUTF(string);
            dos.flush();
        }


    }
}
