package practice.soccer;

import java.awt.*;

public class Ball {

    private Point position;
    private int radius;
    private Color color;
    private float velocityX;
    private float velocityY;

    public Ball(int x, int y, int radius, Color color) {
        this(new Point(x,y), radius, color);
    }

    public Ball(Point position, int radius, Color color) {
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

    public float getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }
}
