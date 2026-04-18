import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ioDemo {
    static void main(String[] args) throws IOException {
        File file=new File("F:\\hello");
        File [ ]file1 =file.listFiles();
        System.out.println(Arrays.toString(file1));
        File file2=new File("F:\\is\\workplace\\you") ;
        System.out.println(file2.mkdirs());
        System.out.println(file2.exists());
        System.out.println(file2.isDirectory());
        remove(file2);

    }
    public static void remove(File file)
    {

       File []file1 =file.listFiles();
        for (File file2 : file1) {

            if (file2.isFile())
            {
                remove(file2);
            }
            else
            {
                file2.delete();
            }
        }

    }





    }

