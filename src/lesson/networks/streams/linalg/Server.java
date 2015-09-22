package lesson.networks.streams.linalg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Map;

public class Server {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        double[] b = {1, 5, 3, 4};

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

        outputs[activeNode].writeObject(new Pack(Message.Send, new Column(A[0].length, b)));

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


            // Начинаем приводить i-й столбец
            // просим вернуть клиентов стоблец коэффициентов
            Pack diffRows = null;
            for (int node = 0; node < outputs.length; node++) {
                outputs[node].writeObject(new Pack(Message.SolveColumn, new Integer(active)));
                Pack p = (Pack) inputs[node].readObject();
                if (p.getMessage() == Message.DiffRows) {
                    // можно добавить доп, проверку, но я просто буду слать ответ всем
                    diffRows = p;
                }
            }

            // Отправить всем клиентам столбец коэффициентов
            for (int node = 0; node < outputs.length; node++) {
                outputs[node].writeObject(diffRows);

                Pack p = (Pack) inputs[node].readObject();
                if (p.getMessage() != Message.Ok) {
                    throw new RuntimeException("Error, one or more clients, cannot diff rows");
                }
            }

            // дождаться пока они приведут свои столбцы
        }


        // Обратный ход
        // собрать со всех клиентов приведенные столбцы, запустить вычисление последовательно
        // TODO сделать это параллельно

        for (int node = 0; node < outputs.length; node++) {
            outputs[node].writeObject(new Pack(Message.GetColumns));

            Pack p = (Pack) inputs[node].readObject();

            if (p.getMessage() == Message.Result) {

                // TODO лучше результат возвращать объектом
                Map<Integer, Column> result = (Map<Integer, Column>) p.getData();

                // заполняем матрицу А результатом
                for(Integer key: result.keySet()) {

                    Column c = result.get(key);
                    if(c.getIndex()==A[0].length) {
                        b = c.getElements();

                    } else {
                        for(int row =0; row< A.length;row++) {
                            A[row][c.getIndex()] = c.getElements()[row];
                        }
                    }
                }

            }
        }

        System.out.println("===================");
        //вывод матрицы на экран
        for (int i = 0; i <A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
        System.out.println("===================");
        System.out.println(Arrays.toString(b));
        System.out.println("===================");

        // TODO добавить проверку на то, имеет ли система решения
        double[] X = new double[b.length]; //инициализация массива ответов

        for (int i = b.length - 1; i >= 0; i--)
        {
            double h = b[i];// h присваиваем ответ из массива сил
            for (int j = 0; j < b.length; j++)
                h = h - X[j] * A[i][ j]; //вычетание элементов строки матрицы
            X[i] = h / A[i][ i];//h  делим на коэффициент при иксу
        }

        // вывести на экран результат вычисления
        System.out.println(Arrays.toString(X));

        // Дать сигнал на завершение работы всем клиентам
        for (ObjectOutputStream o : outputs) {
            o.writeObject(new Pack(Message.End, null));
        }

        System.out.println("Correct end");

    }
}
