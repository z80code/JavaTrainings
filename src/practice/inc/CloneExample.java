package practice.inc;

/**
 * Created by igor on 10.10.2015.
 */
public class CloneExample {

    public static void main(String[] args) throws CloneNotSupportedException {
        MyClass m1 = new MyClass(1,2);
        MyClass m2 = (MyClass) m1.clone();
        //(MyClass) m1.getCopy();
        m1.a = 5555;
        System.out.println(m1);
        System.out.println(m2);
    }
}

class MyClass implements Cloneable {
    int a;
    int b;

    public MyClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public MyClass getCopy()  {
        return new MyClass(a,b);
    }
}