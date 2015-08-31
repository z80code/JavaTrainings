package filtration;

import io.phonebookio.*;

import java.util.List;

/**
 * Created by igor on 26.07.2015.
 */
public class Main {

    public static String printList(List<Record> records) {
        StringBuilder sb = new StringBuilder();
        for(Record record : records) {
            sb.append(record.toString()).append("\n");
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        Repository r = new Repository();

        //FilterByNumber filterByNumber = new FilterByNumber();

        List<Record> records = r.filtration(new Predicate() {
            @Override
            public boolean check(Record record) {
                return record.getNumber()>10;
            }
        });

        System.out.println(printList(records));




    }

}

class FilterByNumber implements Predicate {



    @Override
    public boolean check(Record record) {
        return record.getNumber()<10;
    }
}
