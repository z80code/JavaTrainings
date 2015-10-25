package lesson.gc;

public class CloneObj {

    public static void main(String[] args) throws CloneNotSupportedException {

        CloneableObject obj1 = new CloneableObject(1);
        CloneableObject obj2 = (CloneableObject) obj1.clone();
        obj1.a = 99;

        System.out.println(obj1);
        System.out.println(obj2);

        CloneableObject[] objects = new CloneableObject[5];
        objects[2] = new CloneableObject(345);

        for(CloneableObject object: objects) {
            System.out.println(object);
        }
    }

}

class CloneableObject implements Cloneable {
    int a;

    public CloneableObject(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "CloneableObject{" +
                "a=" + a +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}