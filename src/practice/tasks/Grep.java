package practice.tasks;

import java.io.*;

public class Grep {

    public static void main(String[] args) throws IOException {

        BufferedReader reader2 = new BufferedReader(
                new InputStreamReader(new FileInputStream("D://tt.txt"), "UTF-8"));

        String s = null;
        while ( (s=reader2.readLine())!=null) {

            if(s.contains("��")) {
                System.out.println(s);
            }
        }
    }
}
