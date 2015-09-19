package lesson.networks.streams.echo;

import lesson.io.BufferedReading;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9000);

        while (true) {
            // pause
            final Socket client = serverSocket.accept();

            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {

                        InputStream input = client.getInputStream();

                        InputStreamReader stream = new InputStreamReader(input);
                        BufferedReader reader = new BufferedReader(stream);
                        // pause
                        String msg = reader.readLine();

                        OutputStream output = client.getOutputStream();
                        PrintWriter writer = new PrintWriter(output, true);
                        // pause
                        writer.println("Server says: "+ msg);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            };
            thread.start();

        }

    }

}
