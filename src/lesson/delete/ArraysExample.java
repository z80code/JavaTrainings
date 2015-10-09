package lesson.delete;

import java.util.Arrays;
import java.util.Objects;

public class ArraysExample {

    public static void main(String[] args) {

        // О массивах
        // Статическое создание массива
        // System.out.println(Arrays.toString(array));
        // Динамическое создание массива
        // Методы массивов
        // Особенность хранения массива
        // Многомерные массивы
        // Клонирование массива
        // Класс Arrays
        //int[] array = {1, 3, 4};

        int[] array = new int[5];
        array[3] = 45;

        int[] ar2 = array;
        ar2[0] = 8;

        String[] strings;
        StringBuilder[] stringBuilders;

        Object[] objectses = new Object[5];
        objectses[1] = "sdfsf";
        objectses[4] = 5; // Integer

        System.out.println(Arrays.toString(objectses));

        // System.out.println(Arrays.toString(array));
        // Динамическое создание массива
        // Методы массивов
        // Особенность хранения массива
        // Многомерные массивы
        // Клонирование массива
        // Класс Arrays

    }
}
