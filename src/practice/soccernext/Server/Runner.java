package practice.soccernext.Server;


import lesson.networks.upd.Message;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Runner {

    public static void main(String[] args) throws IOException {

        int clientCounter = 0;

        MulticastSocket broadcast = new MulticastSocket();
        broadcast.setBroadcast(true);

        MulticastSocket listener = new MulticastSocket(8000);
        listener.joinGroup(InetAddress.getByName("224.0.0.2"));
        listener.setSoTimeout(60_000);
        System.out.println("server was run on 8000");

        while (true) {

            byte[] buff = new byte[512];
            DatagramPacket packet = new DatagramPacket(buff, buff.length);
            listener.receive(packet);

            //System.out.println(packet.getLength());
            //System.out.println(Arrays.toString(packet.getData()));


            String s  = new String(packet.getData(), 0, packet.getLength(), "UTF-8");

            //System.out.println(buff.length);
            //System.out.println(packet.getLength());
            System.out.println("receive:("+s+")("+s.length()+")");

            if(s.startsWith("connect")) {
                String connectMessage = String.format("connect:player%d",clientCounter++);

                DatagramPacket answer = new DatagramPacket(connectMessage.getBytes(), connectMessage.getBytes().length, InetAddress.getByName("224.0.0.2"), 8001);
                broadcast.setTimeToLive(1);
                broadcast.send(answer);

                System.out.println("out:"+connectMessage);
            } else {

                //byte[] bb = String.format("move:player0#%f#%f",1f,3f).getBytes();
                DatagramPacket answer = new DatagramPacket(packet.getData(), packet.getLength(), InetAddress.getByName("224.0.0.2"), 8001);
                //DatagramPacket answer = new DatagramPacket(bb, bb.length, InetAddress.getByName("224.0.0.2"), 8001);
                broadcast.setTimeToLive(1);
                broadcast.send(answer);
                //System.out.println("out:"+new String(packet.getData()));
            }
        }


    }
}
