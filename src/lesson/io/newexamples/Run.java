package lesson.io.newexamples;


import java.io.*;
import java.util.Arrays;

public class Run {

    public static void main(String[] args) {

        try (BufferedReader reader = new
                BufferedReader(new FileReader("d:/file.txt"))) {
            String str;

            int sum=0;

            while (      (str = reader.readLine()) != null     ) {

                //System.out.println(str);

                String[] sNumbers =  str.trim().split(" ");

                System.out.println(Arrays.toString(sNumbers));

                for(String v : sNumbers) {
                    try {
                        sum += Integer.parseInt(v);
                    } catch (NumberFormatException e) {
                        System.out.println("bad value: "+e.getMessage());
                    }
                }
            }

            System.out.println("Сумма = "+ sum);

        } catch (IOException e) {
            e.printStackTrace();
        }




    }

}
