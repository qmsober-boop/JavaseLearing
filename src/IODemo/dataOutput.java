package IODemo;

import java.io.*;

public class dataOutput {
    static void main(String[] args) {
        try (DataInputStream dos = new DataInputStream(new FileInputStream("data.txt"))) {

            System.out.println(dos.readByte());
            System.out.println(dos.readUTF());
            System.out.println(dos.readDouble());
            System.out.println(dos.readInt());

            System.out.println(dos.readByte());
            System.out.println(dos.readUTF());
            System.out.println(dos.readDouble());
            System.out.println(dos.readInt());

            System.out.println(dos.readByte());
            System.out.println(dos.readUTF());
            System.out.println(dos.readDouble());
            System.out.println(dos.readInt());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




    }
}
