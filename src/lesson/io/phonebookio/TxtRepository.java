package lesson.io.phonebookio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 25.06.2015.
 */
public class TxtRepository implements Repository{

    final String FILE_PATH;

    public TxtRepository(String filePath) {
        FILE_PATH = filePath;
    }

    private void writeToFile(List<PhoneRecord> records) {

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

    private List<PhoneRecord> readFromFile() {
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

    @Override
    public PhoneRecord get(int id) {
        return null;
    }

    @Override
    public List<PhoneRecord> getAll() {
        return readFromFile();
    }

    @Override
    public void add(PhoneRecord phoneRecord) {

    }

    @Override
    public void update(PhoneRecord phoneRecord) {

    }

    @Override
    public void delete(PhoneRecord delete) {

    }
}
