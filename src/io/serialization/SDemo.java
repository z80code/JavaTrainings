package io.serialization;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SDemo {

    public static void serialize(List<Record> records)  {

        try (
                ObjectOutputStream out = new ObjectOutputStream(
                        new FileOutputStream(
                                "src/io/serialization/records.obj"))
        ) {

            out.writeObject(records);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Record> deserialize() {

        List<Record> records = null;

        try(
                ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream("src/io/serialization/records.obj"))
                ) {


            records = (List<Record>)in.readObject();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return records;
    }


    public static void main(String[] args) {


        List<Record> records = new ArrayList<>();

        records.add(new Record("name1", 12213));
        records.add(new Record("name2", 77777));
        records.add(new Record("name3", 99999));
        for(int i = 0; i< records.size(); i++) {
            records.get(i).setCache(i+1);
        }

        for(Record record: records) {
            System.out.println(record);
        }

        System.out.println("*************");

        serialize(records);
        records = deserialize();

        for(Record record: records) {
            System.out.println(record);
        }
    }
}

class Record implements Externalizable {
    private String name;
    private int number;
    private Integer cache;

    public Record() {
        String sdf = "dsf";
        sdf.contains("sdf");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(number);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String)in.readObject();
        number = (Integer)in.readObject();
    }

    public Integer getCache() {
        return cache;
    }

    public void setCache(Integer cache) {
        this.cache = cache;
    }

    public Record(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", cache=" + cache +
                '}';
    }
}
