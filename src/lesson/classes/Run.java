package lesson.classes;

public class Run {

    public class Inner1 {}
    class Inner2 {}
    protected class Inner3 {}
    private class Inner4 {}

    static public class Inner5 {}
    static class Inner6 {}
    static protected class Inner7 {}
    static private class Inner8 {}

    public static void main(String[] args) {
        ClassOne instance = new ClassOne();

        ClassOne.InnerClass innerClass = instance.new InnerClass();
        ClassOne.InnerClass innerClass2 = instance.new InnerClass();
        ClassOne.Inner3 i = instance.new Inner3();

        ClassOne.Inner5 staticClass = new ClassOne.Inner5();

        Storage storage = instance.getStorage();
        //Storage s2 = instance.new Inner4();

    }

}

interface Storage {}

class ClassOne {

    private int a = 4;

    public Storage getStorage() {

        class InMethodClass {

        }

        return new Inner4();
    }

    public class InnerClass {

        public void print() {
            a = 8;
        }
    }
    class Inner2 {}
    protected class Inner3 {}
    private class Inner4 implements Storage {}

    static public class Inner5 {}
    static class Inner6 {}
    static protected class Inner7 {}
    static private class Inner8 {}

}
