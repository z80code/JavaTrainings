package lesson.oop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class D {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault( Locale.US );
        // Sun Jan 10 19:01:39 MSK 2016
        Date a = new Date();

        Date b = new Date(-1000000000);

        SimpleDateFormat format
                = new SimpleDateFormat("dd.MMM.yy");

        System.out.println(format.format(a));
        System.out.println(format.format(b));
        //System.out.println(  format.parse("11.11.2011")  );

    }

}
