package localization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by igor on 19.06.2015.
 */
public class ManagerUsingRun {

    public static void main(String[] args) {
        Date date = new Date();
        //Locale rus = new Locale("ru","RU");

        ResourceBundle resources = ResourceManager.getInstance().getResourceBundle();

        Locale current = Locale.getDefault();
        System.out.println(current);
        System.out.println(resources.getString("hello")+" "+ DateFormat.getInstance().format(date));

        Locale.setDefault(Locale.US);
        // Check locale
        ResourceManager.getInstance().changeLocale(Locale.getDefault());
        resources = ResourceManager.getInstance().getResourceBundle();
        current = Locale.getDefault();
        System.out.println(current);
        System.out.println(resources.getString("hello")+" "+DateFormat.getInstance().format(date));
    }

}
