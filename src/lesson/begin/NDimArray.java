package lesson.begin;

/**
 * Created by igor on 13.09.2015.
 */
public class NDimArray {

    public static void print(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%d ", a[i][j]);
            }
            System.out.println();
        }
    }

    public static void upd(int[][] a) {
        a[0][0] = 888;
    }

    public static void main(String[] args) {

        int[][] a1 = new int[3][2];
        a1[1][1] = 5;
        print(a1);

        int[][] a2 = new int[4][];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = new int[i+1];
        }

        print(a2);

        upd(a2);

        print(a2);

    }

}
