package oop;

/**
 * Created by igor on 14.06.2015.
 */
public class Inh {
    public static void main(String[] args) {
        Point1d p1 = new Point2d(1,2);
        Point1d p2 = new Point3d(1,2,3);

    }
}

class Point1d {
    int x;

    public Point1d(int x ) {
        this.x = x;
    }

    public void print() {
        System.out.format("Point1d: %d\n", x);
    }
}

class Point2d extends Point1d {
    int y;

    public void print() {
        System.out.format("Point2d: %d %d\n", x, y);
    }

    public Point2d(int x, int y) {
       super(x);
    }
}

class Point3d extends Point2d {
    int z;

    public Point3d(int x, int y, int z) {
        super(x,y);
        this.z = z;
    }

    public void print() {
        System.out.format("Point3d: %d %d %d\n", x, y,z);
    }
}

