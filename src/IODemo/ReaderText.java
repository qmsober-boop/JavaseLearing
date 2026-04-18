package IODemo;

import java.io.*;

public class ReaderText {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        InputStream is =new FileInputStream("F:\\乱码实验.txt");
        InputStreamReader fr = new InputStreamReader(is,"GBK");
        try (BufferedReader br = new BufferedReader(fr))  {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
