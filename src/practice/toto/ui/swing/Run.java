package practice.toto.ui.swing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by igor on 01.10.2015.
 */
public class Run {


    public static void main(String[] args) throws IOException {

        //
       /* BufferedWriter writer = new BufferedWriter(

                new FileWriter("df")
        );*/

        try(CSVWriter writer = new CSVWriter(
                new FileWriter("D://text.csv")) ) {

            writer.writeLine("sdf", "4354", "3453");
            writer.writeLine("sdf", "sdfd", "3453");
            writer.writeLine("12321", "4354", "3453");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
