package lesson;

import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;

public class Ov {

    public static void main(String[] args) {
        A a = new B();
    }
}

class A {

    int a;
    public int load() {
        System.out.println("load A");
        return a;
    }

    public A() {
        System.out.println("constructor A");
        System.out.println("A "+load());
    }
}

class B extends A {

    int b;
    public B() {
        System.out.println("constructor B");
        b = 555;
    }

    public int load() {
        System.out.println("load B");
        return b;
    }

}