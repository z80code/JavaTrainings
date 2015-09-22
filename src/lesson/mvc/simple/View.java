package lesson.mvc.simple;

import javax.swing.*;
import javax.swing.text.StringContent;
import java.awt.*;

/**
 * Created by igor on 17.09.2015.
 */
public class View extends JFrame{

    Controller controller = new Controller(this);

    public void updateText(String string) {
        this.area.setText(string);
    }

    private JButton button1 = new JButton("One");
    private JButton button2 = new JButton("Two");
    private JTextArea area = new JTextArea();

    {
        button1.addActionListener(controller);
        button2.addActionListener(controller);

        this.add(button1, BorderLayout.NORTH);
        this.add(button2, BorderLayout.SOUTH);
        this.add(area, BorderLayout.CENTER);
    }
}
