package weekend_study.조건문;

import j17_스태틱.싱글톤.C;

import java.util.Scanner;

public class Condition {

    // 신용카드나 어떤 웹사이트에서 회원제도가 있는데
    // Vip , Gold , Silver ,Bronze

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        final int VIP_POINT = 80;
        final int GOLD_POINT = 60;
        final int SILVER_POINT = 40;
        final int BRONZE_POINT = 20;

        // 회원 포인트 점수를 입력하세요 라는 문구를 주고
        // 회원포인트 점수를 입력받는 값을 포인트 값이랑 비교를해서 저점수 초과 그사람 VIP ,GOLD ,SILVER ,BRONZE
        int point = 0;
        String rating = null;

        System.out.println("회원 포인트 점수를 입력하세요: ");
        point = sc.nextInt();

        if (point > VIP_POINT) {
            rating = "VIP";
        }else if (point > GOLD_POINT) {
            rating = "GOLD";
        }else if (point > SILVER_POINT) {
            rating = "SILVER";
        }else if (point > BRONZE_POINT) {
            rating = "BRONZE";
        } else {
            rating = "GENERAL";
        }

        System.out.println("회원의 등급: "  + rating);


    }
}
