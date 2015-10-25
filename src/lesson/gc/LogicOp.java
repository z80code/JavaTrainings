package lesson.gc;

/**
 * Created by igor on 25.10.2015.
 */
public class LogicOp {

    public static boolean expr1() {
        System.out.println("expr1");
        return false;
    }

    public static boolean expr2() {
        System.out.println("expr2");
        return true;
    }

    public static void main(String[] args) {
    //        &&
    //        ||
    //        !
    //        ==
    //        !=

        if( expr1() && expr2() ) {
            System.out.println("if");
        }

        if( expr1() || expr2() ) {
            System.out.println("if");
        }

    }
}
