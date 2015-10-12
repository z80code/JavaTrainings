package practice;

/**
 * Created by igor on 10.10.2015.
 */
public class Params {

    public static double mean(double ... values) {
        double sum = 0;

        for(double v:values) {
            sum+=v;
        }

        return sum/values.length;
    }

    public static void main(String[] args) {

        System.out.println(mean(2, 3.5, 9.5));
        System.out.println(mean(100, 200));
        double[] vals = {20, 2, 10.14};
        System.out.println(mean(vals));
    }
}
