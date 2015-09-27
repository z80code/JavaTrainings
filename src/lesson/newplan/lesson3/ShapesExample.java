package lesson.newplan.lesson3;
import java.util.Random;

public class ShapesExample {

    public static void main(String[] args) {
        final int N = 10;
        Shape[] shapes = new Shape[N];
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            switch (r.nextInt(3)) {
                case 0:
                    shapes[i] = new Quad(r.nextFloat());
                    break;
                case 1:
                    shapes[i] = new Circle(r.nextFloat());
                    break;
                case 2:
                    shapes[i] = new Triangle(r.nextFloat(),r.nextFloat());
                    break;
            }
        }

        //TODO dfgdfg
        for (Shape shape: shapes) {
            System.out.println(shape);
        }
    }
}

abstract class Shape {
    abstract double s();
    public String toString() { return String.format("Shape: %s, square: %f", this.getClass(), s() ); }
}
class Quad extends Shape {
    private float a;
    public Quad(float a) { this.a = a; }
    double s() { return a*a; }
}
class Circle extends Shape{
    private float r;
    public Circle(float r) { this.r = r; }
    double s() { return Math.PI*r*r; }
}
class Triangle extends Shape {
    private float h, a;
    public Triangle(float h, float a) { this.h = h; this.a = a; }
    double s() { return 1f/2*h*a;}
}