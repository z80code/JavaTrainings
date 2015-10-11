package lesson.oop;

/**
 * Created by igor on 10.10.2015.
 */
public class Methods {
    public static void print(int a) {
        System.out.println("one :" + a);
    }
    public static void print(int a, int b) {
        System.out.println("two :" +a  +" "+b);
    }

    public static void print(int a, int ... b) {
        System.out.println("three :" +a);
        for(int bValue: b) {
            System.out.println(bValue);
        }
    }

    public static double mean(double ... values) {
        return 0;
    }

    public static void main(String[] args) {


        print(345);
        System.out.println("=");
        print(345, 56);
        System.out.println("=");
        print(345, 56, 4545);
        System.out.println("=");
        int[] array = {1, 2, 3};
        print(345, array);
        System.out.println("=");
    }
}
