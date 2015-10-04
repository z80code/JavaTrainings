package lesson.exceptions;

/**
 * Created by igor on 04.10.2015.
 */
public class Demo {
    public static void main(String[] args) {

        try {
            Box box = new Box(100);
            System.out.println((box.getT()));
            box.setT(500);
            System.out.println((box.getT()));
            // Exception
            //box.setT(-500);
            Box box2 = new Box(-100);
            System.out.println(box2.getT());
        } catch (IllegalArgumentException e) {
            System.out.println("Было введено значение < 0");
        }
    }
}

class Box {
    private double t;

    public Box(double t) {
        setT(t);
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        if(t<0)
            throw new IllegalArgumentException("< 0");
        this.t = t;
    }
}
