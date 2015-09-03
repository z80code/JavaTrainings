package lesson.date;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by igor on 19.07.2015.
 */
public class Simple {

    /**
     * Записывание и считывание данных из файла
     * @param args
     * @throws ParseException
     * @throws IOException
     */
    public static void main(String[] args) throws ParseException, IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date[] dates = {new Date(), new Date(), new Date()};
        boolean flag = true;

        if(!flag) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D://dates.txt"));
            // сохранить в файл
            for(Date d : dates) {
                writer.write(dateFormat.format(d ) + "\n");
            }
            writer.close();
        } else  {
            BufferedReader reader = new BufferedReader(new FileReader("D://dates.txt"));
            // Считываем с файла
            String s = null;
            while ( (s=reader.readLine()) !=null  ) {
                Date date = dateFormat.parse(s);
                System.out.println(date);
            }
            reader.close();
        }


    }
}


