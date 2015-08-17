package ioexamples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RW {

    public static void writeToFile(String fileName, List<Record> records) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {
            writer.write("id, firstName, lastName\n");
            for (Record record : records) {

                String s = String.format("%d,%s,%s\n",
                        record.getId(),
                        record.getFirstName(),
                        record.getLastName());

                writer.write(s);
            }
        }
    }

    public static List<Record> readFromFile(String fileName) throws IOException {
        List<Record> records = new ArrayList<>();

        try( BufferedReader reader = new BufferedReader(
                new FileReader(fileName) ) )  {

            // Cut headers
            reader.readLine();

            String tmp;
            while ( (tmp = reader.readLine() ) !=null ) {

                String[] items = tmp.split(",");

                if(items.length != 3) continue;

                int id = Integer.parseInt(  items[0].trim()  );
                String firstName = items[1].trim();
                String lastName = items[2].trim();

                Record record = new Record(id, firstName, lastName);
                records.add(record);
            }
        }

        return records;
    }

    public static void main(String[] args) {

//        List<Record> records = new ArrayList<>();
//        records.add( new Record(1,"Name1", "Second1") );
//        records.add( new Record(2,"Name2", "Second2") );
//        records.add( new Record(4,"Name4", "Second4") );
//        records.add( new Record(7,"Name7", "Second7") );
//
//
//        try {
//
//            writeToFile("src/ioexamples/records.csv",records);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            List<Record> records = readFromFile("src/ioexamples/records.csv");

            for(Record record: records) {
                System.out.println(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}

class Record {
    private int id;
    private String firstName;
    private String lastName;

    public Record(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Record(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
