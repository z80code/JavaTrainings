package practice.soccernext;

import javax.swing.*;
import javax.swing.text.Position;
import javax.swing.text.StringContent;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Scene extends JPanel {

    private Field field;
    private Ball ball;

    Map<String, Player> players = new HashMap<>();

    public Scene(int width, int height) {

        field = new Field(width,height, new Color(144, 199, 6));
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

        if(ball.getPosition().getX() < ball.getRadius()) {
            ball.getPosition().setX(ball.getRadius() +ball.getPosition().getX() );
            ball.setVelocityX( -ball.getVelocityX() );
        }

        //TODO check boundaries
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

        players.forEach((k,v)-> v.updatePosition(time));
        players.forEach(  (k,v) -> updBall(v,time) );
        ball.updatePosition(time);

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

    private void updBall(Player player, float time) {
        //TODO
        Point pp = player.getPosition();
        Point pb = ball.getPosition();
        float dist = distance(pp,pb);

        if(  dist < (player.getRadius() + ball.getRadius() + 2)  ) {

            float dx = -pp.getX() + pb.getX();
            float dy = -pp.getY() + pb.getY();
            float value = Math.abs(dx) + Math.abs(dy);
            getBall().setVelocityX(ball.getVelocityX() + Math.abs( player.getVelocityX()) * (dx / value ));
            getBall().setVelocityY(ball.getVelocityY() + Math.abs(player.getVelocityY()) * (dy / value ));
        }
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(field.getColor());
        g.fillRect(0,0, field.getWidth(),field.getHeight());

        Point p;

        players.forEach((k,v)->drawPlayer(g,v));

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

    public Map<String, Player> getPlayers() {
        return players;
    }
}
