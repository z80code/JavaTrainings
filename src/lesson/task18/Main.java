package lesson.task18;

import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    final static BigInteger TWO = new BigInteger("2");

    //checks whether an int is prime or not.
    static boolean isPrime(BigInteger n) {
        for(BigInteger i=new BigInteger("2");(new BigInteger("2").multiply(i)).compareTo(n)==-1;i.add(BigInteger.ONE)) {
            if(n.mod(i).equals(BigInteger.ZERO))
                return false;
        }
        return true;
    }

    public static BigInteger magic(BigInteger[] par) {

        while (

                !isPrime(par[1])
                // Stream.iterate( TWO, x -> x.add( BigInteger.ONE ) )
                // .filter(x -> par[1].mod(x).compareTo(BigInteger.ZERO) == 0)
                // .findFirst()
                // .get()
                //.compareTo(par[1]) != 0)
                )
        {
            par[1] = par[0].add(par[1]);
            par[0] = par[1].subtract(par[0]);
            par[2] = par[2].add(par[2]);
        }

        return par[2];
    }

    public static void main(String[] args) {
/*
        BigInteger b = ((java.util.function.Function<java.math.BigInteger[], java.math.BigInteger>) $ -> {
            while (java.util.stream.Stream.iterate($[3], x -> x.add($[3].shiftRight(1)))
                    .filter(x -> $[1]
                            .mod(x)
                            .compareTo($[3].shiftRight(2)) == 0).findFirst().get().compareTo($[1]) != 0) {
                $[1] = $[0].add($[1]);
                $[0] = $[1].subtract($[0]);
                $[2] = $[2].add($[2]);
            }
            return $[2];
        }).apply(java.util.Arrays.stream("".split("(?<=\\G.{14})")).map(javax.xml.bind.DatatypeConverter::parseHexBinary).map(java.math.BigInteger::new).toArray(java.math.BigInteger[]::new));
*/

        //3bc2870871f41d0d7b51a961d7190000000000000100000000000002

        BigInteger[] arr =  { new BigInteger("16820908843987997"), new BigInteger("3794765361567513"), new BigInteger("1"), new BigInteger("2")};

        //BigInteger[] arr =  { new BigInteger("10"), new BigInteger("5"), new BigInteger("1"), new BigInteger("2")};

         //int[] vv = {1,2,3,6};

        /*BigInteger[] vv =  {
                new BigInteger("1"),
                new BigInteger("3"),
                new BigInteger("1"),
                new BigInteger("2")
        };*/

        System.out.println("===================");
//
//        Stream.iterate(vv[3], x -> x + (vv[3] / 2))
//                 .filter(x -> vv[1] % x.compareTo(vv[3] / 4) == 0).limit(5).forEach(System.out::println);



       BigInteger a  = magic(arr);

        System.out.println(a);

    }

}
