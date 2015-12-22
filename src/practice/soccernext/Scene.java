package practice.soccernext;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;

public class Scene extends JPanel {

    private Field field;
    private Player player1;
    private Player player2;
    private Ball ball;

    public Scene(int width, int height) {

        field = new Field(width,
                height,
                new Color(144, 199, 6));

        player1 = new Player(0,0, 20, new Color(17, 18, 255) );
        player2 = new Player(0,0, 20, new Color(255, 10, 5) );

        ball = new Ball(200,100, 15, new Color(238, 229, 162));
    }

    public float distance(Point p1, Point p2) {

        float xx = p1.getX()-p2.getX();
        float yy = p1.getY()-p2.getY();

        return (float)Math.sqrt(xx*xx + yy*yy);
    }

    public void hitDown(Player player) {
        player.setHit(true);
    }

    public void hitUp(Player player) {
        player.setHit(false);

        Point pp = player.getPosition();
        Point pb = getBall().getPosition();
        float dist = distance(pp, pb);

        int hitRadius = 20;
        if(  dist < (player.getRadius() + 20 + getBall().getRadius())  ) {

            float dx = pb.getX() - pp.getX();
            float dy = pb.getY() - pp.getY();

            float value = Math.abs(dx) + Math.abs(dy);

            int V = 20;

            getBall().setVelocityX(V * (dx / value ));
            getBall().setVelocityY(V * (dy / value ));
        }
    }

    public void update(float time) {
        ball.updatePosition(time);


        if(ball.getPosition().getX() < 0) {
            ball.getPosition().setX( -ball.getPosition().getX() );
            ball.setVelocityX( -ball.getVelocityX() );
        }

        if(ball.getPosition().getY() < 0) {
            ball.getPosition().setY( -ball.getPosition().getY() );
            ball.setVelocityY( -ball.getVelocityY() );
        }


        int wi = ball.getPosition().getX() - field.getWidth();
        if( wi > 0) {
            ball.getPosition().setX(  field.getWidth() - wi );
            ball.setVelocityX( -ball.getVelocityX() );
        }

        int hi = ball.getPosition().getY() - field.getHeight();
        if( hi > 0) {
            ball.getPosition().setY(  field.getHeight() - hi );
            ball.setVelocityY( -ball.getVelocityY() );
        }

        getPlayer1().updatePosition(time);
        getPlayer2().updatePosition(time);

        repaint();
    }


    private void drawPlayer(Graphics g, Player player) {
        Point p = player.getPosition();
        if(player.isHit()) {
            p = player.getPosition();
            g.setColor(new Color(168, 209, 222));
            g.fillOval(p.getX() - (player.getRadius() + 20),
                    p.getY() - (player.getRadius() + 20),
                    (player.getRadius() + 20) * 2,
                    (player.getRadius() + 20) * 2);
        }

        g.setColor(player.getColor());
        p = player.getPosition();
        g.fillOval(p.getX()-player.getRadius(),
                p.getY()-player.getRadius(),
                player.getRadius()*2,
                player.getRadius()*2);
    }

    private void updBall(Player player) {
        //TODO
        Point pp = player.getPosition();
        Point pb = ball.getPosition();
        float dist = distance(pp,pb);

        if(  dist < (player.getRadius() + ball.getRadius())  ) {

            float dx = pb.getX() - pp.getX();
            float dy = pb.getY() - pp.getY();

            ball.move((int)(dx*0.2), (int)(dy*0.2));

        }
    }

    @Override
    public void paint(Graphics g) {

        updBall(player1);
        updBall(player2);

        g.setColor(field.getColor());
        g.fillRect(0,0, field.getWidth(),field.getHeight());


        Point p;
        drawPlayer(g,player1);
        drawPlayer(g,player2);


        g.setColor(ball.getColor());
        p = ball.getPosition();
        g.fillOval(p.getX()-ball.getRadius(),
                p.getY()-ball.getRadius(),
                ball.getRadius()*2,
                ball.getRadius()*2);

    }

    public Ball getBall() {
        return ball;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
