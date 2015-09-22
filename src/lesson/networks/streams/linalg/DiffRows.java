package lesson.networks.streams.linalg;

import java.io.Serializable;

public class DiffRows implements Serializable{

    private int active;
    private double[] elements;

    public DiffRows(int active, double[] elements) {
        this.active = active;
        this.elements = elements;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public double[] getElements() {
        return elements;
    }

    public void setElements(double[] elements) {
        this.elements = elements;
    }
}
