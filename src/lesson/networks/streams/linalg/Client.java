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

    private static Map<Integer, Column> columns;

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

        columns = new HashMap<>();

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
                    Move move = (Move) pack.getData();
                    for(Integer key: columns.keySet()) {
                        double[] els = columns.get(key).getElements();
                        double tmp = els[move.getFrom()];
                        els[move.getFrom()] = els[move.getTo()];
                        els[move.getTo()] = tmp;
                    }
                    break;
                case End:
                    printColumns(columns);
                    isListen = false;
                    break;
                case FindMaxRow:
                    // можно оптимизировать, чтобы не инициировать перестановку строк, на главной и так максимальная
                    Integer active = (Integer) pack.getData();
                    if(columns.containsKey(active)) {
                        int max = findMaxRos(active);
                        output.writeObject(new Pack(Message.Move, new Move(active, max)));
                    } else {
                        output.writeObject(new Pack(Message.Cannot));
                    }
                    break;

            }
        }

        System.out.println("Correct end");
    }

    public static int findMaxRos(int column) {
        double[] col = columns.get(column).getElements();

        int maxIdx = column;
        for (int i = column; i <col.length; i++) {
            if( Math.abs(col[i]) > Math.abs(col[maxIdx]) ) {
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}
