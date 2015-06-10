/**
 * Created by igor on 10.06.2015.
 */
public class MyExeptionsExample {

    public static void doSomething(int n) throws MyExeption {

        if(n<5) {
            throw new MyExeption();
        }

    }

    public static void doSomething2(int n) {
        if(n<5) {
            throw new MyUncheckedException();
        }
    }
    public static void main(String[] args) {
        try {
            doSomething(3);
        } catch (MyExeption myExeption) {
            System.out.println("We catch: "+myExeption.getMessage());
        }

        doSomething2(2);
    }
}

class MyExeption extends Exception {
    public MyExeption() {
        super("This is my exception");
    }
}

class MyUncheckedException extends RuntimeException {
   public MyUncheckedException() {
       super("This is my unchecked exception");
   }
}
