package lesson.threading.WaitSignal;

/**
 * Created by igor on 10.09.2015.
 */
public class Monitor {

    public static void main(String[] args) throws InterruptedException {

        final Object monitor = new Object();
        final Object monitor2 = new Object();
        final Object monitor3 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {

                    try {

                        synchronized (monitor3) {
                            monitor3.notifyAll();
                        }

                        synchronized (monitor2) {
                            monitor2.wait();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Th 1: "+ i);

                    synchronized (monitor) {
                        monitor.notify();
                    }

                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        synchronized (monitor) {
                            monitor.wait();
                        }
                        System.out.println("Th 2: "+ i);
                       // Thread.sleep(250);
                        synchronized (monitor2) {
                            monitor2.notify();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();


        synchronized (monitor3) {
            monitor3.wait();
        }

        synchronized (monitor2) {
            monitor2.notify();
        }

        thread1.join();
        thread2.join();
    }
}
