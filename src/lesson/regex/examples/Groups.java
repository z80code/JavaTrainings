package lesson.regex.examples;

import lesson.types.StringBuilderExample;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by igor on 22.11.2015.
 */
public class Groups {
    public static void main(String[] args) {

        Pattern pattern =
                //Pattern.compile("\\d+");
                //Pattern.compile("[a-zA-Z]+@");
                Pattern.compile("([a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)");

        String text = "sdfsdf sdfs sdf@sdf.com dff@fdf.com dsf@@fdsf cc@cf.by dfgdfg";

        Matcher matcher = pattern.matcher(text);

         while (matcher.find()) {
             System.out.println(matcher.group());
         }


    }

}
