package lesson.designpatterns.factorymethod;

/**
 * Недостаток реализации в том, что нужно вносить всякий раз измерения в этот класс, при добавлении новых хранилищ
 */
public class StorageFactory {

    private StorageFactory() {
        // static class
    }

    public static AbstractStorage getStorage(String type) {
        // можно использовать перечисление, в данном случае просто строка
        type = type.toLowerCase().trim();

        switch (type) {
            case "txt":
                return new TxtStorage();
            case "bin":
                return new BinaryStorage();
            case "db":
                return new DbStorage();
                //return new TestStorage();
            default:
                throw new RuntimeException("Illegal type of storage");
        }
    }

}
