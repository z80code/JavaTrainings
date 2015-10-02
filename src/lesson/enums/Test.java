package lesson.enums;

public class Test {

    public static void main(String[] args) {
        DayOfWeek dayOfWeek = DayOfWeek.Saturday;

        System.out.println(dayOfWeek);

        dayOfWeek = DayOfWeek.Thursday;

        DayOfWeek f = DayOfWeek.fromOrd(2);
        System.out.println(f);


    }
}

enum DayOfWeek {Monday(1), Tuesday(2), Wednesday(3), Thursday(4), Friday(5), Saturday(6), Sunday(7);



    private int ord ;

    DayOfWeek(int ord) {
        this.ord = ord;
    }

    public int getOrd() {
        return this.ord;
    }

    public void method() {

    }

    public static DayOfWeek fromOrd(int ord) {

        //if (ord != null) {
            for (DayOfWeek b : DayOfWeek.values()) {
                if (ord == b.ord) {
                    return b;
                }
            }
       // }

        throw new IllegalArgumentException("No constant with text " + ord + " found");
    }
}