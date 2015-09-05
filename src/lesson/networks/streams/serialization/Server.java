package lesson.networks.streams.serialization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by igor on 05.09.2015.
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(888);
        System.out.println("Create socket");

        Socket client = serverSocket.accept();
        System.out.println("User connected");



        System.out.println("Get messages");

        ObjectInputStream objectOutputStream = new ObjectInputStream(client.getInputStream());
        Record r1 = (Record)objectOutputStream.readObject();
        Record r2 = (Record)objectOutputStream.readObject();


        System.out.println(r1);
        System.out.println(r2);
        System.out.println("Finish messages recv");

    }
}
