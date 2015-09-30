package practice.net.chat.client;

import java.io.*;
import java.net.*;

public class Client {

    private Socket socket;
    private ReceiveEvent event;
    private SocketAddress address;
    private boolean isConnected;

    public Client(String host, int port) throws UnknownHostException {
          InetAddress inetAddress = Inet4Address.getByName(host);
          address = new InetSocketAddress(inetAddress, port);
    }

    public void setReceiveEvent( ReceiveEvent event ) {
        this.event = event;
    }


    public boolean isConnected() {
        return isConnected;
    }

    private void disconnect() {
        isConnected = false;
    }

    private void connected() {
        isConnected = true;
    }


    private PrintWriter writer;


    public void connect() throws IOException {
        socket = new Socket();
        socket.connect(address);

        writer = new PrintWriter(socket.getOutputStream(), true);

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputReader = new InputStreamReader(inputStream);
        final BufferedReader reader = new BufferedReader(inputReader);

        new Thread(new Runnable() {


            @Override
            public void run() {

                try {

                    while (isConnected()) {
                        String message = reader.readLine();
                        event.receive(message);
                    }

                    isConnected = false;

                } catch (IOException e) {
                    disconnect();
                    e.printStackTrace();
                }

            }
        }).start();

        connected();
    }

    public void send(String message) {
        writer.println(message);
    }

}
