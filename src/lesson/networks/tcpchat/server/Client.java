package lesson.networks.tcpchat.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class Client {

    private PrintWriter out;
    private BufferedReader in;

    private List<Client> clients;

    private boolean isConnected;

    public Client(Socket socket, List<Client> clients) throws IOException {

        // TODO add socket close
        out = new PrintWriter(
                socket.getOutputStream(),true
        );

        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        this.clients = clients;
        isConnected = true;
    }

    public void sendTo(String message) {
        if(isConnected && out!=null) {
            out.println(message);
        }
    }

    public void start() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    while (true ) {
                        String message = in.readLine();

                        for (Client client : clients) {
                            client.sendTo(message);
                        }
                    }

                } catch (IOException e) {
                    isConnected = false;
                    System.out.println("client disconnected");
                }
            }
        });

        thread.start();
    }

}
