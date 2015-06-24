package io;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReading {

    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new FileReader("src/io/file.txt"));) {


            StringBuilder stringBuilder = new StringBuilder();
            String s;

            while ( (s = reader.readLine()) != null) {
                stringBuilder.append(s+"\n");
            }
            System.out.println(stringBuilder);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
