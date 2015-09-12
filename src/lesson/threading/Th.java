package lesson.threading;


import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;


/**
 * Created by igor on 12.09.2015.
 */
public class Th {

    public static void main(String[] args) throws InterruptedException {

        final CircleBuffer<Integer> buffer = new CircleBuffer<>(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {

                    try {

                        buffer.add(i);
                        System.out.println("put: "+i);

                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    try {

                        int v = buffer.getFirst();
                        System.out.println("get first: " + v);

                        Thread.sleep(500);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    try {



                        int v = buffer.getFirst();
                        System.out.println("get second: " + v);

                        Thread.sleep(500);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        t1.start();
        t2.start();
        t3.start();



        t1.join();
        t2.join();
        t3.join();

    }

    /*public static void main(String[] args) throws InterruptedException {

        final Semaphore isEmpty = new Semaphore(2);
        final Semaphore isFull = new Semaphore(0);

        final int[] buffer = {0};

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {

                    try {

                        isEmpty.acquire();

                        System.out.println("put: "+i);
                        buffer[0] = i;

                        Thread.sleep(100);

                        isFull.release();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    try {

                        isFull.acquire();

                        System.out.println("get: " + buffer[0]);

                        Thread.sleep(500);

                        isEmpty.release();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        t1.start();
        t2.start();



        t1.join();
        t2.join();

    }*/

}


class CircleBuffer<T> {

    private T[] data;
    private int head;
    private int tail;

    private Semaphore isFull;
    private Semaphore isEmpty;

    public CircleBuffer(int buffereSize) {

        data = (T[]) new Object[buffereSize];
        isEmpty = new Semaphore(buffereSize);
        isFull = new Semaphore(0);
    }

    public void add(T v) throws InterruptedException {

        isEmpty.acquire();

        data[head++] = v;

        if(head ==data.length) {
            head=0;
        }

        isFull.release();

    }

    public T getFirst() throws InterruptedException {

        isFull.acquire();

        T v = data[tail];
        data[tail] = null;
        tail++;

        if(tail==data.length) {
            tail = 0;
        }

        isEmpty.release();

        return v;
    }

}