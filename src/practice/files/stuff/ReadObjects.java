package practice.files.stuff;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadObjects {

    public static List<Stuff> read(String path)
            throws IOException {

        List<Stuff> strings = new ArrayList<>();
        File file = new File(path);

        try(BufferedReader reader =
                    new BufferedReader(new FileReader(file))) {

            // Выбрасываем первую строку из файла (заголовки)
            reader.readLine();

            String tmp;
            while ( (tmp = reader.readLine())!=null ) {

                String[] s = tmp.split(";");

                if(s.length == 2) {
                    String type = s[0].trim();
                    int count = Integer.parseInt(s[1].trim());
                    Stuff stuff = new Stuff(type, count);
                    strings.add(stuff);
                }
            }
        }

        return strings;
    }

    public static void main(String[] args) {
        try {
            List<Stuff> strings = read("files/stuff.csv");
            for (Stuff str : strings) {
                System.out.println(str);
            }

            Collections.sort(strings);

//            Collections.sort(strings, new Comparator<Stuff>() {
//
//                @Override
//                public int compare(Stuff o1, Stuff o2) {
//                    //return -Integer.compare( o1.getCount(), o2.getCount())  ;
//                    return - o1.getType().compareTo(o2.getType());
//                }
//            });

            System.out.println("============");
            for (Stuff str : strings) {
                System.out.println(str);
            }

        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

}
