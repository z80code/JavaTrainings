package practice.soccernext;

import java.awt.*;

public class Player {

    private Point position;
    private int radius;
    private Color color;

    public Player(int x, int y, int radius, Color color) {
        this(new Point(x,y),radius,color);
    }

    public Player(Point position, int radius, Color color) {
        this.position = position;
        this.radius = radius;
        this.color = color;
    }

    public void move(int stepByX, int stepByY) {
        position.setX( position.getX() + stepByX );
        position.setY( position.getY() + stepByY );
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
