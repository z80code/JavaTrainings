package lesson.regex.examples;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {
    public static void main(String[] args) {

        Pattern pattern =
                //Pattern.compile("\\d+");
                //Pattern.compile("[a-zA-Z]+@");
                Pattern.compile("([a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Matcher matcher = pattern.matcher(s);

        System.out.println( matcher.matches() );

    }
}
