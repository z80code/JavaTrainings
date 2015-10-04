package lesson.exceptions;

import java.io.*;

public class Example {

    public static void writeFile() {

        try(BufferedWriter writer =
                    new BufferedWriter(new FileWriter("D:/dsd/t.txt"))) {
            writer.write("asdfsdsfd\n");
            writer.write("asdfsdsfd\n");
            writer.write("asdfsdsfd\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        writeFile();
    }
}
