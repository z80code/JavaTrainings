package oopbegin;

/**
 * Created by igor on 02.08.2015.
 */
public class Run {

    public static void main(String[] args) {
        Temperature t = new Temperature();
        t.setValue(500);
        System.out.println(t.getValue());
        System.out.println(t);
    }

}

class Temperature {

    private float value;


    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        if(value<0) {
            RuntimeException e = new RuntimeException("Bad value!");
            throw e;
        } else {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return String.format("{value: %f }", value) ;
    }
}
