package iterators;

import java.util.Iterator;

/**
 * Created by igor on 18.06.2015.
 */
public class NotArrayIterator implements Iterable<Integer>{

    public static void main(String[] args) {
        NotArrayIterator m = new NotArrayIterator();

        for(Integer item : m) {
            System.out.println(item);
        }
    }

    int a = 5;
    int b = 3;
    int c = 7;

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {

            private int idx = 0;

            @Override
            public boolean hasNext() {
                return idx<3;
            }

            @Override
            public Integer next() {
                Integer result = 0;
                switch (idx) {
                    case 0:
                        result = a;
                        break;
                    case 1:
                        result = b;
                        break;
                    case 2:
                        result = c;
                        break;
                }
                idx++;
                return result;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
