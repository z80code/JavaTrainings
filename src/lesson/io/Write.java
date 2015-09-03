package lesson.io;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by igor on 25.06.2015.
 */
public class Write {

    public static void main(String[] args) throws IOException {


        BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/lesson.io/test.txt"));

        PrintWriter out = new PrintWriter(writer);


        out.println("sdfsf sdfsdf");



        out.close();
        writer.close();

    }

}
