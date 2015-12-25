package practice.soccernext;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class UdpHandler implements Handler {

    private MulticastSocket socket;

    public UdpHandler() throws IOException {
        socket = new MulticastSocket();
        //socket.setBroadcast(true);
    }

    @Override
    public void send(String message) throws IOException {
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("224.0.0.2"), 8000);

        //System.out.println("send "+ message);
        socket.setTimeToLive(1);
        //System.out.println("before send: "+ Arrays.toString(data));
        socket.send(packet);
        //System.out.println("send: "+ Arrays.toString(data));
    }
}
