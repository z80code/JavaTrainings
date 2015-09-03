package home.task01.ui;

import java.util.Scanner;

public class StdReader {

    private final static Scanner scanner = new Scanner(System.in);

    private StdReader() {
        // This is static class
    }

    private static void flushBuffer() {
        scanner.nextLine();
    }

    public static int readInt(String message, String errorMessage) {
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            System.out.println(errorMessage);
            scanner.nextLine();
        }

        int number = 0;
        number = scanner.nextInt();
        flushBuffer();

        return number;
    }

    public static String readString(String message){
        System.out.println(message);
        return scanner.nextLine().trim();
    }

    public static String readString(String message, String errorMessage, String pattern){
        System.out.println(message);

        while (!scanner.hasNext(pattern)) {
            System.out.println(errorMessage);
            flushBuffer();
        }

        String value;
        value = scanner.next(pattern);
        flushBuffer();

        return value.trim();
    }

}
