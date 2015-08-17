package gui;

import sun.print.PeekGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by igor on 30.07.2015.
 */
public class GUI {

    final static int WINDOW_WIDTH = 400;
    final static int WINDOW_HEIGHT = 400;

    public static boolean checkBorderX(Ball ball, int fieldWidth) {

        int ballX = ball.getPosition().getX();

        if( ballX < 0 || ballX+ball.getD() > fieldWidth) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkBorderY(Ball ball, int fieldHeight) {

        int ballY = ball.getPosition().getY();

        if( ballY < 0 || ballY+ball.getD() > fieldHeight) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {

        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("My window");
        frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        frame.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();

        Ball ball = new Ball(new Position(50,0), 70, new Color(255,0,0));
        final Racquet racquet = new Racquet(
                100,
                20,
                new Position(WINDOW_WIDTH/2, WINDOW_HEIGHT-10),
                new Color(0,0,255) );








       frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_LEFT ) {
                    racquet.moveLeft();
                }

                if(e.getKeyCode() == KeyEvent.VK_RIGHT ) {
                    racquet.moveRight();
                }
            }
        });



        final DrawPanel mainPanel = new DrawPanel(ball, racquet);

        topPanel.setLayout(new FlowLayout());

        JButton btn1 = new JButton();
        btn1.setText("Create Ball");

        // 0 - speed OX
        // 1 - speed OY
        final int[] speed = new int[2];

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Ball ball = mainPanel.getBall();
                if(ball!=null) {

                    if( checkBorderX(ball, mainPanel.getWidth() ) ) {
                        ball.move(speed[0], 0);
                    } else {
                        speed[0] =-speed[0];
                        ball.move(speed[0], 0);
                    }

                    if( checkBorderY(ball, mainPanel.getHeight() )) {
                        ball.move(0, speed[1]);
                    } else {
                        speed[1] =-speed[1];
                        ball.move(0, speed[1]);
                    }

                }

                mainPanel.repaint();

            }
        });
        timer.start();





        topPanel.add(btn1);

        JButton btn2 = new JButton();
        btn2.setText("Add speed x");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speed[0]+=2;
            }
        });

        topPanel.add(btn2);

        JButton btn3 = new JButton();
        btn3.setText("Add speed y");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speed[1]+=2;
               // mainPanel.getBall().move(0,5);
            }
        });

        topPanel.add(btn3);

        mainPanel.setBackground(new Color(152, 176, 255));
        topPanel.setBackground(new Color(1,255,1));

        //frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class Ball {
    private Position position;
    private int d;
    private Color color;

    public Ball(Position position, int d, Color color) {
        this.position = position;
        this.d = d;
        this.color = color;
    }

    public void move(int dx, int dy) {
        position.setX(  position.getX() + dx  );
        position.setY(position.getY() + dy);
    }

    public Position getPosition() {
        return position;
    }

    public int getD() {
        return d;
    }

    public Color getColor() {
        return color;
    }
}

class Racquet {
    private int width;
    private int height;
    private Position position;
    private Color color;

    private int step = 5;

    public Racquet(int width, int height, Position position, Color color) {
        this.width = width;
        this.height = height;
        this.position = position;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Center of Racquet
     * @return
     */
    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public void moveRight() {
        position.setX(  position.getX() + step  );
    }

    public void moveLeft() {
        position.setX(  position.getX() - step  );
    }
}

class DrawPanel extends JPanel {

    private Ball ball;
    private Racquet racquet;

    public DrawPanel(Ball ball, Racquet racquet) {
        this.ball = ball;
        this.racquet = racquet;
    }

    public Ball getBall() {
        return ball;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if(ball!=null) {
            g.setColor(  ball.getColor()  );
            Position p = ball.getPosition();
            g.fillOval( p.getX(), p.getY(), ball.getD(), ball.getD() );
        }

        if(racquet!=null) {
            g.setColor(  racquet.getColor()  );
            Position p = racquet.getPosition();

            int deltaX = racquet.getWidth()/2;
            int deltaY = racquet.getHeight()/2;

            g.fillRect(p.getX()-deltaX, this.getHeight()-racquet.getHeight(), racquet.getWidth(), racquet.getHeight() );
        }
    }

}