package finalization;

import java.io.IOException;

public class FinalizationRun  {

    public static void main(String[] args) throws IOException {
        FinalizationRun one = new FinalizationRun("one");
        FinalizationRun two = new FinalizationRun("two");
        System.out.println("Create two object");
        one = null;
        System.gc();
        //Runtime.getRuntime().gc();

        System.out.println("Exit");
    }

    private String name;
    public FinalizationRun(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Освобождение ресурсов: "+ this.name);
        super.finalize();
    }
}
