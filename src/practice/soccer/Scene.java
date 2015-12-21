package practice.soccer;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {

    private Field field;
    private Player player;
    private Ball ball;

    public Scene(int width, int height) {

        field = new Field(width,
                height,
                new Color(144, 199, 6));

        player = new Player(0,0, 40, new Color(255, 255, 255), 200);

        ball = new Ball(200,100, 30, new Color(237, 238, 59));
    }

    public float distance(Point p1, Point p2) {

        float xx = p1.getX()-p2.getX();
        float yy = p1.getY()-p2.getY();

        return (float)Math.sqrt(xx*xx + yy*yy);
    }


    private void checkBoundaries() {
        int radius = player.getRadius();

        if(player.getPosition().getX() < radius ) {
            player.getPosition().setX(radius);
        }

        if(player.getPosition().getY() < radius ) {
            player.getPosition().setY(radius);
        }

        if(player.getPosition().getX()> (field.getWidth()-radius)) {
            player.getPosition().setX( field.getWidth()-radius );
        }

        if(player.getPosition().getY()> (field.getHeight()-radius)) {
            player.getPosition().setY( field.getHeight()-radius );
        }
    }

    private void processCollision() {
        int radius = ball.getRadius();

        if(ball.getPosition().getX()<radius) {
            ball.getPosition().setX ( radius );
            ball.setVelocityX(  - ball.getVelocityX() );
        }

        if(ball.getPosition().getY()<radius) {
            ball.getPosition().setY ( radius );
            ball.setVelocityY(  - ball.getVelocityY() );
        }

        if(ball.getPosition().getX() > (field.getWidth()- radius)) {
            ball.getPosition().setX(field.getWidth()-radius);
            ball.setVelocityX(  - ball.getVelocityX() );
        }

        if(ball.getPosition().getY() > (field.getHeight()- radius)) {
            ball.getPosition().setY(field.getHeight()-radius);
            ball.setVelocityY(  - ball.getVelocityY() );
        }


    }

    public void update(float time) {

        ball.updatePosition(time);
        checkBoundaries();
        processCollision();
        repaint();
    }


    @Override
    public void paint(Graphics g) {

        //TODO
        Point pp = player.getPosition();
        Point pb = ball.getPosition();
        float dist = distance(pp,pb);

        if(  dist < (player.getRadius() + ball.getRadius())  ) {


            float dx = pb.getX() - pp.getX();
            float dy = pb.getY() - pp.getY();

            ball.move((int)(dx*0.2), (int)(dy*0.2));
        }


        g.setColor(field.getColor());
        g.fillRect(0,0, field.getWidth(),field.getHeight());


        Point p;
        // draw hit field
        if(player.isHit()) {
            g.setColor(new Color(129, 208, 208));
            p = player.getPosition();
            g.fillOval(p.getX() - player.getHitRadius(),
                    p.getY() - player.getHitRadius(),
                    player.getHitRadius() * 2,
                    player.getHitRadius() * 2);
        }

        // draw player
        g.setColor(player.getColor());
        p = player.getPosition();
        g.fillOval(p.getX()-player.getRadius(),
                p.getY()-player.getRadius(),
                player.getRadius()*2,
                player.getRadius()*2);

        g.setColor(ball.getColor());
        p = ball.getPosition();
        g.fillOval(p.getX()-ball.getRadius(),
                p.getY()-ball.getRadius(),
                ball.getRadius()*2,
                ball.getRadius()*2);

    }

    public Player getPlayer() {
        return player;
    }

    public Ball getBall() {
        return ball;
    }
}
