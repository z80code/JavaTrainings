package lesson.gui.forms;

import javax.swing.*;

/**
 * Created by igor on 29.09.2015.
 */
public class Window {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("window");
        frame.setSize(640,480);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
