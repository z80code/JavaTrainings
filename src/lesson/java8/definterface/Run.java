package lesson.java8.definterface;

/**
 * Created by igor on 28.12.2015.
 */
public class Run {

    public static void main(String[] args) {
        My m = new My();
        m.pay();
        Payerable.print();

    }
}

interface Payerable {

    static void print() {
        System.out.println("print");
    }

    default void pay() {
        System.out.println("default");
    }
}

class P {
    public void pay() {
        System.out.println("p class");
    }
}

class My extends P implements Payerable {

}
