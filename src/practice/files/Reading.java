package practice.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reading {

    // если происходит ошибка (exception) выбасывать её из метода
    // использовать throws
    // ! гарантировать закрытие файла, не зависимо, была ли ошибка
    public static List<String> read(String path)
            throws IOException {

        List<String> strings = new ArrayList<>();

        // создать объект File
        File file = new File(path);
        // проверить есть ли файл (exists) - можно опустить

        // создать объект класса BufferedReader (использовать FileReader)
        try(BufferedReader reader =
                    new BufferedReader(new FileReader(file))) {

            String tmp;
            // считывать по строке, пока есть (не null)
            while ( (tmp = reader.readLine())!=null ) {
                // добавлять в результирующий список strings.add(s);
                strings.add(tmp);
            }

        }

        return strings;
    }

    public static void main(String[] args) {

        try {

            List<String> strings = read("files/strings.txt");

            for (String str : strings) {
                System.out.println(str);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
