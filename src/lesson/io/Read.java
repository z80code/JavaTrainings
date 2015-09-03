package lesson.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by igor on 25.06.2015.
 */
public class Read {
    public static void main(String[] args) throws IOException {

        System.out.println(System.getProperty("user.dir"));
        BufferedReader br =
                new BufferedReader(
                        new FileReader("src/lesson.io/file.txt"));

        String s;
        StringBuilder buffer = new StringBuilder();

        while ( (s=br.readLine())!= null ) {
            buffer.append(s).append("\n");
        }

        System.out.println(buffer);



    }
}
