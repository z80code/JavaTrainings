import java.io.*;

/**
 * Created by igor on 10.06.2015.
 */
public class TryCatchWithResources {

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new FileReader("src/file.txt"))) {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            String everything = sb.toString();
            System.out.println(everything);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
