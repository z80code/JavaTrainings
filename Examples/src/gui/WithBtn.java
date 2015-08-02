package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithBtn {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel jPanel = new JPanel();
        JPanel jPanel2 = new JPanel();


        JButton btn1 = new JButton();
        btn1.setText("Button");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //jPanel2.repaint();
                //JOptionPane.showMessageDialog(null, "btn 1");
                // display/center the jdialog when the button is pressed
                //JDialog d = new JDialog(frame, "Hello", true);
                //d.setLocationRelativeTo(frame);
                //d.setVisible(true);
            }
        });


        JButton btn2 = new JButton();
        btn2.setText("Draw");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //JOptionPane.showMessageDialog(null, "btn 2");
                //jPanel2.getGraphics().clearRect(0,0,200,400);
                //jPanel2.getGraphics().fillOval(0,0,100,300);

                // display/center the jdialog when the button is pressed
                //JDialog d = new JDialog(frame, "Hello", true);
                //d.setLocationRelativeTo(frame);
                //d.setVisible(true);
            }
        });

        BorderLayout layout = new BorderLayout(10,10);

        frame.setLayout(layout);

        jPanel.setBackground(new Color(255, 0, 0));
        jPanel.setLayout(new GridLayout(1,3));

        jPanel.add(btn1);
        jPanel.add(btn2);

        frame.add(jPanel, BorderLayout.NORTH);

        jPanel2.setBackground(new Color(0, 255, 0));
        frame.add(jPanel2, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
