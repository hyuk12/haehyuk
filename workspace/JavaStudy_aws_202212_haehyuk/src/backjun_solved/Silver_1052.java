package backjun_solved;

import java.io.IOException;
import java.util.Scanner;

public class Silver_1052 {
    static int n,k;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int bottle = 0;
        while (true) {

            int tmp = n + bottle;
            int count = 0;
            while (tmp > 0) {
                if (tmp % 2 != 0) {
                    count++;
                }
                tmp /= 2;
            }
            if (count <= k) {
                break;
            }
            bottle++;
        }
        System.out.println(bottle);
    }
}
