package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9000);

        while (true) {
            // ждем клиента
            System.out.println("Waiting connection");
            final Socket client = serverSocket.accept();
            System.out.println("connected");


            Thread thread = new Thread() {
                @Override
                public void run() {
                    // recv

                    try {
                        InputStream input = client.getInputStream();

                        InputStreamReader inputStreamReader = new InputStreamReader(input);
                        BufferedReader reader = new BufferedReader(inputStreamReader);

                        // stop
                        String msg = reader.readLine();

                        System.out.println(msg);

                        // send
                        OutputStream output = client.getOutputStream();
                        PrintWriter writer = new PrintWriter(output, true);
                        writer.println("server: "+msg);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            };
            thread.start();

        }
    }
}
