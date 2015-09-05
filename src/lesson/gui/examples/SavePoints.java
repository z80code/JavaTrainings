package lesson.gui.examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;


public class SavePoints {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setTitle("My GUI app 3");

        final DrawPanel panel = new DrawPanel();

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.addPoint( new Point(e.getX(),e.getY())   );
            }
        });

        frame.add(panel, BorderLayout.CENTER );
        frame.setVisible(true);
    }
}

class DrawPanel extends JPanel {

    private List<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
        this.repaint();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Point point : points) {
            g.fillOval(point.x, point.y, 10, 10);
        }
    }

}



