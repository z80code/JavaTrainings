package practice.soccernext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.SocketException;

public class Game extends JFrame {

    public Game(boolean isNetwork) throws IOException {

        if(isNetwork) {
            ActiveHandler.setHandler(new UdpHandler());
        }

        setSize(640, 480);
        setTitle("Soccer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        final Scene scene = new Scene(getWidth()-6, getHeight()-29);
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

        if(!isNetwork) {
            scene.getPlayers().put("player1", new Player(0,0, 20, new Color(17, 18, 255) ));
            scene.getPlayers().put("player2", new Player(0,0, 20, new Color(255, 10, 5) ));
            addKeyListener(new KeyAdapter() {
                Player p1 = scene.getPlayers().get("player1");
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            p1.setVelocityY(-p1.getSpeed());
                            break;
                        case KeyEvent.VK_RIGHT:
                            p1.setVelocityX(p1.getSpeed());
                            break;
                        case KeyEvent.VK_DOWN:
                            p1.setVelocityY(p1.getSpeed());
                            break;
                        case KeyEvent.VK_LEFT:
                            p1.setVelocityX(-p1.getSpeed());
                            break;
                        case KeyEvent.VK_SPACE:
                            scene.hitDown(p1);
                            break;
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            p1.setVelocityY(0);
                            break;
                        case KeyEvent.VK_RIGHT:
                            p1.setVelocityX(0);
                            break;
                        case KeyEvent.VK_DOWN:
                            p1.setVelocityY(0);
                            break;
                        case KeyEvent.VK_LEFT:
                            p1.setVelocityX(0);
                            break;
                        case KeyEvent.VK_SPACE:
                            scene.hitUp(p1);
                            break;
                    }
                }
            });
            addKeyListener(new KeyAdapter() {

                Player p2 = scene.getPlayers().get("player2");

                @Override
                public void keyReleased(KeyEvent e) {
                    switch (e.getKeyCode()) {

                        case KeyEvent.VK_W:
                            p2.setVelocityY(0);
                            break;
                        case KeyEvent.VK_A:
                            p2.setVelocityX(0);
                            break;
                        case KeyEvent.VK_S:
                            p2.setVelocityY(0);
                            break;
                        case KeyEvent.VK_D:
                            p2.setVelocityX(0);
                            break;
                        case KeyEvent.VK_CONTROL:
                            scene.hitUp(p2);
                            break;
                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {

                        case KeyEvent.VK_W:

                            p2.setVelocityY(-p2.getSpeed());
                            break;
                        case KeyEvent.VK_D:
                            p2.setVelocityX(p2.getSpeed());
                            break;
                        case KeyEvent.VK_S:
                            p2.setVelocityY(p2.getSpeed());
                            break;
                        case KeyEvent.VK_A:
                            p2.setVelocityX(-p2.getSpeed());
                            break;
                        case KeyEvent.VK_CONTROL:
                            scene.hitDown(p2);
                            break;
                    }
                }

            });
        } else {
            UdpReceiver receiver = new UdpReceiver();
            receiver.onReceive(new ReceiveEvent() {
                @Override
                public void receive(String message) {
                    String[] s = message.split(":");
                    if(s[0].equals("connect")) {
                        scene.getPlayers().put(s[1], new Player(0,0, 20, new Color(17, 18, 255) ));
                    }
                }
            });
            receiver.startListening();

            ActiveHandler.send("connect");
        }

    }

    public void start() {
        setVisible(true);
    }

}
