package lesson.begin;

import java.io.BufferedReader;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        BufferedReader f;

        int count = 10;

        String s = "";
        for (int i = 0; i < count; i++) {
            s+=","+i;
        }

        System.out.println(s);


        String[] array = s.split(",");
        int[] numbers = new int[count];

        for(int i = 1; i< array.length; i++ ) {
            //System.out.println(">>"+ array[i] +"<<");
            numbers[i-1] = Integer.parseInt(array[i]);
        }

        int answer = 0;
        for (int v : numbers) {
            answer += v;
        }
        System.out.println(answer);

    }
}
