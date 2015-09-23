package lesson.networks.streams.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(9000);


        while (true) {

            final GameContext context = new GameContext();
            Socket socket1 = serverSocket.accept();
            Player player1 = new Player(socket1,context);
            context.setPlayer(player1,0);
            // TODO инкапсулировать запуск слушателя
            Thread thread1 = new Thread(player1);
            thread1.start();

            Socket socket2 = serverSocket.accept();
            Player player2 = new Player(socket2,context);
            context.setPlayer(player2,1);
            Thread thread2 = new Thread(player2);
            thread2.start();

            context.start();
        }

    }
}

class Player implements Runnable {

    final private ObjectOutputStream output;
    final private ObjectInputStream input;
    final private GameContext context;

    public Player(Socket socket, GameContext context) throws IOException {
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
        this.context = context;
    }

    public void send(Msg msg) throws IOException {
        output.writeObject(msg);
    }

    @Override
    public void run() {
        try {
            // TODO сделать не бесконечный цикл
            while (true) {
                Msg msg = (Msg) input.readObject();
                context.doAction(msg, this);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class GameContext {

    private final int N = 10;
    boolean[][] field;
    private Player[] players = new Player[2];
    private boolean isStarted = false;

    public GameContext() {
        this.field = new boolean[N][N];
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = true;
            }
        }
    }

    public void setPlayer(Player player, int number) {
        players[number] = player;
    }

    public void doAction(Msg msg, Player source) {
        try {
            if (!isStarted) {
                source.send(new Msg(Operation.Wait));
            } else {
                if (msg.getOperation() == Operation.Click) {
                    Hide hide = (Hide) msg.getData();
                    if (field[hide.getI()][hide.getJ()]) {
                        players[0].send(new Msg(Operation.Hide, hide));
                        players[1].send(new Msg(Operation.Hide, hide));
                        field[hide.getI()][hide.getJ()] = false;
                    } else {
                        source.send(new Msg(Operation.Decline));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*private boolean click(int i, int j) {

        if (field[i][j]) {
            field[i][j] = false;
            return true;
        }
        return false;
    }*/

    public void start() {
        isStarted = true;
    }


}
