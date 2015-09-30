package practice.net.chat.server;

import javax.crypto.Cipher;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class Client implements Runnable{

    final private List<Client> clients;
    final private BufferedReader reader;
    private boolean isConnected;

    public boolean isConnected() {
        return isConnected;
    }

    private void connected() {
        isConnected = true;
    }

    private void disconnect() {
        isConnected = false;
    }

    public Client(Socket socket, List<Client> clients) throws IOException {
        this.clients = clients;

        writer = new PrintWriter(socket.getOutputStream(), true);

        InputStream inputStream = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(inputStream));

        connected();
    }

    final private PrintWriter writer;

    public void send( String message ) {
        writer.println(message);
    }

    @Override
    public void run() {


        while (isConnected()) {

            try {
                String message = reader.readLine();

                for(Client client: clients) {
                    if(client!=this) {
                        client.send(message);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
                disconnect();
            }

        }

    }
}
