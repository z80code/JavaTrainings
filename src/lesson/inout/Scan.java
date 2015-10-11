package lesson.inout;

import java.util.Scanner;

public class Scan {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int a;
        System.out.println("Enter number");
        while (!scanner.hasNextInt()) {
            System.out.println("Try again:");
            scanner.nextLine();
        }
        a = scanner.nextInt();


        System.out.println("entered: " + a);

    }
}

