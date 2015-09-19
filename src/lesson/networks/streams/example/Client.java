package lesson.networks.streams.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket server = new Socket();

        // 127.0.0.1
        server.connect(
                new InetSocketAddress(InetAddress.getLocalHost(),9000 )
        );

        PrintWriter writer = new PrintWriter(server.getOutputStream(), true);
        writer.println("Hi, from client!");


    }

}
