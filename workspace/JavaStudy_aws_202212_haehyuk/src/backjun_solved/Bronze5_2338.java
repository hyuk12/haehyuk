package backjun_solved;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Bronze5_2338 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BigInteger x = sc.nextBigInteger();
        BigInteger y = sc.nextBigInteger();

        System.out.println(x.add(y));
        System.out.println(x.subtract(y));
        System.out.println(x.multiply(y));
    }
}
