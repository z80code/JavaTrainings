package lesson.gc;

  class BitOperation {

    public static void main(String[] args) {

        //int b = 0xff22;
        int a = 0b101110;
        int b = 0b100011;

        System.out.println( Integer.toBinaryString(a&b)  );
        System.out.println( Integer.toBinaryString(a|b)  );
        System.out.println( Integer.toBinaryString(a^b)  );
        System.out.println( Integer.toBinaryString(~b)  );
        System.out.println( Integer.toBinaryString(b>>1)  );
        System.out.println( Integer.toBinaryString(b<<1)  );

        //int a2 = 124;
        //System.out.println(a2>>3);
        //System.out.println(a2<<2);

        int a1 = 23243544;
        int b1 = 67565;
        System.out.println(a1);
        System.out.println(b1);

        a1^=b1;
        b1^=a1;
        a1^=b1;

        System.out.println("=========");
        System.out.println(a1);
        System.out.println(b1);


        int a3 = 128;
        boolean is = (a3&(a3-1))==0;
        System.out.println(  is  );
    }
}
