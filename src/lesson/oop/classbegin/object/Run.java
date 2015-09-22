package lesson.oop.classbegin.object;


import java.awt.*;
import java.awt.event.ActionEvent;

public class Run {

    public static void main(String[] args) {

//        Run f = new Run();
//        Object obj = new Object();
//        Object ob2 = f;
//        Object ob3 = new Car();
       // Run r = new Car();

        Car car1 = new Car();
        Color c = new Color(12,23,34);
        Car car2 = new Car(200, c, "car name", -300 );
        Car car3 = new Car(200, new Color(34,45,233), "car name", 3 );


        System.out.println(car1.toString());
        System.out.println(car2);
        System.out.println(car3);

        Car car4 = car1;

        System.out.println(" == ");
        System.out.println(car1 == car1);
        System.out.println(car1 == car2);
        System.out.println(car1 == car3);
        System.out.println(car1 == car4);

        System.out.println("\nequals\n");
        System.out.println(car1.equals(car1));
        System.out.println(car1.equals(car2));
        System.out.println(car1.equals(car3));
        System.out.println(car1.equals(car4));
        System.out.println(car2.equals(car3));

        Run run = new Run();
        System.out.println(car1.equals(run));



    }
}

class Car {
    // public , private, protected, []
    private float maxSpeed;
    Color color;
    private String name;

    public int getCountDoors() {
        return countDoors;
    }

    public void setCountDoors(int countDoors) {
        if(countDoors>1) {
            this.countDoors = countDoors;
        } else {
            System.out.println("Error");
        }
    }

    private int countDoors;

    Car() {
        maxSpeed = 100;
        color = new Color(0, 54, 166);
        name = "None";
        countDoors = 5;
    }

    public void setMaxSpeed(float maxSpeed) {
        if(maxSpeed<0) {
            System.out.println(" Bad argument ");
        } else {
            this.maxSpeed = maxSpeed;
        }
    }

    public Car(float maxSpeed, Color color, String name, int countDoors) {
        setMaxSpeed(maxSpeed);
        this.color = color;
        this.name = name;
        setCountDoors(countDoors);
    }

    public void show() {


        System.out.printf("%f, %s, %s , %d \n", maxSpeed, color, name, countDoors);
    }

    public Color getColor() {
        System.out.println("get color");
        return color;
    }

    public void setColor(Color color) {

        this.color = color;
    }

    @Override
    public String toString() {
        return  String.format("%f, %s, %s , %d \n", maxSpeed, color, name, countDoors);
    }


    @Override
    public boolean equals(Object obj) {

        if( obj instanceof Car ) {
            Car car2 = (Car)obj;

            return this.name.equals(car2.name);
        }

        return false;

    }

}
