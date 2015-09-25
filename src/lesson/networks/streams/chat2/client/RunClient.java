package lesson.networks.streams.chat2.client;

import java.io.IOException;
import java.util.Scanner;

public class RunClient {

    public static void main(String[] args) {

        try {
            Client client = new Client("127.0.0.1", 9000);
            //Client client = new Client("192.168.0.106", 9000);

            client.setReceiveAction(new ReceiveAction() {
                @Override
                public void receive(String message) {
                    System.out.println(message);
                }
            });

            client.connect();

            String userName = "Igor";

            while (client.isConnected()) {
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                client.send(userName+ ": "+message);
            }

        } catch (IOException e) {
            System.out.println("Не удалось подключиться. "
                    + e.getMessage());
        }

    }

}
