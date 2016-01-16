package lesson.anatations.simple;

import java.lang.reflect.Method;

public class Run {

    @Author(name = "Igor", date = "15.01.2016")
    public void demoAnnotation() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class cl = Run.class;
        Method method = cl.getMethod("demoAnnotation");

        //Author a1 = (Author) cl.getAnnotation(Author.class);
        Author a2 = method.getAnnotation(Author.class);

        //System.out.println(a1.name());
        //System.out.println(a1.date());
        System.out.println(a2.name());
        System.out.println(a2.date());
    }
}
