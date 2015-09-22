package net;

import java.io.*;
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

        System.out.println("Enter message:");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        // send
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(message);

        // recv
        InputStream input = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String answer = reader.readLine();

        System.out.println(answer);
    }

}
