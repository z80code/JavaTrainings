package practice.soccernext;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpHandler implements Handler {

    private DatagramSocket socket;

    public UdpHandler() throws SocketException {
        socket = new DatagramSocket();
    }

    @Override
    public void send(String message) throws IOException {
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8000);
        System.out.println("send "+ message);
        socket.send(packet);
    }
}
