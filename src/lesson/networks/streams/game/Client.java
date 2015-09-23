package lesson.networks.streams.game;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class Client implements ActionListener, Runnable {

    final private JFrame frame;
    final private JButton[][] buttons;
    private Network network;

    public Client() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Game");
        frame.setSize(400,400);
        frame.setResizable(false);
        final int SIZE = 10;
        frame.setLayout(new GridLayout(SIZE,SIZE));

        buttons = new JButton[SIZE][SIZE];

        for (int i = 0, k=0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++, k++) {
                JButton btn = new JButton( );
                btn.setName(i+","+j);
                btn.addActionListener(this);
                buttons[i][j] = btn;
            }
        }

        for (JButton[] button : buttons) {
            for (JButton aButton : button) {
                frame.add(aButton);
            }
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    public void start() {
        Thread serverListener = new Thread(this);
        serverListener.start();
    }

    public void connect() throws IOException {
        network = new Network("127.0.0.1",9000);
    }

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.show();
        client.connect();
        client.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String[] point = button.getName().split(",");
        Hide hide = new Hide(Integer.parseInt(point[0]),Integer.parseInt(point[1]));
        try {
            network.sendMessage(new Msg(Operation.Click, hide));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {

            // TODO сделать не бесконечный цикл
            while (true) {
                Msg msg = network.receiveMessage();

                switch (msg.getOperation()) {
                    case Hide:
                        Hide hide = (Hide) msg.getData();
                        buttons[hide.getI()][hide.getJ()].setVisible(false);
                        break;
                    case Wait:
                        JOptionPane.showMessageDialog(null, "Подождите второго игрока");
                        break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Network {
    final private ObjectOutputStream output;
    final private ObjectInputStream input;

    public Network(String host,int port) throws IOException {
        Socket socket = new Socket();
        SocketAddress address = new InetSocketAddress(Inet4Address.getByName(host),port);
        socket.connect(address);
        input = new ObjectInputStream(socket.getInputStream());
        output = new ObjectOutputStream(socket.getOutputStream());
    }

    public Msg receiveMessage() throws IOException, ClassNotFoundException {
        return (Msg)input.readObject();
    }

    public void sendMessage(Msg msg) throws IOException {
        output.writeObject(msg);
    }
}