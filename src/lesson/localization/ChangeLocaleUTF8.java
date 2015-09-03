package lesson.localization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChangeLocaleUTF8 {

    public static void main(String[] args) {

        Date date = new Date();
        //Locale rus = new Locale("ru","RU");

        ResourceBundle resources = ResourceBundle.getBundle("lesson.localization.strings_utf8",Locale.getDefault(),new UTF8Control());

        Locale current = Locale.getDefault();
        System.out.println(current);
        System.out.println(resources.getString("hello")+" "+DateFormat.getInstance().format(date));

        Locale.setDefault(Locale.US);
        resources = ResourceBundle.getBundle("lesson.localization.strings",Locale.getDefault(),new UTF8Control());
        current = Locale.getDefault();
        System.out.println(current);
        System.out.println(resources.getString("hello")+" "+DateFormat.getInstance().format(date));

    }
}
