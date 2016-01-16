package lesson.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsMethods {

    private static void print(List<?> list) {
        for(Object item: list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//        list.add(4);
//        list.add(6);
//        list.add(1);
//        list.add(3);
//        list.add(9);
//        list.add(12);
//
//        print(list);
//        System.out.println("==================");
//
//        Collections.sort(list);
//        print(list);

//        List<String> stringList = new ArrayList<>();
//        stringList.add("one");
//        stringList.add("two");
//        stringList.add("three");
//        print(stringList);

        List<MyClass> list = new ArrayList<>();
        list.add(new MyClass(6));
        list.add(new MyClass(1));
        list.add(new MyClass(7));
        list.add(new MyClass(3));
        list.add(new MyClass(2));

        print(list);

        Collections.sort(list, new Comparator<MyClass>() {
            @Override
            public int compare(MyClass o1, MyClass o2) {
                return Integer.compare(o1.getN(),o2.getN());
            }
        });

        //binarySearch(
        // List<? extends Comparable<? super Integer>> list,
        // Integer key)
        System.out.println("=========");
        print(list);

        int n = Collections.binarySearch(list,1);

        System.out.println(n);

    }
}

class MyClass implements Comparable<Integer> {
    private int n;

    public MyClass(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "n=" + n +
                '}';
    }


//    @Override
//    public int compareTo(MyClass o) {
////        if(this.n == o.n)
////            return 0;
////        if(this.n < o.n)
////            return -1;
////        return 1;
//        return Integer.compare(this.n, o.n);
//
//    }

    @Override
    public int compareTo(Integer o) {
        return Integer.compare(this.n, o);
    }
}