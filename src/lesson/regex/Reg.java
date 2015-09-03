package lesson.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg {

    public static void main(String[] args) {

        String regex = "[a-zA-Z0-9._%+-]@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
        Pattern pattern = Pattern.compile(regex);

        String text = "sadf sdf sdf@gmail.com   dsf fs" +
                " sdfjksdff ksdff%f@ff.rw  sdf@@dsf.ru sdf@rrt.ru";

        Matcher matcher = pattern.matcher(text);

        matcher.find();
        matcher.reset();
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
