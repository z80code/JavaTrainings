package lesson.networks.upd;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;


public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] buff = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buff,1024);

        DatagramSocket socket = new DatagramSocket(8080);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        socket.setSoTimeout(10_000);

        boolean isError = false;

        try {
            while (!isError) {
                socket.receive(packet);
                stream.write(packet.getData());
            }
        } catch (SocketTimeoutException e) {
            System.out.println(e.getMessage());
        }

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(stream.toByteArray()));
        Message message = (Message) objectInputStream.readObject();
        System.out.println(message.getText());


    }
}
