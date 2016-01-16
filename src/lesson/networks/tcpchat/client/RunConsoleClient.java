package lesson.networks.tcpchat.client;


import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class RunConsoleClient {

    public static void main(String[] args) throws IOException {

        Network network = new Network("127.0.0.1", 8080);

        network.setReceiveListener(
                new ReceiveListener() {
                    @Override
                    public void action(String message) {
                        System.out.println(message);
                    }
                }
        );

        network.connect();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            network.send("igor: "+message);
        }

    }

}