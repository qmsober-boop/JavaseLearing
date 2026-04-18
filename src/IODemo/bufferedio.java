package IODemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class bufferedio {
    static void main(String[] args)  {
        try (BufferedReader br = new BufferedReader(new FileReader("hello.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println(br.readLine());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
