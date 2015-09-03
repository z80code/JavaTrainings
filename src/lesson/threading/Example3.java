package lesson.threading;

import sun.awt.windows.ThemeReader;

public class Example3 {

    public static void main(String[] args) throws InterruptedException {
        final SynchonizedObject obj = new SynchonizedObject();

        Thread one = new Thread() {
            @Override
            public void run() {
                obj.one();
            }
        };

        Thread two = new Thread() {
            @Override
            public void run() {
                obj.two();
            }
        };

        one.start();
        two.start();

        one.join();
        two.join();
    }
}



class SynchonizedObject {

   public synchronized void one() {
       System.out.println("one start");

       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       System.out.println("one end");
   }

    public synchronized void two() {
        System.out.println("two start");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("two end");
    }

}
