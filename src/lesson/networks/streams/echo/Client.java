package lesson.networks.streams.echo;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by igor on 17.09.2015.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // Выполняем подключение
        Socket server = new Socket();
        InetAddress ip = InetAddress.getLocalHost();
        InetSocketAddress address = new InetSocketAddress(ip,9000 );
        server.connect(address);

        // Получаем от пользователя строку
        System.out.println("Please, enter something:");
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();

        // Отправляем на сервер
        OutputStream output = server.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(msg);

        // Получаем ответ от сервера
        InputStream input = server.getInputStream();
        InputStreamReader stream = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(stream);

        // Выводим на консоль ответ
        String serverMsg = reader.readLine();
        System.out.println(serverMsg);
    }
}
