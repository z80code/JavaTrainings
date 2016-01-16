package lesson.oop;

public class St {

    public static void d(DaysOfWeek v) {
        if(v == DaysOfWeek.M) {

        }
    }

    public static void main(String[] args) {
        DaysOfWeek day = DaysOfWeek.M;
        System.out.println(day);
        DaysOfWeek day2 =DaysOfWeek.valueOf(3);
        System.out.println(day2);

        DaysOfWeek day3 = DaysOfWeek.values()[1];
        System.out.println(day3);
    }
}

enum DaysOfWeek {
    M(1),D(2),W(3);

    int v;

    DaysOfWeek(int v) {
        this.v = v;
    }

    public static DaysOfWeek valueOf(int v) {

        for(DaysOfWeek day: DaysOfWeek.values()) {
            if(day.v==v){
                return day;
            }
        }

        throw new IllegalArgumentException();
    }
}

class A {

    int a = 123;


    int b = getB();

    {
        a = 234;
        System.out.println("sdf");
    }

    static {

    }

    public A() {

    }

    public int getB() {
        return 4;
    }

    public void print() {
        System.out.println("A");
    }
}

class B extends A{

    public void dsf() {
        System.out.println("sdf");
    }

    @Override
    public void print() {
        System.out.println("B");
    }
}