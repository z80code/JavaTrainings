package practice.soccernext;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpReceiver {

    private DatagramSocket listener;

    public UdpReceiver() throws IOException {
        listener = new DatagramSocket(8001);
        listener.setSoTimeout(60_000);
    }

    private ReceiveEvent event;
    public void onReceive(ReceiveEvent e) {
        event = e;
    }

    public void startListening() throws IOException {
        byte[] buff = new byte[64];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        listener.receive(packet);
                        String s = new String(packet.getData());
                        if(event!=null) {
                            event.receive(s);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
