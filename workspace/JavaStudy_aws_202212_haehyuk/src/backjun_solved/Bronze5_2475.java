package backjun_solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bronze5_2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();

        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        numbers.add(d);
        numbers.add(e);

        int x = 0;
        for (int i = 0; i < numbers.size(); i++) {
            x += Math.pow(numbers.get(i), 2);
        }
        int y = x % 10;

        System.out.println(y);
    }
}
