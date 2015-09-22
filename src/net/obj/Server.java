package net.obj;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9000);
        final Storage storage = new Storage("D:/db.txt");

        while (true) {
            Socket client = serverSocket.accept();
            ServeThread serveThread = new ServeThread(client, storage);
            serveThread.start();
        }

    }
}

class ServeThread extends Thread {

    final private Socket socket;
    final private Storage storage;

    public ServeThread(Socket socket, Storage storage) {
        this.socket = socket;
        this.storage = storage;
    }

    @Override
    public void run() {

        try {
            InputStream input = socket.getInputStream();
            ObjectInputStream stream = new ObjectInputStream(input);

            while (socket.isConnected()) {
                Record record = (Record)stream.readObject();
                storage.writeRecord(record);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}