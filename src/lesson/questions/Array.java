package lesson.questions;

/**
 * Created by igor on 21.10.2015.
 */
public class Array {

    public static void main(String[] args) {

        Object[] arr = {new Object(),new Object(),null,new Object(),new Object()};
        for(Object obj : arr) {
            System.out.println(obj.toString());
        }
    }
}
