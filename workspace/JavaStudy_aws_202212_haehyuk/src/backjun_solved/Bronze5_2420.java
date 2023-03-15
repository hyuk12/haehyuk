package backjun_solved;

import java.math.BigInteger;
import java.util.Scanner;

public class Bronze5_2420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger zero = new BigInteger("0");
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        BigInteger c = a.subtract(b);
        if(c.compareTo(zero) == -1) {
            BigInteger multiply = c.multiply(new BigInteger("-1"));
            System.out.println(multiply);
        } else {
            System.out.println(a.subtract(b));
        }
    }
}
