package iterators;

import java.util.Iterator;

public class MyIterableClass implements Iterable<Integer>{

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        MyIterableClass m = new MyIterableClass(arr);

        for(Integer i : m) {
            System.out.println(i);
        }
    }

    public MyIterableClass(Integer[] data) {
        this.data = data;
    }

    private Integer[] data;

    @Override
    public Iterator iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {

            //private int currentIndex = 0;
            private int currentIndex = data.length-1;

            @Override
            public boolean hasNext() {
                //return currentIndex < data.length && data[currentIndex] != null;
                return currentIndex >=0;
            }

            @Override
            public Integer next() {
                //return data[currentIndex++];
                return data[currentIndex--];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
