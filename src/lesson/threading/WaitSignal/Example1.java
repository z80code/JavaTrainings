package lesson.threading.WaitSignal;

/**
 * Created by igor on 10.09.2015.
 */
public class Example1 {

    public static void main(String[] args) throws InterruptedException {
        final Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Notify");
                synchronized (this) {
                    this.notify();
                }
            }
        });


        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Im wait");
                synchronized (th1) {
                    try {
                        th1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Not");
            }
        });

        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Im wait 222");
                synchronized (th1) {
                    try {

                        th1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                Object f;

                System.out.println("Not 222");
            }
        });

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

    }
}
