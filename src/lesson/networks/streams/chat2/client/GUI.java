package lesson.networks.streams.chat2.client;

import javax.swing.*;
import javax.swing.text.StringContent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Scanner;

public class GUI {

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        frame.setSize(300,400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("My chat");

        final DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);
        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        /*
        model.addElement("sdf");
        model.addElement("345");
        model.add(0,"888");*/

        JPanel panel = new JPanel();
        final JTextField messageTf = new JTextField(15);
        JButton sentBtn = new JButton();

        panel.add(messageTf, BorderLayout.CENTER);
        panel.add(sentBtn, BorderLayout.EAST);

        sentBtn.setText("Send");





        final Client client = new Client("127.0.0.1", 9000);
        //Client client = new Client("192.168.0.106", 9000);

        client.setReceiveAction(new ReceiveAction() {
            @Override
            public void receive(String message) {
                model.add(0,"You: "+message);
            }
        });

        client.connect();


        sentBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(messageTf.getText().trim().length()>0) {

                    String msg = messageTf.getText().trim();
                    model.add(0,"You: "+msg);
                    messageTf.setText("");
                    client.send(msg);
                }
            }
        });




        frame.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);


    }

}
