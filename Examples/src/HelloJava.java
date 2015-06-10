public class HelloJava {

    public static void main(String[] args) {

        Marker[] markers = new Marker[5];

        Object object = new Object();
        for (int i = 0; i <markers.length; i++) {
            markers[i] = new Marker(i,"Color"+i);
        }

        for(Marker marker : markers ) {
            System.out.println( marker );
        }

    }
}


class Marker {
    public int length;
    public String color;

    public Marker(int length, String color) {
        this.length = length;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Length: "+ length + " Color: "+ color;
    }
}