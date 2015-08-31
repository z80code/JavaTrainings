package codepractice;

public class Task1 {

    public static void main(String[] args) throws Exception {



        double[][] array = {
                {1,2,4}, //
                {5,3,2},
                {6,4,3},
                {0,0,0}
        };

        double[] sums = new double[array.length];

        for (int i = 0; i < array.length; i++) {

            double sum = 0;
            // сумма
            // вывод sum
        }

        double[] tmp = array[3];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int maxIdx=0;
        int minIdx = 0;
    }
}

