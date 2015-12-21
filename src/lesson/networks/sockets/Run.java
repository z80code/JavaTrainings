package lesson.networks.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Run {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);

        int k = 0;

        while (true) {
            Socket client = serverSocket.accept();
            System.out.println("connected client");


            PrintWriter writer =
                    new PrintWriter(client.getOutputStream(),true);

            writer.println("connected client number "+k);
            k++;

        }

    }
}
