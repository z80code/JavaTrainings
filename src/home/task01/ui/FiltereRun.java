package home.task01.ui;

import home.task01.bll.InMemoryRepository;
import home.task01.bll.Predicate;
import home.task01.bll.Repository;
import home.task01.model.Record;

import java.util.List;

/**
 * Created by igor on 16.07.2015.
 */
public class FiltereRun {

    public static void main(String[] args) {
        Repository<Record> repository = new InMemoryRepository();
        UIHelper.printRecords(repository.getAll());

        System.out.println("===============");


//        List<Record> records = repository.get(new Predicate<Record>() {
//            @Override
//            public boolean predicate(Record value) {
//                return value.getFirstName().equals("User");
//            }
//        });

        String name = "user";

        final int n = 3;
        List<Record> records = repository.get(new Predicate<Record>() {
            @Override
            public boolean predicate(Record value) {
                return value.getId() < n;
                //return value.getFirstName().contains(name);
            }
        });

        UIHelper.printRecords(records);



    }


}
