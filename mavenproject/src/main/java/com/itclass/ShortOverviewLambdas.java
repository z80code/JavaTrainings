package com.itclass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShortOverviewLambdas {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        list.add(5);

        System.out.println("Find sum via Lambda");
        System.out.println(list.stream().reduce( (x,y) -> x+y ).get());

        System.out.println("Filter via Lambda");
        System.out.println(list.stream().filter(x -> x>=3).collect(Collectors.toList()));

        System.out.println("Sort sum via Lambda");
        list.sort(Integer::compare);
        System.out.println( list  );


    }
}
