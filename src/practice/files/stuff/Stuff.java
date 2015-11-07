package practice.files.stuff;

public class Stuff implements Comparable<Stuff> {

    private String type;
    private int count;

    public Stuff(String type, int count) {
        setType(type);
        setCount(count);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {

        if(count<0)
            throw new IllegalArgumentException("count cannot be < 0");

        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("Stuff[%s,%d]", type, count);
    }

    @Override
    public int compareTo(Stuff o) {
        return Integer.compare(this.getCount(), o.getCount());
    }
}
