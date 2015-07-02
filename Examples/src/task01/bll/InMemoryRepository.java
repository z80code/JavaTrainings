package task01.bll;

import task01.model.Phone;
import task01.model.Record;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by igor on 22.06.2015.
 */
public class InMemoryRepository implements Repository<Record> {

    // В простейшем случае просто можно создать объект через конструктор
    // для каждого объекта храниться коллекция записей

    private List<Record> records = new ArrayList<>();

    public InMemoryRepository() {
        // Лучше заполнить начальными данными
        // чтобы при запуске справочник был не пустой
        Record r1 = new Record("userName",
                "lastName",
                new Phone("домашний", "+375 12 4545456"),
                Arrays.asList("коллека", "друг"));

        Record r2 = new Record("userName1",
                "lastName2",
                new Phone("рабочийй", "+375 12 3426"),
                Arrays.asList("коллека"));

        Record r3 = new Record("userName4",
                "lastNameа4",
                new Phone("домашний", "+375 12 546666"),
                Arrays.asList("друг"));


        records.add(r1);
        records.add(r2);
        records.add(r3);
    }

    @Override
    public Record get(int id) {
        Record result = null;

        for(Record record : records) {
            if(record.getId()==id) {
                result = record;
                break;
            }
        }

        return result;
    }

    @Override
    public List<Record> getAll() {
        return records;
    }


    @Override
    public void add(Record entity) {
        records.add(entity);
    }

    @Override
    public void remove(Record entity) {
        int id = entity.getId();
        for(Record record: records) {
            if(record.getId() == id) {
                records.remove(record);
                break;
            }
        }
    }

    @Override
    public void update(Record entity) {

        boolean isUpdated = false;

        for (int index = 0; index < records.size()&&!isUpdated; index++) {
            Record record = records.get(index);
            if(record.getId()==entity.getId()) {
                records.set(index, entity);
                isUpdated = true;
            }
        }
        if(!isUpdated) {
            records.add(entity);
        }

    }

    @Override
    public void sort(Comparator<Record> comparator) {
        records.sort(comparator);
    }

}
