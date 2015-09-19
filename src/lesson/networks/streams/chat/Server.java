package lesson.networks.streams.chat;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

    public static void sendToAll(List<Socket> sockets, String message) throws IOException {
        for(Socket socket: sockets) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println(message);
        }
    }

    //https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);
        final List<Socket> sockets = new ArrayList<>();

        while (true) {
            final Socket client = serverSocket.accept();
            sockets.add(client);

            System.out.println("Connected new client");

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        Scanner scanner = new Scanner(client.getInputStream());
                        BufferedReader reader = new BufferedReader( new InputStreamReader(client.getInputStream()) );

                        while (client.isConnected()) {
                            //String msg = reader.readLine();
                            String msg = scanner.nextLine();
                            System.out.println(msg);
                            sendToAll(sockets, msg);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
        }

    }
}
