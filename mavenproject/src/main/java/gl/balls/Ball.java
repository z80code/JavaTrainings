package gl.balls;

public class Ball {
    private float height;
    private float x;

    public Ball(float height, float x) {
        this.height = height;
        this.x = x;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }


    private float velocity = 0;
    private float g = 9.8f;
    private long lastTime = 0;

    public float getVelocity() {
        return velocity;
    }

    public void updatePosition(long currentTime) {

        if(lastTime!=0) {

            // время замедленно в 100 раз
            float deltaT = (currentTime-lastTime)/1000f;
            //System.out.println(deltaT);
            //v(t) = \frac{d}{dt} x(t)

            height -= velocity * deltaT;
            velocity += g * deltaT;

            if(g>1) {

                if (height < 0) {
                    velocity = -velocity/2;
                    height=0;
                    System.out.println(velocity);

                    if (Math.abs(velocity) <1) {
                        height = 0;
                        velocity = 0;
                        g = 0;
                    }
                    //g = 0;
                }
            }

        }
            lastTime = currentTime;

        //v = s/t
        //a = s/t


    }
}


// F = ma
// F = dp/dt
// p = mv
// F = ma

// F = mg
//