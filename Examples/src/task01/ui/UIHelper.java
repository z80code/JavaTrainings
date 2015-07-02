package task01.ui;

import task01.model.Phone;
import task01.model.Record;

import java.util.Arrays;
import java.util.List;

/**
 * Created by igor on 22.06.2015.
 */
public class UIHelper {

    public static void printRecords(List<Record> records) {
        for(Record record : records) {
            System.out.println(record);
        }
    }


    // предлагаю создать static class в
    // которыей будут помещены все функции для считывания данных с консоли
    public static Record createNewRecord() {

        String firstName = StdReader.readString("Enter first name");
        String lastName = StdReader.readString("Enter last name");
        String phoneType = StdReader.readString("Enter type (home, work etc.)");
        String phoneNumber = StdReader.readString("Enter phone number");
        String tagsString = StdReader.readString("Enter tags split by space");

        String[] tagsArray = tagsString.trim().split(" ");
        List<String> tags = Arrays.asList(tagsArray);

        Phone phone = new Phone(phoneType, phoneNumber);
        Record record = new Record(firstName,lastName, phone, tags);

        return record;
    }

    public static Record updateRecord( Record record ) {

        System.out.println("Press enter is you don't want update current field");

        String firstName = StdReader.readString("Enter first name [" + record.getFirstName() + "]");
        String lastName = StdReader.readString("Enter last name [" + record.getLastName() + "]");
        String phoneType = StdReader.readString("Enter type (home, work etc.) [" + record.getPhone().getType() + "]");
        String phoneNumber = StdReader.readString("Enter phone number [" + record.getPhone().getNumber() + "]");
        String tagsString = StdReader.readString("Enter new tags split by space [" + record.getTagsAsString() + "]");

        if(firstName.length()>0) {
            record.setFirstName(firstName);
        }
        if(lastName.length()>0) {
            record.setLastName(lastName);
        }
        if(phoneType.length()>0) {
            record.getPhone().setType(phoneType);
        }
        if(phoneNumber.length()>0) {
            record.getPhone().setNumber(phoneNumber);
        }

        if(tagsString.length()>0) {
            String[] tagsArray = tagsString.trim().split(" ");
            List<String> tags = Arrays.asList(tagsArray);
            record.setTags(tags);
        }

        return record;
    }

    public static void deleteRecord() {

    }

    // и т.д.

}
