package codepractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MapWords {
    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        BufferedReader reader = new BufferedReader(new FileReader("D:/data.txt"));
        Map<String, Tuple> map = new HashMap<>();
        String s = "";
        while ( (s = reader.readLine()) !=null) {
            // Отбросить пробелы
            s = s.trim().toLowerCase();
            String[] words = s.split("[ ]+");

            for(String word: words) {

                if( map.containsKey(word)) {
                    Tuple tuple = map.get(word);
                    tuple.count++;
                } else {
                    map.put(word, new Tuple(word,1) );
                }
            }
        }

        List<Tuple> list = new ArrayList<>();

        list.addAll( map.values());
        Collections.sort(list);

        for (int i = 0; i < 20; i++) {
            System.out.println(list.get(i));
        }

        long end = System.currentTimeMillis();

        System.out.println(end-start);
        reader.close();

    }
}

class Tuple implements Comparable<Tuple> {
    public String word;
    public int count;

    public Tuple(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("(%s,%d)",word, count );
    }

    @Override
    public int compareTo(Tuple o) {
        return -Integer.compare(this.count, o.count);
    }
}