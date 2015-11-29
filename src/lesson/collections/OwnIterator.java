package lesson.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class OwnIterator {

    public static void main(String[] args) {


        Container container = new Container();
        for(Integer item : container) {
            System.out.println(item);
        }

    }

}

class Container implements Iterable<Integer> {

    private int[] data = {1,2,3,4,5};


    @Override
    public Iterator<Integer> iterator() {

        class MyIterator implements Iterator<Integer> {

            int pointer;
            int[] data;

            public MyIterator(int[] data) {
                this.data = data;
                pointer = 0;
            }

            @Override
            public boolean hasNext() {
                return (pointer<data.length);
            }

            @Override
            public Integer next() {
                return data[pointer++];
            }
        }

        class MyIteratorReversed implements Iterator<Integer> {

            int pointer;
            int[] data;

            public MyIteratorReversed(int[] data) {
                this.data = data;
                pointer = data.length-1;
            }

            @Override
            public boolean hasNext() {
                return (pointer>=0);
            }

            @Override
            public Integer next() {
                return data[pointer--];
            }
        }

        return new MyIteratorReversed(data);
    }
}