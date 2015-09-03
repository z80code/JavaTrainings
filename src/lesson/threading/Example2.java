package lesson.threading;


public class Example2 {

    public static void main(String[] args) throws InterruptedException {
//        MyThread1 one = new MyThread1();
//        one.start();

        Container container = new Container();

        MyThread2 two = new MyThread2(container);
        Thread threadTwo = new Thread(two);
        threadTwo.start();

        MyThread2 one = new MyThread2(container);
        Thread threadOne = new Thread(two);
        threadOne.start();

        threadOne.join();
        threadTwo.join();

        System.out.println(container.getCounter());
    }
}

class MyThread1 extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            System.out.println("Thread 1: "+i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class Container {

    private int counter = 0;

    public synchronized void inc() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

}

class MyThread2 implements Runnable {

    private Container container;

    public MyThread2(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            container.inc();
        }
    }
}


