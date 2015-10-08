package lesson.designpatterns.factorymethod;

public class TxtStorage extends AbstractStorage {

    @Override
    public void perform() {
        System.out.println("Write something to text file");
    }
}
