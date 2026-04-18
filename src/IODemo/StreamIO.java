package IODemo;

import java.io.*;
import java.util.Scanner;

public class StreamIO {
  public   static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入源文件路径");
        String source=sc.nextLine();
        System.out.println("请输入目标文件路径");
        String target=sc.nextLine();
        copy(source,target);



    }

    public static void copy(String source,String target) throws IOException {

        try (
        FileInputStream it = new FileInputStream(source);
         FileOutputStream ot = new FileOutputStream(target);
        InputStream it1=new BufferedInputStream(it);
        OutputStream ot1=new BufferedOutputStream(ot);

        ){

//        byte[] bytes=it.readAllBytes();
//        ot.write(bytes);
//        ot.close();
//        it.close();
            byte[]bytes=new byte[1024];
            int len;
            while ((len=it1.read(bytes))!=-1)
            {
                ot1.write(bytes,0,len);
            }
            ot1.flush();

            System.out.println("复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
