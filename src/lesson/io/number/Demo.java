package lesson.io.number;

import java.io.*;
import java.util.Scanner;

public class Demo {

    /**
     * Внимание! тут не учитываются возможные ошибки
     * файл не найден или ошибки чтения
     */
    public static void main(String[] args) throws IOException {

        // Это константа
        final String FILE_NAME = "D:/myfile.txt";

        // Запись числа в файл
        PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME));
        writer.print(456);
        writer.close();

        // Чтение из файла
        Scanner scanner = new Scanner(new FileReader(FILE_NAME));
        int readValue = scanner.nextInt();
        scanner.close();

        System.out.println(readValue);

    }

}
