package lesson.networks.streams.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("start app");
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("created server socket");

        Socket client = serverSocket.accept();
        System.out.println("user connected");

        InputStreamReader inputReader = new InputStreamReader(client.getInputStream());
        BufferedReader reader = new BufferedReader(inputReader);
        String msg = reader.readLine();
        System.out.println(msg);
    }
}
