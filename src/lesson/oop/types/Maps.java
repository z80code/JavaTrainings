package lesson.oop.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by igor on 18.10.2015.
 */
public class Maps {

    public static void main(String[] args) {

        Map< String, Integer > map = new HashMap<>();
        map.put("name1",1111111);
        map.put("name2",2222222);
        map.put("name3",3333333);

        Integer v = map.get("namfe2");

        System.out.println(v);
    }

}
