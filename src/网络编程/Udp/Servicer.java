package 网络编程.Udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Servicer {
    static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(8001);
            byte[] bytes = new byte[1024*64];
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
            System.out.println(dp.getLength());
            Scanner sc=new Scanner(System.in);
            while (true) {
                ds.receive(dp);
                System.out.println(dp.getLength());
                System.out.println("客户端输入的内容为:"+new String(dp.getData(),0,dp.getLength()));
                System.out.println(dp.getAddress());
                System.out.println(new String(bytes,0,dp.getLength()));
                System.out.println("对方ip信息:"+dp.getSocketAddress()+"  对方端口"+dp.getPort());
                String string = new String(bytes,0,dp.getLength());
                if ("exit".equals(string))
                {
                    System.out.println("客户端已退出");

                    ds.close();
                    break;
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
