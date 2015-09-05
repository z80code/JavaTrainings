package lesson.gui.examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by igor on 05.09.2015.
 */
public class NullLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setTitle("My GUI app 2");

        JButton btn1 = new JButton("My button 1");
        btn1.setSize(100, 50);

        JButton fd = new JButton();

        Insets insets =  frame.getInsets();

        int leftPosition = 25+ insets.left;

        btn1.setBounds(leftPosition, 5 + insets.top,
                btn1.getSize().width, btn1.getSize().height);


        JButton btn2 = new JButton("My button 2");
        btn2.setSize(200, 50);
        btn2.setBounds(leftPosition, 70 + insets.top,
                btn1.getSize().width, btn1.getSize().height);


        final JPanel panel = new JPanel();
        panel.setLayout(null);


        btn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.printf("click");
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                Graphics g =   panel.getGraphics();
                g.fillOval(e.getX(),e.getY(), 10,10);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }
        });


        panel.add(btn1);
        panel.add(btn2);

        frame.add(panel, BorderLayout.CENTER );

        frame.setVisible(true);
    }
}
