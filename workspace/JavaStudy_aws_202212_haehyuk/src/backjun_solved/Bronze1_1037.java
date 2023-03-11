package backjun_solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze1_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        while (n-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            max = number > max ? number : max;
            min = number < min ? number : min;

        }
        System.out.println(max * min);
    }
}
