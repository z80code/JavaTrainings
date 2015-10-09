package practice.net.chat.client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class RunClient {

    public static void main(String[] args) throws IOException {

        String host = "127.0.0.1";
        int port = 9000;

        Client client = new Client(host, port);
        client.connect();

        OnReceive onReceive = new OnReceive();
        client.setReceiveEvent(onReceive);

        Scanner scanner = new Scanner(System.in);
        while (client.isConnected()) {
            String message = scanner.nextLine();
            client.send(message);
        }
    }
}

class OnReceive implements ReceiveEvent {
    @Override
    public void receive(String message) {
        System.out.println(message);
    }
}