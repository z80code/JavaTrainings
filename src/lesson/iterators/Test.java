package lesson.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by igor on 20.06.2015.
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}




