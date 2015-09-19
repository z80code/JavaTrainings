package lesson.networks.streams.sendobj;


import com.sun.corba.se.pept.encoding.InputObject;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9000);
        final Storage storage = new Storage("d:/database.txt");

        while (true) {
            final Socket socket = serverSocket.accept();

            Thread thread = new Thread() {
                @Override
                public void run() {

                    try {


                        InputStream stream = socket.getInputStream();
                        ObjectInputStream objStream = new ObjectInputStream(stream);

                        while (socket.isConnected()) {
                            Record record = (Record) objStream.readObject();
                            storage.writeRecord(record);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            };
            thread.start();
        }
    }
}