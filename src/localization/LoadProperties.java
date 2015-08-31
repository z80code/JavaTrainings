package localization;

import java.io.*;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by igor on 19.06.2015.
 */
public class LoadProperties {
    public static void main(String[] args) {

        Properties resources = new Properties();

        try (InputStream stream = new FileInputStream("src/localization/strings.properties")) {

            Reader reader = new InputStreamReader(stream,"UTF-8");
            resources.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Locale current = Locale.getDefault();
        System.out.println(current);
        System.out.println(resources.getProperty("hello"));

    }
}
