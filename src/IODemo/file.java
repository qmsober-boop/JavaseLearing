package IODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class file {

    static void main(String[] args) throws IOException {
        File file=new File("F:\\atext.txt");
        System.out.println(file.exists());
        file.createNewFile();
        System.out.println(file.exists());
        FileInputStream fileInputStream=new FileInputStream(file);
        byte []bytes=new byte[fileInputStream.available()];
        int read=1;
        while(read!=-1)
        {
             read = fileInputStream.read(bytes);
            System.out.print(new String(bytes));
        }



    }
}
