package home.task01.bll;

import home.task01.model.Phone;
import home.task01.model.Record;

import java.util.*;

/**
 * Created by igor on 22.06.2015.
 */
public class InMemoryRepository implements Repository<Record> {

    // � ���������� ������ ������ ����� ������� ������ ����� �����������
    // ��� ������� ������� ��������� ��������� �������

    private List<Record> records = new ArrayList<>();

    public InMemoryRepository() {
        // ����� ��������� ���������� �������
        // ����� ��� ������� ���������� ��� �� ������
        Record r1 = new Record("userName",
                "lastName",
                new Phone("��������", "+375 12 4545456"),
                Arrays.asList("�������", "����"));

        Record r2 = new Record("userName1",
                "lastName2",
                new Phone("��������", "+375 12 3426"),
                Arrays.asList("�������"));

        Record r3 = new Record("userName4",
                "lastName�4",
                new Phone("��������", "+375 12 546666"),
                Arrays.asList("����"));

        Record r4 = new Record("User",
                "lastName�4",
                new Phone("��������", "+375 12 546666"),
                Arrays.asList("����"));
        Record r5 = new Record("User",
                "lastName�4",
                new Phone("��������", "+375 12 546666"),
                Arrays.asList("����"));

        records.add(r1);
        records.add(r2);
        records.add(r3);
        records.add(r4);
        records.add(r5);

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
    public List<Record> get(Predicate<Record> predicate) {
        List<Record> filtred = new ArrayList<>();

        for(Record record : records) {
            if(   predicate.predicate(record)    ) {
                filtred.add(record);
            }
        }

        return filtred;
    }


    @Override
    public void add(Record entity) {

        if(entity!=null) {
            records.add(entity);
        }
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
        Collections.sort(records, Comparators.BY_NAME_INC);
        Collections.sort(records,comparator);
    }

    @Override
    public void save() {

    }

}
