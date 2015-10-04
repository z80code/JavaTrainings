package lesson.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("My Swing Frame");
        frame.setSize(640,480);


        JButton button = new JButton("click me");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "My message");
            }
        });

        button.setSize(400,50);
        frame.setLayout(null);
        frame.add(button);
        frame.setVisible(true);
    }
}
