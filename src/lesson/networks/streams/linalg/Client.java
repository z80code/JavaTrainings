package lesson.networks.streams.linalg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Client {

    public static void printColumns(Map<Integer, Column> map) {
        for(Column c : map.values()) {
            System.out.printf("%d -> %s\n", c.getIndex(), Arrays.toString(c.getElements()));
        }
    }

    public static void printColumn(Column column) {
        System.out.printf("%d -> %s\n", column.getIndex(), Arrays.toString(column.getElements()));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 9000));

        System.out.println("Connected");

        Map<Integer, Column> columns = new HashMap<>();

        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

        boolean isListen = true;
        while (isListen) {
            Pack pack = (Pack)input.readObject();
            switch (pack.getMessage()) {

                case Send:
                    Column column = (Column)pack.getData();
                    columns.put(column.getIndex(), column);
                    //printColumn(column);
                    break;
                case Move:
                    break;
                case End:
                    printColumns(columns);
                    isListen = false;
                    break;
            }
        }

        System.out.println("Correct end");
    }

}
