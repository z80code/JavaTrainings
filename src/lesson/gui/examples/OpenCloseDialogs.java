package lesson.gui.examples;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

public class OpenCloseDialogs {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setTitle("My GUI app 2");

        JButton btn1 = new JButton("My button 1");
        btn1.setSize(100, 50);

        btn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JColorChooser.showDialog(null, "sdf", new Color(0,0,0));

                /*JFileChooser chooser = new JFileChooser();
                int status = chooser.showSaveDialog(null);


                if(status==JFileChooser.APPROVE_OPTION) {

                    String name = chooser.getSelectedFile().getAbsolutePath();
                    JOptionPane.showMessageDialog(null, name);

                }*/

                /*JFileChooser chooser = new JFileChooser();
                int status = chooser.showOpenDialog(null);

                if(status==JFileChooser.APPROVE_OPTION) {

                    String name = chooser.getSelectedFile().getAbsolutePath();
                    JOptionPane.showMessageDialog(null, name);

                }*/

            }
        });

        frame.add(btn1, BorderLayout.NORTH);
        frame.setVisible(true);
    }

}
