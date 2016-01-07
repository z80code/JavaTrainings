package lesson.classes;

public class InstanceofExample {

    public static void main(String[] args) {

        Object object1 = new Car(23,"sdff");
        Object object2 = "dsf";

        System.out.println(object1 instanceof Car);
        System.out.println(object2 instanceof Car);

        if(object1 instanceof Car) {
            Car car = (Car) object1;
            System.out.println(car.id);
        }

        if(object2 instanceof Car) {
            Car car = (Car) object2;
            System.out.println(car.id);
        }

    }
}
