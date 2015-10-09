package lesson.threading.pool;

import lesson.threading.Ru;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example {

    public static void main(String[] args) throws InterruptedException {

        final int N = 5;
        CountDownLatch latch = new CountDownLatch(N);

        ExecutorService pool = Executors.newFixedThreadPool(N);

        for (int i = 0; i < N; i++) {
            pool.submit(new TestThread(i, latch));
        }

        System.out.println("wait threads");
        latch.await();
        System.out.println("end");

        pool.shutdown();

        System.out.println("thread pool down");
    }

}

class TestThread implements Runnable {

    private int id;
    private CountDownLatch latch;

    public TestThread(int id , CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {

        System.out.println("start thread: "+ id);

        Random random = new Random();

        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("stop thread: "+ id);
        latch.countDown();

    }
}
