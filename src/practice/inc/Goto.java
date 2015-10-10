package practice.inc;

import java.io.*;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by igor on 10.10.2015.
 */
public class Goto {

    public static void main(String[] args) {

        InputStream stream;
        Reader reader;
        InputStreamReader streamReader;
        FileReader fileReader;
        FileInputStream fileInputStream;



        label: for(int i = 0 ;i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                if(j ==2 ) continue label;

                System.out.println("i=" +i + " j="+ j);
            }

            //101011
            //
            //010101
        }

    }
}
