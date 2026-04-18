package IODemo;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class printstream {
    static void main(String[] args) {
        try (
                PrintStream ps = new PrintStream(new FileOutputStream("hello.txt",true))
                ){
            ps.println("hello world");
            ps.println(123);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
