package lesson.types.strings;

import lesson.types.StringBuilderExample;

public class Str {

    public static void main(String[] args) {
        String s1 = "str";
        String s2 = "str";

        String s3 = s1;


        System.out.println(s1);
        System.out.println(s1.toUpperCase());

        StringBuilder sb1 = new StringBuilder("str");
        StringBuilder sb2 = new StringBuilder("str");

        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(sb1==sb2);
    }
}
