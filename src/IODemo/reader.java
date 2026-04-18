package IODemo;

import java.io.FileReader;
import java.io.Reader;

public class reader {
    static void main(String[] args) {
        try (Reader rd = new FileReader("hello.txt")) {
            char[] chars = new char[4];
            int len;
            while ((len = rd.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));
                System.out.print(len+" ");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
