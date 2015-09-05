package lesson.networks.streams.serialization;

import java.io.Serializable;

public class Record implements Serializable {
    private String name;
    private long number;
    private String email;

    public Record(String name, long number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", email='" + email + '\'' +
                '}';
    }
}
