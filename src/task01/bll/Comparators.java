package task01.bll;

import task01.model.Record;

import java.util.Comparator;

public class Comparators {

    public final static Comparator<Record> BY_NAME_INC = new SortByFirstName();
    public final static Comparator<Record> BY_LAST_NAME_INC = new SortByLastName();

    private static class SortByFirstName implements Comparator<Record> {

        @Override
        public int compare(Record o1, Record o2) {
            return o1.getFirstName().compareTo( o2.getFirstName()  );
        }
    }

    private static class SortByLastName implements Comparator<Record> {

        @Override
        public int compare(Record o1, Record o2) {
            return o1.getLastName().compareTo( o2.getLastName() );
        }
    }

}
