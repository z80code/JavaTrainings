package codepractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Ball {

    // TODO задание 1 сделать чтобы шарик летел еще и по оси X, т.е. он теперь будет ударяться о стенки еще и боковые
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        // TODO почитать что это за классы
        final int WINDOW_HEIGHT = 300;
        final int WINDOW_WIDTH = 460;
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setTitle("Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Graphics g = frame.getGraphics();

        // TODO разобраться почему здесь использованы массивы из одного элемента
        // TODO улучшить, т.е. хранить эти параметны в некотором объекте
        final int[] x = {200};
        final int[] y = {50};

        int size = 50;
        // HINT: нужно добавить шаг по OX
        final int[] step = {2};

        Timer timer = new Timer(20, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear old image

                g.clearRect(0,0, WINDOW_WIDTH,WINDOW_HEIGHT);
                g.setColor(new Color(0, 54, 166));
                g.fillOval(x[0], y[0],size,size);
                y[0] += step[0];

                // HINT нужно проверять и по оси OX
                if(y[0] > WINDOW_HEIGHT-size) {
                    step[0] =-step[0];
                } else if(y[0]<size/2) {
                    step[0] =-step[0];
                }
            }
        });

        timer.start();
    }
}

// TODO придумать что-то свое с рисованием, код на github
// TODO (повышенной сложности) попробовать добавить события на кнопки

//String input = JOptionPane.showInputDialog("Enter n:");
//int n = Integer.parseInt(input);
