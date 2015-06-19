package localization;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.text.DateFormat;
import java.util.*;

public class ChangeLocale {

    public static void main(String[] args) {

        Date date = new Date();
        //Locale rus = new Locale("ru","RU");

        ResourceBundle resources = ResourceBundle.getBundle("localization.strings",Locale.getDefault());

        Locale current = Locale.getDefault();
        System.out.println(current);
        System.out.println(resources.getString("hello")+" "+DateFormat.getInstance().format(date));

        Locale.setDefault(Locale.US);
        resources = ResourceBundle.getBundle("localization.strings",Locale.getDefault());
        current = Locale.getDefault();
        System.out.println(current);
        System.out.println(resources.getString("hello")+" "+DateFormat.getInstance().format(date));

    }
}
