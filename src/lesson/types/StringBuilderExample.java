package lesson.types;

public class StringBuilderExample {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("sdffds");
        sb.append(" ");
        String s = null;
        sb.append(567);
        sb.append("dfgdfg 2345678902345678902345678");


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(4);



        String string = sb.toString();
        System.out.println(string);

    }
}
