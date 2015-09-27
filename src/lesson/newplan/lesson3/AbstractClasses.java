package lesson.newplan.lesson3;
public class AbstractClasses {
    public static void main(String[] args) {
        Storage storage = new Txt();
        System.out.println(storage.get(0));

        storage = new Binary();
        System.out.println(storage.get(0));
    }
}

abstract class Storage {
    abstract String[] load();
    String get( int id) {
        String[] records = load();
        return records[id];
    }
}
class Txt extends Storage {
    String[] load() {
        System.out.println("Get data from TXT");
        return new String[] {"one", "two"};
    }
}
class Binary extends Storage {
    String[] load() {
        System.out.println("Get data from Binary");
        return new String[] {"five", "seven", "one"};
    }
}