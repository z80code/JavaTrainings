package lesson.types;


public class Classes {
    public static void main(String[] args) {
        JustClass one = new JustClass();
        JustClass two = new JustClass(123, "sdf");

        System.out.println(one);
        System.out.println(two);
    }
}

class JustClass {
    private int number;
    private String name;

    public JustClass() { }

    public JustClass(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return String
                .format("JustClass {%s, %d}", name,number);
    }
}
