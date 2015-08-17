package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by igor on 25.06.2015.
 */
public class BasicFileOutput {
    public static void main(String[] args) {

        // Добавление в файл
        try(PrintWriter writer = new PrintWriter(new FileWriter("src/io/ttt.txt",true))) {
            writer.println("sdf");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
