package lesson.networks.streams.sctp;

import com.sun.nio.sctp.SctpServerChannel;

import java.io.IOException;
import java.net.InetSocketAddress;

// http://www.oracle.com/technetwork/articles/javase/index-139946.html
public class Ex {
    private static final int SERVER_PORT = 9000;

    public static void main(String[] args) throws IOException {
          SctpServerChannel ssc = SctpServerChannel.open();
          InetSocketAddress serverAddr = new InetSocketAddress(SERVER_PORT);
          ssc.bind(serverAddr);




    }
}
