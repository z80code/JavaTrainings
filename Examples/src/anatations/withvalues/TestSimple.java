package anatations.withvalues;

public class TestSimple {
    public static void main(String[] args) {
        // Get annotations
        Class<TestOne> one = TestOne.class;
        SimpleAnnotation oneAnnotation = one.getAnnotation(SimpleAnnotation.class);
        System.out.println(oneAnnotation.user());

        // Get annotations
        Class<TestTwo> two = TestTwo.class;
        SimpleAnnotation twoAnnotation = two.getAnnotation(SimpleAnnotation.class);
        System.out.println(twoAnnotation.user());
    }
}

@SimpleAnnotation(user = "Igor")
class TestOne {

}

@SimpleAnnotation
class TestTwo {

}