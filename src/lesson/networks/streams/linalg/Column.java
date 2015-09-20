package lesson.networks.streams.linalg;

import java.io.Serializable;

public class Column implements Serializable{

    private int index;
    private double[] elements;

    public Column(int index, double[] elements) {
        this.index = index;
        this.elements = elements;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double[] getElements() {
        return elements;
    }

    public void setElements(double[] elements) {
        this.elements = elements;
    }
}
