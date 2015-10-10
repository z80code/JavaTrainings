package practice.inc;

/**
 * Created by igor on 10.10.2015.
 */
public class DTypes {

    public static void main(String[] args) {
        int a = 5;
        int b = a;
        a = 999;

        System.out.println(a);
        System.out.println(b);
        System.out.println("=====");

        int[] a1 = {1};
        int[] b1 = a1;
        a1[0] = 99;
        System.out.println(a1[0]);
        System.out.println(b1[0]);
        System.out.println("=====");

        System.out.println("clone");
        int[] a2 = {1};
        int[] b2 = a2.clone();
        a2[0] = 99;
        System.out.println(a2[0]);
        System.out.println(b2[0]);
        System.out.println("=====");


        System.out.println("clone 2D");
        int[][] a3 = {{1}};
        int[][] b3 = a3.clone();
        a3[0][0] = 99;
        System.out.println(a3[0][0]);
        System.out.println(b3[0][0]);
        System.out.println("=====");

    }
}
