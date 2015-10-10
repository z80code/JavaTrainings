package practice.inc;

import javax.swing.*;
import java.awt.*;

public class FrameInlineImpl {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.black);
                g.fillRect(0,0, 100,100);
            }
        };

        frame.add(panel);

        frame.setVisible(true);

         /*Graphics g = panel.getGraphics();
         g.setColor(Color.black);
         g.fillRect(0,0, 100,100);
         frame.paint(g);*/


    }
}
