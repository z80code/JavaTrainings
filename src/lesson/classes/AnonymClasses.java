package lesson.classes;

public class AnonymClasses {

    public static void main(String[] args) {

        Printable printable = new PrintImpl();
        printable.print();

        PrintImpl imp = (PrintImpl)printable;
        imp.print();
        imp.print2();

        Printable printable1 = new Printable() {
            @Override
            public void print() {
                System.out.println("in main");
            }
        };

        printable1.print();


        PrintImpl p1 = new PrintImpl();
        PrintImpl p2 = new PrintImpl();
    }

}

interface Printable {
    void print();
}

class PrintImpl implements Printable {
    @Override
    public void print() {
        System.out.println(PrintImpl.class);
    }

    public void print2() {
        System.out.println("print2");
    }
}