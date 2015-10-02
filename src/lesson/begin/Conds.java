package lesson.begin;

/**
 * Created by igor on 13.09.2015.
 */
public class Conds {

    public static void main(String[] args) {


        // (�������) ? <���������> : <��������>
        String[] strings = new String[5];

        strings[0] = "str 1";
        strings[2] = "str 2";
        strings[3] = "str 3";

        for (String s : strings) {
            System.out.println(  (s!=null)?s:"-"  );
        }


    }

}
