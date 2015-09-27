package lesson.newplan.lesson3;

import java.io.File;
import java.util.Arrays;

public class ArraysOfObjects {

    public static void main(String[] args) {

        Point1D point1D = new Point1D(6);

        Point2D point2D = new Point2D(1,4);

        Point1D p = point2D;

//        System.out.println(point1D);
//        System.out.println(point2D);
//        System.out.println(p);

        point1D.print();
        point2D.print();
        p.print();

    }
}

class Point1D {
    final private int x;

    public Point1D(int x) {
        this.x = x;
    }

    public final void print() {
        System.out.println("1D");
    }

    public String toString() {
        return "Point1D{" +
                "x=" + x +
                '}';
    }
}

//class MyString extends String {
//
//}

class Point2D extends Point1D {

    private int y;

    public Point2D(int x, int y) {
        super(x);
        this.y = y;
    }


//    public void print() {
//        System.out.println("2D");
//    }

    public String toString() {
        return "Point2D{" +
                "y=" + y +
                '}';
    }
}


