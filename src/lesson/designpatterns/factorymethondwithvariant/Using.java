package lesson.designpatterns.factorymethondwithvariant;


/**
 * Пример реализации паттерна Factory Method
 */
public class Using {


    public static void main(String[] args) {
        AbstractStorage s1 = StorageFactory.getBin();
        AbstractStorage s2 = StorageFactory.getDb();
        AbstractStorage s3 = StorageFactory.getTxt();

        s1.perform();
        s2.perform();
        s3.perform();
    }
}
