package regex;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
    public static void main(String[] args) {

        // ^ - begin word $ - end word
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

        Scanner scanner = new Scanner(System.in);
        String inputText=null;
        do {
            System.out.println("Enter 'exit' to shutdown program\nor enter any string ");
            inputText = scanner.nextLine();
            Matcher matcher = pattern.matcher(inputText);
            if(matcher.matches()) {
                System.out.println("It's correct e-mail");
            } else {
                System.out.println("E-mail incorrect!");
            }

        } while (!"exit".equals(inputText));

    }
}
