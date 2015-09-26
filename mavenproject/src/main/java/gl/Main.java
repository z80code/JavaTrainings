package gl;

import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("GL demo");
        frame.setSize(640,480);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GLJPanel gljPanel = new GLJPanel();
        frame.add(gljPanel);
        frame.setVisible(true);

    }

}
