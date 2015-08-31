package hwskeleton.bll;

import hwskeleton.model.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 22.06.2015.
 */
public class InMemoryRepository implements Repository<Record> {

    // В простейшем случае просто можно создать объект через конструктор
    // для каждого объекта храниться коллекция записей

    List<Record> records = new ArrayList<>();

    public InMemoryRepository() {
        // Лучше заполнить начальными данными
        // чтобы при запуске справочник был не пустой
        //
        // records.add(new Record(...));
        // records.add(new Record(...));
        // records.add(new Record(...));
    }

    @Override
    public Record get(int id) {
        return null;
    }

    @Override
    public List<Record> getAll() {
        return null;
    }

    @Override
    public void add(Record entity) {

    }

    @Override
    public void remove(Record entity) {

    }

    @Override
    public void update(Record entity) {

    }
}
