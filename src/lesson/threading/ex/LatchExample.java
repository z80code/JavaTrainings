package lesson.threading.ex;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;

public class LatchExample {

    public static void main(String[] args) throws InterruptedException {

        final int N = 5;
        CountDownLatch latch = new CountDownLatch(N);
        ExecutorService pool = Executors.newFixedThreadPool(N);

        for (int i = 0; i < N; i++) {
            pool.submit(new MThread(latch,i));
            //new Thread(new MThread(latch,i)).start();
        }

        System.out.println("await");

        latch.await();

        pool.shutdown();
        //pool.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("end");
    }
}

class MThread implements Runnable {

    private CountDownLatch latch;
    private int id;

    public MThread(CountDownLatch latch, int id) {
        this.latch = latch;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("thread started: "+id);

        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread finished: "+id);
        latch.countDown();
    }

}