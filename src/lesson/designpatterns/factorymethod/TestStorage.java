package lesson.designpatterns.factorymethod;

/**
 * Created by igor on 08.10.2015.
 */
public class TestStorage extends AbstractStorage {
    @Override
    public void perform() {
        System.out.println("Test storage");
    }
}
