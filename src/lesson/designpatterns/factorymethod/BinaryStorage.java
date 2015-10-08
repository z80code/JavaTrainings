package lesson.designpatterns.factorymethod;

public class BinaryStorage extends AbstractStorage {

    @Override
    public void perform() {
        System.out.println("Write to binary file");
    }
}
