package lesson.regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Blr {

    public static void main(String[] args) {
        //final String PATTERN_PRICE_BLR = "(blr)";
        //final String PATTERN_PRICE_BLR = "^.*(blr).*$";
        final String PATTERN_PRICE_BLR = "([0-9 ]+blr)";

        String s = "I was left with 1 700 253 blr and 2 000$.";

        Pattern pattern = Pattern.compile(PATTERN_PRICE_BLR);
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.matches());

        matcher.find();
        System.out.println(matcher.group());
    }
}
