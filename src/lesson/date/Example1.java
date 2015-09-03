package lesson.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by igor on 16.07.2015.
 */
public class Example1 {
    public static void main(String[] args) throws ParseException {

        Date data = new Date();


/*
        System.out.println( data.toLocaleString() );
        Locale.setDefault(Locale.US);
        System.out.println( data.toLocaleString() );
        Date s = new Date(347583485);
*/


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String utc = simpleDateFormat.format(data);

        Date d2 = simpleDateFormat.parse(utc);

        System.out.println( utc );

        /*SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date d2 = simpleDateFormat1.parse(utc);
        System.out.println(d2);*/

        /*Date d2 = simpleDateFormat.parse("15.08.12");
        System.out.println(d2);*/


    }
}
