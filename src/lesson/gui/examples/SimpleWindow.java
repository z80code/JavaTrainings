package lesson.gui.examples;

import javax.swing.*;
import java.awt.*;

public class SimpleWindow {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setTitle("My GUI app");

        JButton btn1 = new JButton("My button 1");
        JButton btn2 = new JButton("My button 2");


        JPanel panel = new JPanel();
        panel.setBackground(new Color(49, 46,255));

        JPanel nav = new JPanel();
        nav.setLayout(new FlowLayout());
        nav.add(btn1);
        nav.add(btn2);

        frame.add(nav, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER );

        frame.setVisible(true);

    }

}
