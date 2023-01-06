package j12_배열.학점관리시스템;

import java.util.Scanner;

public class StudentService {

	private Scanner scanner;
	
	public StudentService() {
		scanner = new Scanner(System.in);
	}
	
	// run 을 했을 때 학생의 이름, 학생의 점수를 입력받는다.
	// 입력 받은 정보로 A,B,C,D,F 학점으로 나누어 출력하는 시스템
	
	public void run() {
		boolean loopFlag = true;
		char select = '\0';
		
		while(loopFlag) {
			showGradeTransferSystemView();
		}
	}
	
	private void showGradeTransferSystemView() {
		System.out.println("======== << 학점 관리 시스템 >> ========");
		System.out.println("1. 학생 이름 입력: ");
		System.out.println("2. 학생 점수 입력: ");
		System.out.println("3. 학점으로 변환 출력");
		System.out.println("========================================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}
}
