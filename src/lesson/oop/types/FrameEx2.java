package lesson.oop.types;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class FrameEx2 extends JFrame {

    private DrawPanel panel;

    public FrameEx2() {
        setTitle("My app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);

        panel = new DrawPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.drawRect(0, 0, 10, 50);
            }
        };

        // определить свой класс панели унаследованной от JPanel
        // определить класс Point
        // внутри класса своей панели хранить список List точек


        panel.setBackground(new Color(208, 196, 255));
        add(panel);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //JOptionPane.showMessageDialog(null, "Click! : "+e.getPoint());
                //Graphics g = panel.getGraphics();
                //g.fillOval(e.getX(), e.getY(), 10, 10);

                panel.addPoint( new Point(/*e.getX, e.getY*/) );
                panel.repaint();
            }
        });
    }

    public static void main(String[] args) {
        FrameEx2 frameEx2 = new FrameEx2();
        frameEx2.setVisible(true);
    }

}

class Point {
    // x
    // y
}

class DrawPanel extends JPanel {

    private ArrayList<Point> points;

    public void addPoint(Point p) {
        // добавить в список
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // пройти по списку и нарисовать все точки

    }
}
