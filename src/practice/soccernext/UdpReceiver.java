package practice.soccernext;


import java.io.IOException;
import java.net.*;

public class UdpReceiver {

    private MulticastSocket listener;
    //private DatagramSocket listener;

    public UdpReceiver() throws IOException {
        listener = new MulticastSocket(8001);
        listener.joinGroup(InetAddress.getByName("224.0.0.2"));
        listener.setSoTimeout(60_000);
    }

    private ReceiveEvent event;
    public void onReceive(ReceiveEvent e) {
        event = e;
    }

    public void startListening() throws IOException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    while (true) {
                        byte[] buff = new byte[512];
                        DatagramPacket packet = new DatagramPacket(buff, buff.length);
                        listener.receive(packet);
                        String s = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
                        //System.out.println(buff.length);
                        //System.out.println(packet.getLength());
                        System.out.println("receive:("+s+")("+s.length()+")");
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

    void close() {
//        socket.leaveGroup(group);
//        socket.close();
    }

}
