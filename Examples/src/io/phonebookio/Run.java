package io.phonebookio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 25.06.2015.
 */
public class Run {

    private final static String FILE_PATH = "src/io/phonebookio/records.csv";

    public static void writeToFile(List<PhoneRecord> records) {

        try(
                BufferedWriter bufferedWriter =
                        new BufferedWriter(new FileWriter(FILE_PATH));
                PrintWriter out = new PrintWriter(bufferedWriter)
            ) {

            // Print head
            out.println("firstName, secondName, number");

            for(PhoneRecord record : records) {
                out.format("%s,%s,%s\n",
                        record.getFirstName(),
                        record.getLastName(),
                        record.getNumber());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<PhoneRecord> readFromFile() {
        List<PhoneRecord> records = new ArrayList<>();

        try( BufferedReader reader =
                     new BufferedReader( new FileReader(FILE_PATH) ) ) {

            // Cut headers
            reader.readLine();

            String s;

            while ( (s=reader.readLine())!=null ) {

                String[] strings = s.trim().split(",");

                if(strings.length!=3) {
                    continue;
                }

                String firstName = strings[0].trim();
                String lastName = strings[1].trim();
                long number = Long.parseLong(strings[2].trim());

                PhoneRecord phoneRecord =
                        new PhoneRecord(firstName,lastName, number);

                records.add(phoneRecord);

            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


        return  records;
    }


    public static void main(String[] args) {

//        List<PhoneRecord> records = new ArrayList<>();
//        records.add(new PhoneRecord("Joht","Fsdf",23345));
//        records.add(new PhoneRecord("Iusdf","Uwer",4577));
//        records.add(new PhoneRecord("Jdsfs","Tert",678678));
//        writeToFile(records);

        List<PhoneRecord> records = readFromFile();

        for (PhoneRecord record : records) {
            System.out.println(record);
        }


    }

}
