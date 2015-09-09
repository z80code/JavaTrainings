package com.itclass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 09.09.2015.
 */
public class Parallel {

    public static void sleepAndPring(Integer x)  {
        try {
            Thread.sleep(2000);

            System.out.printf("%d ", x);
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(3);
        values.add(4);
        values.add(6);

        values.parallelStream().forEach(Parallel::sleepAndPring);

    }
}
