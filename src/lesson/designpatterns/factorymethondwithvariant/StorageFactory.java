package lesson.designpatterns.factorymethondwithvariant;

import lesson.designpatterns.factorymethod.*;
import lesson.designpatterns.factorymethod.DbStorage;

/**
 * Недостаток реализации в том, что нужно вносить всякий раз измерения в этот класс, при добавлении новых хранилищ
 */
public class StorageFactory {

    private StorageFactory() {
        // static class
    }

    // В метода могут быть дополнительные параметры, для каждого типа хранилища
    public static AbstractStorage getTxt() {
        return new TxtStorage();
    }

    public static AbstractStorage getBin() {
        return new BinaryStorage();
    }

    public static AbstractStorage getDb() {
        return new lesson.designpatterns.factorymethondwithvariant.DbStorage();
    }

}
