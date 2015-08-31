package task01.model;

import task01.bll.Comparators;

import java.util.Date;
import java.util.List;

public class Record {

    private int id;
    private String firstName;
    private String lastName;
    private Phone phone;
    private List<String> tags;
    private Date lastChange;

    // Для генирации уникальных Id
    private static int globalId = 0;

    public Record(String firstName, String lastName, Phone phone, List<String> tags) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.tags = tags;
        this.id = nextId();
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    private int nextId() {
        return globalId++;
    }

    public String getTagsAsString() {
        StringBuilder tagsSb = new StringBuilder();
        for(String tag: getTags()) {
            tagsSb.append(tag).append(" ");
        }

        return tagsSb.toString();
    }

    @Override
    public String toString() {

        String result  = String.format("{%d, %s, %s, %s, [%s] }",
                getId(),
                getFirstName(),
                getLastName(),
                getPhone(),
                getTagsAsString());

        return result;
    }
}
