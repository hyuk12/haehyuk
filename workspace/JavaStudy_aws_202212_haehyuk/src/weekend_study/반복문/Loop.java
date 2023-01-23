package weekend_study.반복문;

import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 0;
        System.out.println("몇번 반복할지 입력하세요: ");
        n = sc.nextInt();

        // n번 반복을 할거아냐  5를 넣었을 때 출력이 되게하고싶은데
        // n ~ 1까지 거꾸로 나오게하고싶어 출력을
        // 1 ~ n까지 나오게하려면 어떻게짜야할까
        for (int i = 0; i < n; i++) {
            // 몇번도는지 0 ~ n -1 n 번을돈다.
//            System.out.println(i+1);

        }
    }
}