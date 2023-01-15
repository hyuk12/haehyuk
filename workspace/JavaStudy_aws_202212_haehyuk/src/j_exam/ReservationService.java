package j_exam;

import java.util.Scanner;

public class ReservationService {
    private FurnitureRepository repository;

    private final Scanner scanner ;

    public ReservationService(FurnitureRepository repository) {
        this.repository = repository;
        scanner = new Scanner(System.in);
    }

    public void reservation() {

        boolean flag = true;
        char select = '\0';
        while (flag) {
            showReservationView();
            select = inputSelected();
            flag = selectReservation(select);
        }
    }

    private char inputSelected() {
        char select = scanner.next().charAt(0);
        scanner.nextLine();
        return select;
    }

    private void showReservationView() {
        System.out.println("========<< 가구 주문 >>========");
        System.out.println("1. 가구 주문하기");
        System.out.println("2. 예약번호로 조회하기");
        System.out.println("==============================");
        System.out.println("q. 나가기");
    }

    private boolean selectReservation(char select) {
        boolean flag = true;
        if (isExit(select)) {
            flag = false;
        }else if (select == '1') {
            repository.saveFurniture();
        }else if (select == '2') {
            repository.checkReservationByCode();
        }else {
            System.out.println("번호를 다시 입력해주세요.");
        }
        return flag;
    }





    private boolean isExit(char select) {
        return select == 'q' || select == 'Q';
    }
}
