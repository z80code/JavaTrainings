package lesson.Generics;

import lesson.gui.examples.NullLayout;

import java.util.ArrayList;
import java.util.HashSet;

public class YetAnother {

    public static void m(Container<? extends Number> f   ) {

    }

    public static void main(String[] args) {

        Container<Number> listInt = new Container<>();
        listInt.setValue(234);
        listInt.setValue(234.4);

        m(listInt);

        Container<Integer> container = new Container<>();
        m(container);

        Container container1 = new Container();
        Container<Object> container2 = new Container<>();

        Container<String> stringContainer = new Container<>();
        //m(stringContainer);
    }
}

class Container<T> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
