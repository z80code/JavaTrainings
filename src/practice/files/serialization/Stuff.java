package practice.files.serialization;

import java.io.*;

//Serializable
public class Stuff implements Comparable<Stuff>, Externalizable {

    private static final long serialVersionUID = 2L;

    // не сериилзуются transient и static
    private String type;
    private int count;

    public Stuff() {}

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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(count);
        out.writeUTF("other info");
        out.writeUTF(type);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        count = in.readInt();
        in.readUTF();
        type = in.readUTF();
    }
}
