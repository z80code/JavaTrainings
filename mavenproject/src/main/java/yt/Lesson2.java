package yt;

import java.util.Date;

public class Lesson2 {

    public static void main(String[] args) {

        Object object = new Object();
        System.out.println(object.toString());

        MyClass myClass = new MyClass(345);
        System.out.println(myClass.toString());

        Object myObj = new MyClass(789);
        System.out.println(myObj.toString());

        MySecondClass secondClass = new MySecondClass(111);
        System.out.println(secondClass.toString());
    }
}

class MyClass {
    int a;
    public MyClass(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return String.format("{ %d }", a);
    }
}

class MySecondClass extends MyClass {

    public MySecondClass(int a) {
        super(a);
    }

    @Override
    public String toString() {
        return "Second class: " + a;
    }
}