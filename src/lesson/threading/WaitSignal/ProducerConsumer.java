package lesson.threading.WaitSignal;

import java.util.concurrent.Semaphore;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        final Buffer<String> buffer = new Buffer<>(5);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    System.out.println("T1 put: " + i);
                    try {
                        buffer.put("T1 put: " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("T2 get value: " + buffer.getFirst());
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

    }

}

class Buffer<T> {

    private T[] data;
    private int head = 0;
    private int tail = 0;

    Semaphore isEmpty;
    Semaphore isFull = new Semaphore(0);

    public Buffer(int bufferSize) {
        data = (T[]) new Object[bufferSize];
        isEmpty = new Semaphore(bufferSize);
        isFull = new Semaphore(0);
    }

    public T getFirst() throws InterruptedException {

        T value = null;

        isFull.acquire();

        synchronized (data) {
            value = data[tail];
            data[tail] = null;
            tail++;

            if (tail == data.length) {
                tail = 0;
            }
        }

        isEmpty.release();

        return value;
    }

    public void put(T value) throws InterruptedException {

        isEmpty.acquire();

        synchronized (data) {
            data[head++] = value;

            if (head == data.length) {
                head = 0;
            }
        }

        isFull.release();

    }
}
