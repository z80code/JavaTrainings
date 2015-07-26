package filtration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 26.07.2015.
 */
public class Repository {

    public List<Record> getRecords() {
        return records;
    }

    List<Record> records = new ArrayList<>();

    public List<Record> filtration ( Predicate predicate ) {
        List<Record> selected = new ArrayList<>();

        for(Record record : records) {
            if(predicate.check(record)) {
                selected.add(record);
            }
        }

        return selected;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Record record : records) {
           sb.append(record.toString()).append("\n");
        }
        return  sb.toString();
    }



    public Repository() {
        records.add(new Record("nam1","lastname54",45));
        records.add(new Record("nam4","lastname56",5));
        records.add(new Record("ab43","lastname3",78));
        records.add(new Record("nam17","lastname45",0));
        records.add(new Record("ab43","lastname5",23));
        records.add(new Record("nam12","lastname",3));
    }


}
