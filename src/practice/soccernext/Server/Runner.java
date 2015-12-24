package practice.soccernext.Server;


import lesson.networks.upd.Message;

import java.io.*;
import java.net.*;

public class Runner {

    public static void main(String[] args) throws IOException {

        int clientCounter = 0;

        DatagramSocket broadcast = new DatagramSocket();
        broadcast.setBroadcast(true);

        byte[] buff = new byte[64];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        DatagramSocket listener = new DatagramSocket(8000);
        listener.setSoTimeout(60_000);
        System.out.println("server was run on 8000");

        while (true) {
            listener.receive(packet);

            String s = new String(packet.getData());
            System.out.println("in:"+s);
            if(s.startsWith("connect")) {
                String connectMessage = String.format("connect:player%d",clientCounter++);
                byte[] data = connectMessage.getBytes();
                DatagramPacket answer = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8001);
                broadcast.send(answer);
                System.out.println("out"+connectMessage);
            } else {
                DatagramPacket answer = new DatagramPacket(packet.getData(), packet.getLength(), InetAddress.getLocalHost(), 8001);
                broadcast.send(answer);
                System.out.println("out"+new String(packet.getData()));
            }
        }


    }
}
