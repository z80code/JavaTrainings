package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by igor on 30.07.2015.
 */
public class ReadData {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JButton btn = new JButton("input");
        btn.setSize(200,50);

        final JTextField textField = new JTextField();
        textField.setSize(200,50);

        textField.setBounds(10 +frame.getInsets().left,70+frame.getInsets().top,textField.getWidth(),textField.getHeight());


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 textField.setText(JOptionPane.showInputDialog(null, "sdfsdf"));
            }
        });

        frame.setLayout(null);
        btn.setBounds(10 +frame.getInsets().left,20+frame.getInsets().top,btn.getWidth(),btn.getHeight());
        frame.add(btn);
        frame.add(textField);
        frame.setVisible(true);



    }

}
