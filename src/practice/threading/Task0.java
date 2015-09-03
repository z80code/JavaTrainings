package practice.threading;


import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Task0 {

    // Создать 2 потока
    // каждый поток в цикле записывает строку в виде:
    //     [Номер потока]:[значение счетчика]
    //     например:         Thread1 : 5
    // Обеспечить синхронизированный доступ к файлу

    public static void main(String[] args) throws InterruptedException {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("result.txt",true))) {

            Thread one = new Thread(new Printer(1,writer ));
            one.start();

            Thread two = new Thread(new Printer(2,writer ));
            two.start();

            one.join();
            two.join();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Printer implements Runnable {

    private int threadId;
    private final BufferedWriter writer;

    public Printer(int id, BufferedWriter writer) {
        this.threadId = id;
        this.writer = writer;
    }

    @Override
    public void run() {

            for (int i = 0; i < 10000; i++) {
                synchronized (writer) {
                    try {
                        writer.write("Thread " + threadId + " : " + i + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}