package IODemo;

import java.io.File;
import java.io.IOException;

public class FirstDay {
    static void main(String[] args) throws IOException {
        File file=new File("D:\\");

        search(file,"jdk");


    }

    public static void search(File files, String targetName) throws IOException {
        if (files.isFile()||!files.exists())
        {
            return;
        }

        File []file1 =files.listFiles();

        if(file1!=null&&file1.length>0)
        {
            for (File file2 : file1) {
                if(file2.isFile())
                {
                    if (file2.getName().contains(targetName))
                    {
                        System.out.println("找到目的文件了"+file2.getAbsolutePath());
                        Runtime r=Runtime.getRuntime();

                    }

                }
                else {
                    search(file2, targetName);
                }
            }
        }


    }




}
