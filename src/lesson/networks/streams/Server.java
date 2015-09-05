package lesson.networks.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(888);
        System.out.println("Create socket");

        Socket client = serverSocket.accept();
        System.out.println("User connected");


        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

        System.out.println("Sleep 5 sec");
        Thread.sleep(5000);

        System.out.println("Get message");

        String s = reader.readLine();
        System.out.println(s);

        s = reader.readLine();
        System.out.println(s);


        System.out.println("Finish messages recv");

    }
}
