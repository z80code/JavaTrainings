package practice.inc;

/**
 * Created by igor on 10.10.2015.
 */
public class Main {

    public static void main(String[] args) {
        int i = 4;
        //5 + 4
        int b = ++i*(++i+i--);
        System.out.println(b);
    }

}
