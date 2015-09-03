package lesson.gui.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by igor on 03.08.2015.
 */
public class BoxDraw {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        final JPanel panel = new JPanel();
        frame.add(panel);

        frame.setVisible(true);
        final Graphics g = panel.getGraphics();

        final boolean[] isPresed = {false};
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isPresed[0] = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                isPresed[0] = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                isPresed[0] = false;
            }
        });
        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if(isPresed[0]) {
                    //g.clearRect(0,0,400,400);

                    g.fillOval(e.getX() - 5, e.getY() - 5, 10, 10);
                }
            }
        });
        //



    }
}