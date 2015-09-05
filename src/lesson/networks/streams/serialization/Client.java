package lesson.networks.streams.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by igor on 05.09.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Try connect
        System.out.println("Try connect");
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(),888));
        System.out.println("connected");


        ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());

        stream.writeObject(new Record("igor",234234, "nesterione@gmail.com"));
        stream.writeObject(new Record("other",345345, "345@gmail.com"));

        System.out.printf("End");

        Thread.sleep(20000);
    }
}
