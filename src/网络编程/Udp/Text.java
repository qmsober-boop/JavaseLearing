package 网络编程.Udp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Text {
    static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("www.baidu.com");
            InetAddress ip1= InetAddress.getLocalHost();
            System.out.println(ip1);
            System.out.println(ip1.getHostName());
            System.out.println(Arrays.toString(ip1.getAddress()));
            System.out.println(ip1.getHostAddress());

            System.out.println(ip.getHostAddress());
            System.out.println(ip.isReachable(5000));
            System.out.println(ip.isReachable(5000));
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
