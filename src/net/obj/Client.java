package net.obj;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();

        SocketAddress address = new InetSocketAddress(
                InetAddress.getLocalHost(),
                9000
        );

        socket.connect(address);

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(outputStream);

        int action = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.printf("============");
            System.out.println("1 - add");
            System.out.println("0 - exit");
            System.out.printf("============");

            while (!scanner.hasNextInt()) {
                System.out.println("bad argument");
                scanner.nextLine();
            }
            action = scanner.nextInt();
            scanner.nextLine();

            if(action==1) {
                System.out.println("Enter name");
                String name = scanner.nextLine();

                System.out.println("Phone number");
                while (!scanner.hasNextInt()) {
                    System.out.println("bad argument");
                    scanner.nextLine();
                }
                int number = scanner.nextInt();

                Record record = new Record(name, number);
                // Send
                output.writeObject(record);
            }

        } while (action!=0);

    }

}
