package lesson.networks.streams;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Try connect
        System.out.println("Try connect");
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(),888));
        System.out.println("connected");

        PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);

        writer.println("message1 one");
        writer.println("message2 two");

        System.out.printf("End");

        Thread.sleep(20000);

    }

}
