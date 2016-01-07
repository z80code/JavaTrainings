package lesson.classes;

import lesson.types.StringBuilderExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortWithComparator {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();
        carList.add(new Car(5,"qwer"));
        carList.add(new Car(1,"abc"));
        carList.add(new Car(7,"zzz"));
        carList.add(new Car(2,"qe"));

        System.out.println(carList);
        System.out.println("========");

        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return -Integer.compare(o1.id, o2.id);
            }
        });

        System.out.println(carList);
    }
}

class Car {
    int id;
    String name;

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "}\n";
    }
}
