package lesson.networks.streams.sendobj;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        // Выполняем подключение
        Socket server = new Socket();
        InetAddress ip = InetAddress.getLocalHost();
        InetSocketAddress address = new InetSocketAddress(ip,9000 );
        server.connect(address);

        OutputStream output = server.getOutputStream();
        ObjectOutputStream  stream = new ObjectOutputStream(output);

        int action = 0;

        do {

            System.out.println("1 - Add record");
            System.out.println("0 - Exit");

            Scanner scanner = new Scanner(System.in);

            while ( !scanner.hasNextInt() ) {
                System.out.println("Invalid arg");
                scanner.nextLine();
            }

            action = scanner.nextInt();

            // Чистим поток ввода
            scanner.nextLine();

            if(action==1) {
                // ввести имя
                System.out.println("Enter name");
                String name = scanner.nextLine();
                System.out.println("Enter phone");

                while ( !scanner.hasNextInt() ) {
                    System.out.println("Invalid arg");
                    scanner.nextLine();
                }
                int number = scanner.nextInt();

                Record record = new Record(name, number);
                System.out.println(record);
                stream.writeObject(record);
            }

        } while (action!=0);

    }


}
