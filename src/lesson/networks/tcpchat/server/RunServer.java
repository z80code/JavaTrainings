package lesson.networks.tcpchat.server;

import lesson.networks.streams.linalg.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class RunServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        List<Client> clients = new ArrayList<>();

        while (true) {
            Socket socket = serverSocket.accept();
            Client client = new Client(socket, clients);
            clients.add(client);
            client.start();
        }
    }
}
