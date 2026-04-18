package IODemo;

import java.io.FileWriter;
import java.io.Writer;

public class writer {
    static void main(String[] args) {
        try (Writer wr = new FileWriter("newfile.txt")) {

            for (int i = 1; i <= 520; i++) {

                wr.write("I love you"+i+"\r\n");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
