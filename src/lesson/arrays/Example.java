package lesson.arrays;

import java.util.Arrays;

public class Example {

    public static void main(String[] args) {

        int[] a = {1, 2, 4, 5};
        int[] b = new int[5];
        int[] c = b.clone();
        c[2] = 342;
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(b));
        int i = 0;
    }

}
