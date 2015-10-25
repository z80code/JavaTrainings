package lesson.gc;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Boxing {


    public static void method(long a) {

    }

    public static void method2(Long a) {

    }

    public static void main(String[] args) {

        //int
        //Integer

        // double
        // Double

        // char
        // Character

        Integer a = 123; // Boxing
        int b = a; // Unboxing

        // Old way (befor java 1.5)
        int c = a.intValue();
        Integer d = Integer.valueOf(b);

        //List<double> a;
        List<Double> a1;

        long n = 10000000000L;

        long start = System.currentTimeMillis();
        for (long i = 0; i < n ; i++) {
            method(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("without boxing");
        System.out.println(end-start);


        start = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            method2(i);
        }
        end = System.currentTimeMillis();
        System.out.println("boxing");
        System.out.println(end-start);
    }

}
