package lesson.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UsingIterator {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,3,4,5,6);
        Iterator<Integer> iterator = arr.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
