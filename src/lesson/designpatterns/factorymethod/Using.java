package lesson.designpatterns.factorymethod;

import lesson.networks.streams.sendobj.Storage;

/**
 * Пример реализации паттерна Factory Method
 */
public class Using {


    public static void main(String[] args) {

        AbstractStorage s1 = StorageFactory.getStorage("txt");
        AbstractStorage s2 = StorageFactory.getStorage("db");
        AbstractStorage s3 = StorageFactory.getStorage("bin");

        s1.perform();
        s2.perform();
        s3.perform();
    }
}
