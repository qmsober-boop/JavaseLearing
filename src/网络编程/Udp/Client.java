package 网络编程.Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    static void main(String[] args)  {

        Scanner sc= new Scanner(System.in);

        try {
            DatagramSocket ds = new DatagramSocket();


            int i = 1;
            while (true) {

                String s=sc.nextLine();

                byte[] bytes =new String(s).getBytes();
                DatagramPacket dp = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(), 8001);
                ds.send(dp);
                if("exit".equals(s))
                {
                    ds.close();
                    break;
                }
                i++;
                Thread.sleep(10000);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
