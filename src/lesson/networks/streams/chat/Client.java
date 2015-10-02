package lesson.networks.streams.chat;

import lesson.io.BufferedReading;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        final Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your user name");
        String name = scanner.nextLine();

        final Socket socket = new Socket();
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(),8888));
        System.out.println("Connected");

        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final PrintWriter printer = new PrintWriter(socket.getOutputStream(),true);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {

                    String msg = null;
                    try {
                        msg = reader.readLine();
                        System.out.println(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        thread.start();

        while (socket.isConnected()) {
            String msg = scanner.nextLine();
            printer.println(name+"> "+msg);
        }



    }

}
