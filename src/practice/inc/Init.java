package practice.inc;

public class Init {

    int value = 2;
    static int staticValue = 1;

    public static void main(String[] args) {
        System.out.println("create obj");
        Init2 init = new Init2();

        System.out.println(init);
        System.out.println("=======");

        Init2 init2 = new Init2();
        System.out.println(init2);

        System.out.println("=======");

        Init2 init3 = new Init2() {
            @Override
            public String toString() {

                return "inline : "+super.toString();
            }

            {
                value = 1000;
                staticValue = 333;
            }
        };

        System.out.println(init3);

    }

    static {
        System.out.println("static init 1: " +staticValue);
        staticValue = 5;
    }

    {
        System.out.println("init block: "+ value+" static "+staticValue);
        staticValue = 6;
        int f = 34;
        value = 7;
    }

    public Init() {
        System.out.println("constructor: "+ value+" static "+staticValue);
    }

}

class Init2 {

    int value = 2;
    static int staticValue = 1;



    static {
        System.out.println("static init2: " +staticValue);
        staticValue = 5;
    }

    {
        System.out.println("init block: "+ value+" static "+staticValue);
        staticValue = 6;
        value = 7;
    }

    public Init2() {
        System.out.println("constructor: " + value + " static " + staticValue);

    }

    @Override
    public String toString() {
        return String.format(" value: %d , staticValue: %d", value, staticValue);
    }
}