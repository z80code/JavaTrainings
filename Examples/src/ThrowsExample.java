import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by igor on 10.06.2015.
 */
public class ThrowsExample {

    public static void printFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/file.txt"));

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            String everything = sb.toString();
            System.out.println(everything);
    }

    public static void main(String[] args) {

        try {
            printFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
