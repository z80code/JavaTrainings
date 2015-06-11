




package my;

/**
 * Created by igor on 11.06.2015.
 */
public class TestPl {
    public static void main(String[] args) {

        MyInterface f = new A();
        f.doSome();
    }
}


interface MyInterface {
    void doSome();
    int b = 35;
}

interface MyOtherInterfaces extends MyInterface {
    void doSome2();
}

class A implements MyInterface{

    @Override
    public void doSome() {
        System.out.println("sdf");
    }
}

