package regex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by igor on 25.06.2015.
 */
public class FindExample {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/regex/data.txt"))) {


            StringBuilder data = new StringBuilder();
            String s = null;

            while ((s=reader.readLine())!=null) {
                data.append(s).append("\n");
            }

            System.out.println("Data:");
            System.out.println(data);



            System.out.println("Found sequences:");


            String regex = "(\\d+)-(\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(data);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }






        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
