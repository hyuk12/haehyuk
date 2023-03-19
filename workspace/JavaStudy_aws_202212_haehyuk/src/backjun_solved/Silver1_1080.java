package backjun_solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver1_1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        a.stream().forEach(integer -> {
            
        });
    }
}
