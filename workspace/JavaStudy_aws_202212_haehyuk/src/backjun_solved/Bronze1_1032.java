package backjun_solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bronze1_1032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        List<char[]> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = String.copyValueOf(sc.nextLine().toCharArray());
            lines.add(s.toCharArray());
            System.out.println(s.toCharArray());
        }
    }
}
