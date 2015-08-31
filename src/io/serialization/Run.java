package io.serialization;

import java.io.*;

/**
 * Created by igor on 25.06.2015.
 */
public class Run {

    public static PhoneNumber deserizlization()   {
        PhoneNumber result = null;
        File file = new File("src/io/serialization/number.obj");

        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream)) {

            result = (PhoneNumber)objectOutputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void serizlization(PhoneNumber number)   {
        File file = new File("src/io/serialization/number.obj");

        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(number);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PhoneNumber number = new PhoneNumber("home",4326456);
        System.out.println(number);
        serizlization(number);
        PhoneNumber readnumber = deserizlization();
        System.out.println("readed obj");
        System.out.println(readnumber);
    }
}

class PhoneNumber implements Serializable {
    private long number;
    private String description;


    public PhoneNumber(String description, long number) {
        this.description = description;
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "description='" + description + '\'' +
                ", number=" + number +
                '}';
    }
}
