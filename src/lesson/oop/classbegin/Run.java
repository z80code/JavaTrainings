package lesson.oop.classbegin;


import java.awt.Color;

public class Run {

    public static void main(String[] args) {

        Car car1 = new Car();
        Color c = new Color(12,23,34);
        Car car2 = new Car(200, c, "car name", -300 );
        Car car3 = new Car(200, new Color(34,45,233), "car name", 3 );
        car2.setMaxSpeed(-100);

        //car2.maxSpeed = -100000;

        car1.getColor();
        car1.getColor();
        car3.setCountDoors(-5);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

//        car1.show();
//        car2.show();
//        car3.show();
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
}
