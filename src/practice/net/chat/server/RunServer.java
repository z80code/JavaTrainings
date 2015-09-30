package practice.net.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Client> clients = new ArrayList<>();

        while (!serverSocket.isClosed()) {

            Socket socket = serverSocket.accept();
            Client client = new Client(socket,clients);
            clients.add(client);
            // Задача выполняется параллельно
            pool.submit(client);
        }

        pool.shutdown();
    }
}
