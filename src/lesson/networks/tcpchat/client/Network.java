package lesson.networks.tcpchat.client;

import lesson.types.StringBuilderExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Network {

    private String host;
    private int port;

    private Socket socket;

    private PrintWriter out;
    private BufferedReader in;

    public Network(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {

        socket = new Socket();

        SocketAddress address
                = new InetSocketAddress(host,port);

        socket.connect(address);

        out = new PrintWriter(socket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        try {

                            while (true) {

                                String message = in.readLine();

                                //TODO !!!!
                                if(receiveListener==null) {
                                    break;
                                }

                                receiveListener.action(message);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
        );

        thread.start();
    }

    public void send(String message) {
        if(out!=null) {
            out.println(message);
        }
    }

    private ReceiveListener receiveListener;

    public void setReceiveListener(ReceiveListener listener) {
        receiveListener = listener;
    }
}