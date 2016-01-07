package lesson.threading.examples;

public class Run1 {

    public static void task() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public static void main(String[] args) throws InterruptedException {




        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                task();
            }
        });

        thread.start();
        System.out.println("main thread");

        thread.join();

        task();




    }
}
