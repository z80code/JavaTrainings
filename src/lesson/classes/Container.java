package lesson.classes;

import java.util.ArrayList;
import java.util.List;

public class Container {

    public static void main(String[] args) {
        Container container = new Container();

        List<Car> cars = container.filtration(new Predicate() {
            @Override
            public boolean predict(Object v) {
                Car car = (Car)v;
                return (car.id > 5);
            }
        });

        System.out.println(cars);
    }

    List<Car> list = new ArrayList<>();

    Container() {
        list.add(new Car(5,"qwer"));
        list.add(new Car(1,"abc"));
        list.add(new Car(7,"zzz"));
        list.add(new Car(2,"qe"));
    }

    public List<Car>  filtration(Predicate p ) {

        List<Car> cars = new ArrayList<>();

        for(Car car: list) {
            if(p.predict(car)) {
                cars.add(car);
            }
        }

        return cars;
    }
}

interface Predicate<T> {
    boolean predict(T v);
}
