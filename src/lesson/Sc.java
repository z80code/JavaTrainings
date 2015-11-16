package lesson;

public class Sc {

    public static Integer m2(Integer n) {
        Integer m = (n | (n - 1)) + 1;

        if (n == 0) {
            return ~0;
        } else {
            return (m | ((((m & -m) / (n & -n)) >> 1) - 1));
        }
    }

    public static boolean magic(Integer n) {
        Integer nn = m2(n);
        return nn!=~0;
    }

    public static long f() {
        Long s = 0L;
        Integer i = Integer.MIN_VALUE;

        while (i < Integer.MAX_VALUE) {
            Integer c = 1;
            Integer n = i;
            while (magic(n)) {
                c+=1;
            }
            s += c;
            i += 1;
            System.out.println(s);

        }

        return s;
    }

    public static void main(String[] args) {

        f();

    }

}


/*
def f(): Long = {
    var (s, i) = (0L, Int.MinValue)
    while (i < Int.MaxValue) {
      var (c, n) = (1, i)
      while ({n = ((n : Int) => {val m : Long = (n | (n - 1)) + 1; if (n == 0) ~0 else (m | ((((m & -m) / (n & -n)) >> 1) - 1)).toInt})(n); n != ~0}) c += 1
      s += c
      i += 1
    }
    s
  }



 */