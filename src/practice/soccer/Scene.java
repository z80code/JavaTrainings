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

        player = new Player(0,0, 40, new Color(255, 255, 255) );

        ball = new Ball(200,100, 30, new Color(237, 238, 59));
    }

    private float distance(Point p1, Point p2) {

        float xx = p1.getX()-p2.getX();
        float yy = p1.getY()-p2.getY();

        return (float)Math.sqrt(xx*xx + yy*yy);
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

            ball.move((int)(dx*0.1), (int)(dy*0.1));

        }


        g.setColor(field.getColor());
        g.fillRect(0,0, field.getWidth(),field.getHeight());

        g.setColor(player.getColor());

        Point p = player.getPosition();
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
}
