package 网络编程2.聊天软件;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServivceThread extends Thread {
    private Socket socket;

    public ServivceThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String name = null;
            while (true) {
                int cmd = dis.readInt();
                switch (cmd) {
                    //登录
                    case 1:
                        name = dis.readUTF();
                        Consent.OnlineUsers.put(socket, name);
                        upDateUserList();
                        System.out.println("用户:" + name + "登录成功\n");
                        System.out.println(Consent.OnlineUsers.size()+"人在线");
                        break;
                    case 2://在大厅的处理信息
                        name = Consent.OnlineUsers.get(socket);
                        String message = dis.readUTF();
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss EEE a");
                        String time = dtf.format(now);
                        StringBuilder sb = new StringBuilder();
                        String messageSend = sb.append(name).append("   " + time).append("\r\n: ").
                                append(message).append("\r\n").toString();
                        DataOutputStream write=null;
                        for (Socket s : Consent.OnlineUsers.keySet())
                        {
                            try {
                                write =new DataOutputStream(s.getOutputStream());
                                write.writeInt(4);//使客户端接受信息
                                write.writeUTF(messageSend);
                                write.flush();
                            } catch (IOException e) {
                                System.out.println("用户:"+Consent.OnlineUsers.get(s)+"接受信息异常(有可能异常退出)");
                            }
                        }
                        break;

                    case 3:
                        break;

                        //退出登录
                    case 4:

                        socket.close();
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println(socket.getInetAddress() + "退出服务器"+"-->"+ Consent.OnlineUsers.get(socket));
            Consent.OnlineUsers.remove(socket);
            upDateUserList();
        }
    }

    public void upDateUserList() {
        int num = Consent.OnlineUsers.size();
        try {
            DataOutputStream dos =null;
            for (Socket socket1 : Consent.OnlineUsers.keySet()) {
                dos = new DataOutputStream(socket1.getOutputStream());
                dos.writeInt(1);
                dos.writeInt(num);
                for (String name : Consent.OnlineUsers.values()) {
                    dos.writeUTF(name);
                }
//                for (Socket socket1 : Consent.OnlineUsers.keySet()) {
//                    try (DataOutputStream dos = new DataOutputStream(socket1.getOutputStream())) {
//                        dos.writeInt(1);
//                        dos.writeInt(Consent.OnlineUsers.size());
//豪气冲天的写法:--->
//                        for (String name : Consent.OnlineUsers.values()) {
//                            dos.writeUTF(name);
//                        }
//                        dos.flush();
//                    } catch (IOException e) {
//                        System.out.println("向用户:" + Consent.OnlineUsers.get(socket1) + "更新列表异常");
//                    }

                dos.flush();
            }



        } catch (IOException e) {
            System.out.println(socket.getInetAddress() + "服务器更新异常");
        }
    }


}
