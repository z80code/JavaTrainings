package practice.files.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample {

    public static void save(String path, List<Stuff> list)
            throws IOException {

        try(ObjectOutputStream outputStream =
                    new ObjectOutputStream(
                            new FileOutputStream(path))) {

            outputStream.writeObject(list);
        }

    }

    //@SuppressWarnings("unchecked")
    public static List<Stuff> load(String path)
            throws IOException, ClassNotFoundException {

        List<Stuff> list = null;
        try( ObjectInputStream inputStream =
            new ObjectInputStream(
                    new FileInputStream(path))) {

            list = (List<Stuff>) inputStream.readObject();
        }
        return list;
    }

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

//        List<Stuff> list = new ArrayList<>();
//
//        list.add(new Stuff("st 1", 123));
//        list.add(new Stuff("st 4", 3));
//        list.add(new Stuff("st 2", 7));
//        save("D://stuff.bin", list);

        List<Stuff> list = load("D://stuff.bin");
        for(Stuff s: list) {
            System.out.println(s);
        }


    }

}
