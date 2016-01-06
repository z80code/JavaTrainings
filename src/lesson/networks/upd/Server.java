package lesson.networks.upd;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();
        socket.setBroadcast(true);
        //for (int i = 0; i < 10; i++) {

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
                String ss = "bla-bla ";
                System.out.println("send : "+ss);

                Message message = new Message(ss);
                objectOutputStream.writeObject(message);

                byte[] data = outputStream.toByteArray();

                DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8080);
                socket.send(packet);

            }
        //}
    }
}
