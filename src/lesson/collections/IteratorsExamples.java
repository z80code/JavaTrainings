package lesson.collections;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorsExamples {

    public static void main(String[] args) {



        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        for (Integer item: list) {
            System.out.println(item);
        }
        System.out.println("эквивалентно");

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
