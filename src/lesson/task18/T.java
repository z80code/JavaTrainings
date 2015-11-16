package lesson.task18;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by igor on 19.10.2015.
 */
public class T {

    public static void main(String[] args) {
        //BigInteger bb = new BigInteger("2");
        //System.out.println(bb.shiftRight(2));

        BigInteger[] a= Arrays.stream("3bc2870871f41d0d7b51a961d7190000000000000100000000000002".split("(?<=\\G.{14})")).map(javax.xml.bind.DatatypeConverter::parseHexBinary).map(java.math.BigInteger::new).toArray(java.math.BigInteger[]::new);
        System.out.println(Arrays.toString(a));
    }
}
