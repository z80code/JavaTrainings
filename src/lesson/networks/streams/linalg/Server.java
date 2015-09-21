package lesson.networks.streams.linalg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        double[] b = {1, 2, 3, 4};

        double[][] A = {
                {1, 2, 7, 1},
                {5, 3, 3, 2},
                {2, 1, 2, 3},
                {7, 2, 9, 4}
        };

        Matrix m = new Matrix(A);

        int N = 3;

        ServerSocket serverSocket = new ServerSocket(9000);
        ObjectOutputStream[] outputs = new ObjectOutputStream[N];
        ObjectInputStream[] inputs = new ObjectInputStream[N];


        for (int i = 0; i < N; i++) {
            Socket socket = serverSocket.accept();
            outputs[i] = new ObjectOutputStream(socket.getOutputStream());
            inputs[i] = new ObjectInputStream(socket.getInputStream());
            System.out.println("User connected: " + i);
        }


        int activeNode = 0;

        for (int i = 0; i < A[0].length; i++) {
            outputs[activeNode].writeObject(new Pack(Message.Send, new Column(i, m.getColumn(i))));
            activeNode++;
            activeNode %= N;
        }

        outputs[activeNode].writeObject(new Pack(Message.Send, new Column(-1, b)));

        System.out.println("start solution");

        // проходим по всем столбцам
        for (int active = 0; active < A[0].length; active++) {

            // можно распараллелить брасать в pull который возвращает ответы
            // просим найти максимальный элемент в i строке

            Pack moveOperation = null;
            for (int node = 0; node < outputs.length; node++) {
                outputs[node].writeObject(new Pack(Message.FindMaxRow, new Integer(active)));
                Pack p = (Pack) inputs[node].readObject();
                if (p.getMessage() == Message.Move) {
                    // можно добавить доп, проверку, но я просто буду слать ответ всем
                    moveOperation = p;
                }
            }

            System.out.println(moveOperation.getData());
            // Шлем всем команду переставить строки
            for (int node = 0; node < outputs.length; node++) {
                outputs[node].writeObject(moveOperation);
                Pack p = (Pack) inputs[node].readObject();
                if (p.getMessage() != Message.Ok) {
                    throw new RuntimeException("Error, one or more clients, cannot retake rows");
                }
            }
        }


        for (ObjectOutputStream o : outputs) {
            o.writeObject(new Pack(Message.End, null));
        }

        System.out.println("Correct end");

    }
}
