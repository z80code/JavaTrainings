package lesson.networks.streams.linalg;

public class Matrix {

    private double[][] A;

    public Matrix(double[][] A) {
        this.A = A;
    }

    private void checkColumnIndex(int index) {
        if(index<0||index>(A.length-1))
            throw new IllegalArgumentException("Bad index");
    }

    public double[] getColumn(int index) {
        checkColumnIndex(index);
        double[] column = new double[A.length];

        for (int i = 0; i < A.length; i++) {
            column[i] = A[i][index];
        }

        return  column;
    }
}
