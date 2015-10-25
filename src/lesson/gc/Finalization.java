package lesson.gc;


public class Finalization {


    public static void main(String[] args) {

        TestFinalization obj = new TestFinalization();
        obj = null;
        //System.gc();
        System.out.println("end");

    }
}

class TestFinalization {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("delete object");
    }
}