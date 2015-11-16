package lesson.oop.types;

import lesson.types.StringBuilderExample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Run {

    public static void main(String[] args) throws IOException {

        // int
        // Integer

        try( BufferedReader reader =
                new BufferedReader(new FileReader("d:/f.txt")) ) {

            //List<String> list = new
            //ArrayList<String> list1 =
            //LinkedList<String> list2 = new LinkedList<String>();
            //MyList<String> list3 = new MyList<>();

            List<String> list = new LinkedList<String>(); // new ArrayList<String>();

            String str;
            while ( (str=reader.readLine())!=null ) {
                if(str.trim().length()>0) {
                    list.add(str);
                }
            }
            // вывод
            for (String s : list) {
                System.out.println(s);
            }

            reader.close();

        }



    }

}

class MyList<T> implements List<T> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}

interface MyInterface {

}

abstract class A {
    abstract public void doSome();
}

class AImpl extends A {

    @Override
    public void doSome() {
        System.out.println("impl A");
    }

    public void m2() {

    }
}
