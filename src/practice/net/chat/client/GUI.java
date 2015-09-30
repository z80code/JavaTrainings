package practice.net.chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.UnknownHostException;

public class GUI {

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        frame.setSize(240,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);

        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        final JTextField messageField = new JTextField(10);
        JButton sendBtn = new JButton("Send");

        final Client client = new Client("127.0.0.1", 9000);
        client.connect();
        client.setReceiveEvent(new ReceiveEvent() {
            @Override
            public void receive(String message) {
                model.add(0, message);
            }
        });


        sendBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText().trim();
                messageField.setText("");
                if(message.length()>0&&client.isConnected()) {
                    model.add(0, message);
                    client.send(message);
                }
            }
        });


        JPanel panel = new JPanel();
        panel.add(messageField, BorderLayout.CENTER);
        panel.add(sendBtn, BorderLayout.EAST);
        frame.add(panel, BorderLayout.SOUTH);


        frame.setVisible(true);
    }
}
