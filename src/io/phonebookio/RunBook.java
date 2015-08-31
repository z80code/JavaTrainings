package io.phonebookio;

/**
 * Created by igor on 25.06.2015.
 */
public class RunBook {

    public static void main(String[] args) {

        Repository repository =
                new TxtRepository("src/io/phonebookio/records.csv");

        for(PhoneRecord record: repository.getAll()) {
            System.out.println(record);
        }
    }
}
