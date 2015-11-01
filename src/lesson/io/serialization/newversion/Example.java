package lesson.io.serialization.newversion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void print(List<Record> records) {
        for(Record record : records) {
            System.out.println(record);
        }
    }

    public static boolean saveTxt(List<Record> records,
                                  String path,
                                  String fileName) {

        File file = new File(path);

        if(file.exists()) {

            String fullPath = path+File.separator+fileName;
            System.out.println(fullPath);

            try( BufferedWriter writer =
                         new BufferedWriter(new FileWriter(fullPath))) {

                for(Record r : records ) {
                    String line = String.format("%d;%s;%d\n",
                                    r.getId(),
                                    r.getName(),
                                    r.getNumber());

                    writer.write(line);
                }

                return true;

            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        List<Record> records = new ArrayList<>();
//        records.add(new Record(1,"name1", 3534534534L  ));
//        records.add(new Record(3,"name3", 455874564L  ));
//        records.add(new Record(6,"name4", 234L  ));
//        print(records);
//        System.out.println(saveTxt(records, "d:", "records.csv"));

        List<Record> records = readTxt("d:\\records.csv");
        print(records);
    }

    public static List<Record> readTxt(String fullPath) {

        List<Record> records = new ArrayList<>();
        File file = new File(fullPath);

        if(file.exists()) {

            try( BufferedReader reader =
                         new BufferedReader(new FileReader(file)) ) {
                String s = null;
                while (   (s = reader.readLine()) != null   ) {
                    String[] fields = s.split(";");

                    if( fields.length == 3 ) {
                        // Нужно проверять ошибки при преобразовании в числа
                        int id = Integer.parseInt(fields[0].trim());
                        String name = fields[1].trim();
                        long number = Long.parseLong(fields[2].trim());

                        Record record = new Record(id,name, number);
                        records.add(record);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return records;
    }
}
