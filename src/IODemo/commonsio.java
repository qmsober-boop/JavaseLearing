package IODemo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class commonsio {
    static void main(String[] args) throws IOException {
        FileUtils.copyDirectory(new File("F:\\copytry"),new File("F:\\commonscry"));



    }
}
