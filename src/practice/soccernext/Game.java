package practice.soccernext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JFrame {

    public Game() {
        setSize(640, 480);
        setTitle("Soccer");
        setDefaultCloseOperation(
                WindowConstants.EXIT_ON_CLOSE);

        final Scene scene = new Scene(getWidth(), getHeight());
        add(scene);

        final int MIN_FRAMETIME_MSECS = 33;

        Timer timer = new Timer(33, new ActionListener() {

            long prevTime = System.currentTimeMillis();

            @Override
            public void actionPerformed(ActionEvent e) {

                long currTime = System.currentTimeMillis();
                long timeElapsed = currTime - prevTime;
                if (timeElapsed < MIN_FRAMETIME_MSECS) {
                    // Not enough time has elapsed. Let's limit the frame rate
                    try {
                        Thread.sleep(MIN_FRAMETIME_MSECS - timeElapsed);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                    currTime = System.currentTimeMillis();
                    timeElapsed = currTime - prevTime;
                }
                prevTime = currTime;

                float timeSec = timeElapsed / 20;
                scene.update(timeSec);
            }
        });

        timer.start();

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {

                    case KeyEvent.VK_W:
                        scene.getPlayer2().setVelocityY(0);
                        break;
                    case KeyEvent.VK_A:
                        scene.getPlayer2().setVelocityX(0);
                        break;
                    case KeyEvent.VK_S:
                        scene.getPlayer2().setVelocityY(0);
                        break;
                    case KeyEvent.VK_D:
                        scene.getPlayer2().setVelocityX(0);
                        break;
                    case KeyEvent.VK_CONTROL:
                        scene.hitUp(scene.getPlayer2());
                        break;


                    case KeyEvent.VK_UP:
                        scene.getPlayer1().setVelocityY(0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        scene.getPlayer1().setVelocityX(0);
                        break;
                    case KeyEvent.VK_DOWN:
                        scene.getPlayer1().setVelocityY(0);
                        break;
                    case KeyEvent.VK_LEFT:
                        scene.getPlayer1().setVelocityX(0);
                        break;
                    case KeyEvent.VK_SPACE:
                        scene.hitUp(scene.getPlayer1());
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {

                    case KeyEvent.VK_W:
                        scene.getPlayer2().setVelocityY(-scene.getPlayer2().getSpeed());
                        break;
                    case KeyEvent.VK_D:
                        scene.getPlayer2().setVelocityX(scene.getPlayer2().getSpeed());
                        break;
                    case KeyEvent.VK_S:
                        scene.getPlayer2().setVelocityY(scene.getPlayer2().getSpeed());
                        break;
                    case KeyEvent.VK_A:
                        scene.getPlayer2().setVelocityX(-scene.getPlayer2().getSpeed());
                        break;
                    case KeyEvent.VK_CONTROL:
                        scene.hitDown(scene.getPlayer2());
                        break;


                    case KeyEvent.VK_UP:
                        scene.getPlayer1().setVelocityY(-scene.getPlayer1().getSpeed());
                        break;
                    case KeyEvent.VK_RIGHT:
                        scene.getPlayer1().setVelocityX(scene.getPlayer1().getSpeed());
                        break;
                    case KeyEvent.VK_DOWN:
                        scene.getPlayer1().setVelocityY(scene.getPlayer1().getSpeed());
                        break;
                    case KeyEvent.VK_LEFT:
                        scene.getPlayer1().setVelocityX(-scene.getPlayer1().getSpeed());
                        break;
                    case KeyEvent.VK_SPACE:
                        scene.hitDown(scene.getPlayer1());
                        break;
                }
            }

        });

    }

    public void start() {
        setVisible(true);
    }

}
