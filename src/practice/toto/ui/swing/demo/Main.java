package practice.toto.ui.swing.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {


    public static void main(final String[] args) {

        try(CSVWriter csvWriter =
                    new CSVWriter(new FileWriter("D://file.csv"))) {

            csvWriter.writeLine("234", "435", "tyu");
            csvWriter.writeLine(new String[]{"a1","h3", "j8"});

            ArrayList<String> list = new ArrayList<String>() {{
                    add("s1");
                    add("s2");
                    add("s3");
                }};

            csvWriter.writeLine( list.toArray( new String[] {"","",""}));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
