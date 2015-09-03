package lesson.anatations.marker;

import lesson.anatations.withvalues.SimpleAnnotation;

@SimpleAnnotation(user = "Igor")
class SimpleRun {

    public static void main(String[] args) {
        Class cl  = SimpleRun.class;
        System.out.println(cl);

        boolean isAnnotated = CheckMarkerAnnotation.class.isAnnotationPresent(MarkerAnnotation.class);
        System.out.println("CheckMarkerAnnotation is annotated: "+isAnnotated);
    }
}

@MarkerAnnotation
class CheckMarkerAnnotation {

}