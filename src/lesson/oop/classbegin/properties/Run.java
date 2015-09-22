package lesson.oop.classbegin.properties;

public class Run {

    public static void main(String[] args) {

        // создать окружность
        Circle circle = new Circle(45);
        System.out.println(circle.square());
        System.out.println(circle.square());
        System.out.println(circle.square());

        // изменить радиус
        circle.setR(10);

        System.out.println(circle.square());
        circle.setR(455);
        System.out.println(circle.square());
        System.out.println(circle.square());
    }
}

class Circle {

    private double r;
    private double s;
    private boolean isChanged;

    public Circle(double r) {
        this.r = r;
        isChanged=true;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        isChanged = true;
        this.r = r;
    }

    public double square() {

        if(isChanged) {
            s = Math.PI*r*r;
            isChanged = false;
            //System.out.println("calc");
        }

        return s;
    }
}