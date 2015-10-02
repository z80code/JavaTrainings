package lesson.networks.streams.linalg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server {

    public static double[] getRandomIntegerVector(int dim, int seed, int maxValue) {
        Random r = new Random(1);

        double[] A = new double[dim];
        for (int i = 0; i < A.length; i++) {
            A[i] = r.nextInt(maxValue);
        }

        return A;
    }

    public static double[][] getRandomIntegerMatrix(int dim, int seed, int maxValue) {

        Random r = new Random(1);

        double[][] A = new double[dim][dim];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = r.nextInt(maxValue);
            }
        }

        return A;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        int port = 9000;
        int MDIM = 2000;
        int N = 2;

        if(args.length >=3) {
            try {
                port =  Integer.parseInt(args[0]);
                MDIM =  Integer.parseInt(args[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.format("Server run with default params. Listening port: %d, Matrix dimension: %d, waiting %d clients", port, MDIM, N);
        }

        //double[] b = {1, 5, 3, 4};

//        double[][] A = {
//                {1, 2, 7, 1},
//                {5, 3, 3, 2},
//                {2, 1, 2, 3},
//                {7, 2, 9, 4}
//        };


        final double[][] A = getRandomIntegerMatrix(MDIM, 1, 1000);
        final double[] b = getRandomIntegerVector(MDIM, 1, 1000);


//        double[] b = {2, 3, 4, 5, 6};
//
//        double[][] A = {
//                {2, 5, 4, 1, 6},
//                {5, 3, 7, 8, 4},
//                {4, 7, 6, 7, 3},
//                {1, 8, 7, 8, 2},
//                {6, 4, 3, 2, 1}
//        };


        Matrix m = new Matrix(A);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = new ServerSocket(port);
        final ObjectOutputStream[] outputs = new ObjectOutputStream[N];
        final ObjectInputStream[] inputs = new ObjectInputStream[N];

        for (int i = 0; i < N; i++) {
            Socket socket = serverSocket.accept();
            outputs[i] = new ObjectOutputStream(socket.getOutputStream());
            inputs[i] = new ObjectInputStream(socket.getInputStream());
            System.out.println("User connected: " + i);
        }

        long start = System.currentTimeMillis();
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

            // просим найти максимальный элемент в i строке
            Pack moveOperation = null;
            for (int node = 0; node < outputs.length; node++) {
                outputs[node].writeObject(new Pack(Message.FindMaxRow, new Integer(active)));
                Pack p = (Pack) inputs[node].readObject();
                if (p.getMessage() == Message.Move) {
                    moveOperation = p;
                }
            }


            final CountDownLatch latch1 = new CountDownLatch(N);
            // Шлем всем команду переставить строки
            for (int node = 0; node < outputs.length; node++) {

                final int finalNode = node;
                final Pack finalMoveOperation = moveOperation;
                pool.submit(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            outputs[finalNode].writeObject(finalMoveOperation);
                            Pack p = (Pack) inputs[finalNode].readObject();

                            if (p.getMessage() != Message.Ok) {
                                throw new RuntimeException("Error, one or more clients, cannot retake rows");
                            }

                            latch1.countDown();

                        } catch (ClassNotFoundException | IOException e) {
                            e.printStackTrace();
                        }

                    }
                });


            }

            latch1.await();
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

            final CountDownLatch latch = new CountDownLatch(N);
            // Отправить всем клиентам столбец коэффициентов
            for (int node = 0; node < outputs.length; node++) {

                //TODO в пул

                final Pack finalDiffRows = diffRows;
                final int finalNode = node;
                pool.submit(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    outputs[finalNode].writeObject(finalDiffRows);

                                    Pack p = (Pack) inputs[finalNode].readObject();

                                    latch.countDown();
                                    if (p.getMessage() != Message.Ok) {
                                        throw new RuntimeException("Error, one or more clients, cannot diff rows");
                                    }

                                } catch (IOException | ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                );

            }

            latch.await();

            // дождаться пока они приведут свои столбцы
        }

        // Обратный ход
        // собрать со всех клиентов приведенные столбцы, запустить вычисление последовательно

        final CountDownLatch latch3 = new CountDownLatch(N);

        for (int node = 0; node < outputs.length; node++) {

            final int finalNode = node;
            pool.submit(new Runnable() {
                @Override
                public void run() {


                    try {
                        outputs[finalNode].writeObject(new Pack(Message.GetColumns));
                        Pack p = (Pack) inputs[finalNode].readObject();

                        if (p.getMessage() == Message.Result) {

                            // TODO лучше результат возвращать объектом
                            Map<Integer, Column> result = (Map<Integer, Column>) p.getData();

                            // заполняем матрицу А результатом
                            for (Integer key : result.keySet()) {

                                Column c = result.get(key);
                                if (c.getIndex() == A[0].length) {
                                    System.arraycopy(c.getElements(), 0, b, 0, c.getElements().length);
                                } else {
                                    for (int row = 0; row < A.length; row++) {
                                        A[row][c.getIndex()] = c.getElements()[row];
                                    }
                                }
                            }
                        }
                        latch3.countDown();
                    } catch (ClassNotFoundException | IOException e) {
                        e.printStackTrace();
                    }
                }


            });
        }

        latch3.await();

//        System.out.println("===================");
//        //вывод матрицы на экран
//        for (int i = 0; i <A.length; i++) {
//            System.out.println(Arrays.toString(A[i]));
//        }
//        System.out.println("===================");
//        System.out.println(Arrays.toString(b));
//        System.out.println("===================");

        // TODO добавить проверку на то, имеет ли система решения
        double[] X = new double[b.length]; //инициализация массива ответов

        for (int i = b.length - 1; i >= 0; i--) {
            double h = b[i];// h присваиваем ответ из массива сил
            for (int j = 0; j < b.length; j++)
                h = h - X[j] * A[i][j]; //вычетание элементов строки матрицы
            X[i] = h / A[i][i];//h  делим на коэффициент при иксу
        }

        long end = System.currentTimeMillis();
        System.out.println("time elapsed: "+(end - start));
        // вывести на экран результат вычисления
        //System.out.println(Arrays.toString(X));

        // Дать сигнал на завершение работы всем клиентам
        for (ObjectOutputStream o : outputs) {
            o.writeObject(new Pack(Message.End, null));
        }

        System.out.println("Correct end");

        pool.shutdown();

        // Save results
        try(PrintWriter writer = new PrintWriter("result.txt")) {
            writer.println(Arrays.toString(X));
        }
    }
}
