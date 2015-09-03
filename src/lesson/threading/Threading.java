package lesson.threading;

public class Threading {

    public static void main(String[] args) {


        final Integer[] counter = {0};
        final Object lock = new Object();

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        for (int i = 0; i < 10000; i++) {
                            //System.out.println("Thread "+i);
                            synchronized (lock) {
                                counter[0]++;
                            }

                        }

                    }
                }
        );

        thread.start();


        for (int i = 0; i < 10000; i++) {
            //System.out.println("Main "+i);
            synchronized (lock) {
                counter[0]++;
            }
        }




        try {
            thread.join();
            System.out.println("Count value: " + counter[0]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
