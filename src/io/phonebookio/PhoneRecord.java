package io.phonebookio;

/**
 * Created by igor on 25.06.2015.
 */
public class PhoneRecord {

    public PhoneRecord(String firstName, String lastName, long number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneRecord{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number=" + number +
                '}';
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

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    private String firstName;
    private String lastName;
    private long number;

}
