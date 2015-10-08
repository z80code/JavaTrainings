package lesson.designpatterns.factorymethod;

public class DbStorage extends AbstractStorage {
    @Override
    public void perform() {
        System.out.println("write something to DB");
    }
}
